package org.covidsn.covid.data_loader;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DataLoader implements Initializable{
   
	private final Label checkedItemsLabel = new Label();
	     private final Label selectedItemsLabel = new Label();
	     
	     @FXML
	     private AnchorPane anch;
	     
	     @FXML
	     private CheckTreeView<String> fichiertreeview ;
	     
	     private CheckBoxTreeItem<String> treeItem_Jonathan = new CheckBoxTreeItem<>("Jonathan");
	     private CheckBoxTreeItem<String> treeItem_Eugene = new CheckBoxTreeItem<>("Eugene");
	     private CheckBoxTreeItem<String> treeItem_Henry = new CheckBoxTreeItem<>("Henry");
	     private CheckBoxTreeItem<String> treeItem_Samir = new CheckBoxTreeItem<>("Samir");

	     @FXML
	     void exporterBD(ActionEvent event) throws IOException {
	    	 String url = "/data_loader/exporteBD.fxml";
	    	 
	    	 Outils.load(event, url);

	     }
	     
	     @FXML
	     private void retourButton(ActionEvent event) throws IOException {
	     	String url = "/acceuil.fxml";
	 		Outils.load(event, url);
	     }
	     

	@SuppressWarnings("unchecked")

	public void initialize(URL location, ResourceBundle resources) {
		CheckBoxTreeItem<String> root = new CheckBoxTreeItem<>("Root");
		root.setExpanded(true);
		root.getChildren().addAll(
				treeItem_Jonathan,
				treeItem_Eugene,
				treeItem_Henry,
				treeItem_Samir);

		// lets check Eugene to make sure that it shows up in the tree
		treeItem_Eugene.setSelected(true);

		// CheckListView

		fichiertreeview = new CheckTreeView<>(root);
		fichiertreeview.setRoot(root);
		fichiertreeview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		fichiertreeview.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<TreeItem<String>>() {
			@Override public void onChanged(ListChangeListener.Change<? extends TreeItem<String>> c) {
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
					System.out.println("Added " + change.wasAdded() + " Permutated " + change.wasPermutated() + " Removed " + change.wasRemoved() + " Replaced "
							+ change.wasReplaced() + " Updated " + change.wasUpdated());
					System.out.println("============================================");
				}
			}
		});
			   
		
	}
	   
	  
	}
