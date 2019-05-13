package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.Player;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Carte Douves (Moat)
 *
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. Dans ce
 * cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends Card {
    public Moat() {
        super("Moat", 2);
    }

    public Moat(String name, int cost) {
        super(name, cost);
    }

    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();
    }

    public boolean devoileCarte(Player p) {
        String answer = (String) p.choose("Do you want to play your moat card ?", new ArrayList(Arrays.asList("y", "n")), false,true);
        return answer.equalsIgnoreCase("y");
    }
    }
