package fxTreenikirja;


import java.io.IOException;
import java.io.PrintStream;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.TextAreaOutputStream;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import treenikirja.Paivamaara;
import treenikirja.treenikirja;
import treenikirja.SailoException;


/**
 * @author Oskari
 * @version 25.1.2022
 *
 */
public class TreenikirjaGUIController {
		
	private Stage stage;
	private Scene scene;
	
	treenikirja treenikirja = new treenikirja();
	
	
    @FXML
    private ListChooser<Paivamaara> paivamaaraLista;
    
    @FXML
    private ComboBox<String> hakuehto;

    @FXML
    private Button tallennaButton;
    
    @FXML
    private ScrollPane treeniTaulukko;
    
    
    @FXML
    void uusiTreeniButton(ActionEvent event) {
    	uusiTreeni();
    }
    
    @FXML
    void handleApua(ActionEvent event) {
    	Dialogs.showMessageDialog("Viel‰ ei tarvita apua");
    }

    @FXML
    void handleLopeta() {
    	Platform.exit();
    }

    @FXML
    void handlePoistaTreeni(ActionEvent event) {
    	Dialogs.showMessageDialog("Viel‰ ei osata poistaa treeni‰");
    }

    @FXML
    void handleTallenna(ActionEvent event) {
    	Dialogs.showMessageDialog("Viel‰ ei osata tallentaa");
    }

    @FXML
    void handleTietoja(ActionEvent event) {
    	Dialogs.showMessageDialog("Viel‰ ei ole tietoja");
    }

    @FXML
    void handleUusiTreeni(ActionEvent event) {
    	uusiTreeni();
    }

	/**
     * Scenen vaihtaminen k‰ytt‰j‰n kysymissivulle.
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
     * treenityyppien ja hakuehtojen lis‰‰minen comboBoxiin.
     */
    public void initialize() {
    	ObservableList<String> hakuehdot = FXCollections.observableArrayList("P‰iv‰m‰‰r‰", "Treenin tyyppi");
    	hakuehto.setItems(hakuehdot);
    	
    	treeniTaulukko.setContent(areaJasen);
        areaJasen.setFont(new Font("Courier New", 12));
        treeniTaulukko.setFitToHeight(true);

    	
    	paivamaaraLista.clear();
    	paivamaaraLista.addSelectionListener(e -> naytaJasen());
        }


///-----------------------------------------

    
    private Paivamaara paivamaaranKohdalla;
    private TextArea areaJasen = new TextArea();
    
        
	private void uusiTreeni() {
    	Paivamaara uusi = new Paivamaara();
    	uusi.luoTreeni();
    	try {
			treenikirja.lisaa(uusi);
		} catch (SailoException e) {
			e.printStackTrace();
			return;
		}
    	lisaa(uusi.getPaivamaaranNro());
	}
        

	private void lisaa(int paivamaaranNro) {
		
		paivamaaraLista.clear();
		
		int index = 0;
		for (int i=0; i < treenikirja.getPaivamaarat(); i++) {
			Paivamaara paivamaara = treenikirja.annaPaivamaara(i);
			if (paivamaara.getPaivamaaranNro() == paivamaaranNro) index = i;
			paivamaaraLista.add(paivamaara.getPaivamaara(), paivamaara);
		}
		paivamaaraLista.setSelectedIndex(index);
	}

	
    protected void naytaJasen() {
    	paivamaaranKohdalla = paivamaaraLista.getSelectedObject();

        areaJasen.setText("");
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(areaJasen)) {
            tulosta(os,paivamaaranKohdalla);  
        }
    }

	
	public void tulosta(PrintStream os, Paivamaara paiva) {
		paiva.tulosta(os);
	}
	

	public void setTreenikirja(treenikirja treenikirja) {
		this.treenikirja = treenikirja;
	}
	
}