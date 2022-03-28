package treenikirja;

import java.util.Arrays;


/**
 * Treenikirjan p�iv�m��r�t
 *
 * @author Oskari Kainulainen
 * @version 25.03.2022
 * @version 28.03.2022 - bugikorjailua
 */

public class Paivamaarat {
	
	
	public Paivamaara alkiot[] = new Paivamaara[10];
	private static int lkm = 0;
	
	
	/*
	 * Lis�� uuden p�iv�m��r�n tietorakenteeseen
	 */
    public void lisaa(Paivamaara treeni) throws SailoException {
        if (lkm >= alkiot.length) {
        	alkiot = Arrays.copyOf(alkiot, alkiot.length+10);
        }
        alkiot[lkm++] = treeni;
    }
    
    
    /*
     * Palauttaa viitteen i:teen p�iv�m��r��n
     */
    public Paivamaara anna(int i) {
        return alkiot[i];
    }
    
    
    /*
     * Palauttaa kuinka monta p�iv�m��r�� on
     */
    public int getLkm() {
        return lkm;
    }

    
    /**
     * Testiohjelma j�senist�lle
     * @param args ei k�yt�ss�
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



