package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.CardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                List<String> choices = Arrays.asList("y", "n");
                String choice = p.choose("Voulez vous mettre cette carte de côté?", choices, false, true);


                    if (choice.equals("y")){
                        carteDeCote.add(cartePioche);
                        p.removeFromHand(choice);

                    }

                }
            }


        p.getDiscard().addAll(carteDeCote);
    }
}
