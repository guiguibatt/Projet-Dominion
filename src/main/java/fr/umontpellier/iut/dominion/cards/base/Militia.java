package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.Arrays;
import java.util.List;

/**
 * Carte Milice (Militia)
 *
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends Card {
    public Militia() {
        super("Militia", 4);
    }

    public void play(Player p) {

        p.incrementMoney(2);


        List<Player> opponents;
        opponents = p.getOtherPlayers();




        for (Player op : opponents) {
            ListOfCards cardInHand = op.getCardsInHand();
            while (op.getCardsInHand().size() > 3) {

                String choice = op.chooseCard("Choisissez une carte à défausser", cardInHand, false);
                int i =0;

                for (Card c : op.getCardsInHand()) {
                    if (choice.equals(c.getName()) && i==0) {
                        op.discardCard(cardInHand.getCard(choice));
                        op.removeFromHand(choice);
                        cardInHand.remove(choice);
                        i=1;
                    }

                }



            }
        }
    }
}