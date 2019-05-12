package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Artisan
 *
 * Gagnez une carte coûtant jusqu'à 5 Pièces dans votre main.
 * Mettez une carte de votre main sur votre deck.
 */
public class Artisan extends Card {
    public Artisan() {
        super("Artisan", 6);
    }

    @Override
    public void play(Player p) {

        ListOfCards cardsInSupply = p.getCardsInSupply();

        boolean n = false;
        while (!n) {
            String choice = p.chooseCard("Choisissez une carte à ajouter à votre main", cardsInSupply, false);

            Card cardFound = p.getGame().removeFromSupply(choice);
            if (cardFound != null && cardFound.getCost() < 6) {
                p.gainFromSupply(cardFound.getName());
                p.addToHand(cardFound);
                p.removeFromDiscard(cardFound.getName());
                n = true;
            }
        }

        ListOfCards cardsInHand = p.getCardsInHand();

        String choice2 = p.chooseCard("Choisissez une carte à ajouter sur votre deck", cardsInHand, false);

        for (Card c : p.getCardsInHand()) {
            if (choice2.equals(c.getName())) {
                p.addToDraw(c);
                p.removeFromHand(choice2);
            }

        }
    }
}
