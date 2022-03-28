package treenikirja;

import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate; 


/**
 * Treenikirjan osa joka osaa tehd‰ uuden treenin
 *
 * @author Oskari Kainulainen
 * @version 25.03.2022
 * @version 28.03.2022 - bugikorjailua
 */
public class Paivamaara {
	public int         paivamaaraNro;
	public LocalDate   paivamaara;
	public int         id;
	public String      treeniTyyppi;
	public String      kesto;
	public String      kalorit;
	public String      matka;
	public String      askeleet;
	public String      syke;
	
	/*
	 * Apumetodi, jolla saadaan luotua testiarvot
	 */
    public void luoTreeni() {

    	LocalDate paiva = java.time.LocalDate.now();
    	
    	Tyyppi tyyppi = new Tyyppi();
		tyyppi.alusta();
		
		kesto     = null;
		kalorit   = null;
		matka     = null;
		askeleet  = null;
		syke      = null;
		
        paivamaara = paiva;
        treeniTyyppi = tyyppi.tyyppi;
        
        if(tyyppi.kesto == true) {
        	kesto = "1" + " h " + "30" + " min";
        }
        
        if(tyyppi.kalorit == true) {
        	kalorit = "40";
        }
        
        if(tyyppi.matka == true) {
        	matka = "10" + " km";
        }
        
        if(tyyppi.askeleet == true) {
        	askeleet = "15000";
        }
        
        if(tyyppi.syke) {
        	syke = "140";
        }
        
        paivamaaraNro++;
    }

    
	/*
	 * tulostaa p‰iv‰m‰‰r‰n tiedot
	 */
	public void tulosta(PrintStream out) {
		out.println("------------------");
        out.println(paivamaara);
        out.println(treeniTyyppi);
        
        out.println("kesto: " + kesto);

        out.println("kalorit: " + kalorit);

        out.println("matka: " + matka);

        out.println("askeleet: " + askeleet);

        out.println("syke: " + syke);
	}
    
    /*
     * tulostaa p‰iv‰m‰‰r‰n tiedot
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    
    /*
     * Palauttaa p‰iv‰m‰‰r‰n numeron
     */
    public int getPaivamaaranNro() {
    	return paivamaaraNro;
    }
    
    
    /*
     * Muuttaa p‰iv‰m‰‰r‰n String-muuttujaksi
     */
    public String getPaivamaara() {
    	String paivamaaraS = paivamaara.toString();
        return paivamaaraS;
    }


    /**
     * Testiohjelma j‰senelle.
     * @param args ei k‰ytˆss‰
     */
    public static void main(String args[]) {
        Paivamaara treeni = new Paivamaara(), treeni2 = new Paivamaara();
        treeni.luoTreeni();
        treeni.tulosta(System.out);

        treeni2.luoTreeni();
        treeni2.tulosta(System.out);

        treeni2.luoTreeni();
        treeni2.tulosta(System.out);
    }

}
