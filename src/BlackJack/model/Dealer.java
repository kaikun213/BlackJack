package BlackJack.model;

import java.util.ArrayList;
import java.util.List;

import BlackJack.model.rules.*;
import BlackJack.view.IViewVisitorBase;

public class Dealer extends Player {

	
	//Implementing the observer and do the update after getting a new card 
  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinningRules m_winRule;
  private List<INewCardDealedObserver> subscribers;

  public Dealer(AbstractRulesFactory a_rulesFactory, IViewVisitorBase a_visitor) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule(a_visitor);
    m_hitRule = a_rulesFactory.GetHitRule(a_visitor);
    m_winRule = a_rulesFactory.WinningRule(a_visitor);
    
    subscribers = new ArrayList<INewCardDealedObserver>();
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  public boolean Stand () {
	  if (m_deck!=null) {
		  ShowHand();
		  while (m_hitRule.DoHit(this)){
			Hit(this, true);
		  }
	  }
	  return true ; 
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player, boolean showCard) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      Card c;
      c = m_deck.GetCard();
      c.Show(showCard);
      a_player.DealCard(c);
      for (INewCardDealedObserver subscriber : subscribers) subscriber.NotifyNewCardDealed(); 			// calls the Notify () in playGame - notify controller (and print in view) that new card has been dealed
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
	  if (a_player.isGameOver()) {
	      return true;
	    } else if (this.isGameOver()) {
	      return false;
	    }
  
    return m_winRule.WinningRule(this, a_player) ; 
  }

  public boolean IsGameOver() {
    if ((m_deck != null && m_hitRule.DoHit(this) != true)) {
        return true;
    }
    return false;
  }
  
  public void addSubscriber(INewCardDealedObserver subscriber){
	  subscribers.add(subscriber);
  }
  
}