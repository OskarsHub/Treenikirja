package treenikirja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Treenikirjan treenien tyypit
 *
 * @author Oskari Kainulainen
 * @version 25.03.2022
 * @version 05.04.2022 - Listakorjaus
 * @version 21.4.2022 - HT6 uusi
 * @version 29.4.2022 - HT7
 */
public class Tyypit {

	public final Collection<Tyyppi> alkiot = new ArrayList<Tyyppi>();
	
	private String tiedostonPerusNimi = "";

	
	/*
	 * alustetaan jokainen treeni
	 */
	public void alusta() {

		Tyyppi lenkki = new Tyyppi();
		Tyyppi sali = new Tyyppi();
		Tyyppi fitness = new Tyyppi();
		Tyyppi pyoraily = new Tyyppi();
		Tyyppi pallopelit = new Tyyppi();
		Tyyppi jooga = new Tyyppi();
		Tyyppi talviurheilu = new Tyyppi();
		Tyyppi vesiurheilu = new Tyyppi();
		
		lenkki.alusta(0);
		alkiot.add(lenkki);
		sali.alusta(1);
		alkiot.add(sali);
		fitness.alusta(2);
		alkiot.add(fitness);
		pyoraily.alusta(3);
		alkiot.add(pyoraily);
		pallopelit.alusta(4);
		alkiot.add(pallopelit);
		jooga.alusta(5);
		alkiot.add(jooga);
		talviurheilu.alusta(6);
		alkiot.add(talviurheilu);
		vesiurheilu.alusta(7);
		alkiot.add(vesiurheilu);
		
	}
	
	
	/*
	 * lis‰t‰‰n treenin tyyppi tietokantaan
	 */
    public void lisaa(Tyyppi tyyppi) {
        alkiot.add(tyyppi);
    }

    
    /*
     * palauttaa treenientyyppien lukum‰‰r‰n
     */
	public int getLkm() {
		return alkiot.size();
	}
	
	
	/*
	 * antaa valitun paikan treenin tiedot
	 */
    public Tyyppi anna(int i) {
        return ((ArrayList<Tyyppi>) alkiot).get(i);
    }
    
    
    /*
     * M‰‰ritet‰‰n tiedoston nimi johon tieto tallennetaan
     */
	public void setTiedostonPerusNimi(String nimi) {
		tiedostonPerusNimi = nimi;
	}
    
	
	/*
	 * Tiedoston nimi p‰‰tteineen
	 */
    public String getTiedostonNimi() {
        return getTiedostonPerusNimi() + ".dat";
    }
    
    
    /*
     * tiedoston nimi johon tieto tallennetaan
     */
    public String getTiedostonPerusNimi() {
        return tiedostonPerusNimi;
    }
    
    
    /*
     * Luetaan tiedostosta tyypit
     */
	public void lueTiedostosta(String nimi) throws IOException, SailoException {
		
		File file = new File(getTiedostonNimi());
		if (file.exists() == false) {
			PrintWriter fo = new PrintWriter(new FileWriter(file.getCanonicalPath()));
			fo.println("");
        }
		
		
        BufferedReader fi = new BufferedReader(new FileReader(getTiedostonNimi()));
        String rivi = null;
        
        if (fi.readLine() == null) {
        	alusta();
        	tallenna();
        }
           
        
        while ( (rivi = fi.readLine()) != null ) {
        	rivi = rivi.trim();
        	Tyyppi tyyppi = new Tyyppi();
        	tyyppi.parse(rivi);
        	lisaa(tyyppi);
        }
            
	}
	
	
    /*
     * Tallennetaan tyyppien tiedot
     */
	public void tallenna() throws SailoException {
		
        File ftied = new File(getTiedostonNimi());

        try ( PrintWriter fo = new PrintWriter(new FileWriter(ftied.getCanonicalPath())) ) {
            for (Tyyppi tyyppi : alkiot) {
            	
            	if (tyyppi == null) {
            		break;
            	}
            	
                fo.println(tyyppi.toString());
            }
            
        } catch ( FileNotFoundException ex ) {
            throw new SailoException("Tiedosto " + ftied.getName() + " ei aukea");
        } catch ( IOException ex ) {
            throw new SailoException("Tiedoston " + ftied.getName() + " kirjoittamisessa ongelmia");
        }
    
	}
	
    
    /**
     * Testiohjelma harrastuksille
     * @param args ei k‰ytˆss‰
     */
	public static void main(String args[]) {
    	
    	Tyypit tyypit = new Tyypit();
    	Tyyppi lenkki = new Tyyppi();
    	Tyyppi sali = new Tyyppi();
    	Tyyppi fitness = new Tyyppi();
    	Tyyppi pyorailu = new Tyyppi();
    	Tyyppi pallopelit = new Tyyppi();
    	Tyyppi jooga = new Tyyppi();
    	Tyyppi talviurheilu = new Tyyppi();
    	Tyyppi vesiurheilu = new Tyyppi();
    	
    	lenkki.alusta(0);
    	sali.alusta(1);
    	fitness.alusta(2);
    	pyorailu.alusta(3);
    	pallopelit.alusta(4);
    	jooga.alusta(5);
    	talviurheilu.alusta(6);
    	vesiurheilu.alusta(7);  
    	
    	tyypit.lisaa(lenkki);
    	tyypit.lisaa(sali);
    	tyypit.lisaa(fitness);
    	tyypit.lisaa(pyorailu);
    	tyypit.lisaa(pallopelit);
    	tyypit.lisaa(jooga);
    	tyypit.lisaa(talviurheilu);
    	tyypit.lisaa(vesiurheilu);
    	
        for (int i = 0; i < tyypit.getLkm(); i++) {
            Tyyppi tyyppi = tyypit.anna(i);
            System.out.println("Treeni nro: " + i);
            tyyppi.tulosta(System.out);
            System.out.println("");
        }
    	
    }
    
	
}

