package fxTreenikirja;



import java.io.IOException;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import treenikirja.Paivamaara;
import treenikirja.treenikirja;
import treenikirja.SailoException;


/**
 * @author Oskari
 * @version 25.3.2022
 * @version 28.3.2022 - Bugikorjauksia
 * @version 7.4.2022 - HT6
 * @version 21.4.2022 - HT6 uusi
 * @version 29.4.2022 - HT7
 * @version 6.5.4.2022 - HT7 lisätty oikeellisuustarkistus
 */
public class TreenikirjaGUIController {
	
	treenikirja treenikirja = new treenikirja();
	private boolean oikeinA = true;
	private boolean oikeinKa = true;
	private boolean oikeinKeH = true;
	private boolean oikeinKeMin = true;
	private boolean oikeinM = true;
	private boolean oikeinS = true;
	
	
    @FXML
    private TextField askeleet;
    
    @FXML
    void handleAskeleet(KeyEvent event) {
    	oikeinA = tarkista(askeleet.getText());
    	
    	if (oikeinA == false) {
    		askeleet.setStyle("-fx-text-inner-color: red;");
    	}
    	
    	if (oikeinA == true) {
    		askeleet.setStyle("-fx-text-inner-color: black;");
    	}
    	
    }

	@FXML
    private TextField kalorit;
    
    @FXML
    void handleKalorit(KeyEvent event) {
    	oikeinKa = tarkista(kalorit.getText());
    	
    	if (oikeinKa == false) {
    		kalorit.setStyle("-fx-text-inner-color: red;");
    	}
    	
    	if (oikeinKa == true) {
    		kalorit.setStyle("-fx-text-inner-color: black;");
    	}
    	
    }
    
    @FXML
    private Text kcalText;

    @FXML
    private TextField kestoH;
    
    @FXML
    void handleKestoH(KeyEvent event) {
    	oikeinKeH = tarkista(kestoH.getText());
    	
    	if (oikeinKeH == false) {
    		kestoH.setStyle("-fx-text-inner-color: red;");
    	}
    	
    	if (oikeinKeH == true) {
    		kestoH.setStyle("-fx-text-inner-color: black;");
    	}
    	
    }
    
    @FXML
    private Text hText;

    @FXML
    private TextField kestoMin;
    

    @FXML
    void handleKestoMin(KeyEvent event) {
    	oikeinKeMin = tarkista(kestoMin.getText());
    	
    	if (oikeinKeMin == false) {
    		kestoMin.setStyle("-fx-text-inner-color: red;");
    	}
    	
    	if (oikeinKeMin == true) {
    		kestoMin.setStyle("-fx-text-inner-color: black;");
    	}
    	
    }


	@FXML
    private Text minText;

    @FXML
    private TextField matka;
    
    @FXML
    void handleMatka(KeyEvent event) {
    	oikeinM = tarkista(matka.getText());
    	
    	if (oikeinM == false) {
    		matka.setStyle("-fx-text-inner-color: red;");
    	}
    	
    	if (oikeinM == true) {
    		matka.setStyle("-fx-text-inner-color: black;");
    	}
    	
    }
    
    @FXML
    private Text kmText;

    @FXML
    private TextField syke;
    
    @FXML
    void handleSyke(KeyEvent event) {
    	oikeinS = tarkista(syke.getText());
    	
    	if (oikeinS == false) {
    		syke.setStyle("-fx-text-inner-color: red;");
    	}
    	
    	if (oikeinS == true) {
    		syke.setStyle("-fx-text-inner-color: black;");
    	}
    	
    }
    
    @FXML
    private Text bpmText;
    
    @FXML
    private Text treeninPaivamaaraTiedot;
	
    @FXML
    private ListChooser<Paivamaara> paivamaaraLista;
    
    @FXML
    private ComboBox<String> hakuehto;
    
    @FXML
    private ComboBox<String> treeniTyypit;

    @FXML
    private Button tallennaButton;
    
    @FXML
    void uusiTreeniButton(ActionEvent event) {
    	
    	if (oikeinA == false     || oikeinKa == false || oikeinKeH == false ||
    		oikeinKeMin == false || oikeinM == false  || oikeinS == false)   {
    		Dialogs.showMessageDialog("Korjaa virhe");
    		return;
    	}
    	
    	uusiTreeni();
    }
    
