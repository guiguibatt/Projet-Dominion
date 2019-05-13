package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Vassal
 *
 * +2 Pièces.
 * Défaussez la première carte de votre deck. Si c'est une carte Action, vous pouvez la jouer.
 */
public class Vassal extends Card {
    public Vassal() {
        super("Vassal", 3);
    }

    @Override
    public void play(Player p){
        p.incrementBuys(2);
        Card c = p.drawCard();

}
}
