package fxTreenikirja;

import java.io.IOException;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import treenikirja.SailoException;

/**
 * @author Oskari
 * @version 15.2.2022
 *
 */
public class UusiKayttajaGUIController {

	private Stage stage;
	private Scene scene;
	
    /**
     * Scenen vaihtaminen k‰ytt‰j‰n kysymissivulle.
     */
	public void vaihdaKayttajanKysyminen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("KayttajanKysyminenGUIView.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
    /**
     * Scenen vaihtaminen p‰‰sivulle.
     * @throws SailoException 
     */
	public void vaihdaTreenikirja(ActionEvent event) throws IOException, SailoException {
		Parent root = FXMLLoader.load(getClass().getResource("TreenikirjaGUIView.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		String treenikirjaNimi =  nimikentta.getText();

		TreenikirjaGUIController.avaa(treenikirjaNimi);

	}
	
    @FXML
    private TextField nimikentta;

    @FXML
    private Button okButton;

    @FXML
    private Button peruuta;
    
    
    public static String kysyNimi(Stage modalityStage, String oletus) {
    	return ModalController.showModal(
    	UusiKayttajaGUIController.class.getResource("KayttajanKysyminenGUIView.fxml"),
    	"Kerho",
    	modalityStage, oletus);
    	}
}