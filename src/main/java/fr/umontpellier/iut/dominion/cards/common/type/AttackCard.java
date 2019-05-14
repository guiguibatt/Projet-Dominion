package fr.umontpellier.iut.dominion.cards.common.type;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.cards.base.Moat;

import java.util.List;

public abstract class AttackCard extends ActionCard {

    public AttackCard(String name, int cost) {
        super(name, cost);
        // TODO Auto-generated constructor stub
    }

    public boolean PlayerHasMoatInHand(Player p){
        Card moat;
        for(int i = 0; i < p.getHand().size(); i++){
            moat = p.getHand().get(i);
            if(moat instanceof Moat)
            {
                return ((Moat)moat).devoileCarte(p);
            }
        }
        return false;
    }
    public List<CardType> getTypes() {
        List<CardType> types = super.getTypes();
        types.add(CardType.Attack);
        return types;
    }
}