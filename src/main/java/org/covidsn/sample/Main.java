package org.covidsn.sample;
	
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.covidsn.covid.tools.Outils;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;


public class Main extends Application  implements Initializable {
	
	public static String choix = "";
	
	@FXML
    private MenuButton menuadminbtn;
	
	 @FXML
	    private MenuItem ajouuserbtn;

	    @FXML
	    private MenuItem listeuserbtn;
	
	 @FXML
	    private Button acquisitionbtn;

	    @FXML
	    private Button explorationbtn;

	    @FXML
	    private Button chargementbtn;

	    @FXML
	    private Button analysebtn;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/acceuil.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
	private void acquisition(ActionEvent event) throws IOException  {
		String	url = "/data_acquisition/acquisition_module.fxml";
		Outils.load(event, url);
	}
	
	@FXML
	private void analyse(ActionEvent event) throws IOException {
		String url = "/evolution_analyzer/evolution_analyzer.fxml";
			Outils.load(event, url);
	}
	@FXML
	private void exploration(ActionEvent event) throws IOException {
		String url = "/data_explorer/data_explorer.fxml";
		Outils.load(event, url);	
	}
	@FXML
	private void chargement(ActionEvent event) throws IOException {
		String url = "/data_loader/liste_fichier_xml_json.fxml";
		Outils.load(event, url);
	}


	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
