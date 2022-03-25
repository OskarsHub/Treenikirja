package treenikirja;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;

public class Tyyppi {
	protected static int id;
	protected static String tyyppi;
	public static boolean kesto;
	public static boolean kalorit;
	public static boolean matka;
	public static boolean askeleet;
	public static boolean syke;
	
	public static String[] tyypit = {"Lenkki","Sali","Fitness","Pyöräily","Pallopelit",
            "Jooga", "Talviurheilu", "Vesiurheilu"};
	
    public void luoTyyppi(int tyyppiId) {


		String aputyyppi = tyypit[id];
    	
		
        if (tyyppiId == 0) {
        	tyyppi     = aputyyppi;
            kesto      = true;
            kalorit    = true;
            matka      = true;
            askeleet   = true;
            syke       = true;
        }
        
        if (tyyppiId == 1) {
        	tyyppi     = aputyyppi;
            kesto      = false;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 2) {
        	tyyppi     = aputyyppi;
            kesto      = false;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 3) {
        	tyyppi     = aputyyppi;
            kesto      = true;
            kalorit    = true;
            matka      = true;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 4) {
        	tyyppi     = aputyyppi;
            kesto      = true;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 5) {
        	tyyppi     = aputyyppi;
            kesto      = true;
            kalorit    = false;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 6) {
        	tyyppi     = aputyyppi;
            kesto      = true;
            kalorit    = true;
            matka      = false;
            askeleet   = false;
            syke       = true;
        }
        
        if (tyyppiId == 7) {
        	tyyppi     = aputyyppi;
            kesto      = true;
            kalorit    = true;
            matka      = true;
            askeleet   = false;
            syke       = true;
        }
    }

    
	public void luoTyyppi() {
		Random random = new Random();
		id = random.nextInt(8);
		
		luoTyyppi(id);
	}
    

	public void tulosta(PrintStream out) {
        out.println(tyyppi);
        out.println(kesto);
        out.println(kalorit);
        out.println(matka);
        out.println(askeleet);
        out.println(syke);
    }
    
    
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }

    
    public static void main(String args[]) {
        Tyyppi treeni = new Tyyppi(), treeni2 = new Tyyppi();
        
        treeni.luoTyyppi();
        treeni.tulosta(System.out);

        treeni2.luoTyyppi();
        treeni2.tulosta(System.out);

        treeni2.luoTyyppi();
        treeni2.tulosta(System.out);
    }

    
}
