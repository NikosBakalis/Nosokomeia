package ui.clinic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class InitialClinicScreen {
    public Button logoutButton;
    public Button pendingAdmissionTicketsButton;
    public Button postButton;
    public Label numberOfPendingTicketLabel;
    public Label postNumLabel;
    public Button clinicInfoButton;
    public Button clinicChangeButton;
    public Label iasoLabel;
    ;

// <Label alignment="CENTER" contentDisplay="CENTER" layoutX="419.0" layoutY="619.0" prefHeight="21.0" prefWidth="163.0" style="-fx-background-color:
//    rgba(0,0,0,0.75); -fx-text-fill: white; -fx-font-weight: bold;" text="i-aso" />
//        style="-fx-background-color: rgba(255,255,255,0.75);" >
    public void onPendingAdmissionTicketsClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Show pending admission tickets");
        openScene("pending_admission_ticket_screen.fxml");
        closeButtonAction();
    }

    public void onLogoutClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Clinic agent logout");
        openScene("../login.fxml");
        closeButtonAction();
    }

    public void onClinicInfoClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Show clinic info");
    }

    public void onClinicChangeClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Change clinic");
    }

    public void onPostClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Show posts list screen");
        openScene("post_list_screen.fxml");
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
