package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Sentinelle (Sentry)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez les 2 premières cartes de votre deck. Écartez et/ou défaussez celles que vous voulez.
 * Replacez les autres sur votre deck dans l'ordre de votre choix.
 */
public class Sentry extends Card {
    public Sentry() {
        super("Sentry", 5);
    }

    @Override
    public void play(Player p) {

        p.drawToHand();
        p.incrementActions(1);

        ListOfCards twoFromDeck = new ListOfCards();
        twoFromDeck.add(p.drawCard());
        twoFromDeck.add(p.drawCard());


        String choiceTrash = "texte-non-vide";
        String choiceDiscard = "texte-non-vide";
        int i = 0;

        while (!choiceTrash.equals("") || i < 2) {
            choiceTrash = p.chooseCard("Choisissez une carte à écarter", twoFromDeck, true);
            i++;

            for (Card c : twoFromDeck) {
                if (choiceTrash.equals(c.getName())) {
                    twoFromDeck.remove(c.getName());
                }
            }
        }


        while (!choiceDiscard.equals("") || i < 3) {
            choiceDiscard = p.chooseCard("Choisissez une carte à défausser", twoFromDeck, false);
            i++;

            for (Card c : twoFromDeck) {
                if (choiceDiscard.equals(c.getName())) {
                    p.addToDraw(c);
                    twoFromDeck.remove(c);

                }

            }


        }
    }
}
