package comiccollection;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComicCollection extends Application {

    public static String location;

    @Override
    public void start(Stage stage) throws Exception {
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

    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        ComicCollection.location = location;
    }
}
