package org.covidsn.covid.data_loader;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;



import com.jfoenix.controls.JFXButton;

import javafx.scene.control.TreeItem;
import org.covidsn.covid.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class ExportBD  implements Initializable{
	
	@FXML
    private JFXButton transactionbtn;

    @FXML
    private JFXButton notransactionbtn;

    @FXML
    private JFXButton retourbtn;

    DataLoader dataloader ;
    


    
    @FXML
    void retourButton(ActionEvent event) throws IOException {
    	String url = "/data_loader/liste_fichier_xml_json.fxml";
		Outils.load(event, url);
    }

    @FXML
    void noTransaction(ActionEvent event) throws IOException {
    	boolean bool = false;
		dataloader = new DataLoader();
    	if (bool) {
			List<TreeItem<String>> list = dataloader.cheekedItems();

        	Outils.showInformationMessage("Success", "Exportation termin�");

		} else {
	    	Outils.showErrorMessage("Error", "Probleme survenue");

		}
    }


    @FXML
    void transaction(ActionEvent event) throws IOException {
    	ButtonType valider = new ButtonType("valider", ButtonBar.ButtonData.OK_DONE);
		ButtonType annuler = new ButtonType("annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
		Alert alert = new Alert(AlertType.WARNING,
		        "La transaction est termin�. Voulez vous valider ?",
		        valider,
		        annuler);

		alert.setTitle("Date format warning");
		Optional<ButtonType> result = alert.showAndWait();

		dataloader = new DataLoader();
		List<TreeItem<String>> list = dataloader.cheekedItems();

		if (result.orElse(valider) == annuler) {
			Outils.showErrorMessage("Cancel", "Transaction annul�");
		}else {
			Outils.showInformationMessage("Success", "transaction termin� valid�. Donn�e export� vers la base");
		}
	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}


}
