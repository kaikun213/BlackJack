package BlackJack.model.rules;

import BlackJack.model.Player;
import BlackJack.view.IViewVisitorBase;

public class D_WinningRule implements IWinningRules, IStrategyBase {

	@Override
	public boolean WinningRule(Player a_dealer, Player a_player) {
		return a_dealer.CalcScore()>= a_player.CalcScore(); // if dealer has greater or equal than the player so the dealer wins
	}

	@Override
	public void accept(IViewVisitorBase visitor) {
		visitor.visit(this);
	}

}
