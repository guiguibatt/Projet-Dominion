package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.Arrays;
import java.util.List;

/**
 * Carte Cave (Cellar)
 *
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends Card {
    public Cellar() {
        super("Cellar", 2);
    }

    @Override
    public void play(Player p) {
        ListOfCards CardInHand = p.getCardsInHand();
        List<String> choices = Arrays.asList("yes","no");
        int i = 0;
        String chooseAgain = "yes";

        p.incrementActions(1);

        while (chooseAgain.equals("yes")){

            p.chooseCard("Choisissez une carte à écarter",CardInHand,false );
            chooseAgain =  p.chooseOption("Voulez vous continuer à jeter des cartes?"
                    ,choices,false);

            i++;

        }

        while (i != 0){
        p.drawToHand();
        i--;
    }
}
}