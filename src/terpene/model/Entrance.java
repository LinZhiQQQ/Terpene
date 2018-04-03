package terpene.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import terpene.view.Painting;


public class Entrance extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene;
        Painting painting = new Painting();
        scene = new Scene(painting,400,300);
        primaryStage.setTitle("Terpene");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
