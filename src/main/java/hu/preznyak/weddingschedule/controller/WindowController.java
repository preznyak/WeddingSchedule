package hu.preznyak.weddingschedule.controller;

import hu.preznyak.weddingschedule.entity.Wedding;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class WindowController {

    @FXML
    private Button showButton;

    @FXML
    private Button registerButton;

    @FXML
    private Pane welcomePane;

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

    public void onShowButtonClicked(){
        System.out.println("Hello");
    }

    public void onRegisterButtonClicked(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(welcomePane.getScene().getWindow());
        dialog.setTitle("Register a new wedding!");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/Register.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Couldn't load dialog.");
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.FINISH);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.FINISH) {
            RegisterDialogController controller = fxmlLoader.getController();
            Wedding wedding = controller.createWedding();
            System.out.println(wedding);
        } else {
            System.out.println("Cancel pressed");
        }
    }
}
