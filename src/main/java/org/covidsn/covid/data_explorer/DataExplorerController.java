package org.covidsn.covid.data_explorer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.esri.arcgisruntime.data.VectorTileCache;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.layers.ArcGISVectorTiledLayer;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.Callout;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Point2D;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.covidsn.covid.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
//import javafx.embed.swing.SwingFXUtils;
import com.esri.arcgisruntime.concurrent.ListenableFuture;

public class DataExplorerController implements Initializable {

    @FXML
    private AnchorPane anch;

    @FXML
    private DatePicker datepicker;

    @FXML
    private JFXButton pngbtn;

    @FXML
    private JFXButton sqlbtn;

    @FXML
    private JFXButton csvbtn;

    @FXML
    private StackPane stackpane;

    @FXML
    private JFXButton retourbtn;

    private MapView mapView;

    @FXML
    void retourButton(ActionEvent event) throws IOException {
    	String url = "/acceuil.fxml";
		Outils.load(event, url);
    }

    @FXML
    void telechargerCSV(ActionEvent event) {
    	boolean bool = false;
    	if (bool) {
        	Outils.showInformationMessage("Success", "telechargement fichier termin�");

		} else {
	    	Outils.showErrorMessage("Error", "Probleme survenue");

		}
    }

    @FXML
    void telechargerPNG(ActionEvent event) {
    	LocalDate date = datepicker.getValue();
    	if (date !=null) {
        	Outils.showInformationMessage("Success", "Telechargement image termin�");
        	System.out.println(date);

		} else {
	    	Outils.showErrorMessage("Error", "Probleme survenue");

		}

    }

    @FXML
    void telechargerSQL(ActionEvent event) {
    	boolean bool = false;
    	if (bool) {
        	Outils.showInformationMessage("Success", "Telechargement fichier sql termin�");

		} else {
	    	Outils.showErrorMessage("Error", "Probleme survenue");

		}
    }
    @FXML
    public void loadMap(){
        try {

            // create a tile cache from a local tile package
            File tpkFile = new File(System.getProperty("data.dir"), "./src/main/resources/samples-data/zglz5ucjyyso3mkr2cew6vauic.vtpk");
            System.out.println(tpkFile.getAbsolutePath());
            VectorTileCache tileCache = new VectorTileCache (tpkFile.getAbsolutePath());


            // create a tiled layer from the tile cache
            ArcGISVectorTiledLayer tiledLayer = new ArcGISVectorTiledLayer(tileCache);

            // create a basemap with the tiled layer
            Basemap basemap = new Basemap(tiledLayer);

            // create ArcGISMap with the tiled layer basemap
            ArcGISMap map = new ArcGISMap(basemap);

            // create a map view and set its mapz
            mapView = new MapView();
            mapView.setMap(map);
            // get the map view's callout
            Callout callout = mapView.getCallout();

            // click event to display the callout
            mapView.setOnMouseClicked(e -> {

                // check that the primary mouse button was clicked and user is not panning
                if (e.getButton() == MouseButton.PRIMARY && e.isStillSincePress()) {

                    // create a point from where the user clicked
                    Point2D point = new Point2D(e.getX(), e.getY());

                    // create a map point from a point
                    Point mapPoint = mapView.screenToLocation(point);

                    // set the callout's details
                    callout.setTitle("Region: ");
                    callout.setDetail(String.format("\nNombre de Test: 15\n Nombre de nouveaux cas: 20\nNbre de cas communautaires: \nNbre de guéris:%.2f \nNombre de décès: %.2f,  ", mapPoint.getX(), mapPoint.getY()));

                    // show the callout where the user clicked
                    callout.showCalloutAt(mapPoint);

                    // dismiss the callout on secondary click
                } else if (e.getButton() == MouseButton.SECONDARY && e.isStillSincePress()) {
                    callout.dismiss();
                }
            });

            // add map view to stack pane
            //stackPane.getChildren().add(mapView);
            stackpane.getChildren().add(mapView);

        } catch (Exception e) {
            // on any error, print the stack trace
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datepicker = new DatePicker();
        loadMap();
    }
}
