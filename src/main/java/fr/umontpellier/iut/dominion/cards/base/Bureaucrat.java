package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Bureaucrate (Bureaucrat)
 *
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur
 * main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends Card {
    public Bureaucrat() {
        super("Bureaucrat", 4);
    }


    //Lors de la création de cette méthode, le type des cartes n'etaient pas implémentées, c'est pour cela que

    @Override
    public void play(Player p) {
        Card c = p.gainFromSupply("Silver");
        p.removeFromDiscard(c.getName());
        p.addToDraw(c);

        List<Player> opponents;
        opponents = p.getOtherPlayers();
        boolean n = false;


        for (Player op : opponents) {

            ListOfCards victoryCardInhand = new ListOfCards();

            for (Card c2 : op.getCardsInHand()) {
                if (c2.getName().equals("Duchy") || c2.getName().equals("Estate") || c2.getName().equals("Province") ) {
                    victoryCardInhand.add(c2);
                }
            }

                if (!victoryCardInhand.isEmpty()) {
                    while (!n) {
                        String choice = op.chooseCard("Choisissez une carte victoire à poser sur votre deck", victoryCardInhand, false);

                        for (Card c3 : new ListOfCards(op.getCardsInHand())) {
                            if (choice.equals(c3.getName())) {
                                op.addToDraw(c3);
                                op.removeFromHand(choice);
                                n = true;
                            }

                        }
                    }


                    for (Card c4 : new ListOfCards(victoryCardInhand)) {
                        victoryCardInhand.remove(c4);

                    }

                }

            n=false;
        }
    }
}