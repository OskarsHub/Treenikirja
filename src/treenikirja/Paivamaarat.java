package treenikirja;

import java.util.Arrays;

public class Paivamaarat {
	
	public Paivamaara alkiot[] = new Paivamaara[10];
	private static int lkm = 0;
	
	
    public void lisaa(Paivamaara treeni) throws SailoException {
        if (lkm >= alkiot.length) {
        	alkiot = Arrays.copyOf(alkiot, alkiot.length+10);
        }
        alkiot[lkm++] = treeni;
    }
    
    
    public Paivamaara anna(int i) throws IndexOutOfBoundsException {
        if (i < 0 || lkm <= i)
            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
        return alkiot[i];
    }
    
    
    public int getLkm() {
        return lkm;
    }

    
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



