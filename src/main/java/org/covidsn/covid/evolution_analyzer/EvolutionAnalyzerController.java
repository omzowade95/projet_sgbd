package org.covidsn.covid.evolution_analyzer;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import org.covidsn.covid.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EvolutionAnalyzerController {

    @FXML
    private JFXButton pngbtn;

    @FXML
    private JFXButton txtbtn;

    @FXML
    private JFXButton retourbtn;

    @FXML
    void retourButton(ActionEvent event) throws IOException {
    	String url = "/acceuil.fxml";
		Outils.load(event, url);
    }

    @FXML
    void telechargerPNG(ActionEvent event) {
    	boolean bool = false;
    	if (bool) {
        	Outils.showInformationMessage("Success", "telechargement fichier termin�");

		} else {
	    	Outils.showErrorMessage("Error", "Probleme survenue");

		}
    }

    @FXML
    void telechargerTXT(ActionEvent event) {
    	boolean bool = true;
    	if (bool) {
        	Outils.showInformationMessage("Success", "telechargement fichier termin�");

		} else {
	    	Outils.showErrorMessage("Error", "Probleme survenue");

		}
    }

}
