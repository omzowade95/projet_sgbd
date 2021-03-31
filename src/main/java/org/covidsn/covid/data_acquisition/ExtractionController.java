package org.covidsn.covid.data_acquisition;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import org.covidsn.covid.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ExtractionController {
	 @FXML
	    private TableView<?> fichiertable;

	    @FXML
	    private TableColumn<?, ?> fichiercolumn;

	    @FXML
	    private JFXButton xmlbtn;

	    @FXML
	    private JFXButton jsonbtn;

	    @FXML
	    private JFXButton retourbtn;

	    @FXML
	    void genererJSON(ActionEvent event) throws IOException {
	    	Outils.showInformationMessage("success", "Fichier JSON gener�");
        	String url = "/data_acquisition/acquisition_module.fxml";
    		Outils.load(event, url);
	    }

	    @FXML
	    void genererXML(ActionEvent event) throws IOException {
	    	Outils.showInformationMessage("success", "Fichier XML gener� ");
        	String url = "/data_acquisition/acquisition_module.fxml";
    		Outils.load(event, url);
	    }

	    @FXML
	    void retourButton(ActionEvent event) throws IOException {
	    	String url = "/data_acquisition/acquisition_module.fxml";
			Outils.load(event, url);
	    }

}
