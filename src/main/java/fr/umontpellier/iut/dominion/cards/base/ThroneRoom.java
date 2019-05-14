package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.CardType;

/**
 * Carte Salle du trône (Throne Room)
 *
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends Card {
    public ThroneRoom() {
        super("Throne Room", 4);
    }



   /* public void play(Player p) {
        String cardName = p.chooseCard("Choisissez 1 carte Action de votre main a jouer 2 fois", p.getCardsInHand().contains(CardType.Action), true);
        if (!cardName.equals("")) {
            p.playCard(cardName);
            p.getHand().add(p.getInPlay().remove(cardName));
            p.playCard(cardName);
        }

    }
*/
}