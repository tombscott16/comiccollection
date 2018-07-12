package comiccollection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class SpidermanController implements Initializable{    
    @FXML
    private TableView<String> seriesNameTable = new TableView<String>();
    private ObservableList<String> seriesNameItems = FXCollections.observableArrayList();
    
    @FXML
    private TableColumn seriesName = new TableColumn("Series Name:");
    @FXML
    private TableColumn volNum = new TableColumn("Volumes:");
    @FXML
    private ListView<String> volNumList = new ListView<String>();
    private ObservableList<String> volNumItems = FXCollections.observableArrayList();
    @FXML
    private TableView<String> issueNumList = new TableView<String>();
    private ObservableList<String> issueNumItems = FXCollections.observableArrayList();
    
    private FXMLDocumentController homeController = new FXMLDocumentController();
    private Spiderman spiderman = new Spiderman();

    @FXML
    public void openPreviousPage(ActionEvent event) throws IOException {
        homeController.openPreviousPage(event);
    }
    
    @FXML
    public void handleMouseClick(MouseEvent event) throws IOException {
        System.out.println(event.getTarget());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        seriesNameItems.addAll(spiderman.getSeries());
        
        System.out.println(seriesNameItems);
        
        seriesNameTable.setItems(seriesNameItems);
//        seriesNameTable.getColumns().addAll(seriesName, volNum);
    }
}
