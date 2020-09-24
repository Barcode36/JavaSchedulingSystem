
package view_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import utilities.Utils;


public class AddAppointmentViewController implements Initializable {

    // FXML variables for view controls
    @FXML private ChoiceBox apptTypeChoice;
    @FXML private TextField dateField;
    @FXML private TextField timeField;
    @FXML private ChoiceBox customerChoice;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void saveButtonHandler(ActionEvent event) throws IOException {
    
        // TODO: Go to dB and create a new appointment
        
        
        // Change back to Appointments View
        Utils.sceneChanger("view_controller/AppointmentsView.fxml", event);
        
    }
    
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("view_controller/AppointmentsView.fxml", event);
    }
    
}
