package fxTreenikirja;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

/**
 * @author Oskari
 * @version 25.1.2022
 *
 */
public class TreenikirjaGUIController {

	
    @FXML
    private ChoiceBox treeninTyyppi;
   
    ObservableList<String> treeniTyyppiValinnat = FXCollections.observableArrayList("Lenkki", "Sali","Fitness");
    
    @FXML
    private void initialize() {
    	treeninTyyppi.setItems(treeniTyyppiValinnat);
    }
    
}