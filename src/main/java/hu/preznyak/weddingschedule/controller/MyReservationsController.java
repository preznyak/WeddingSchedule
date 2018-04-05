package hu.preznyak.weddingschedule.controller;

import hu.preznyak.weddingschedule.dao.WeddingDAO;
import hu.preznyak.weddingschedule.entity.Contract;
import hu.preznyak.weddingschedule.entity.Wedding;
import hu.preznyak.weddingschedule.service.WeddingService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;

public class MyReservationsController {

    @FXML
    private TableView<Wedding> myReservations;

    @FXML
    private TableColumn<Wedding, String> brideName;

    @FXML
    private TableColumn<Wedding, String> groomName;

    @FXML
    private TableColumn<Wedding, String> locale;

    @FXML
    private TableColumn<Wedding, String> bandName;

    @FXML
    private TableColumn<Wedding, String> fotoVideo;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Wedding, LocalDate> date;

    @FXML
    private TableColumn<Wedding, Contract> contract;

    @FXML
    private BorderPane reservationsBorderPane;

    @FXML
    public void initialize(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WeddingSchedulePU");
        EntityManager em = emf.createEntityManager();
        WeddingService weddingService = new WeddingService(new WeddingDAO(em));

        myReservations.getItems().addAll(weddingService.getAll());

        brideName.setCellValueFactory(new PropertyValueFactory<>("brideName"));
        groomName.setCellValueFactory(new PropertyValueFactory<>("groomName"));
        locale.setCellValueFactory(new PropertyValueFactory<>("locale"));
        bandName.setCellValueFactory(new PropertyValueFactory<>("bandName"));
        fotoVideo.setCellValueFactory(new PropertyValueFactory<>("fotoVideo"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        contract.setCellValueFactory(new PropertyValueFactory<>("contract"));

        em.close();
        emf.close();
    }

    public void onBackButtonClicked(){
        Pane pane;
        Stage stage = new Stage();
        stage.initOwner(reservationsBorderPane.getScene().getWindow());

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/Welcome.fxml"));
        try {
            pane = fxmlLoader.load();
            reservationsBorderPane.getChildren().setAll(pane);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Couldn't load pane.");
            return;
        }
    }
}
