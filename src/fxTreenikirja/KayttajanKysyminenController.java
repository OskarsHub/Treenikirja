package fxTreenikirja;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Oskari
 * @version 21.4.2022 - HT6 uusi
 * @version 29.4.2022 - HT7
 */
public class KayttajanKysyminenController {

	private static String vastaus = null;
	private static boolean vastausBoolean;

	
	/*
	 * Luodaan k�ytt�j�n vaihtamista varten kysymiskentt�
	 * @return k�ytt�j�n nimen
	 */
	public static String kysyNimi() {
		Stage ikkuna = new Stage();
		ikkuna.initModality(Modality.APPLICATION_MODAL);
		ikkuna.setTitle("K�ytt�j�n kysyminen");
		ikkuna.setMinWidth(300);
		
		TextField nimikentta = new TextField();
		
		Button OkNappi = new Button("Ok");
		
		OkNappi.setOnAction(e -> {
			vastaus = nimikentta.getText();
			ikkuna.close();
		});
		
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(nimikentta, OkNappi);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		ikkuna.setScene(scene);
		ikkuna.showAndWait();
		
		
		return vastaus;
	}
	
	
	/*
	 * Luodaan kysymiskentt� jos annettua k�ytt�j�� ei viel� l�ydy
	 * @return true tai false riippuen halutaanko luoda uusi k�ytt�j�
	 */
	public static boolean varmista(String uusinimi) {
		Stage ikkuna = new Stage();
		ikkuna.initModality(Modality.APPLICATION_MODAL);
		ikkuna.setTitle("Huomio");
		ikkuna.setMinWidth(250);

		Button peruutaNappi = new Button("Peruuta");
		
		peruutaNappi.setOnAction(e -> {
			vastausBoolean = false;
			ikkuna.close();
		});
		
		Button jatkaNappi = new Button("Jatka");
		
		jatkaNappi.setOnAction(e -> {
			vastausBoolean = true;
			ikkuna.close();
		});
		
		Text info = new Text();
		info.setText("K�ytt�j�� " + uusinimi + " ei l�ytynyt");
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(info, peruutaNappi, jatkaNappi);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		ikkuna.setScene(scene);
		ikkuna.showAndWait();
		
		return vastausBoolean;
	}
	
}
	

