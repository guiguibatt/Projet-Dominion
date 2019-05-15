package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.Player;

/**
 * Carte Mine
 *
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ;
 * ajoutez cette carte à votre main.
 */
public class Mine extends Card {
    public Mine() {
        super("Mine", 5);
    }

    public void play(Player p) {
        String carteGagner = "";
        new ListOfCards();
        ListOfCards cartesAChoisir = new ListOfCards();
        String carteTresorName = p.chooseCard("Choose a Treasure card to remove from your hand", p.getTypes, false);
        Card carteTresor = p.getHand().remove(carteTresorName);
        p.getGame().getTrash().add(carteTresor);

        for(int h = 0; h < carteTresor.getCost() + 4; ++h) {
            ListOfCards curList = p.getGame().getCardsByCostAndTypes(h, CardType.Treasure);
            cartesAChoisir.addAll(curList);
        }

        p.getGame().pause(1000, new String[]{"Search for card with a cost of " + carteTresor.getCost() + " maximum", ".", ".", "."});
        carteGagner = p.chooseCard("Choose a card (ENTER TO PASS)", cartesAChoisir, true);
        p.getHand().add(p.getGame().removeFromSupply(carteGagner));
        p.getGame().pause(1000, new String[]{"You received " + carteGagner});
    }

}