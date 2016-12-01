package BlackJack.model.rules;

import BlackJack.model.Player;
import BlackJack.view.IViewVisitorBase;

public class BasicHitStrategy implements IHitStrategy,IStrategyBase {
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
      return a_dealer.CalcScore() < g_hitLimit;  
    }

	@Override
	public void accept(IViewVisitorBase visitor) {
		visitor.visit(this);
	}
}