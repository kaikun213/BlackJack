package BlackJack;

import BlackJack.model.Game;
import BlackJack.model.rules.ConcreteRulesFactoryA;
import BlackJack.model.rules.AbstractRulesFactory;
import BlackJack.view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import BlackJack.controller.*;

public class Program extends Application
{

  public static void main(String[] a_args)
  { 
    launch(a_args); 
  }
  
  @Override 
  public void start(Stage primaryStage) throws Exception { 
	IView v = JavaFX(primaryStage); //new SimpleView();   // JavaFXGUI class connected to the root  
	AbstractRulesFactory rules = new ConcreteRulesFactoryA();
    Game g = new Game(rules, (IViewVisitorBase) v); // Add subject as parameter 
    PlayGame ctrl = new PlayGame(v ,g);  // add Subject as parameter 

   // changed while loop to make it event-based
   ctrl.Play();
  }  
  
  private IView JavaFX(Stage primaryStage){
	  FXMLLoader fxmlLoader = new FXMLLoader(); 
      Parent root;
	try {
		root = fxmlLoader.load(getClass().getResource("view/JavaFXView.fxml").openStream());
		Scene scene = new Scene(root,1000,700); 
	    primaryStage.setScene(scene); 
	    primaryStage.show(); 
	} catch (IOException e) {
		e.printStackTrace();
	}  
      return (IView) fxmlLoader.getController();
  }
  
}
