package BlackJack.model.rules;

import BlackJack.model.Card;

import BlackJack.model.Player;
import BlackJack.view.IViewVisitorBase;


public class Soft17HitStrategy implements IHitStrategy,IStrategyBase  {
	private final int g_hitLimit = 17;

	@Override
	public boolean DoHit(Player a_dealer) {
	int score = a_dealer.CalcScore() ; 
	// pureScore to test if the ace in the hand is already counted as one. Then, even when it is 17, the dealer should not take a new card
	int pureScore = a_dealer.CalcPureScore(false);
		     if (score ==g_hitLimit && pureScore == score) {      // if score is equal to 17 and the ace is not already counted as 1
		    	 Iterable<Card> list = a_dealer.GetHand()  ;   // going through all the cards that the dealer has in his hand
		    	 
		    	 for ( Card c :list ) {                          
		    		 if (c.GetValue() == Card.Value.Ace ) return true ; 
		    	 }
		    	 return false ;
		    	 
		
		 }
		     else return score < g_hitLimit ; 	     
	}

	@Override
	public void accept(IViewVisitorBase visitor) {
		visitor.visit(this);
	}}
	


