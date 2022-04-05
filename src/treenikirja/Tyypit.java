package treenikirja;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Treenikirjan treenien tyypit
 *
 * @author Oskari Kainulainen
 * @version 25.03.2022
 * @version 28.03.2022 - bugikorjailua
 */
public class Tyypit {

	private final Collection<Tyyppi> alkiot = new ArrayList<Tyyppi>();

	
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
	 * lisätään treenin tyyppi tietokantaan
	 */
    public void lisaa(Tyyppi tyyppi) {
        alkiot.add(tyyppi);
    }

    
    /*
     * palauttaa treenientyyppien lukumäärän
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
    
    
    /**
     * Testiohjelma harrastuksille
     * @param args ei käytössä
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

