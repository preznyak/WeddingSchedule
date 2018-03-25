package hu.preznyak.weddingschedule.controller;

import hu.preznyak.weddingschedule.dao.WeddingDAO;
import hu.preznyak.weddingschedule.entity.Contract;
import hu.preznyak.weddingschedule.entity.Wedding;
import hu.preznyak.weddingschedule.service.WeddingService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class RegisterDialogController {

    @FXML
    private TextField bridesNameField;

    @FXML
    private TextField groomsNameField;

    @FXML
    private TextField localeField;

    @FXML
    private TextField bandField;

    @FXML
    private TextField fotovideoField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField depositField;

    @FXML
    private DatePicker datePicker;

    public Wedding createWedding(){
        String bridesName = bridesNameField.getText().trim();
        String groomsName = groomsNameField.getText().trim();
        String locale = localeField.getText().trim();
        String band = bandField.getText();
        String fotovideo = fotovideoField.getText();
        LocalDate date = datePicker.getValue();
        Double price = Double.valueOf(priceField.getText());
        Double deposit = Double.valueOf(depositField.getText());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WeddingSchedulePU");
        EntityManager entityManager = emf.createEntityManager();
        WeddingService weddingService = new WeddingService(new WeddingDAO(entityManager));

        Wedding newWedding = new Wedding(bridesName,groomsName,date,locale,band,fotovideo,new Contract(price,deposit));
        weddingService.createWedding(newWedding);
        entityManager.close();
        emf.close();
        return newWedding;
    }
}
