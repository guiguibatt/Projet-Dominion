package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.Arrays;
import java.util.List;

/**
 * Carte Avant-coureur (Harbinger)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez dans votre défausse, vous pouvez prendre une carte et la mettre sur votre deck.
 */
public class Harbinger extends Card {
    public Harbinger() {
        super("Harbinger", 3);
    }

    @Override
    public void play(Player p){
        p.drawToHand();
        p.incrementActions(1);

        ListOfCards cardsInDiscard = new ListOfCards();
        cardsInDiscard = p.getCardsInDiscard();
        int i = 0;


        String choice = p.chooseCard("Choisissez une carte à ajouter à votre pioche", cardsInDiscard ,false );

        Card c = cardsInDiscard.getCard(choice);
        p.addToDraw(c);
        p.removeFromDiscard(choice);

    }
}
