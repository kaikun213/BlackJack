package BlackJack.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import BlackJack.controller.IButtonPressedObserver;
import BlackJack.model.Card;
import BlackJack.model.rules.AmericanNewGameStrategy;
import BlackJack.model.rules.BasicHitStrategy;
import BlackJack.model.rules.D_WinningRule;
import BlackJack.model.rules.InternationalNewGameStrategy;
import BlackJack.model.rules.P_WinningRule;
import BlackJack.model.rules.Soft17HitStrategy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class JavaFXView implements Initializable, IView, IViewVisitorBase {
	
	@FXML FlowPane topPane;
	@FXML Button hit;
	@FXML Button play;
	@FXML Button quit;
	@FXML Button stand;
	@FXML Label window;
	@FXML Label dealerDisplay;
	@FXML Label playerDisplay;
	@FXML Label newGameStrategy;
	@FXML Label hitStrategy;
	@FXML Label winStrategy;
	@FXML Label winnerDisplay;
	@FXML Label processDisplay;
	
	List<IButtonPressedObserver> subscribers;
	
	public void addSubscriber(IButtonPressedObserver subscriber){
		subscribers.add(subscriber);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		subscribers = new ArrayList<IButtonPressedObserver>();
		winnerDisplay.setVisible(false);
		processDisplay.setVisible(false);
		processDisplay.setText("");	//empty

		play.setOnAction((event) -> {
			winnerDisplay.setVisible(false);
		   for (IButtonPressedObserver subscriber : subscribers){
			   subscriber.playButtonPressed();
		   }
		});	
		
		quit.setOnAction((event) -> {
			   for (IButtonPressedObserver subscriber : subscribers){
				   subscriber.quitButtonPressed();
			   }
			});	
		
		hit.setOnAction((event) -> {
			   for (IButtonPressedObserver subscriber : subscribers){
				   subscriber.hitButtonPressed();
			   }
			});	
		
		stand.setOnAction((event) -> {
			   for (IButtonPressedObserver subscriber : subscribers){
				   subscriber.standButtonPressed();
			   }
			});	
	}

	@Override
	public void visit(AmericanNewGameStrategy americanNewGameStrategy) {
		newGameStrategy.setText("GameStrategy:\n American");
	}
	@Override
	public void visit(InternationalNewGameStrategy internationalNewGameStrategy) {
		newGameStrategy.setText("GameStrategy:\n Inernational");
	}
	@Override
	public void visit(BasicHitStrategy basicHitStrategy) {
		hitStrategy.setText("HitStrategy:\n Basic");			
	}
	@Override
	public void visit(Soft17HitStrategy soft17HitStrategy) {
		hitStrategy.setText("HitStrategy:\n Soft17");			
	}
	@Override
	public void visit(D_WinningRule d_winingRule) {
		winStrategy.setText("WinningRule:\n Dealer");			
	}
	@Override
	public void visit(P_WinningRule p_WiningRule) {
		winStrategy.setText("WinningRule:\n Player");			
	}

	@Override
	public void DisplayWelcomeMessage() {
		window.setText("Hello Black Jack World");
	}

	@Override
	public void DisplayPlayerHand(Iterable<Card> a_hand, int a_score) {
        DisplayHand("Player", a_hand, a_score, playerDisplay);				
	}

	@Override
	public void DisplayDealerHand(Iterable<Card> a_hand, int a_score) {
        DisplayHand("Dealer", a_hand, a_score, dealerDisplay);		
	}
	
	private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score, Label display)
    {
		String s = (a_name + " Has: \n");
        for(BlackJack.model.Card c : a_hand)
        {
            s += DisplayCard(c);
        }
        s += ("Score: " + a_score + "\n\n");
        display.setText(s);
    }
	
	private String DisplayCard(Card a_card) {
        return ("" + a_card.GetValue() + " of " + a_card.GetColor() + "\n");		
	}

	@Override
	public void DisplayGameOver(boolean a_dealerIsWinner) {
		winnerDisplay.setVisible(true);
		processDisplay.setVisible(true);
		processDisplay.setText("GameOver");
        if (a_dealerIsWinner)
        {
        	winnerDisplay.setText("Dealer Won!");
        }
        else
        {
        	winnerDisplay.setText("You Won!");
        }		
	}
	

	@Override
	public void DisplayDealerStatus() {
		processDisplay.setVisible(true);
		// No notification given
		//processDisplay.setText(processDisplay.getText() + "\n" + "New card dealed");		
	}
	

}
