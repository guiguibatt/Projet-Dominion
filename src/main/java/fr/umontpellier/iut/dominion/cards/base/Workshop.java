package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Atelier (Workshop)
 *
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends Card {
    public Workshop() {
        super("Workshop", 3);
    }

    @Override
    public void play(Player p) {

        ListOfCards cardsInSupply = p.getCardsInSupply();

        boolean n = false;
        while(!n){
            String choice = p.chooseCard("Choisissez une carte à ajouter à votre pioche", cardsInSupply ,false );

            Card cardFound = p.getGame().removeFromSupply(choice);
            if(cardFound != null && cardFound.getCost()<4 ) {
                p.gain(cardFound);
                n = true;
            }
        }
    }

}