
package view_controller;

import dao.AppointmentDao;
import dao.CustomerDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
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
import models.User;
import utilities.Utils;


public class AddAppointmentViewController implements Initializable {

    // FXML variables for view controls
    @FXML private ChoiceBox apptTypeChoice;
    @FXML private DatePicker dateField;
    @FXML private ComboBox startTimeChoice;
    @FXML private ComboBox customerChoice;
    @FXML private ComboBox endTimeChoice;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    
    User user;
    
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
        
        
        // Set options for appointment start times
        ObservableList<String> startTimes = FXCollections.observableArrayList(
                "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", 
                "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00",
                "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00",
                "21:00", "22:00", "23:00", "24:00");
        startTimeChoice.setItems(startTimes);
        
        // Set options for appointment end times
        ObservableList<String> endTimes = FXCollections.observableArrayList(
                "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", 
                "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00",
                "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00",
                "21:00", "22:00", "23:00", "24:00");
        endTimeChoice.setItems(endTimes);
        
    }    
    
    // Set current user of application
    public void initUser(User user) {
        this.user = user;
    }
    
    
    public void saveButtonHandler(ActionEvent event) throws IOException, SQLException, InterruptedException {
    
        // Get customerId of chosen customer
        // TODO - wrap with try catch
        String customerName = customerChoice.getSelectionModel().getSelectedItem().toString();
        int customerId = CustomerDao.getCustomer(customerName).getCustomerId();
        
        // Get userId of current application user
        int userId = this.user.getUserId();
        
        // Get start and end times
        LocalDate startDate = dateField.getValue();
        String startDateString = startDate.toString();
        String startTimeString = startTimeChoice.getValue().toString();
        String endTimeString = endTimeChoice.getValue().toString();
        Timestamp startTime = Timestamp.valueOf(startDateString + " " + startTimeString + ":00");        
        Timestamp endTime = Timestamp.valueOf(startDateString + " " + endTimeString + ":00");        
        
        // Get appointment type
        String apptType = apptTypeChoice.getValue().toString();

        // Get current timestamp
        Timestamp timestamp = Timestamp.valueOf(LocalDate.now().atStartOfDay());
        
        
        // Wait just long enough for customer dB call above to finish
        Thread.sleep(100);
        
        // Add new Appointment to database
        AppointmentDao.createAppointment(customerId, userId, "", "", "", "", apptType, "", startTime, 
                                         endTime, timestamp, this.user.getUserName(), timestamp, 
                                         this.user.getUserName());
        
        // Change back to Appointments View
        Utils.sceneChanger("view_controller/AppointmentsView.fxml", event);
        
    }
    
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("view_controller/AppointmentsView.fxml", event);
    }
    
}
