package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Merchant;

/**
 * Carte Argent (Silver)
 *
 * 2 Pièces
 */
public class Silver extends Card {
    public Silver() {
        super("Silver", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
        if (p.getInPlay().getCard("Merchant")!=null){
          if (p.getInPlay().getCard("Silver")==null){
              p.incrementMoney(1);
          }
        }
    }
}
