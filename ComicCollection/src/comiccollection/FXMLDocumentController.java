package comiccollection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    ComicCollection comicCollection = new ComicCollection();
    public Boolean dcOpen = false;
    public Boolean marvelOpen = false;
    @FXML
    private Button marvelButton;
    @FXML
    private Button dcButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button importButton;

    @FXML
    private void searchButtonAction(ActionEvent event) {
        System.out.println("Search");
    }

    @FXML
    private void importButtonAction(ActionEvent event) throws IOException {
        comicCollection.importFile(event);
        closeCurrentPage(event);
    }
    
    @FXML
    public void marvelButtonAction(ActionEvent event) throws IOException {
        closeCurrentPage(event);
        comicCollection.switchScene("Marvel_Comics.fxml", "HomePage.fxml");
    }

    @FXML
    public void dcButtonAction(ActionEvent event) throws IOException {
        closeCurrentPage(event);
        comicCollection.switchScene("DC_Comics.fxml", "HomePage.fxml");
    }

    @FXML
    public void spidermanButtonAction(ActionEvent event) throws IOException {
        closeCurrentPage(event);
        comicCollection.switchScene("Spider-Man.fxml", "Marvel_Comics.fxml");
    }

    @FXML
    public void openPreviousPage(ActionEvent event) throws IOException {
        closeCurrentPage(event);
        comicCollection.previousScene();
    }

    @FXML
    public void closeCurrentPage(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
