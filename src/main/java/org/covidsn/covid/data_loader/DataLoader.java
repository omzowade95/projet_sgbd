package org.covidsn.covid.data_loader;

import javafx.collections.ObservableList;
import org.covidsn.covid.tools.Outils;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.Label;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DataLoader implements Initializable{
   
	private final Label checkedItemsLabel = new Label();
	     private final Label selectedItemsLabel = new Label();
	     
	     @FXML
	     private AnchorPane anch;
	     
	     @FXML
	     private CheckTreeView<String> fichiertreeview ;

		private  ObservableList<TreeItem<String>> list =  null ;



	     @FXML
	     void exporterBD(ActionEvent event) throws IOException {
	    	 String url = "/data_loader/exporteBD.fxml";
	    	 Outils.load(event, url);

	     }

	     public void affichage(){

			 SAXBuilder builder = new SAXBuilder();
			 File fichierXML = new File("C:\\Users\\User\\Desktop\\essai.xml");
			 Document document ;

			 CheckBoxTreeItem<String> root = new CheckBoxTreeItem<>();
			 CheckBoxTreeItem<String> treeit = null ;
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

				 fichiertreeview.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<TreeItem<String>>() {
					 @Override
					 public void onChanged(ListChangeListener.Change<? extends TreeItem<String>> c) {
						 System.out.println("selectedItemsLabel, c.getList()");

					 }
				 });


				 fichiertreeview.getCheckModel().getCheckedItems().addListener(new ListChangeListener<TreeItem<String>>() {
					 @Override public void onChanged(ListChangeListener.Change<? extends TreeItem<String>> change) {
						 System.out.println("checkedItemsLabel, change.getList()");

						 while (change.next()) {
							 System.out.println("============================================");
							 System.out.println("Change: " + change);
							 System.out.println("Added sublist " + change.getAddedSubList());
							 System.out.println("Removed sublist " + change.getRemoved());
							 System.out.println("List " + change.getList());
							 list = (ObservableList<TreeItem<String>>) change.getList();
							 System.out.println("Added " + change.wasAdded() + " Permutated " + change.wasPermutated() + " Removed " + change.wasRemoved() + " Replaced "
									 + change.wasReplaced() + " Updated " + change.wasUpdated());
							 System.out.println("============================================");
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


		public ObservableList<TreeItem<String>> cheekedItems(){

			return list;
		}

	@FXML
	     private void retourButton(ActionEvent event) throws IOException {
	     	String url = "/acceuil.fxml";
	 		Outils.load(event, url);

	     }
	     

	@SuppressWarnings("unchecked")

	public void initialize(URL location, ResourceBundle resources) {

		affichage();
		
	}
	   
	  
	}
