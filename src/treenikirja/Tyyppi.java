package treenikirja;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;

import fi.jyu.mit.ohj2.Mjonot;


/**
 * Treenikirjan treenien osa jolla voidaan alustaa jokainen treeni
 *
 * @author Oskari Kainulainen
 * @version 25.03.2022
 * @version 28.03.2022 - bugikorjailua
 * @version 21.4.2022 - HT6 uusi
 */
public class Tyyppi {
	
	protected int id;
	protected String tyyppi;
	public boolean kesto;
	public boolean kalorit;
	public boolean matka;
	public boolean askeleet;
	public boolean syke;
	
	
	/*
	 * Alustetaan jokaiselle treenityypille mit� tietoja halutaan ker�t�
	 */
    public void alusta(int tyyppiId) {
		
        if (tyyppiId == 0) {
        	id         = 0;
        	tyyppi     = "Lenkki";
            kesto      = true;
            kalorit    = true;
            matka      = true;
            askeleet   = true;
            syke       = true;
        }
        
        if (tyyppiId == 1) {
        	id         = 1;
        	tyyppi     = "Sali";
            kesto      = false;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 2) {
        	id         = 2;
        	tyyppi     = "Fitness";
            kesto      = false;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 3) {
        	id         = 3;
        	tyyppi     = "Py�r�ily";
            kesto      = true;
            kalorit    = true;
            matka      = true;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 4) {
        	id         = 4;
        	tyyppi     = "Pallopelit";
            kesto      = true;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 5) {
        	id         = 5;
        	tyyppi     = "Jooga";
            kesto      = true;
            kalorit    = false;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 6) {
        	id         = 6;
        	tyyppi     = "Talviurheilu";
            kesto      = true;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 7) {
        	id         = 7;
        	tyyppi     = "Vesiurheilu";
            kesto      = true;
            kalorit    = true;
            matka      = true;
            askeleet   = false;
            syke       = true;
        }
    }
    

    /*
     * apumetodi, jolla saadaan luotua testiarvot
     */
	public void alusta() {
		Random random = new Random();
		id = random.nextInt(8);
		
		alusta(id);
	}
    
	
    /*
     * Muutetaan tiedostossa oleva muoto atribuuteille
     */
    public void parse(String rivi) {
        StringBuffer sb = new StringBuffer(rivi);
        id             = Mjonot.erota(sb, '|', id);
        tyyppi         = Mjonot.erota(sb, '|', tyyppi);
        kesto          = Mjonot.erota(sb, '|', kesto) != null;
        kalorit        = Mjonot.erota(sb, '|', kalorit) != null;
        matka          = Mjonot.erota(sb, '|', matka) != null;
        askeleet       = Mjonot.erota(sb, '|', askeleet) != null;
        syke           = Mjonot.erota(sb, '|', syke) != null;
    }
	
	
    /*
     * Muutetaan tyypit tiedosto muotoon
     */
    public String toString() {
        return "" +
        		id         + "|" +
        		tyyppi     + "|" +
        		kesto      + "|" +
        		kalorit    + "|" +
        		matka      + "|" +
        		askeleet   + "|" +
        		syke       + "|" ;
    }
    
    
	/*
	 * Tulostaa true/false halutaanko ker�t� tietoa
	 */
	public void tulosta(PrintStream out) {
        out.println(tyyppi);
        out.println(kesto);
        out.println(kalorit);
        out.println(matka);
        out.println(askeleet);
        out.println(syke);
    }
    
	
	/*
	 * Tulostaa true/false halutaanko ker�t� tietoa
	 */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }

    
    /**
     * Testiohjelma Harrastukselle.
     * @param args ei k�yt�ss�
     */
    public static void main(String args[]) {
        Tyyppi treeni = new Tyyppi(), treeni2 = new Tyyppi();
        
        treeni.alusta();
        treeni.tulosta(System.out);

        treeni2.alusta();
        treeni2.tulosta(System.out);

        treeni2.alusta();
        treeni2.tulosta(System.out);
    }

    
}
