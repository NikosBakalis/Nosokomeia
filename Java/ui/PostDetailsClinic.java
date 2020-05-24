package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PostDetailsClinic {
    public Button returnButton;

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        openScene("post_clinic.fxml");
        //closeButtonAction();
    }
  //  public void onLogoutClick(ActionEvent actionEvent) throws IOException {
    //    openScene("login.fxml");
      //  closeButtonAction();
   // }

    private void openScene(String fxmlFile) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("I-aso");
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}