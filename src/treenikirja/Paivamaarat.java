package treenikirja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


/**
 * Treenikirjan päivämäärät
 *
 * @author Oskari Kainulainen
 * @version 25.03.2022
 * @version 28.03.2022 - bugikorjailua
 * @version 7.4.2022 - HT6
 */

public class Paivamaarat {
	
	
	public Paivamaara alkiot[] = new Paivamaara[10];
	private static int lkm = 0;
	private static String tiedostonPerusNimi = "";
	
	
	/*
	 * Lisää uuden päivämäärän tietorakenteeseen
	 */
    public void lisaa(Paivamaara treeni) throws SailoException {
        if (lkm >= alkiot.length) {
        	alkiot = Arrays.copyOf(alkiot, alkiot.length+10);
        }
        alkiot[lkm++] = treeni;
    }
    
    
    /*
     * Palauttaa viitteen i:teen päivämäärään
     */
    public Paivamaara anna(int i) {
        return alkiot[i];
    }
    
    
    /*
     * Palauttaa kuinka monta päivämäärää on
     */
    public static int getLkm() {
        return lkm;
    }

    
    /*
     * Luetaan tiedostosta treenit ja muutetaan ne atribuuteille
     */
	public void lueTiedostosta() throws SailoException{

        try ( BufferedReader fi = new BufferedReader(new FileReader(getTiedostonNimi())) ) {
            String rivi = fi.readLine();

            while ( (rivi = fi.readLine()) != null ) {
                rivi = rivi.trim();
                if ( "".equals(rivi) || rivi.charAt(0) == ';' ) continue;
                Paivamaara paivamaara = new Paivamaara();
                paivamaara.parse(rivi);
                lisaa(paivamaara);
            }
            
        } catch ( FileNotFoundException e ) {
            throw new SailoException("Tiedosto " + getTiedostonNimi() + " ei aukea");
        } catch ( IOException e ) {
            throw new SailoException("Ongelmia tiedoston kanssa: " + e.getMessage());
        }
        
	}


	/*
	 * Määritetään tiedoston nimi johon tieto tallennetaan
	 */
	public void setTiedostonPerusNimi(String nimi) throws FileNotFoundException {
		tiedostonPerusNimi = nimi;
	}
	
	
	/*
	 * Tiedoston nimi päätteineen
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
     * Tallennetaan treenin tiedot
     */
	public void tallenna() throws SailoException {
        
        File ftied = new File(getTiedostonNimi());

        try ( PrintWriter fo = new PrintWriter(new FileWriter(ftied.getCanonicalPath())) ) {
            for (Paivamaara paivamaara : alkiot) {
            	if (paivamaara == null) {
            		break;
            	}
                fo.println(paivamaara.toString());
            }
            
        } catch ( FileNotFoundException ex ) {
            throw new SailoException("Tiedosto " + ftied.getName() + " ei aukea");
        } catch ( IOException ex ) {
            throw new SailoException("Tiedoston " + ftied.getName() + " kirjoittamisessa ongelmia");
        }
    
	}
    
    
    /**
     * Testiohjelma jäsenistölle
     * @param args ei käytössä
     */
    public static void main(String args[]) {
    	Paivamaarat paivamaarat = new Paivamaarat();
    	
    	Paivamaara ensimmainen = new Paivamaara(); Paivamaara toinen = new Paivamaara();
    	Paivamaara kolmas = new Paivamaara(); Paivamaara neljas = new Paivamaara();
    	ensimmainen.luoTreeni();
    	toinen.luoTreeni();
    	kolmas.luoTreeni();
    	neljas.luoTreeni();
    	
 
		try {
			paivamaarat.lisaa(ensimmainen);
			paivamaarat.lisaa(toinen);
			paivamaarat.lisaa(kolmas);
			paivamaarat.lisaa(neljas);
			
            for (int i = 0; i < paivamaarat.getLkm(); i++) {
                Paivamaara jasen = paivamaarat.anna(i);
                System.out.println("Treeni nro: " + i);
                jasen.tulosta(System.out);
                System.out.println("");
            }
            
        
		} catch (SailoException e) {
			e.printStackTrace();
		}
		
 	
    }

    

	
}