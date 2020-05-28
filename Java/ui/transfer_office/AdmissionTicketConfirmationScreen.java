package ui.transfer_office;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.AdmissionTicketConfirmationScreenListItem;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdmissionTicketConfirmationScreen implements Initializable {
    public Button logoutButton;
    public Button returnButton;
    public TableView<AdmissionTicketConfirmationScreenListItem> admissionTicketList;
    public TableColumn<AdmissionTicketConfirmationScreenListItem, String> colAmka;
    public TableColumn<AdmissionTicketConfirmationScreenListItem, String> colFirstName;
    public TableColumn<AdmissionTicketConfirmationScreenListItem, String> colLastName;
    public TableColumn<AdmissionTicketConfirmationScreenListItem, String> colSourceClinic;
    public TableColumn<AdmissionTicketConfirmationScreenListItem, String> colDestinationClinic;
    public TableColumn<AdmissionTicketConfirmationScreenListItem, String> colStage;
    public TableColumn<AdmissionTicketConfirmationScreenListItem, String> colId;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colAmka.setCellValueFactory(new PropertyValueFactory<>("amka"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colSourceClinic.setCellValueFactory(new PropertyValueFactory<>("sourceClinic"));
        colDestinationClinic.setCellValueFactory(new PropertyValueFactory<>("destinationClinic"));
        colStage.setCellValueFactory(new PropertyValueFactory<>("stage"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        admissionTicketList.setItems(iCRUDImpl.getAdmissionTicketConfirmationScreenListItem(user.getHospital_afm()));
    }

    // note that onAdmissionTicketClik listener is missing

    public void onLogoutClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Transfer office agent logout");
        openScene("../login.fxml");
        closeButtonAction();
    }
    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to initial transfer office screen");
        openScene("initial_transfer_office_screen.fxml");
        closeButtonAction();
    }

    private void openScene(String fxmlFile) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("I-aso");
        scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void closeButtonAction(){
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }
}
