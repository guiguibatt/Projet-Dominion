package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import java.util.List;

/**
 * Carte Sorcière (Witch)
 *
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends Card {
    public Witch() {
        super("Witch", 5);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();

        List<Player> opponents;
        opponents = p.getOtherPlayers();


        for (Player op : opponents) {
            op.gainFromSupply("Curse");

        }

    }
}