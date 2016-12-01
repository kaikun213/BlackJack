package BlackJack.view;

import java.util.ArrayList;
import java.util.List;

import BlackJack.controller.IButtonPressedObserver;
import BlackJack.model.rules.AmericanNewGameStrategy;
import BlackJack.model.rules.BasicHitStrategy;
import BlackJack.model.rules.D_WinningRule;
import BlackJack.model.rules.InternationalNewGameStrategy;
import BlackJack.model.rules.P_WinningRule;
import BlackJack.model.rules.Soft17HitStrategy;

public class SimpleView implements IView, IViewVisitorBase
{

	List<IButtonPressedObserver> subscribers;
	
	public SimpleView(){
		subscribers = new ArrayList<IButtonPressedObserver>();
	}

	@Override
	public void addSubscriber(IButtonPressedObserver subscriber) {
		subscribers.add(subscriber);
	}
	
	public void DisplayWelcomeMessage(){
          for(int i = 0; i < 1; i++) {System.out.print("\n");}; 
          System.out.println("Hello Black Jack World");
          GetInput();	// initializes endless loop
    }
	  

    private void GetInput(){
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
      try {
        int c = System.in.read();
        while (c == '\r' || c =='\n') {
          c = System.in.read();
        }
        if ( c=='p') {
        	for (IButtonPressedObserver subscriber : subscribers){
 			   subscriber.playButtonPressed();
 		   }
        	 }
        	else if (c=='h') {
        		for (IButtonPressedObserver subscriber : subscribers){
     			   subscriber.hitButtonPressed();
     		   }
        	}
        	else if (c=='s') {
        		for (IButtonPressedObserver subscriber : subscribers){
      			   subscriber.standButtonPressed();
      		   } 
        	}
        	else if (c=='q') {
        		for (IButtonPressedObserver subscriber : subscribers){
      			   subscriber.quitButtonPressed();
      		   }
        	}
        	GetInput();	// endless loop
        	  
      } catch (java.io.IOException e) {
        System.out.println("" + e);
      }
    }

        public void DisplayCard(BlackJack.model.Card a_card)
        {
            System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
        }

        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Player", a_hand, a_score);
        }

        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Dealer", a_hand, a_score);
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Has: ");
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Score: " + a_score);
            System.out.println("");
        }

        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("GameOver: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Dealer Won!");
            }
            else
            {
                System.out.println("You Won!");
            }
            
        }

		@Override
		public void DisplayDealerStatus() {
		for ( int i = 0 ; i<1 ; i++ ) {
			System.out.println() ; }
			System.out.println("getting a card...\n");
			
		
			
		}
		@Override
		public void visit(AmericanNewGameStrategy americanNewGameStrategy) {
			System.out.println("GameStrategy: American");
		}
		@Override
		public void visit(InternationalNewGameStrategy internationalNewGameStrategy) {
			System.out.println("GameStrategy: Inernational");
		}
		@Override
		public void visit(BasicHitStrategy basicHitStrategy) {
			System.out.println("HitStrategy: Basic");			
		}
		@Override
		public void visit(Soft17HitStrategy soft17HitStrategy) {
			System.out.println("HitStrategy: Soft17");			
		}
		@Override
		public void visit(D_WinningRule d_winingRule) {
			System.out.println("WinningRule: Dealer");			
		}
		@Override
		public void visit(P_WinningRule p_WiningRule) {
			System.out.println("WinningRule: Player");			
		}
    }
