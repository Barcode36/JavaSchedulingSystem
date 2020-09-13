
package view_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginViewController implements Initializable {

    // FXML variables for view controls
    @FXML private Button exitButton;
    @FXML private Button submitButton;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Do I need to do anything upon initialize?
    }    
    
    
    public void loginSubmitButtonHandler(ActionEvent event) throws IOException {
        // Eventually this will actually go to the database
        // and authorize/authenticate user
        
        // TEMPORARY - change scene to Appointments View to bypass login functionality
            Parent parent = FXMLLoader.load(getClass().getResource("AppointmentsView.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        
    }
    
    
    public void loginExitButtonHandler(ActionEvent event) {
        // TODO
        // Implement loginExitButtonHandler
    }
    
    
    
}
