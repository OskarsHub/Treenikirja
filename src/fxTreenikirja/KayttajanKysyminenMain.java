package fxTreenikirja;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author Oskari
 * @version 15.2.2022
 *
 */
public class KayttajanKysyminenMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("KayttajanKysyminenGUIView.fxml"));
            final Pane root = ldr.load();
            //final KayttajanKysyminenGUIController kayttajankysyminenCtrl = (KayttajanKysyminenGUIController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("kayttajankysyminen.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Treenikirja");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei käytössä
     */
    public static void main(String[] args) {
    	
    	
        launch(args);
    }
}