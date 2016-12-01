package BlackJack.model.rules;

import BlackJack.view.IViewVisitorBase;

public interface IStrategyBase {
	
	public void accept(IViewVisitorBase visitor);

}
