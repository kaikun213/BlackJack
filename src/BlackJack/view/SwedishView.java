package BlackJack.view;

import BlackJack.controller.IButtonPressedObserver;
import BlackJack.model.rules.AmericanNewGameStrategy;
import BlackJack.model.rules.BasicHitStrategy;
import BlackJack.model.rules.D_WinningRule;
import BlackJack.model.rules.InternationalNewGameStrategy;
import BlackJack.model.rules.P_WinningRule;
import BlackJack.model.rules.Soft17HitStrategy;


/**************************************
 * 
 * NOT MAINTAINED
 *
 */
public class SwedishView implements IView, IViewVisitorBase
    {
        public void DisplayWelcomeMessage()
        {
         
            for(int i = 0; i < 50; i++) {System.out.print("\n");};

            System.out.println("Hej Black Jack Världen");
            System.out.println("----------------------");
            System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
        }
        
        
        public int GetInput()
        {
          try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
              c = System.in.read();
            }
            return c;
          } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
          }
        }
        
        public void DisplayCard(BlackJack.model.Card a_card)
        {
            if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hjärter", "Spader", "Ruter", "Klöver" };
                String values[] =  
                    { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
        }
        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Poäng: " + a_score);
            System.out.println("");
        }

        @Override
		public void DisplayDealerStatus() {
		for ( int i = 0 ; i<20 ; i++ ) {
			System.out.println() ; 
			System.out.println("Dealer Getting a card");
			
		}	
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


		@Override
		public void addSubscriber(IButtonPressedObserver subscriber) {
			// TODO Auto-generated method stub
			
		}
    }
