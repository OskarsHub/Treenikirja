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
 * @version 29.4.2022 - HT7
 */
public class Tyyppi {
	
	protected int id;
	protected String tyyppi;
	public boolean kestoH;
	public boolean kestoMin;
	public boolean kalorit;
	public boolean matka;
	public boolean askeleet;
	public boolean syke;
	
	
	/*
	 * Alustetaan jokaiselle treenityypille mitä tietoja halutaan kerätä
	 */
    public void alusta(int tyyppiId) {
		
        if (tyyppiId == 0) {
        	id         = 0;
        	tyyppi     = "Lenkki";
            kestoH     = true;
            kestoMin   = true;
            kalorit    = true;
            matka      = true;
            askeleet   = true;
            syke       = true;
        }
        
        if (tyyppiId == 1) {
        	id         = 1;
        	tyyppi     = "Sali";
            kestoH     = false;
            kestoMin   = false;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 2) {
        	id         = 2;
        	tyyppi     = "Fitness";
            kestoH     = false;
            kestoMin   = false;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 3) {
        	id         = 3;
        	tyyppi     = "Pyöräily";
            kestoH     = true;
            kestoMin   = true;
            kalorit    = true;
            matka      = true;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 4) {
        	id         = 4;
        	tyyppi     = "Pallopelit";
            kestoH     = true;
            kestoMin   = true;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 5) {
        	id         = 5;
        	tyyppi     = "Jooga";
            kestoH     = true;
            kestoMin   = true;
            kalorit    = false;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 6) {
        	id         = 6;
        	tyyppi     = "Talviurheilu";
            kestoH     = true;
            kestoMin   = true;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 7) {
        	id         = 7;
        	tyyppi     = "Vesiurheilu";
            kestoH     = true;
            kestoMin   = true;
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
        kestoH         = Mjonot.erota(sb, '|', kestoH) != null;
        kestoMin       = Mjonot.erota(sb, '|', kestoMin) != null;
        kalorit        = Mjonot.erota(sb, '|', kalorit) != null;
        matka          = Mjonot.erota(sb, '|', matka) != null;
        askeleet       = Mjonot.erota(sb, '|', askeleet) != null;
        syke           = Mjonot.erota(sb, '|', syke) != null;
    }
    
    
    /*
     * Muutetaan tiedostossa oleva muoto atribuuteille
     */
    public String parseTyyppi(String rivi) {
        StringBuffer sb = new StringBuffer(rivi);
        id             = Mjonot.erota(sb, '|', id);
        tyyppi         = Mjonot.erota(sb, '|', tyyppi);
        kestoH         = Mjonot.erota(sb, '|', kestoH) != null;
        kestoMin       = Mjonot.erota(sb, '|', kestoMin) != null;
        kalorit        = Mjonot.erota(sb, '|', kalorit) != null;
        matka          = Mjonot.erota(sb, '|', matka) != null;
        askeleet       = Mjonot.erota(sb, '|', askeleet) != null;
        syke           = Mjonot.erota(sb, '|', syke) != null;
        
        return tyyppi;
    }
	
	
    /*
     * Muutetaan tyypit tiedosto muotoon
     */
    public String toString() {
        return "" +
        		id         + "|" +
        		tyyppi     + "|" +
        		kestoH     + "|" +
        		kestoMin   + "|" +
        		kalorit    + "|" +
        		matka      + "|" +
        		askeleet   + "|" +
        		syke       + "|" ;
    }
    
    
	/*
	 * Tulostaa true/false halutaanko kerätä tietoa
	 */
	public void tulosta(PrintStream out) {
        out.println(tyyppi);
        out.println(kestoH);
        out.println(kestoMin);
        out.println(kalorit);
        out.println(matka);
        out.println(askeleet);
        out.println(syke);
    }
    
	
	/*
	 * Tulostaa true/false halutaanko kerätä tietoa
	 */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }

    
    /**
     * Testiohjelma Harrastukselle.
     * @param args ei käytössä
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
