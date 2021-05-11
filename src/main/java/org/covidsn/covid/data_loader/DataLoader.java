package org.covidsn.covid.data_loader;

import org.covidsn.covid.tools.Outils;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
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
			String repertoiree = "C:\\Users\\User\\Desktop\\essai";
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
						affichage(chemin);
					}
				}
			} else {
				System.err.println("Nom de repertoire invalide");
			}
		}



		 SAXBuilder builder = new SAXBuilder();
		 Document document  = new Document();
		 CheckBoxTreeItem<String> treeit = new CheckBoxTreeItem<>() ;
		 CheckBoxTreeItem<String> root = new CheckBoxTreeItem<>();
	     public void affichage(String file){
			 File fichierXML = new File(file);
			 try {
				 document = builder.build(fichierXML);
				 Element rootNode = document.getRootElement();
				 List<Element> liste = rootNode.getChildren();
				 root.setValue(rootNode.getName());
				 for (Element eClasse : liste) {
					 treeit = new CheckBoxTreeItem<>();
					 treeit.setValue(eClasse.getName());
					 root.getChildren().add(
							 treeit
					 );
				 }

				 root.setExpanded(true);
				 fichiertreeview.setRoot(root);
				 fichiertreeview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

				 fichiertreeview.getCheckModel().getCheckedItems().addListener(new ListChangeListener<TreeItem<String>>() {
					 @Override public void onChanged(ListChangeListener.Change<? extends TreeItem<String>> change) {
					 	while (change.next()) {
							 System.out.println("List " + change.getList());
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
	     

	@SuppressWarnings("unchecked")

	public void initialize(URL location, ResourceBundle resources) {

		//affichage();
		repertoire();
		
	}
	   
	  
	}
