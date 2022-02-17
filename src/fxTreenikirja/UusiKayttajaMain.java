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
public class UusiKayttajaMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("UusiKayttajaGUIView.fxml"));
            final Pane root = ldr.load();
            //final UusiKayttajaGUIController uusikayttajaCtrl = (UusiKayttajaGUIController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("uusikayttaja.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("UusiKayttaja");
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