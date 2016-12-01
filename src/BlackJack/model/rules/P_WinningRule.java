package BlackJack.model.rules;

import BlackJack.model.Player;
import BlackJack.view.IViewVisitorBase;

public class P_WinningRule implements IWinningRules, IStrategyBase {

	@Override
	public boolean WinningRule(Player a_dealer, Player a_player) {
		
		return a_dealer.CalcScore()> a_player.CalcScore();    // in this case the dealer wins just if his score is greater than the player
	}

	@Override
	public void accept(IViewVisitorBase visitor) {
		visitor.visit(this);
	}

}
