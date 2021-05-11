package org.covidsn.covid.data_loader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;


import com.jfoenix.controls.JFXButton;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import org.covidsn.covid.dao.arrondissement.Arrondissement;
import org.covidsn.covid.dao.arrondissement.ArrondissementDB;
import org.covidsn.covid.dao.commune.CommuneDB;
import org.covidsn.covid.dao.communique.Communique;
import org.covidsn.covid.dao.communique.CommuniqueDB;
import org.covidsn.covid.dao.communiqueLocalite.CommuniqueLocalite;
import org.covidsn.covid.dao.communiqueLocalite.CommuniqueLocaliteDB;
import org.covidsn.covid.dao.departement.DepartementDB;
import org.covidsn.covid.dao.region.RegionDB;
import org.covidsn.covid.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExportBD  implements Initializable{
	
	@FXML
    private JFXButton transactionbtn;

    @FXML
    private JFXButton notransactionbtn;

    @FXML
    private JFXButton retourbtn;

    DataLoader dataloader ;

	List list = DataLoader.list;

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	private void loadtransactional( String fileName) throws IOException, JDOMException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CommuniqueLocalite cml ;
		SAXBuilder builder = new SAXBuilder();
		File fichierXML = new File(fileName);
		Document document = builder.build(fichierXML);
		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren();


		for (int i = 0; i < liste.size(); i++ ){

			String nbTest = liste.get(i).getChild("nombre-test").getValue();
			String nbNouveauxCas = liste.get(i).getChild("nombre-nouveaux-cas").getValue();
			String nbCasContact = liste.get(i).getChild("nombre-cas-contact").getValue();
			String nbCasComm = liste.get(i).getChild("nombre-cas-communautaires").getAttribute("nombre").getValue();
			String nbGueris = liste.get(i).getChild("nombre-gueris").getValue();
			String nbDeces = liste.get(i).getChild("nombre-deces").getValue();
			String nomFichier = liste.get(i).getChild("nom-fichier-source").getValue();
			String dateExtraction = liste.get(i).getChild("date-heure-extraction").getValue();

			List<Element> ville = liste.get(i).getChild("nombre-cas-communautaires").getChildren();

			String localite =  null;
			String nbCas =  null;

			int n = 0;
			for (int v = 0; v < ville.size(); v++) {
				String nomV = ville.get(v).getName().toUpperCase(Locale.ROOT);


				if (nomV.toLowerCase(Locale.ROOT).equals("nom-localite") ){
					localite = ville.get(v).getValue();
				}else{
					nbCas = ville.get(v).getValue();
				}
				n++;

				if (n%2 == 0){

					System.out.println(localite+"    "+nbCas);


					Communique c = new 	Communique( nomFichier,dateExtraction, Integer.parseInt(nbTest), Integer.parseInt(nbNouveauxCas),
							Integer.parseInt(nbNouveauxCas),Integer.parseInt(nbCasComm),  Integer.parseInt(nbGueris), Integer.parseInt( nbDeces), nomFichier);

					RegionDB region = new RegionDB();
					DepartementDB dept =new DepartementDB();
					CommuneDB comm  = new CommuneDB();
					ArrondissementDB arr  = new ArrondissementDB();

					String val = region.getCodeRegionByName(localite);
					if (val== null){
						val = dept.getCodeDepartementByName(localite);
						if (val == null){
							val = arr.getCodeArrondissementByName(localite);
							if (val == null){
								val = comm.getCodeCommuneByname(localite);
								if (val == null){
									cml = new CommuniqueLocalite("not known",Integer.parseInt(nbCas));
									cml.setCommunique(c);
								}else{
									cml = new CommuniqueLocalite(val,Integer.parseInt(nbCas));
									cml.setCommunique(c);
								}
							}else{
								cml = new CommuniqueLocalite(val,Integer.parseInt(nbCas));
								cml.setCommunique(c);
							}
						}else{
							cml = new CommuniqueLocalite(val,Integer.parseInt(nbCas));
							cml.setCommunique(c);
						}
					}else{
						cml = new CommuniqueLocalite(val,Integer.parseInt(nbCas));
						cml.setCommunique(c);
					}


					entityManager.persist(c);
					entityManager.persist(cml);

				}
			}
		}

	}


	private void loadNoTransactional(String fileName) throws IOException, JDOMException {
		CommuniqueLocalite cml ;
    	SAXBuilder builder = new SAXBuilder();
		File fichierXML = new File(fileName);
		Document document = builder.build(fichierXML);
		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren();


		for (int i = 0; i < liste.size(); i++ ){

			String nbTest = liste.get(i).getChild("nombre-test").getValue();
			String nbNouveauxCas = liste.get(i).getChild("nombre-nouveaux-cas").getValue();
			String nbCasContact = liste.get(i).getChild("nombre-cas-contact").getValue();
			String nbCasComm = liste.get(i).getChild("nombre-cas-communautaires").getAttribute("nombre").getValue();
			String nbGueris = liste.get(i).getChild("nombre-gueris").getValue();
			String nbDeces = liste.get(i).getChild("nombre-deces").getValue();
			String nomFichier = liste.get(i).getChild("nom-fichier-source").getValue();
			String dateExtraction = liste.get(i).getChild("date-heure-extraction").getValue();

			List<Element> ville = liste.get(i).getChild("nombre-cas-communautaires").getChildren();

			String localite =  null;
			String nbCas =  null;

			int n = 0;
			for (int v = 0; v < ville.size(); v++) {
				String nomV = ville.get(v).getName().toUpperCase(Locale.ROOT);


				if (nomV.toLowerCase(Locale.ROOT).equals("nom-localite") ){
					 localite = ville.get(v).getValue();
				}else{
					nbCas = ville.get(v).getValue();
				}
				n++;

				if (n%2 == 0){

					System.out.println(localite+"    "+nbCas);


				Communique c = new 	Communique( nomFichier,dateExtraction, Integer.parseInt(nbTest), Integer.parseInt(nbNouveauxCas),
						Integer.parseInt(nbNouveauxCas),Integer.parseInt(nbCasComm),  Integer.parseInt(nbGueris), Integer.parseInt( nbDeces), nomFichier);

				RegionDB region = new RegionDB();
				DepartementDB dept =new DepartementDB();
				CommuneDB comm  = new CommuneDB();
				ArrondissementDB arr  = new ArrondissementDB();

				String val = region.getCodeRegionByName(localite);
				if (val== null){
					val = dept.getCodeDepartementByName(localite);
					if (val == null){
						val = arr.getCodeArrondissementByName(localite);
						if (val == null){
							val = comm.getCodeCommuneByname(localite);
							if (val == null){
								cml = new CommuniqueLocalite("not known",Integer.parseInt(nbCas));
								cml.setCommunique(c);
							}else{
								cml = new CommuniqueLocalite(val,Integer.parseInt(nbCas));
								cml.setCommunique(c);
							}
						}else{
							cml = new CommuniqueLocalite(val,Integer.parseInt(nbCas));
							cml.setCommunique(c);
						}
					}else{
						cml = new CommuniqueLocalite(val,Integer.parseInt(nbCas));
						cml.setCommunique(c);
					}
				}else{
					cml = new CommuniqueLocalite(val,Integer.parseInt(nbCas));
					cml.setCommunique(c);
				}

				CommuniqueDB cl = new CommuniqueDB();
				CommuniqueLocaliteDB cmdb = new CommuniqueLocaliteDB();
				cl.add(c);
				cmdb.add(cml);
				}
			}
		}
	}

    
    @FXML
    void retourButton(ActionEvent event) throws IOException {
    	String url = "/data_loader/liste_fichier_xml_json.fxml";
		Outils.load(event, url);
    }

    @FXML
    void noTransaction(ActionEvent event) throws IOException , JDOMException {

			if (list != null){
				String file = "C:\\Users\\User\\Desktop\\essai.xml";
				loadNoTransactional(file);

				for (Object i : list){
					System.out.println(i);
				}
				Outils.showInformationMessage("Success", "Exportation termin�");
			}else {
				Outils.showErrorMessage("Error", "Vous n'avez selectionne aucun element");
			}


    }


    @FXML
    void transaction(ActionEvent event) throws IOException, JDOMException {
    	ButtonType valider = new ButtonType("valider", ButtonBar.ButtonData.OK_DONE);
		ButtonType annuler = new ButtonType("annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
		Alert alert = new Alert(AlertType.WARNING,
		        "La transaction est termin�. Voulez vous valider ?",
		        valider,
		        annuler);

		alert.setTitle("Date format warning");
		Optional<ButtonType> result = alert.showAndWait();
		String file = "C:\\Users\\User\\Desktop\\essai.xml";
		entityManager.getTransaction().begin();
		loadtransactional(file);
		if (result.orElse(valider) == annuler) {
			System.out.println("FF");
			entityManager.getTransaction().rollback();
			entityManager.close();
			Outils.showErrorMessage("Cancel", "Transaction annulé");

		}else {
			entityManager.getTransaction().commit();
			entityManager.close();
			Outils.showInformationMessage("Success", "transaction terminé validé. Donnée exporté vers la base");
		}
	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}


}
