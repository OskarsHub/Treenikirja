package treenikirja;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;


/**
 * Treenikirjan treenien osa jolla voidaan alustaa jokainen treeni
 *
 * @author Oskari Kainulainen
 * @version 25.03.2022
 * @version 28.03.2022 - bugikorjailua
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
	 * Alustetaan jokaiselle treenityypille mitä tietoja halutaan kerätä
	 */
    public void alusta(int tyyppiId) {
		
        if (tyyppiId == 0) {
        	tyyppi     = "Lenkki";
            kesto      = true;
            kalorit    = true;
            matka      = true;
            askeleet   = true;
            syke       = true;
        }
        
        if (tyyppiId == 1) {
        	tyyppi     = "Sali";
            kesto      = false;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 2) {
        	tyyppi     = "Fitness";
            kesto      = false;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 3) {
        	tyyppi     = "Pyöräily";
            kesto      = true;
            kalorit    = true;
            matka      = true;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 4) {
        	tyyppi     = "Pallopelit";
            kesto      = true;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 5) {
        	tyyppi     = "Jooga";
            kesto      = true;
            kalorit    = false;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 6) {
        	tyyppi     = "Talviurheilu";
            kesto      = true;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 7) {
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
	 * Tulostaa true/false halutaanko kerätä tietoa
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
