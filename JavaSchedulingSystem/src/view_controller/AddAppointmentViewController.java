
package view_controller;

import dao.CustomerDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import models.CustomerShort;
import utilities.Utils;


public class AddAppointmentViewController implements Initializable {

    // FXML variables for view controls
    @FXML private ChoiceBox apptTypeChoice;
    @FXML private DatePicker dateField;
    @FXML private ComboBox timeField;
    @FXML private ChoiceBox ampmField;
    @FXML private ComboBox customerChoice;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Add types of appointments to appointment type choicebox
        ObservableList<String> availableChoices = FXCollections.observableArrayList("Concert", "Gig", 
                                                                                    "Practice", "Festival",
                                                                                    "Tour stop"); 
        apptTypeChoice.setItems(availableChoices);
        apptTypeChoice.setValue("Concert");
        
        // Fetch all customers, put their names in an array and add them to customer choicebox
        ObservableList<String> customerNames = FXCollections.observableArrayList();
        try {
            ObservableList<CustomerShort> customers = CustomerDao.getAllCustomers();
            
            for(CustomerShort cs : customers) {
                customerNames.add(cs.getCustomerName());
            }
            customerChoice.setItems(customerNames);
            
        } catch (SQLException ex) {
            Logger.getLogger(AddAppointmentViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Set options for appointment time slots
        ObservableList<String> times = FXCollections.observableArrayList(
                "12:00", "12:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", 
                "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30", "8:00", "8:30",
                "9:00", "9:30", "10:00", "10:30", "11:00", "11:30");
        timeField.setItems(times);
        
        // Set options for am/pm choicebox
        ObservableList<String> ampm = FXCollections.observableArrayList("am", "pm");
        ampmField.setItems(ampm);
        
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
