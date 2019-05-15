package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.type.ActionCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static fr.umontpellier.iut.dominion.CardType.Action;

/**
 * Carte Bibliothèque (Library)
 *
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté.
 * Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {
    public Library() {
        super("Library", 5);
    }




    @Override
    public void play(Player p) {

        ListOfCards stock = new ListOfCards();
        List<String> choices = Arrays.asList("y", "n");

        while (p.getCardsInHand().size() < 7) {

            Card c = p.drawToHand();


            if (c == null) {
                break;
            }


            if (c.getTypes().contains(Action)) {

                String input = p.chooseOption("Voulez-vous mettre la carte " + c.getName() + " de côté ? y / n.", choices, false);

                if (input.equals("y")) {
                    stock.add(p.removeFromHand(c.getName()));
                }

            }
        }


        for (Card c: stock) {
            p.discardCard(c);
        }
    }
}