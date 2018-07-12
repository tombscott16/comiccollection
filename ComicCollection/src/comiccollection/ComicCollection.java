package comiccollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComicCollection extends Application {

    public static String location;
    public ComicBookSeries[] comicBookSeries = new ComicBookSeries[18];

    @Override
    public void start(Stage stage) throws Exception {
        getComicSeries();

        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void switchScene(String nextFxmlFile, String previousFxmlFile) throws IOException {
        setLocation(previousFxmlFile);

        Parent root = FXMLLoader.load(getClass().getResource(nextFxmlFile));

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    public void previousScene() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(location));

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        if ("Marvel_Comics.fxml".equals(location) || "DC_Comics.fxl".equals(location)) {
            setLocation("HomePage.fxml");
        }
    }

    public void getComicSeries() throws IOException {

        File excelFile = new File("C:\\Users\\ypf5bbh\\Documents\\Comic Collection\\comiccollection\\ComicCollection\\src\\comiccollection\\ComicSeries.csv");

        FileReader reader;
        try {
            reader = new FileReader(excelFile);
            BufferedReader buffReader = new BufferedReader(reader);

            String line;
            int i = 0;

            while ((line = buffReader.readLine()) != null) {
                if (i == 0) {
                } else {
                    comicBookSeries[i] = new ComicBookSeries(line.split(",")[0], line.split(",")[1]);
                }
                i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ComicCollection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        ComicCollection.location = location;
    }
}
