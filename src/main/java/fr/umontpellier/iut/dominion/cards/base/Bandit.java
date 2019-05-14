package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.type.TreasureCard;

import java.util.List;

/**
 * Carte Bandit
 *
 * Gagnez un Or.
 * Chaque joueur révèle les deux premières cartes de son deck, écarte un trésor autre que Cuivre et défausse le reste.
 */
public class Bandit extends Card {
    public Bandit() {
        super("Bandit", 5);
    }

    @Override
    public void play(Player p) {

        p.gainFromSupply("Gold");
        ListOfCards twoFromDeck = new ListOfCards();
        ListOfCards twoFromDeckTreasure = new ListOfCards();
        List<Player> opponents;
        opponents = p.getOtherPlayers();


        for (Player op : opponents) {

            twoFromDeck.add(op.drawCard());
            twoFromDeck.add(op.drawCard());

            for (Card c : new ListOfCards(twoFromDeck)) {
                if (c.getName().equals("Gold")  || c.getName().equals("Silver")){
                    twoFromDeckTreasure.add(c);
                    twoFromDeck.remove(c);
                }
            }

            String choice = p.chooseCard("Choisissez un trésor à écarter",twoFromDeckTreasure,false);
            twoFromDeckTreasure.remove(choice);
            op.removeFromHand(choice);

            if (!twoFromDeckTreasure.isEmpty()) {
                for (Card c : new ListOfCards(twoFromDeckTreasure)) {
                    op.discardCard(c);
                    twoFromDeckTreasure.remove(c);
                }
            }

            if (!twoFromDeck.isEmpty()) {
                for (Card c : new ListOfCards(twoFromDeck)) {
                    op.discardCard(c);
                    twoFromDeck.remove(c);
                }
            }
        }
    }
}
