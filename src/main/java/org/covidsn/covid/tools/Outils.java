package org.covidsn.covid.tools;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Outils {
	
	public static void showConfirmationMessage(String title, String message) {
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setTitle(title);
		a.setContentText(message);
		a.showAndWait();
	}
	
	public static void showInformationMessage(String title, String message) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle(title);
		a.setContentText(message);
		a.showAndWait();
	}
	
	public static void showErrorMessage(String title, String message) {
		Alert a = new Alert(AlertType.ERROR);
		a.setTitle(title);
		a.setContentText(message);
		a.showAndWait();
	}
	
	public static void showWarningMessage(String title, String message) {
		Alert a = new Alert(AlertType.WARNING);
		a.setTitle(title);
		a.setContentText(message);
		a.showAndWait();
	}
	
	private void loadPage(ActionEvent event , String url)  throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		
		Parent root = FXMLLoader.load(getClass().getResource(url));
		Scene scene = new Scene (root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("COVID SN");
		stage.show();
	}
	
	public static void load (ActionEvent event , String url) throws IOException {
		new Outils().loadPage(event, url);
	}

}
