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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import treenikirja.Paivamaara;
import treenikirja.treenikirja;
import treenikirja.SailoException;


/**
 * @author Oskari
 * @version 25.3.2022
 * @version 28.3.2022 - Bugikorjauksia
 * @version 7.4.2022 - HT6
 * @version 21.4.2022 - HT6 uusi
 */
public class TreenikirjaGUIController {
	
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
    void handleAvaa(ActionEvent event) throws SailoException, IOException {
    	avaa();
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
    void handleTallenna(ActionEvent event) throws SailoException {
    	tallenna();
    	Dialogs.showMessageDialog("Tallennettu");
    }

    @FXML
    void handleTietoja(ActionEvent event) {
    	Dialogs.showMessageDialog("Viel‰ ei ole tietoja");
    }

    @FXML
    void handleUusiTreeni(ActionEvent event) {
    	uusiTreeni();
    }

    
    ///-----------------------------------------
    
    
    /**
     * treenityyppien ja hakuehtojen lis‰‰minen comboBoxiin, sek‰ paivamaaraListaan kuuntelija
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

    
    /*
     * Valitun p‰iv‰m‰‰r‰n n‰ytt‰mist‰ varten
     */  
    private Paivamaara paivamaaranKohdalla;
    
    
    /*
     * alue johon valittu p‰iv‰m‰‰r‰ kirjoitetaan
     */
    private TextArea areaJasen = new TextArea();
    
    
    /*
     * Luodaan uusi treeni ja arvotaan sille tyyppi
     */
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
	
        
	/*
	 * Lis‰t‰‰n luotu treeni p‰iv‰m‰‰r‰listaan
	 */
	public void lisaa(int paivamaaranNro) {
		
		paivamaaraLista.clear();
		
		int index = 0;
		for (int i=0; i < treenikirja.getPaivamaarat(); i++) {
			Paivamaara paivamaara = treenikirja.annaPaivamaara(i);
			if (paivamaara.getPaivamaaranNro() == paivamaaranNro) index = i;
			paivamaaraLista.add(paivamaara.getPaivamaara(), paivamaara);
		}
		paivamaaraLista.setSelectedIndex(index);
	}
	
	/*
	 * Lis‰t‰‰n tiedostosta tiedot
	 */
	public void lisaa() {
		
		int index = 0;
		for (int i=0; i < treenikirja.getPaivamaarat(); i++) {
			Paivamaara paivamaara = treenikirja.annaPaivamaara(i);
			if (paivamaara.getPaivamaaranNro() == paivamaara.getPaivamaaranNro()) index = i;
			paivamaaraLista.add(paivamaara.getPaivamaara(), paivamaara);
		}
		paivamaaraLista.setSelectedIndex(index);
	}
	

	/*
	 * Valitun p‰iv‰m‰‰r‰n tiedot
	 */
    protected void naytaJasen() {
    	paivamaaranKohdalla = paivamaaraLista.getSelectedObject();

        areaJasen.setText("");
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(areaJasen)) {
            tulosta(os,paivamaaranKohdalla);  
        }
    }
    

	/*
	 * Tulostaa valitun p‰iv‰m‰‰r‰n tiedot ruudulle
	 */
	public void tulosta(PrintStream os, Paivamaara paiva) {
		paiva.tulosta(os);
	}
	
	
	/*
	 * Valittu treenikirja jota k‰ytet‰‰n t‰ss‰ kyttˆliittymss‰
	 */
	public void setTreenikirja(treenikirja treenikirja) {
		this.treenikirja = treenikirja;
	}
	
	
	/*
	 * Luetaan tiedosto
	 */
    public void avaa() throws SailoException, IOException {
    	String uusinimi = KayttajanKysyminenController.kysyNimi();
    	treenikirja.lueTiedosto(uusinimi);
		paivamaaraLista.clear();
    	lisaa();
    }
    
    
    /*
     * Tallennetaan
     */
    public void tallenna() throws SailoException {
    	treenikirja.tallenna();
    }
    
	
}
