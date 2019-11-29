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

public class SupermanController implements Initializable{
    @FXML
    private ListView<String> seriesNameList = new ListView<>();
    public ObservableList<String> seriesNameItems = FXCollections.observableArrayList();
    @FXML
    private ListView<String> volNumList = new ListView<String>();
    private ObservableList<String> volNumItems = FXCollections.observableArrayList();
    @FXML
    private ListView<String> issueNumList = new ListView<String>();
    private ObservableList<String> issueNumItems = FXCollections.observableArrayList();

    private FXMLDocumentController homeController = new FXMLDocumentController();
    private Character superman = new Character();

    @FXML
    public void openPreviousPage(ActionEvent event) throws IOException {
        homeController.openPreviousPage(event);
    }

    @FXML
    public void getIssues() {
        String issues = superman.getIssues(seriesNameList.getSelectionModel().getSelectedItem(), volNumList.getSelectionModel().getSelectedItem());
        issueNumItems.clear();

        String[] issueRange = issues.split(Pattern.quote("|"));
        for (String ranges: issueRange) {
            if (ranges.contains("-")) {
                String firstIssue = ranges.split("-")[0];
                String lastIssue = ranges.split("-")[1];
                for (Integer j = Integer.parseInt(firstIssue); j <= Integer.parseInt(lastIssue); j++) {
                    issueNumItems.add(j.toString());
                }
            } else {
                issueNumItems.add(ranges);
            }
        }

        issueNumList.getItems().setAll(issueNumItems);
    }

    @FXML
    public void getVolumes(MouseEvent event) {
        int volumes = superman.getVolumes(event.toString());
        volNumItems.clear();
        issueNumItems.clear();


        for (Integer j = 1; j <= volumes; j++) {
            volNumItems.add(j.toString());
        }

        volNumList.getItems().setAll(volNumItems);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        seriesNameItems.addAll(superman.getSeries("Superman"));

        seriesNameList.getItems().setAll(seriesNameItems);
    }
}