    @FXML
    void handleAvaa(ActionEvent event) throws SailoException, IOException {
    	
    	if (oikeinA == false     || oikeinKa == false || oikeinKeH == false ||
    		oikeinKeMin == false || oikeinM == false  || oikeinS == false)   {
    		Dialogs.showMessageDialog("Korjaa virhe");
    		return;
    	}
    	
    	avaa();
    }

    @FXML
    void handleLopeta() {
    	Platform.exit();
    }

    @FXML
    void handlePoistaTreeni(ActionEvent event) throws SailoException {
    	
    	if (oikeinA == false     || oikeinKa == false || oikeinKeH == false ||
    		oikeinKeMin == false || oikeinM == false  || oikeinS == false)   {
    		Dialogs.showMessageDialog("Korjaa virhe");
    		return;
    	}
    	
    	poistaTreeni();
    }

	@FXML
    void handleTallenna(ActionEvent event) throws SailoException {
    	
    	if (oikeinA == false     || oikeinKa == false || oikeinKeH == false ||
    		oikeinKeMin == false || oikeinM == false  || oikeinS == false)   {
    		Dialogs.showMessageDialog("Korjaa virhe");
    		return;
    	}
    	
    	tallenna();
    	Dialogs.showMessageDialog("Tallennettu");
    }
	
    @FXML
    void handleAlaTallenna(ActionEvent event) throws SailoException {
    	
    	if (oikeinA == false     || oikeinKa == false || oikeinKeH == false ||
    		oikeinKeMin == false || oikeinM == false  || oikeinS == false)   {
    		Dialogs.showMessageDialog("Korjaa virhe");
    		return;
    	}
    	
    	tallenna();
    	Dialogs.showMessageDialog("Tallennettu");
    }

    @FXML
    void handleUusiTreeni(ActionEvent event) {
    	
    	if (oikeinA == false     || oikeinKa == false || oikeinKeH == false ||
    		oikeinKeMin == false || oikeinM == false  || oikeinS == false)   {
    		Dialogs.showMessageDialog("Korjaa virhe");
    		return;
    	}
    	
    	uusiTreeni();
    }
    
    @FXML
    void valitaanTreenityyppi(ActionEvent event) {
    	uusiTreenityyppi(treeniTyypit.getValue());
    }
    
    @FXML
    void handleHakuTreenit(ActionEvent event) {
    	
    	if (oikeinA == false     || oikeinKa == false || oikeinKeH == false ||
    		oikeinKeMin == false || oikeinM == false  || oikeinS == false)   {
    		Dialogs.showMessageDialog("Korjaa virhe");
    		return;
    	}
    	
    	hae(hakuehto.getValue());
    }
    

	///-----------------------------------------
    
    
    /**
     * treenityyppien ja hakuehtojen lisääminen comboBoxeille, sekä paivamaaraListaan kuuntelija
     * @throws IOException 
     */
    public void initialize() throws IOException {
    	ObservableList<String> hakuehdot = FXCollections.observableArrayList("Kaikki", "Lenkki", "Sali", "Fitness", "Pyöräily", "Pallopelit", "Jooga", "Talviurheilu", "Vesiurheilu");
    	ObservableList<String> tyypit    = FXCollections.observableArrayList("Lenkki", "Sali", "Fitness", "Pyöräily", "Pallopelit", "Jooga", "Talviurheilu", "Vesiurheilu");
    	hakuehto.setItems(hakuehdot);
    	treeniTyypit.setItems(tyypit);
    	
        
    	paivamaaraLista.clear();
    	paivamaaraLista.addSelectionListener(e -> naytaJasen());
    }
	

    /*
     * Tarkistetaan sisältääkö kirjoitettu teksti kirjaimia
     * @return true tai false sen mukaan onko tekstissä kirjaimia
     */
    private boolean tarkista(String text) {
    	
    	if (text.matches(".*[a-ö].*")) {
    		return false;
    	}
    	
		return true;
	}
    
    
	/*
     * Valitun päivämäärän näyttämistä varten
     */  
    private Paivamaara paivamaaranKohdalla;
    
    
    /*
     * Luodaan uusi treeni ja arvotaan sille tyyppi
     */
	private void uusiTreeni() {
    	Paivamaara uusi = new Paivamaara();
    	uusi.luoTreeni();
		treenikirja.lisaa(uusi);

    	lisaa(uusi.getPaivamaaranNro());
	}
	
	
	/*
	 * Poistetaan valittu treeni
	 */
    private void poistaTreeni(){
    	treenikirja.poista(paivamaaranKohdalla);
    	lisaa();
	}
    
