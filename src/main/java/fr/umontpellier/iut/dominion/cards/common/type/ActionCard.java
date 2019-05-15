package fr.umontpellier.iut.dominion.cards.common.type;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.CardType;

import java.util.List;

public class ActionCard extends Card {
    public ActionCard(String name, int cost) {
        super(name, cost);
    }

    public List<CardType> getTypes() {
        List<CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}

