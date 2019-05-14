package fr.umontpellier.iut.dominion.cards.common.type;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.CardType;

import java.util.List;
public abstract class TreasureCard extends Card {
    public TreasureCard(String name, int cost) {
        super(name, cost);
    }

    public abstract int treasureValue();

    public List<CardType> getTypes() {
        List<CardType> types = super.getTypes();
        types.add(CardType.Treasure);
        return types;
    }

    public void play(Player p) {
        p.incrementMoney(this.treasureValue());
    }
}
