package fr.umontpellier.iut.dominion.cards.common.type;

import fr.umontpellier.iut.dominion.CardType;

import java.util.List;
public class ReactionCard extends ActionCard {
    public ReactionCard(String name, int cost) {
        super(name, cost);
    }

    public List<CardType> getTypes() {
        List<CardType> types = super.getTypes();
        types.add(CardType.Reaction);
        return types;
    }
}
