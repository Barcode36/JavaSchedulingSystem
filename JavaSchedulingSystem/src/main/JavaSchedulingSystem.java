
package main;

import dao.DBConnection;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaSchedulingSystem extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view_controller/LoginView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    
    public static void main(String[] args) {
        // Establish connection to database
        DBConnection.startConnection();
        
        // Launch Java application
        launch(args);
        
        // Close connection to database
        DBConnection.closeConnection();
    }
    
}
