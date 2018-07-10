package comiccollection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class SpidermanController implements Initializable{
    @FXML
    private ListView<String> seriesNameList = new ListView<String>();
    private ObservableList<String> seriesNameItems = FXCollections.observableArrayList();
    @FXML
    private ListView<String> volNumList = new ListView<String>();
    private ObservableList<String> volNumItems = FXCollections.observableArrayList();
    @FXML
    private ListView<String> issueNumList = new ListView<String>();
    private ObservableList<String> issueNumItems = FXCollections.observableArrayList();
    @FXML
    private FXMLDocumentController homeController = new FXMLDocumentController();

    @FXML
    public void openPreviousPage(ActionEvent event) throws IOException {
        homeController.openPreviousPage(event);
    }
    
    @FXML
    public void handleMouseClick(MouseEvent event) throws IOException {
        System.out.println(seriesNameList.getSelectionModel().getSelectedItem());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        seriesNameList.setItems(seriesNameItems);
        seriesNameItems.add("The Amazing Spider-Man");
        seriesNameItems.add("Spider-Man");
        seriesNameItems.add("Spider-Man/Deadpool");
        seriesNameItems.add("Peter Parker: The Spectacular Spider-Man");
        seriesNameItems.add("The Spectacular Spider-Man");
        seriesNameItems.add("Web of Spider-Man");
        seriesNameItems.add("Ultimate Spider-Man");
    }
}