	/*
	 * Asetetaan treenille treenityyppi
	 */
    private void uusiTreenityyppi(String valinta) {
    	paivamaaranKohdalla = paivamaaraLista.getSelectedObject();
    	
    	askeleet.setText("");
    	kalorit.setText("");
    	kestoH.setText("");
    	kestoMin.setText("");
    	matka.setText("");
    	syke.setText("");

    	if (valinta == null) {
    		valinta = "";
    	}
    	
    	if (valinta.equals("Lenkki")) {
    		
    		paivamaaranKohdalla.treeniTyyppi = (valinta);
    		askeleet. setVisible(true);
    		kalorit.  setVisible(true);
    		kestoH.   setVisible(true);
    		kestoMin. setVisible(true);
    		matka.    setVisible(true);
    		syke.     setVisible(true);
    	}
    	
    	if (valinta.equals("Sali")) {
    		paivamaaranKohdalla.treeniTyyppi = (valinta);
    		askeleet. setVisible(false);
    		kalorit.  setVisible(true);
    		kestoH.   setVisible(false);
    		kestoMin. setVisible(false);
    		matka.    setVisible(false);
    		syke.     setVisible(true);
    	}
    	
    	if (valinta.equals("Fitness")) {
    		paivamaaranKohdalla.treeniTyyppi = (valinta);
    		askeleet. setVisible(false);
    		kalorit.  setVisible(true);
    		kestoH.   setVisible(false);
    		kestoMin. setVisible(false);
    		matka.    setVisible(false);
    		syke.     setVisible(true);
    	}
    	
    	if (valinta.equals("Pyöräily")) {
    		paivamaaranKohdalla.treeniTyyppi = (valinta);
    		askeleet. setVisible(false);
    		kalorit.  setVisible(true);
    		kestoH.   setVisible(true);
    		kestoMin. setVisible(true);
    		matka.    setVisible(true);
    		syke.     setVisible(true);
    	}
    	
    	if (valinta.equals("Pallopelit")) {
    		paivamaaranKohdalla.treeniTyyppi = (valinta);
    		askeleet. setVisible(false);
    		kalorit.  setVisible(true);
    		kestoH.   setVisible(true);
    		kestoMin. setVisible(true);
    		matka.    setVisible(false);
    		syke.     setVisible(true);
    	}
    	
    	if (valinta.equals("Jooga")) {
    		paivamaaranKohdalla.treeniTyyppi = (valinta);
    		askeleet. setVisible(false);
    		kalorit.  setVisible(false);
    		kestoH.   setVisible(true);
    		kestoMin. setVisible(true);
    		matka.    setVisible(false);
    		syke.     setVisible(true);
    	}
    	
    	if (valinta.equals("Talviurheilu")) {
    		paivamaaranKohdalla.treeniTyyppi = (valinta);
    		askeleet. setVisible(false);
    		kalorit.  setVisible(true);
    		kestoH.   setVisible(true);
    		kestoMin. setVisible(true);
    		matka.    setVisible(false);
    		syke.     setVisible(true);
    	}
    	
    	if (valinta.equals("Vesiurheilu")) {
    		paivamaaranKohdalla.treeniTyyppi = (valinta);
    		askeleet. setVisible(false);
    		kalorit.  setVisible(true);
    		kestoH.   setVisible(true);
    		kestoMin. setVisible(true);
    		matka.    setVisible(true);
    		syke.     setVisible(true);
    	}
    	
	}
	
        
	/*
	 * Lisätään luotu treeni päivämäärälistaan
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
	 * Lisätään tiedostosta tiedot
	 */
	public void lisaa() {
		
		paivamaaraLista.clear();
		
		int index = 0;
		for (int i=0; i < treenikirja.getPaivamaarat(); i++) {
			Paivamaara paivamaara = treenikirja.annaPaivamaara(i);
			if (paivamaara.getPaivamaaranNro() == paivamaara.getPaivamaaranNro()) index = i;
			paivamaaraLista.add(paivamaara.getPaivamaara(), paivamaara);
		}
		paivamaaraLista.setSelectedIndex(index);
	}
	
	
	/*
	 * Treenintyyppien haun jälkeen lisätään löydetyt treenit listaan
	 */
	private void lisaa(String tyyppi) {
		
		paivamaaraLista.clear();

		for (int i=0; i < treenikirja.getPaivamaarat(); i++) {
			Paivamaara paivamaara = treenikirja.annaPaivamaara(i);
			if (paivamaara.treeniTyyppi == tyyppi) {
			paivamaaraLista.add(paivamaara.getPaivamaara(), paivamaara);
			}
		paivamaaraLista.setSelectedIndex(i);
		}
		
	}
	

