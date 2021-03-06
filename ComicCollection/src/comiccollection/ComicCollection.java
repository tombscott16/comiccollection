package comiccollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ComicCollection extends Application {

    public static String location;
    public static List<ComicBookSeries> comicBookSeries = new ArrayList<>();
    public static String characterName;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("ImportPage.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Comic Collection");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void importFile(ActionEvent event) throws IOException {

        Stage stage = new Stage();

        FileChooser choose = new FileChooser();
        File excelFile = choose.showOpenDialog(stage);
        getComicSeries(excelFile);
    }

    public void switchScene(String nextFxmlFile, String previousFxmlFile) throws IOException {
        setLocation(previousFxmlFile);

        Parent root = FXMLLoader.load(getClass().getResource(nextFxmlFile));

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setTitle("Comic Collection");
        stage.setScene(scene);
        stage.show();
    }

    public void previousScene() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(location));

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setTitle("Comic Collection");
        stage.setScene(scene);
        stage.show();

        if ("Marvel_Comics.fxml".equals(location) || "DC_Comics.fxml".equals(location)) {
            setLocation("HomePage.fxml");
        }
    }

    public void getComicSeries(File excelFile) throws IOException {

        FileReader reader;
        try {
            reader = new FileReader(excelFile);
            BufferedReader buffReader = new BufferedReader(reader);

            String line;
            int i = 0;

            while ((line = buffReader.readLine()) != null) {
                if (i == 0) {
                } else {
                    comicBookSeries.add(new ComicBookSeries(line.split(",")[0], line.split(",")[1], line.split(",")[2]));
                }
                i++;
            }

            setComicBookSeries(comicBookSeries);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ComicCollection.class.getName()).log(Level.SEVERE, null, ex);
        }

        switchScene("HomePage.fxml", "ImportPage.fxml");
    }

    public static List<ComicBookSeries> getComicBookSeries() {
        return comicBookSeries;
    }

    public static void setComicBookSeries(List<ComicBookSeries> comicBookSeries) {
        ComicCollection.comicBookSeries = comicBookSeries;
    }

    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        ComicCollection.location = location;
    }

    public static String getCharacterName() {
        return characterName;
    }

    public static void setCharacterName(String characterName) {
        ComicCollection.characterName = characterName;
    }
}
