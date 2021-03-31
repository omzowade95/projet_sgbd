package org.covidsn.covid.data_explorer;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;


import javafx.fxml.Initializable;
import org.covidsn.covid.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.DatePicker;

public class DataExplorerController implements Initializable {

    @FXML
    private AnchorPane anch;

    @FXML
    private DatePicker datepicker;

    @FXML
    private JFXButton pngbtn;

    @FXML
    private JFXButton sqlbtn;

    @FXML
    private JFXButton csvbtn;

    @FXML
    private ScrollPane srollpane;

    @FXML
    private JFXButton retourbtn;

    @FXML
    void retourButton(ActionEvent event) throws IOException {
    	String url = "/acceuil.fxml";
		Outils.load(event, url);
    }

    @FXML
    void telechargerCSV(ActionEvent event) {
    	boolean bool = false;
    	if (bool) {
        	Outils.showInformationMessage("Success", "telechargement fichier termin�");

		} else {
	    	Outils.showErrorMessage("Error", "Probleme survenue");

		}
    }

    @FXML
    void telechargerPNG(ActionEvent event) {
    	LocalDate date = datepicker.getValue();
    	if (date !=null) {
        	Outils.showInformationMessage("Success", "Telechargement image termin�");
        	System.out.println(date);

		} else {
	    	Outils.showErrorMessage("Error", "Probleme survenue");

		}

    }

    @FXML
    void telechargerSQL(ActionEvent event) {
    	boolean bool = false;
    	if (bool) {
        	Outils.showInformationMessage("Success", "Telechargement fichier sql termin�");

		} else {
	    	Outils.showErrorMessage("Error", "Probleme survenue");

		}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datepicker = new DatePicker();
    }
}
