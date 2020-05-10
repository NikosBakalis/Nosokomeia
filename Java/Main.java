import database.ICRUDImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ui/login.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setTitle("I-aso");
        scene.getStylesheets().add(getClass().getResource("ui/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
//        primaryStage.setResizable(false);
        ICRUDImpl iCRUDImpl = new ICRUDImpl();
        iCRUDImpl.openConnection();
    }
}
