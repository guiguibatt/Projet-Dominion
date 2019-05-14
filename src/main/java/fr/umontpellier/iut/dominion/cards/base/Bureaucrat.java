package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.type.AttackCard;

/**
 * Carte Bureaucrate (Bureaucrat)
 *
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur
 * main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {
    public Bureaucrat() {
        super("Bureaucrat", 4);
    }

    public Bureaucrat(String name, int cost) {
        super(name, cost);
    }

    public void play(Player p) {
        String carteARetirez = "";
        p.getDraw().add(p.getGame().removeFromSupply("Silver"));

        for(int i = 0; i < p.getOtherPlayers().size(); ++i) {
            Player adversaire = (Player)p.getOtherPlayers().get(i);
            if (!this.PlayerHasMoatInHand(adversaire)) {

                carteARetirez = adversaire.chooseCard("Choose a victory card to show ", adversaire.getVictoryCards(), false);
                if (!carteARetirez.equalsIgnoreCase("")) {
                    adversaire.getDraw().add(adversaire.getHand().remove(carteARetirez));

                }
            }
        }

    }
}
