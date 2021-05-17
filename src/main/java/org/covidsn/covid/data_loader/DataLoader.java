package org.covidsn.covid.data_loader;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.controlsfx.control.PopOver;
import org.covidsn.covid.tools.Outils;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.CheckTreeView;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataLoader implements Initializable{

	     @FXML
	     private AnchorPane anch;
	     
	     @FXML
	     private CheckTreeView<String> fichiertreeview ;

		public static List list ;

		CheckBoxTreeItem<String> root = new CheckBoxTreeItem<>();

	     @FXML
	     void exporterBD(ActionEvent event) throws IOException {
	     	if (list == null){
				Outils.showErrorMessage("Erreur","Vous n'avez pas choisi de date");
			}else{
				String url = "/data_loader/exporteBD.fxml";
				Outils.load(event, url);
			}

	     }

	     public void repertoire(){
			String repertoiree = "essai";
			File repertoire = new File(repertoiree);
			String liste[] = repertoire.list();

			if (liste != null) {
				for (int i = 0; i < liste.length; i++) {
					String file = liste[i];
					String regex = ".(.+)n";
					Pattern s = Pattern.compile(regex);
					Matcher d = s.matcher(file);
					if (d.find()){
						//System.out.println("Trouve");
					}else{
						String chemin = repertoiree+"\\"+file;
						affichage(chemin);
					}
				}
			} else {
				System.err.println("Nom de repertoire invalide");
			}
		}

	     public void affichage(String file){

			 SAXBuilder builder = new SAXBuilder();
			 Document document  = new Document();
			 CheckBoxTreeItem<String> treeit = new CheckBoxTreeItem<>();
			 CheckBoxTreeItem child  = new CheckBoxTreeItem();

			 try {
				 File fichierXML = new File(file);
				 root.setExpanded(true);
				 document = builder.build(fichierXML);
				 Element rootNode = document.getRootElement();
				 List<Element> liste = rootNode.getChildren();
				 root.setValue("Select all date");
				 treeit = new CheckBoxTreeItem<>();
				 treeit.setValue(rootNode.getName());
				 root.getChildren().add(treeit);
				 for (Element eClasse : liste) {
					child = new CheckBoxTreeItem<>();
					 child.setValue(eClasse.getName());
					 treeit.getChildren().add(child);

				 }
				 fichiertreeview.setRoot(root);
				 fichiertreeview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
				 fichiertreeview.getCheckModel().getCheckedItems().addListener(new ListChangeListener<TreeItem<String>>() {
					 @Override public void onChanged(ListChangeListener.Change<? extends TreeItem<String>> change) {
					 	while (change.next()) {
							 //System.out.println("List " + change.getList());
							 list = change.getList();
						 }
					 }
				 });


			 }catch (JDOMException e) {
				 e.printStackTrace();
			 }
			 catch (IOException e) {
				 e.printStackTrace();
			 }

		}



	@FXML
	     private void retourButton(ActionEvent event) throws IOException {
	     	String url = "/acceuil.fxml";
	 		Outils.load(event, url);

	     }

	     private void visualControl() throws Exception{
			 String repertoiree = "essai";
			 File repertoire = new File(repertoiree);
			 String liste[] = repertoire.list();

			 if (liste != null) {
				 for (int i = 0; i < liste.length; i++) {
					 String file = liste[i];
					 String regex = ".(.+)n";
					 Pattern s = Pattern.compile(regex);
					 Matcher d = s.matcher(file);
					 if (d.find()){
						 System.out.println("Trouve");
					 }else{
						 String chemin = repertoiree+"\\"+file;
						visualisation(chemin);
					 }
				 }
			 } else {
				 System.err.println("Nom de repertoire invalide");
			 }
		 }

	     private void visualisation(String file) throws Exception{
			 fichiertreeview.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<TreeItem<String>>() {
				 @Override public void onChanged(ListChangeListener.Change<? extends TreeItem<String>> change) {
					 while (change.next()) {
						 try{

							 List<? extends TreeItem<String>> t = change.getAddedSubList();
							 String donnee =t.get(0).getValue();
							 Label lblName = new Label();
							 lblName.setText(donnee);
							 SAXBuilder builder = new SAXBuilder();
							 Document document  = new Document();
							 File fichierXML = new File(file);
							 document = builder.build(fichierXML);
							 Element rootNode = document.getRootElement();
							 List<Element> liste = rootNode.getChildren();
							 String don = "";
							 int i = 0;
							 Label lblStreet = new Label();
							 for (Element eClasse : liste) {
								 if (eClasse.getName().equals(donnee)){
									 lblStreet = new Label();
								 	don = "";
								 	List<Element> e = eClasse.getChildren();
								 	for (Element el : e){
								 		don += el.getName() + " "+ el.getValue()+ "\n";
									}
								 }
							 }

							 lblStreet.setText(don);
							 VBox vBox = new VBox(lblName, lblStreet );
							 //Create PopOver and add look and feel
							 PopOver popOver = new PopOver(vBox);
							 popOver.setMaxSize(30,15);
							 popOver.show(anch,100);
						 }catch (Exception e){
							 e.printStackTrace();
							// System.out.println("there");
						 }
					 }
				 }
			 });

		 }


	@SuppressWarnings("unchecked")

	public void initialize(URL location, ResourceBundle resources) {

		//affichage();
		repertoire();
		try {
			visualControl();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}





	}

		
