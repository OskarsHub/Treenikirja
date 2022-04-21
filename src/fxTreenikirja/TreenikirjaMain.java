package fxTreenikirja;

import java.awt.Frame;
import java.io.IOException;

import javafx.application.Application;
import javafx.css.Style;
import javafx.stage.Stage;
import treenikirja.treenikirja;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author Oskari
 * @version 25.1.2022
 *
 */
public class TreenikirjaMain extends Application {
	
    @Override
    public void start(Stage primaryStage) throws IOException {
    	
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("TreenikirjaGUIView.fxml"));
            final Pane root = ldr.load();
            final TreenikirjaGUIController treenikirjaCtrl = (TreenikirjaGUIController)ldr.getController();
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("treenikirja.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Treenikirja");

            treenikirja treenikirja = new treenikirja();  
            treenikirjaCtrl.setTreenikirja(treenikirja);

            
            primaryStage.show();
            
    	}
    
    
    /**
     * @param args Ei kytss
     */
    public static void main(String[] args) {
        launch(args);
    }
}
