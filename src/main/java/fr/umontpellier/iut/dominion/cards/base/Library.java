package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.type.ActionCard;
import static fr.umontpellier.iut.dominion.CardType.Action;

import java.util.Arrays;
import java.util.List;



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

        ListOfCards side = new ListOfCards();

        List<String> choices = Arrays.asList("y","n");

        boolean EmptyDraw = false;

        while (p.getHand().size() < 7 && !EmptyDraw) {
            Card drewCard = p.drawCard();
            if (drewCard == null) {
                EmptyDraw = true;
            } else if (drewCard.getTypes().contains(Action)) {
                String scan = p.chooseOption("Mettre la carte de coté ?", choices, false);
                if (scan.equals("y")) {
                    side.add(drewCard);
                }
                else {
                    p.addToHand(drewCard);
                }
            }
                else {
                p.addToHand(drewCard);
            }
        }
        for (Card c: side) {
            p.discardCard(c);
        }
    }
}