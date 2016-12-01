package BlackJack.model.rules;

import BlackJack.view.IViewVisitorBase;

public abstract class AbstractRulesFactory {
		  
	  protected AbstractRulesFactory(){
	  }

	  public abstract IHitStrategy GetHitRule(IViewVisitorBase a_visitor);

	  public abstract INewGameStrategy GetNewGameRule(IViewVisitorBase a_visitor);
	  
	  public abstract IWinningRules WinningRule(IViewVisitorBase a_visitor);

}