	/*
	 * Valitun päivämäärän tiedot
	 */
    protected void naytaJasen() {
    	
    	
    	if (oikeinA == false     || oikeinKa == false || oikeinKeH == false ||
    		oikeinKeMin == false || oikeinM == false  || oikeinS == false)   {
    		Dialogs.showMessageDialog("Korjaa virhe");
    		return;
    	}
    	
    	if (paivamaaranKohdalla != null) {
    		setUudet();
    	}
    	
    	paivamaaranKohdalla = paivamaaraLista.getSelectedObject();

    	askeleet.setText("");
    	kalorit.setText("");
    	kestoH.setText("");
    	kestoMin.setText("");
    	matka.setText("");
    	syke.setText("");

        tulosta(paivamaaranKohdalla);  
        
    }
    
    
    /*
     * Treeniä vaihdettaessa tallennetaan annetut tiedot talteen
     */
	private void setUudet() {
		paivamaaranKohdalla.askeleet = askeleet.getText();
		paivamaaranKohdalla.kalorit = kalorit.getText();
		paivamaaranKohdalla.kestoH = kestoH.getText();
		paivamaaranKohdalla.kestoMin = kestoMin.getText();
		paivamaaranKohdalla.matka = matka.getText();
		paivamaaranKohdalla.syke = syke.getText();
	}

	/*
	 * Tulostaa valitun päivämäärän tiedot oikeisiin ruutuihin
	 */
	public void tulosta(Paivamaara paiva) {
		treeniTyypit.setValue(paiva.treeniTyyppi);
		askeleet.setText(paiva.askeleet);
		kalorit.setText(paiva.kalorit);
		kestoH.setText(paiva.kestoH);
		kestoMin.setText(paiva.kestoMin);
		matka.setText(paiva.matka);
		syke.setText(paiva.syke);
		
		treeninPaivamaaraTiedot.setText(paiva.paivamaara);
	}
	
	
	/*
	 * Treenityyppien hakeminen
	 */
	private void hae(String tyyppi) {
		
		if (tyyppi.equals("Kaikki")) {
			lisaa();
    	}
		
		if (tyyppi.equals("Lenkki")) {
			lisaa("Lenkki");
    	}
    	
    	if (tyyppi.equals("Sali")) {
    		lisaa("Sali");
    	}
    	
    	if (tyyppi.equals("Fitness")) {
    		lisaa("Fitness");
    	}
    	
    	if (tyyppi.equals("Pyöräily")) {
    		lisaa("Pyöräily");
    	}
    	
    	if (tyyppi.equals("Pallopelit")) {
    		lisaa("Pallopelit");
    	}
    	
    	if (tyyppi.equals("Jooga")) {
    		lisaa("Jooga");
    	}
    	
    	if (tyyppi.equals("Talviurheilu")) {
    		lisaa("Talviurheilu");
    	}
    	
    	if (tyyppi.equals("Vesiurheilu")) {
    		lisaa("Vesiurheilu");
    	}
	}
	

	/*
	 * Valittu treenikirja jota käytetään tässä kyttöliittymssä
	 */
	public void setTreenikirja(treenikirja treenikirja) {
		this.treenikirja = treenikirja;
	}
	
	
	/*
	 * Luetaan tiedosto
	 */
    public void avaa() throws SailoException, IOException {
    	String uusinimi = KayttajanKysyminenController.kysyNimi();
    	boolean onkoOlemassa = treenikirja.kysy(uusinimi);
    	
    	if (onkoOlemassa == false) {
    		onkoOlemassa = KayttajanKysyminenController.varmista(uusinimi);
    		
    		if (onkoOlemassa == false) {
    			return;
    		}
    	}
    	
    	treenikirja.lueTiedosto(uusinimi);
		paivamaaraLista.clear();
    	lisaa();
    }
    
    
    /*
     * Tallennetaan
     */
    public void tallenna() throws SailoException {
    	setUudet();
    	treenikirja.tallenna();
    }
    
	
}
