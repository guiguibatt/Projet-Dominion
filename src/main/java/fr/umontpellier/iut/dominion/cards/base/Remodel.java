package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Rénovation (Remodel)
 *
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */

public class Remodel extends Card {
    public Remodel() {
        super("Remodel", 4);
    }

    @Override
    public void play(Player p) {
        ListOfCards cardsInHand = new ListOfCards();
        cardsInHand = p.getCardsInHand();
        int cout = 0;

        String choice = p.chooseCard("Choisissez une carte à écarter", cardsInHand, false);

        for (Card c : new ListOfCards( p.getCardsInHand()) ){
            if (choice.equals(c.getName())) {
                cout = c.getCost() +3; // le plus trois compense le fait que ce soit un < et pas un <= dans la verification du coût

                p.removeFromHand(choice);

            }
        }

        ListOfCards cardsInSupply = p.getCardsInSupply();

        boolean n = false;
        while(!n){
            String choice2 = p.chooseCard("Choisissez une carte coutant 2 de plus que celle jetée à ajouter à votre pioche", cardsInSupply ,false );

            Card cardFound = p.getGame().removeFromSupply(choice2);
            if(cardFound != null && cardFound.getCost() < cout ) {
                p.gain(cardFound);
                n = true;
            }
        }
    }
}