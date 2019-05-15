package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.cards.common.type.ActionCard;

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



    public void play(Player p) {

        ListOfCards actionCardInHand = new ListOfCards();
        int cout = 0;

        for (Card c : p.getCardsInHand()) {
            if (c.getName().equals("Copper") || c.getName().equals("Silver") || c.getName().equals("Gold") ) {
                actionCardInHand.add(c);
            }
        }

        String cardName = p.chooseCard("Choisissez 1 carte Action de votre main a jouer 2 fois",actionCardInHand, true);
        if (!cardName.equals("")) {
            p.playCard(cardName);
            p.getHand().add(p.getInPlay().remove(cardName));
            p.playCard(cardName);
        }

    }

}