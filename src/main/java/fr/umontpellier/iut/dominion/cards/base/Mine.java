package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Mine
 *
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ;
 * ajoutez cette carte à votre main.
 */
public class Mine extends Card {
    public Mine() {
        super("Mine", 5);
    }


    @Override
    public void play(Player p) {

        ListOfCards treasurecardsInHand = new ListOfCards();
        int cout = 0;

        for (Card c : p.getCardsInHand()) {
            if (c.getName().equals("Copper") || c.getName().equals("Silver") || c.getName().equals("Gold") ) {
                treasurecardsInHand.add(c);
            }
        }

            String choice = p.chooseCard("Choisissez une carte trésor de votre main à écarter", treasurecardsInHand ,false);

        for (Card c : new ListOfCards( p.getCardsInHand())) {
            if (choice.equals(c.getName())) {
                cout = c.getCost() + 4;
                p.removeFromHand(choice);
            }

        }

        ListOfCards treasureCardSupply = new ListOfCards();

        for (Card c2 : p.getCardsInSupply()) {
            if (c2.getName().equals("Copper") || c2.getName().equals("Silver") || c2.getName().equals("Gold")) {
                treasureCardSupply.add(c2);
            }
        }




        boolean n = false;
        while(!n) {

            String choice2 = p.chooseCard("Choisissez une carte coutant jusqu'à 3 Pièces de plus", treasureCardSupply, false);
            Card cardFound = p.getGame().removeFromSupply(choice2);

            if (cardFound != null && cardFound.getCost() < cout) {
                p.gainFromSupply(cardFound.getName());
                p.addToHand(cardFound);
                p.removeFromDiscard(cardFound.getName());
                n=true;
            }
        }








    }
}
