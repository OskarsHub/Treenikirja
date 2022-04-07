package treenikirja;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Treenikirja-luokka, joka huolehtii p‰iv‰m‰‰rist‰, sek‰ treenien tyypeist‰
 *
 * @author Oskari Kainulainen
 * @version 05.03.2022
 * @version 28.04.2022 - bugikorjauksia
 * @version 7.4.2022 - HT6
 */

	public class treenikirja {
			
		private Tyypit tyypit = new Tyypit();
		private Paivamaarat paivamaarat = new Paivamaarat();
			

		/*
		 * Luetaan tiedostosta treeni tiedot
		 */
		public void lueTiedosto(String nimi) throws SailoException, FileNotFoundException {
			setTiedosto(nimi);
			paivamaarat.lueTiedostosta();
		}
		
		
		/*
		 * Tiedoston teko
		 */
		private void setTiedosto(String nimi) throws FileNotFoundException {
			File dir = new File(nimi);
			dir.mkdirs();
			String hakemistonNimi = "";
			if ( !nimi.isEmpty() ) hakemistonNimi = nimi +"/";
			paivamaarat.setTiedostonPerusNimi(hakemistonNimi + "paivamaarat");
		}


		/*
		 * Tallennetaan treeni
		 */
	    public void tallenna() throws SailoException {
	    	paivamaarat.tallenna();
	    }
		
		
		
		/*
		 * Palauttaa treenikirjan p‰iv‰m‰‰rien m‰‰r‰n
		 * @return p‰iv‰m‰‰rien m‰‰r‰n
		 */
		public int getPaivamaarat() {
			return paivamaarat.getLkm();  
		}
		   

		/*
		 * Lis‰‰ uuden p‰iv‰m‰‰r‰n
		 */
		public void lisaa(Paivamaara paivamaara) throws SailoException {
			paivamaarat.lisaa(paivamaara);
		}
		    
		
		/*
		 * Palauttaa i:n p‰iv‰m‰‰r‰n
		 * @return valittun p‰iv‰m‰‰r‰n viite
		 */
		public Paivamaara annaPaivamaara(int i) throws IndexOutOfBoundsException {
		    return paivamaarat.anna(i);
		}

		
		
	    /**
	     * Testiohjelma kerhosta
	     * @param args ei k‰ytˆss‰
	     */
		public static void main(String args[]) {

		    try {
		        	
		    	treenikirja treenikirja = new treenikirja();
		        	
		        Paivamaara ensimmainen = new Paivamaara(), toinen = new Paivamaara();

		        ensimmainen.luoTreeni();
		        toinen.luoTreeni();
		            
		        treenikirja.lisaa(ensimmainen);
		        treenikirja.lisaa(toinen);

		        for (int i = 0; i < treenikirja.getPaivamaarat(); i++) {
		            Paivamaara maara = treenikirja.annaPaivamaara(i);
		            System.out.println("P‰iv‰m‰‰r‰ paikassa: " + i);
		            maara.tulosta(System.out);
		        }
		        

		    } catch (SailoException ex) {
		        System.out.println(ex.getMessage());
		    }
		    
		    
    }
		

}