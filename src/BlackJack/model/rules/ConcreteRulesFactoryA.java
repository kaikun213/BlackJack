package BlackJack.model.rules;

import BlackJack.view.IViewVisitorBase;

public class ConcreteRulesFactoryA extends AbstractRulesFactory {
	  
	@Override
	  public IHitStrategy GetHitRule(IViewVisitorBase a_visitor) {
		Soft17HitStrategy strategy =  new Soft17HitStrategy();
		strategy.accept(a_visitor);
	    return strategy;
	  }
	  @Override
	  public INewGameStrategy GetNewGameRule(IViewVisitorBase a_visitor) {
	    AmericanNewGameStrategy strategy =  new AmericanNewGameStrategy();
		strategy.accept(a_visitor);
	    return strategy;
	  }
	  @Override
	  public IWinningRules WinningRule(IViewVisitorBase a_visitor) { 
		D_WinningRule strategy =  new D_WinningRule();
		strategy.accept(a_visitor);
	    return strategy;
	  }

}
