package fxTreenikirja;

import java.io.IOException;

import fi.jyu.mit.fxgui.ModalController;
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
 * @version 15.2.2022
 *
 */
public class KayttajanKysyminenGUIController {
	
	private Stage stage;
	private Scene scene;
	
    /**
     * Scenen vaihtaminen uuden k‰ytt‰j‰n lis‰‰missivulle.
     */
	public void vaihdaUusiKayttaja(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UusiKayttajaGUIView.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
	
    /**
     * Scenen vaihtaminen p‰‰sivulle.
     */
	   public void vaihdaTreeni(ActionEvent event) throws IOException {
		   Parent root = FXMLLoader.load(getClass().getResource("TreenikirjaGUIView.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	   	}
	
	
    @FXML
    private Button uusiKayttaja;
    

    @FXML
    private ComboBox<String> valitseKayttaja;

    
    /**
     * K‰ytt‰j‰listan lis‰‰minen comboBoxiin.
     */
    public void initialize() {
    	ObservableList<String> kayttaja = FXCollections.observableArrayList("Oskari", "Kari", "Ari");
        valitseKayttaja.setItems(kayttaja);
        }

	public static String kysyNimi(Stage modalitySatge, String oletus) {
		return ModalController.showModal(
				KayttajanKysyminenGUIController.class.getResource("KerhonNimiView.fxml"),
				"Treenikirja", modalitySatge, oletus);
	}
    
    
    
    
    }