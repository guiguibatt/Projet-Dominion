package fr.umontpellier.iut.dominion.cards.common.type;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.CardType;

import java.util.List;

public class CurseCard extends Card {
    public CurseCard(String name, int cost) {
        super(name, cost);
    }

    public List<CardType> getTypes() {
        List<CardType> types = super.getTypes();
        types.add(CardType.Curse);
        return types;
    }
}
