package comiccollection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class CharacterController implements Initializable{
    @FXML
    private ListView<String> seriesNameList = new ListView<>();
    public ObservableList<String> seriesNameItems = FXCollections.observableArrayList();
    @FXML
    private ListView<String> volNumList = new ListView<>();
    private ObservableList<String> volNumItems = FXCollections.observableArrayList();
    @FXML
    private ListView<String> issueNumList = new ListView<>();
    private ObservableList<String> issueNumItems = FXCollections.observableArrayList();
    
    private FXMLDocumentController homeController = new FXMLDocumentController();
    private Character character = new Character();
    private ComicCollection comicCollection = new ComicCollection();

    @FXML
    public void openPreviousPage(ActionEvent event) throws IOException {
        homeController.openPreviousPage(event);
    }
    
    @FXML
    public void getIssues() {
        String issues = character.getIssues(seriesNameList.getSelectionModel().getSelectedItem(), volNumList.getSelectionModel().getSelectedItem());
        issueNumItems.clear();
        issueNumList.getItems().clear();

        String[] issueRange = issues.split(Pattern.quote("|"));
        for (String ranges: issueRange) {
            if (ranges.contains("-")) {
                String firstIssue = ranges.split("-")[0];
                String lastIssue = ranges.split("-")[1];
                if (firstIssue.length() == 0) {
                    issueNumItems.add(ranges);
                } else {
                    for (Integer j = Integer.parseInt(firstIssue); j <= Integer.parseInt(lastIssue); j++) {
                        issueNumItems.add(j.toString());
                    }
                }
            } else {
                issueNumItems.add(ranges);
            }
        }

        issueNumList.getItems().setAll(issueNumItems);
    }
    
    @FXML
    public void getVolumes() {
        String volumes = character.getVolumes(seriesNameList.getSelectionModel().getSelectedItem());
        volNumItems.clear();
        volNumList.getItems().clear();
        issueNumList.getItems().clear();
        String[] volumeRange = volumes.split(";");
        for(String range: volumeRange) {
            if (range.contains("-")) {
                String firstIssue = range.split("-")[0];
                String lastIssue = range.split("-")[1];
                for (Integer j = Integer.parseInt(firstIssue); j <= Integer.parseInt(lastIssue); j++) {
                    volNumItems.add(j.toString());
                }
            } else {
                volNumItems.add(range);
            }
        }

        volNumList.getItems().setAll(volNumItems);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        seriesNameItems.addAll(character.getSeries(comicCollection.getCharacterName()));
        
        seriesNameList.getItems().setAll(seriesNameItems);
    }
}
