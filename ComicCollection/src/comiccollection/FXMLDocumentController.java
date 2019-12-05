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
    public void marvelCharacterButtonAction(ActionEvent event) throws IOException {
        Button characterButton = (Button) event.getSource();
        String buttonId = characterButton.getId();
        closeCurrentPage(event);
        checkCharacterName(buttonId);
        comicCollection.switchScene("character_pages/" + buttonId + ".fxml", "Marvel_Comics.fxml");
    }

    @FXML
    public void dcCharacterButtonAction(ActionEvent event) throws IOException {
        Button characterButton = (Button) event.getSource();
        String buttonId = characterButton.getId();
        closeCurrentPage(event);
        checkCharacterName(buttonId);
        comicCollection.switchScene("character_pages/" + buttonId + ".fxml", "DC_Comics.fxml");
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

    public void checkCharacterName(String characterName) {
        switch (characterName) {
            case "Black_Panther":
                comicCollection.setCharacterName("Black Panther");
                break;
            case "Captain_America":
                comicCollection.setCharacterName("Captain America");
                break;
            case "Doctor_Strange":
                comicCollection.setCharacterName("Doctor Strange");
                break;
            case "Fantastic_Four":
                comicCollection.setCharacterName("Fantastic Four");
                break;
            case "Green_Arrow":
                comicCollection.setCharacterName("Green Arrow");
                break;
            case "Green_Lantern":
                comicCollection.setCharacterName("Green Lantern");
                break;
            case "Iron_Man":
                comicCollection.setCharacterName("Iron Man");
                break;
            case "Justice_League":
                comicCollection.setCharacterName("Justice League");
                break;
            case "Spider_Man":
                comicCollection.setCharacterName("Spider-Man");
                break;
            case "X_Men":
                comicCollection.setCharacterName("X-Men");
                break;
            default:
                comicCollection.setCharacterName(characterName);
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
