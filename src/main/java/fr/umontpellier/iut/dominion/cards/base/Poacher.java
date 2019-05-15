package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Braconnier (Poacher)
 *
 * +1 Action.
 * +1 Carte.
 * +1 Pièce.
 * Défaussez une carte de votre main par pile de réserve épuisée.
 */
public class Poacher extends Card {
    public Poacher() {
        super("Poacher", 4);
    }


    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(1);
        p.incrementMoney(1);
        int cpt = 0;
        boolean b = false;

        cpt = p.getGame().nonAvailableSupplyCards();
        for (int i = 0; i < cpt; i++) {


            ListOfCards cardsInHand =  p.getCardsInHand();
            b=false;
            String choice = p.chooseCard("Choisissez une carte à écarter", cardsInHand, false);

            for (Card c : new ListOfCards( p.getCardsInHand())) {
                if (choice.equals(c.getName()) && b==false) {
                    p.discardCard(cardsInHand.getCard(choice));
                    p.removeFromHand(choice);
                    b=true;
                }

            }

        }
    }


}