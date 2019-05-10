package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.Arrays;
import java.util.List;

/**
 * Carte Chapelle (Chapel)
 *
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends Card {
    public Chapel() {
        super("Chapel", 2);
    }

    @Override
    public void play(Player p) {
            ListOfCards cardInHand = p.getCardsInHand();
            int i = 0;


        String choice="texte-non-vide";

        while ( !choice.equals("") && i<4){
            choice = p.chooseCard("Choisissez une carte à écarter",cardInHand,true );


            for (Card c : p.getCardsInHand()) {
                if (choice.equals(c.getName())) {
                    p.removeFromHand(choice);
                    i++;
                }

            }

        }

    }
}