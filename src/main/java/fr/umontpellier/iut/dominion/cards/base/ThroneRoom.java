package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.cards.common.type.ActionCard;

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

        ListOfCards actionCardInHand = new ListOfCards();
        int cout = 0;

        for (Card c : p.getCardsInHand()) {
            if (c.getName().equals("Cellar") || c.getName().equals("Chapel") || c.getName().equals("Harbinger")
                    || c.getName().equals("Merchant") || c.getName().equals("Vassal") || c.getName().equals("Village")
                    || c.getName().equals("Workshop")|| c.getName().equals("Bureaucrat")|| c.getName().equals("Gardens")
                    || c.getName().equals("Militia")|| c.getName().equals("Poacher")|| c.getName().equals("Moneylender")
                    || c.getName().equals("Remodel")|| c.getName().equals("Smithy")|| c.getName().equals("ThroneRoom")
                    || c.getName().equals("Bandit")|| c.getName().equals("CouncilRoom")|| c.getName().equals("Festival")
                    || c.getName().equals("Laboratory")|| c.getName().equals("Library")|| c.getName().equals("Market")
                    || c.getName().equals("Mine")|| c.getName().equals("Sentry")|| c.getName().equals("Witch")
                    || c.getName().equals("Artisan") || c.getName().equals("Moat")) {
                actionCardInHand.add(c);
            }
        }

        String cardName = p.chooseCard("Choisissez 1 carte Action de votre main a jouer 2 fois",actionCardInHand, true);
        if (!cardName.equals("")) {
            p.playCard(cardName);
            p.getHand().add(p.getInPlay().remove(cardName));
            p.playCard(cardName);
        }

    }

}