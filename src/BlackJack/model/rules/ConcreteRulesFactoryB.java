package BlackJack.model.rules;

import BlackJack.view.IViewVisitorBase;

public class ConcreteRulesFactoryB extends AbstractRulesFactory {
	  
	@Override
	  public IHitStrategy GetHitRule(IViewVisitorBase a_visitor) {
	    BasicHitStrategy strategy =  new BasicHitStrategy();
		strategy.accept(a_visitor);
	    return strategy;
	  }
	  @Override
	  public INewGameStrategy GetNewGameRule(IViewVisitorBase a_visitor) {
	    InternationalNewGameStrategy strategy =  new InternationalNewGameStrategy();
		strategy.accept(a_visitor);
	    return strategy;
	  }
	  @Override
	  public IWinningRules WinningRule(IViewVisitorBase a_visitor) { 
		P_WinningRule strategy =  new P_WinningRule();
		strategy.accept(a_visitor);
	    return strategy;
	  }

}
