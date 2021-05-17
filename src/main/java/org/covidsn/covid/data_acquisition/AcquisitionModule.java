package org.covidsn.covid.data_acquisition;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;


import org.covidsn.covid.dao.arrondissement.ArrondissementDB;
import org.covidsn.covid.dao.commune.Commune;
import org.covidsn.covid.dao.commune.CommuneDB;
import org.covidsn.covid.dao.departement.DepartementDB;
import org.covidsn.covid.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AcquisitionModule {


	@FXML
    private JFXButton telechargerbtn;

    @FXML
    private JFXButton extractionbtn;

    @FXML
    private JFXButton retourbtn;
    
    @FXML
    private void retourButton(ActionEvent event) throws IOException {
    	String url = "/acceuil.fxml";
		Outils.load(event, url);
    }

    @FXML
    private void telecharger(ActionEvent event) throws IOException {
    	String url = "/data_acquisition/liste_telechargement.fxml";
		Outils.load(event, url);
    }
    
    @FXML
    private void extraction(ActionEvent event) throws IOException {
    	String url = "/data_acquisition/extraction_donnee.fxml";
		Outils.load(event, url);
    }

}
