package hu.preznyak.weddingschedule.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowController {

    @FXML
    private Button showButton;

    @FXML
    private Button registerButton;

    @FXML
    private Pane windowPane;

    @FXML
    private Label label;

    /*
    @FXML
    public void onShowButtonClicked(){
        Pane pane;
        Stage stage = new Stage();
        stage.initOwner(windowPane.getScene().getWindow());

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/MyReservations.fxml"));

        try {
            pane = fxmlLoader.load();
            windowPane.getChildren().setAll(pane);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    */
}
