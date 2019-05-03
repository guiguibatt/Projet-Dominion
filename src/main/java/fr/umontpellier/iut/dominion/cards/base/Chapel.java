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
            ListOfCards CardInHand = p.getCardsInHand();
            List<String> choices = Arrays.asList("yes","no");
            int i = 0;
            String chooseAgain = "yes";

            while (chooseAgain == "yes" && i < 4) {

            p.chooseCard("Choisissez une carte à écarter",CardInHand,false );
            chooseAgain =  p.chooseOption("Voulez vous continuer à jeter des cartes?"
                    ,choices,false);

            i++;

            }
        }
    }