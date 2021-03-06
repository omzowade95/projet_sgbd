package org.covidsn.covid.data_acquisition;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import org.covidsn.covid.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

public class TelechargementController implements Initializable {
	@FXML
    private AnchorPane anch;	
	 
	@FXML
    private TableView<?> telechargementtable;

    @FXML
    private TableColumn<?, ?> nomfichierrow;

    @FXML
    private TableColumn<?, ?> daterow;

    @FXML
    private JFXButton telechargerbtn;

    @FXML
    private ProgressBar progressbar;

    @FXML
    private JFXButton retourbtn;
    
    DirectoryChooser directoryChooser = new DirectoryChooser();
    String lien ;
   


    @FXML
    void retourButton(ActionEvent event) throws IOException {
    	String url = "/data_acquisition/acquisition_module.fxml";
		Outils.load(event, url);
    }
    
    @FXML
    void  selectDirectory() {
    	 directoryChooser.setInitialDirectory(new File("src"));
    	File selectedDirectory = directoryChooser.showDialog(anch.getScene().getWindow());
    	 lien = selectedDirectory.getAbsolutePath();	 
 	
    }
   

    @FXML
    void telecharger(ActionEvent event) throws IOException {
    	
        progressbar.setProgress(0);        
        if (lien != null) {
       	 try {

            	System.out.println(lien.toString());
        		progressbar.setProgress(1);
            	Outils.showInformationMessage("success", "telechargement reussi"+lien.toString());
            	String url = "/data_acquisition/acquisition_module.fxml";
        		Outils.load(event, url);
        	
            } catch (Exception e1) {
           	 // TODO: handle exception
            }
		}else {
			Outils.showErrorMessage("No file selected", "Vous n'avez pas choisis de repertoire");
		}
       
    }

	public void initialize(URL location, ResourceBundle resources) {
		//  Pour remplir le tableau
		
	}

}
