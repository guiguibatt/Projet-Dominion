package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.CardType;

/**
 * Carte Salle du trône (Throne Room)
 *
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends Card {
    public ThroneRoom() {
        super("Throne Room", 4);
    }




    public void play(Player p) {

        ListOfCards cardsInHand = new ListOfCards();
        cardsInHand = p.getCardsInHand();

        String cardName = p.chooseCard("Choisissez 1 carte Action de votre main a jouer 2 fois", cardsInHand, true);

        ListOfCards c = new ListOfCards();
        c.add(cardsInHand.getCard(cardName));

        if (c.contains(CardType.Action)) {
            p.playCard(cardName);
            p.getHand().add(p.getInPlay().remove(cardName));
            p.playCard(cardName);
        }

    }

}