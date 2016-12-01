package BlackJack.controller;

import BlackJack.view.IView;
import javafx.application.Platform;
import BlackJack.model.Game;
import BlackJack.model.INewCardDealedObserver;

public class PlayGame implements INewCardDealedObserver, IButtonPressedObserver{
	
	private IView a_view ; 
	private Game a_game ; 
	
	public PlayGame (IView a_view , Game a_game) {
		this.a_view = a_view ;                              // Adding Subject in the constructor
		a_view.addSubscriber(this);
		this.a_game = a_game ; 
		
		a_game.addSubscriber(this); 
	}

  public void Play() {
	showPlayerHands();
    a_view.DisplayWelcomeMessage();
  }
  
  public void playButtonPressed(){
      a_game.NewGame();
      showPlayerHands();
 	  checkGameOver();
  }
  
  public void hitButtonPressed(){
	 a_game.Hit();
	 showPlayerHands();
	 checkGameOver();
  }
  
  public void standButtonPressed(){
	  a_game.Stand();
	  showPlayerHands();
      checkGameOver();
  }
  
  public void quitButtonPressed(){
	  Platform.exit();		// exits javaFX application
	  System.exit(0); 		// exits console
  }
  
  private void checkGameOver(){
	  if (a_game.IsGameOver())
	    {
	        a_view.DisplayGameOver(a_game.IsDealerWinner());
	    }
  }
  
  private void showPlayerHands(){
	  a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
	  a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
  }
  
  @Override
  public void NotifyNewCardDealed() {
		  try {
			  a_view.DisplayDealerStatus();    // Display the Dealer status
			  Thread.sleep(2500); //Delay
			  a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore()); 
			  a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
		  }
		  catch ( InterruptedException e ) {
			  e.printStackTrace(); 
		  }
  }
  
}