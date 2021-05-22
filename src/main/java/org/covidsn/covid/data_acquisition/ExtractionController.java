package org.covidsn.covid.data_acquisition;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TablePosition;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sourceforge.tess4j.TesseractException;
import org.covidsn.covid.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.swing.*;

public class ExtractionController implements Initializable {

	 @FXML
	    private TableView<String> fichiertable;

	    @FXML
	    private TableColumn<String, String> fichiercolumn;

	    @FXML
	    private JFXButton xmlbtn;

	    @FXML
	    private JFXButton jsonbtn;

	    @FXML
	    private JFXButton retourbtn;
		private Object val;




	    @FXML
	    void genererJSON(ActionEvent event) throws IOException, TesseractException {
	    	Extraction ext = new Extraction((String)val);
	    	new CreateFile().fileXml(ext.getNomCommunique(), ext.getNombreTest(), ext.getTestPositifs(), ext.getCasContact(), ext.getTransmissionCommunautaire(),ext.getNombreGueris(),ext.getNombreDeces());
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<String> o = new ArrayList<>();
		File folder = new File(TelechargementController.getLien());
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				String nom = file.getName();
				o.add(nom);
			}
		}
		ObservableList<String> listed = FXCollections.observableArrayList(o);
		fichiertable.setItems(listed);
		fichiercolumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

		fichiertable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				TableView.TableViewSelectionModel selectionModel = fichiertable.getSelectionModel();
				ObservableList selectedCells = selectionModel.getSelectedCells();
				TablePosition tablePosition = (TablePosition) selectedCells.get(0);
				val = tablePosition.getTableColumn().getCellData(newValue);

			}
		});

	}
}
