package hu.preznyak.weddingschedule;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class.
 */

public class Main extends Application {
    /**
     * Launch a standalone JavaFX application
     * @param primaryStage The {@link Stage} where the application will show up
     * @throws Exception if exception occured.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Welcome.fxml"));
        primaryStage.setTitle("Wedding Schedule");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Main method for WeddingSchedule application.
     * @param args arguments.
     */
    public static void main(String[] args){
        launch(args);
    }
}
