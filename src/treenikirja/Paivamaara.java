package treenikirja;

import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate; 

public class Paivamaara {
	public int         paivamaaraNro;
	public LocalDate   paivamaara;
	public int         id;
	public String      treeniTyyppi;
	public String      kesto;
	public String      kalorit;
	public String      matka;
	public String      askeleet;
	public String      syke;
	
	
    public void luoTreeni() {

    	LocalDate paiva = java.time.LocalDate.now();
    	
    	Tyyppi tyyppi = new Tyyppi();
		tyyppi.luoTyyppi();
    	
        paivamaara = paiva;
        treeniTyyppi = Tyyppi.tyyppi;
        if(Tyyppi.kesto == true) {
        	kesto = "1" + " h " + "30" + " min";
        }
        if(Tyyppi.kalorit == true) {
        	kalorit = "40";
        }
        if(Tyyppi.matka == true) {
        	matka = "10" + " km";
        }
        if(Tyyppi.askeleet == true) {
        	askeleet = "15000";
        }
        if(Tyyppi.syke) {
        	syke = "140";
        }
        
        paivamaaraNro++;
    }

	
	public void tulosta(PrintStream out) {
		out.println("------------------");
        out.println(paivamaara);
        out.println(Tyyppi.tyyppi);
        
        if(Tyyppi.kesto == true) {
        	out.println("kesto: " + kesto);
        }
        
        if(Tyyppi.kalorit == true) {
        	out.println("Kalorit: " + kalorit);
        }
        
        if(Tyyppi.matka == true) {
        	out.println("matka: " + matka);
        }
        
        if(Tyyppi.askeleet == true) {
        	out.println("askeleet: " + askeleet);
        }
        
        if(Tyyppi.syke == true) {
        	out.println("syke: " + syke);
        }
    }
    
    
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    
    public int getPaivamaaranNro() {
    	return paivamaaraNro++;
    }
    
    
    public String getPaivamaara() {
    	String paivamaaraS = paivamaara.toString();
        return paivamaaraS;
    }

    
    public static void main(String args[]) {
        Paivamaara treeni = new Paivamaara(), treeni2 = new Paivamaara();
        treeni.luoTreeni();
        treeni.tulosta(System.out);

        treeni2.luoTreeni();
        treeni2.tulosta(System.out);

        treeni2.luoTreeni();
        treeni2.tulosta(System.out);
    }

}
