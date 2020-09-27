
package utilities;

// Utility methods common to lots of views

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Utils {
    
    // Used in controllers to change scenes 
    public static void sceneChanger(String sceneName, ActionEvent event) throws IOException {
            Parent parent = FXMLLoader.load(Utils.class.getClassLoader().getResource(sceneName));
            Scene scene = new Scene(parent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
    }
    
    // Throws confirmation alert
    public static String throwConfirmationAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        return result.get().getText();
    }
    
    // Handles exit button click
    public static void exitApplication() {
        if(throwConfirmationAlert().equals("OK")) {
            System.exit(0);
        } 
    }
    
    // Throws error alert
    public static void throwErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
    
}
