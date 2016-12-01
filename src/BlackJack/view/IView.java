package BlackJack.view;

import BlackJack.controller.IButtonPressedObserver;

public interface IView
{
  void DisplayWelcomeMessage();
 // int GetInput();
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
  void DisplayDealerStatus () ; // Observer 
  void addSubscriber(IButtonPressedObserver subscriber);
}