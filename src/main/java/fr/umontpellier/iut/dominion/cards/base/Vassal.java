package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.Arrays;
import java.util.List;

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
        p.incrementMoney(2);
        if (p.getCardsInDiscard().size() + p.getCardsInDraw().size() > 0){
            Card remove = p.drawCard();
            List<String> choices = Arrays.asList("y","n");

            String choice = p.chooseOption("voulez vous jouer" + remove.getName(), choices,false);

            if(remove.getTypes().contains(CardType.Action) && choice.equals("y")){

                p.addToInPlay(remove);
                remove.play(p);

            }
            else{p.discardCard(remove);
            }
        }

}
}
