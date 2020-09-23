
package utilities;

// Utility methods common to lots of views

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
}
