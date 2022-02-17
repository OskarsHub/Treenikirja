package fxTreenikirja;


import java.io.IOException;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * @author Oskari
 * @version 25.1.2022
 *
 */
public class TreenikirjaGUIController {

	private Stage stage;
	private Scene scene;
	
	
    @FXML
    private ComboBox<String> hakuehto;

    @FXML
    private Button tallennaButton;

    @FXML
    private ComboBox<String> treeninTyyppi;

    @FXML
    private Button uusiTreeniButton;

    @FXML
    void handleApua(ActionEvent event) {
    	Dialogs.showMessageDialog("Vielä ei tarvita apua");
    }

    @FXML
    void handleLopeta() {
    	Platform.exit();
    }

    @FXML
    void handlePoistaTreeni(ActionEvent event) {
    	Dialogs.showMessageDialog("Vielä ei osata poistaa treeniä");
    }

    @FXML
    void handleTallenna(ActionEvent event) {
    	Dialogs.showMessageDialog("Vielä ei osata tallentaa");
    }

    @FXML
    void handleTietoja(ActionEvent event) {
    	Dialogs.showMessageDialog("Vielä ei ole tietoja");
    }

    @FXML
    void handleUusiTreeni(ActionEvent event) {
    	Dialogs.showMessageDialog("Vielä ei osata lisätä treeniä");
    }

    
    /**
     * Scenen vaihtaminen käyttäjän kysymissivulle.
     */
    public void vaihdaKayttaja(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("KayttajanKysyminenGUIView.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		Dialogs.showMessageDialog("Tietoja ei tallennettu");
    }

    /**
     * treenityyppien ja hakuehtojen lisääminen comboBoxiin.
     */
    public void initialize() {
    	ObservableList<String> treenit = FXCollections.observableArrayList("Lenkki", "Sali", "Fitness", "Pyöräily", "Pallopelit", "Jooga", "Talviurheilu", "Vesiurheilu");
    	ObservableList<String> hakuehdot = FXCollections.observableArrayList("Päivämäärä", "Treenin tyyppi");
    	treeninTyyppi.setItems(treenit);
    	hakuehto.setItems(hakuehdot);
        }
}