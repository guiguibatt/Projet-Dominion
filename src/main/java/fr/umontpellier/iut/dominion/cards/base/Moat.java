package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> choices = Arrays.asList("y", "n");
        String answer = (String) p.choose("Voulez vous jouer votre carte Douves?", choices , false,true);
        return answer.equalsIgnoreCase("y");
    }
    }
