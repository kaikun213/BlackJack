package BlackJack.view;

import BlackJack.model.rules.AmericanNewGameStrategy;
import BlackJack.model.rules.BasicHitStrategy;
import BlackJack.model.rules.D_WinningRule;
import BlackJack.model.rules.InternationalNewGameStrategy;
import BlackJack.model.rules.P_WinningRule;
import BlackJack.model.rules.Soft17HitStrategy;

public interface IViewVisitorBase {
	void visit(AmericanNewGameStrategy americanNewGameStrategy);
	void visit(InternationalNewGameStrategy internationalNewGameStrategy);

	void visit(BasicHitStrategy basicHitStrategy);
	void visit(Soft17HitStrategy soft17HitStrategy);
	
	void visit(D_WinningRule d_winingRule);
	void visit(P_WinningRule p_WiningRule);
 
}
