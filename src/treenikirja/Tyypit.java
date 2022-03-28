package treenikirja;


/**
 * Treenikirjan treenien tyypit
 *
 * @author Oskari Kainulainen
 * @version 25.03.2022
 * @version 28.03.2022 - bugikorjailua
 */
public class Tyypit {

	private Tyyppi alkiot[] = new Tyyppi[8];
	private int lkm = 0;

	
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
		alkiot[0] = lenkki;
		sali.alusta(1);
		alkiot[1] = sali;
		fitness.alusta(2);
		alkiot[2] = fitness;
		pyoraily.alusta(3);
		alkiot[3] = pyoraily;
		pallopelit.alusta(4);
		alkiot[4] = pallopelit;
		jooga.alusta(5);
		alkiot[5] = jooga;
		talviurheilu.alusta(6);
		alkiot[6] = talviurheilu;
		vesiurheilu.alusta(7);
		alkiot[7] = vesiurheilu;
	}
	
	
	/*
	 * lisätään treenin tyyppi tietokantaan
	 */
    public void lisaa(Tyyppi tyyppi) {
        alkiot[lkm++] = tyyppi;
    }

    
    /*
     * palauttaa treenientyyppien lukumäärän
     */
	public int getLkm() {
		return lkm;
	}
	
	
	/*
	 * antaa valitun paikan treenin tiedot
	 */
    public Tyyppi anna(int i) throws IndexOutOfBoundsException {
        return alkiot[i];
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

