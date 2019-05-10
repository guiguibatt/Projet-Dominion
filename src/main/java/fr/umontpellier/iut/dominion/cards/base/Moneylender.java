package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Prêteur sur gages (Moneylender)
 *
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends Card {
    public Moneylender() {
        super("Moneylender", 4);
    }


    @Override
    public void play(Player p) {
        ListOfCards CardInHand = p.getCardsInHand();

        boolean lever = false;

        for (Card carte : CardInHand) {
            if (carte.toString().equals("Copper")  && !lever) {
                lever = true;
                p.discardCard(carte);
                p.removeFromHand("Copper");
                p.incrementMoney(3);
            }
        }
    }
}