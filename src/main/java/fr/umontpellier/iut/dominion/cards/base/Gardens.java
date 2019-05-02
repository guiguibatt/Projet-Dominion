package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Jardins (Gardens)
 *
 * Vaut 1VP pour chaque 10 cartes dans votre deck (arrondi à l'unité inférieure).
 */
public class Gardens extends Card {
    public Gardens() {
        super("Gardens", 4);
    }






    @Override

    public int getVictoryValue(Player p) {
        int disaines = 0;
        int unite = 0;

        for( Card c : p.getAllCards()){
            unite ++;

            if (unite == 10){
                unite = 0;
                disaines ++;
            }
        }
        return disaines;
    }
}