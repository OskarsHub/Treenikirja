package fxTreenikirja;

import java.io.IOException;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
     */
	public void vaihdaTreenikirja(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("TreenikirjaGUIView.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		Dialogs.showMessageDialog("Viel‰ ei osata lis‰t‰ k‰ytt‰j‰‰");
	}
	
    @FXML
    private TextField nimikentta;

    @FXML
    private Button okButton;

    @FXML
    private Button peruuta;
    
}