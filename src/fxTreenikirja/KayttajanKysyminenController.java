package fxTreenikirja;

import java.awt.Label;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Oskari
 * @version 21.4.2022 - HT6 uusi
 */
public class KayttajanKysyminenController {

	/*
	 * Luodaan käyttäjän vaihtamista varten kysymiskenttä
	 * @return käyttäjän nimen
	 */
	private static String vastaus = null;


	public static String kysyNimi() {
		Stage ikkuna = new Stage();
		ikkuna.initModality(Modality.APPLICATION_MODAL);
		ikkuna.setTitle("Käyttäjän kysyminen");
		ikkuna.setMinWidth(250);
		Label label = new Label();
		label.setText("Nimi");
		
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
	
}
	

