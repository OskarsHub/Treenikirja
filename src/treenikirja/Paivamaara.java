package treenikirja;

import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fi.jyu.mit.ohj2.Mjonot; 


/**
 * Treenikirjan osa joka osaa tehd uuden treenin
 *
 * @author Oskari Kainulainen
 * @version 25.03.2022
 * @version 28.03.2022 - bugikorjailua
 * @version 7.4.2022 - HT6
 * @version 21.4.2022 - HT6 uusi
 * @version 29.4.2022 - HT7
 */
public class Paivamaara {
	public int         paivamaaraNro;
	public String      paivamaara;
	public String      treeniTyyppi;
	public String      kestoH;
	public String      kestoMin;
	public String      kalorit;
	public String      matka;
	public String      askeleet;
	public String      syke;
	
	/*
	 * Apumetodi, jolla saadaan luotua testiarvot
	 */
    public void luoTreeni() {

    	LocalDate paiva = java.time.LocalDate.now();
    	DateTimeFormatter muotoilu = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    	paivamaara = paiva.format(muotoilu);
		
		kestoH    = null;
		kestoMin  = null;
		kalorit   = null;
		matka     = null;
		askeleet  = null;
		syke      = null;
		
        paivamaaraNro = Paivamaarat.getLkm();
    }
    
    
	/*
	 * tulostaa p‰iv‰m‰‰r‰n tiedot
	 */
	public void tulosta(PrintStream out) {
		out.println("------------------");
        out.println(paivamaara);
        out.println(treeniTyyppi);
        
        out.println("kesto: " + kestoH + "tuntia" + kestoMin + "minuuttia");

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
     * Muutetaan p‰iv‰m‰‰r‰ tiedosto muotoon
     */
    public String toString() {
        return "" +
        		paivamaaraNro + "|" +
        		paivamaara    + "|" +
        		treeniTyyppi  + "|" +
        		askeleet      + "|" +
        		kalorit       + "|" +
        		kestoH        + "|" +
        		kestoMin      + "|" +
        		matka         + "|" +
        		syke          + "|" ;
    }

    
    /*
     * Muutetaan tiedostossa oleva muoto atribuuteille
     */
    public void parse(String rivi) {
        StringBuffer sb = new StringBuffer(rivi);
        paivamaaraNro = Mjonot.erota(sb, '|', paivamaaraNro);
        paivamaara    = Mjonot.erota(sb, '|', paivamaara);
        treeniTyyppi  = Mjonot.erota(sb, '|', treeniTyyppi);
        askeleet      = Mjonot.erota(sb, '|', askeleet);
        kalorit       = Mjonot.erota(sb, '|', kalorit);
        kestoH        = Mjonot.erota(sb, '|', kestoH);
        kestoMin      = Mjonot.erota(sb, '|', kestoMin);
        matka         = Mjonot.erota(sb, '|', matka);
        syke          = Mjonot.erota(sb, '|', syke);
    }
    
    
    /*
     * Palauttaa p‰iv‰m‰‰r‰n numeron
     */
    public int getPaivamaaranNro() {
    	return paivamaaraNro;
    }
    
    
    /*
     * Palauttaa valitun p‰iv‰m‰‰r‰n numeron
     */
	public static int getPaivamaaraNro(Paivamaara paivamaara) {
		int nro = paivamaara.paivamaaraNro;
		return nro;
	}
    
    
    /*
     * Muuttaa p‰iv‰m‰‰r‰n String-muuttujaksi
     */
    public String getPaivamaara() {
    	String paivamaaraS = paivamaara.toString();
        return paivamaaraS;
    }


    /**
     * Testiohjelma p‰iv‰m‰‰rille.
     * @param args ei kytss
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
