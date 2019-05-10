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
        ListOfCards cardInHand = p.getCardsInHand();
        int i = 0;


        p.incrementActions(1);
        String choice="texte-non-vide";

        while ( !choice.equals("")){
            choice = p.chooseCard("Choisissez une carte à écarter",cardInHand,true );



            p.discardCard(cardInHand.getCard(choice));


            i++;

        }

        while (i != 0){
        p.drawToHand();
        i--;
    }
}
}
