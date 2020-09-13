
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


public class AddCustomerViewController implements Initializable {

    // FXML variables for view controls
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField addressField;
    @FXML private TextField phoneField;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void sceneChangeHandler(ActionEvent event, String view) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(view));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    // Do nothing and return to Customer View
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        sceneChangeHandler(event, "AppointmentsView.fxml");
    }
    
    public void saveButtonHandler(ActionEvent event) throws IOException {
        // TODO - go to dB and create new customer
        
        sceneChangeHandler(event, "AppointmentsView.fxml");
        
        
    }
    
}
