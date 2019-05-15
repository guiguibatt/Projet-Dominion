package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Rénovation (Remodel)
 *
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends Card {
    public Remodel() {
        super("Remodel", 4);
    }

    public Remodel(String name, int cost) {
        super(name, cost);
    }

    public void play(Player p) {
        new ListOfCards();
        ListOfCards cartesAChoisir = new ListOfCards();
        if (p.getHand().size() > 0) {
            Card carteEcarte = p.getHand().remove(p.chooseCard("Choisissez une carte a écarter de votre main :", p.getHand(), false));
            int cost = carteEcarte.getCost();

            for(int h = 0; h < cost + 3; ++h) {
                ListOfCards curList = p.getGame().getCardsByCost(h);
                cartesAChoisir.addAll(curList);
            }


            String carteGagne = p.chooseCard("Choisissez une carte :", cartesAChoisir, true);
            p.gain(p.getGame().removeFromSupply(carteGagne));

    }
}