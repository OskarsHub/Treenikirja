package treenikirja;


		public class treenikirja {
			
			private Tyypit tyypit = new Tyypit();
			private Paivamaarat paivamaarat = new Paivamaarat();
			
		    public int getPaivamaarat() {
		        return paivamaarat.getLkm();
		    }
		    
		    
		    public void lisaa(Paivamaara paivamaara) throws SailoException {
		    	paivamaarat.lisaa(paivamaara);
		    }
		    
		    
		    public Paivamaara annaPaivamaara(int i) throws IndexOutOfBoundsException {
		        return paivamaarat.anna(i);
		    }

		    
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
		                System.out.println("Päivämäärä paikassa: " + i);
		                maara.tulosta(System.out);
		            }

		        } catch (SailoException ex) {
		            System.out.println(ex.getMessage());
		        }
		}


		
		
}


			

