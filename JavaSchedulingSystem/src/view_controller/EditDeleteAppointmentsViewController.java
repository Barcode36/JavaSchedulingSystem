
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


public class EditDeleteAppointmentsViewController implements Initializable {

    // FXML variables for view controls
    @FXML private ChoiceBox apptTypeChoiceBox;
    @FXML private TextField dateField;
    @FXML private TextField timeField;
    @FXML private ChoiceBox customerChoiceBox;
    @FXML private Button deleteButton;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void deleteButtonHandler(ActionEvent event) throws IOException {
        // TODO - go to dB and delete appt
        
        // Return to Appointments View
        Utils.sceneChanger("/AppointmentsView.fxml", event);
    }

    // Do nothing in dB and return to Appointments View
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("/AppointmentsView.fxml", event);
    }
    
    public void saveButtonHandler(ActionEvent event) throws IOException {
        // TODO - go to dB and edit appt
        
        // Return to Appointments View
        Utils.sceneChanger("/AppointmentsView.fxml", event);
    }
    
}
