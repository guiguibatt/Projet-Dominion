package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.CardType;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Carte Bibliothèque (Library)
 *
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté.
 * Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends Card {
    public Library() {
        super("Library", 5);
    }

    public void play(Player p) {
        ListOfCards carteDeCote = new ListOfCards();

        while(p.getHand().size() < 7) {
            Card cartePioche = p.drawToHand();
            if (cartePioche != null && cartePioche.getTypes().contains(CardType.Action)) {

                String veutMettreDeCote = p.choose("Do you want to put it in the discard instead of your hand?", new ArrayList(Arrays.asList("y", "n")), false, false);
                if (veutMettreDeCote.equalsIgnoreCase("y")) {
                    carteDeCote.add(p.getHand().remove(cartePioche.getName()));

                }
            }
        }

        p.getDiscard().addAll(carteDeCote);
    }
}