package fr.umontpellier.iut.dominion.cards.common.type;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.CardType;

import java.util.List;
public class VictoryCard extends Card {
    public VictoryCard(String name, int cost) {
        super(name, cost);
    }

    public List<CardType> getTypes() {
        List<CardType> types = super.getTypes();
        types.add(CardType.Victory);
        return types;
    }
}
