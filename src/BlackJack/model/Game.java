package BlackJack.model;

import BlackJack.view.IViewVisitorBase;

public class Game {

  private Dealer m_dealer;
  private Player m_player;

  public Game(BlackJack.model.rules.AbstractRulesFactory rules,IViewVisitorBase a_visitor)
  {
    m_dealer = new Dealer(rules, a_visitor);
    m_player = new Player();
  }
    
    
  public boolean IsGameOver()
  {
	  if (m_dealer.IsGameOver() || m_dealer.isGameOver() || m_player.isGameOver()){
	    	m_dealer.ShowHand();
	    	return true;
	    }
	    return false;
  }
  
  public boolean IsDealerWinner()
  {
    return m_dealer.IsDealerWinner(m_player);
  }
  
  public boolean NewGame()
  {
    return m_dealer.NewGame(m_player);
  }
  
  public boolean Hit()
  {
    return m_dealer.Hit(m_player, true);
  }
  
  public boolean Stand()
  {
	  return m_dealer.Stand() ; 
  }
  
  public Iterable<Card> GetDealerHand()
  {
    return m_dealer.GetHand();
  }
  
  public Iterable<Card> GetPlayerHand()
  {
    return m_player.GetHand();
  }
  
  public int GetDealerScore()
  {
    return m_dealer.CalcScore();
  }
  
  public int GetPlayerScore()
  {
    return m_player.CalcScore();
  }
  
  public void addSubscriber(INewCardDealedObserver subscriber){
	  m_dealer.addSubscriber(subscriber); 			// add subscriber to publisher (dealer) for event -> new card = notify
  }
    
  
}