package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.view.IViewVisitorBase;
 

public class AmericanNewGameStrategy implements INewGameStrategy, IStrategyBase {

  public boolean NewGame(Dealer a_dealer, Player a_player) {
	  a_dealer.Hit(a_player, true);
	  a_dealer.Hit(a_dealer, true);
	  a_dealer.Hit(a_player, true);
	  a_dealer.Hit(a_dealer, false);
    return true;
  }
  
  @Override
  public void accept(IViewVisitorBase visitor) {
  	visitor.visit(this);
  }
}