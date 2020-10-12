
package view_controller;

import dao.AppointmentDao;
import dao.CustomerDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
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
            
            //********* Using lambda expression here rather than for loop 
            //********* for conciseness and easier comprehension
            customers.forEach((cs) -> {
                customerNames.add(cs.getCustomerName());
            });
            customerChoice.setItems(customerNames);
            customerChoice.setValue(customerNames.get(0));
        } catch (SQLException ex) {
            Logger.getLogger(AddAppointmentViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dateField.setEditable(false);
        dateField.setValue(LocalDate.now());
        
        // Set options for appointment start times
        ObservableList<String> startTimes = FXCollections.observableArrayList(
                "08:00", "09:00", "10:00", "11:00", "12:00", "13:00",
                "14:00", "15:00", "16:00");
        startTimeChoice.setItems(startTimes);
        startTimeChoice.setValue("08:00");
        
        // Set options for appointment end times
        ObservableList<String> endTimes = FXCollections.observableArrayList(
                "09:00", "10:00", "11:00", "12:00", "13:00",
                "14:00", "15:00", "16:00", "17:00");
        endTimeChoice.setItems(endTimes);
        endTimeChoice.setValue("09:00");   
    }    
    
    
    // Set current user of application
    public void initUser(User user) {
        this.user = user;
    }
    
    // Handle clicks on save button
    public void saveButtonHandler(ActionEvent event) throws IOException, SQLException, InterruptedException {
        
        // Get customerId of chosen customer
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
        
        // Checking to make sure times are within normal business hours
        LocalTime tooEarly = LocalTime.parse("07:00");
        LocalTime tooLate = LocalTime.parse("18:00");
        LocalTime lst = LocalTime.parse(startTimeString);
        LocalTime let = LocalTime.parse(endTimeString);
        
        //********* Assert that the user cannot choose a time outside of business hours else throw error
        assert lst.isAfter(tooEarly) : "Start time is too early.";
        assert let.isBefore(tooLate) : "End time is too late.";
        
        // Get appointment type
        String apptType = apptTypeChoice.getValue().toString();

        // Get current timestamp
        Timestamp timestamp = Timestamp.valueOf(LocalDate.now().atStartOfDay());
        
        // Make sure the appointment form is valid
        if (Utils.checkForValidTimes(startTimeString, endTimeString)) {
            Utils.throwErrorAlert("Your end time cannot be scheduled prior to your start time.");
        } else if(Utils.areOverlappingAppts(userId, startTime)) {
            Utils.throwErrorAlert("There is already an appointment at that time.");
        } else {
            // Wait just long enough for customer dB call above to finish
            Thread.sleep(100);
        
            // Add new Appointment to database
            AppointmentDao.createAppointment(customerId, userId, "", "", "", "", apptType, "", Utils.toUTC(startTime), 
                                             Utils.toUTC(endTime), timestamp, this.user.getUserName(), timestamp, 
                                             this.user.getUserName());
        
            // Change back to Appointments View
            FXMLLoader loader = new FXMLLoader(getClass()
                                           .getResource("AppointmentsView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        
            AppointmentsViewController controller = loader.getController();
            controller.initUser(user);
            stage.show();
        }   
    }
    
    // Handle cancel button clicks
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                                           .getResource("AppointmentsView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        
        AppointmentsViewController controller = loader.getController();
        controller.initUser(user);
        stage.show();
    }
    

    // Check to make sure user isn't trying to schedule an appointment in the past
    public void checkForValidDate() {
        // ********* This commented out section below is before the lambda expression
        // ********* I've converted to a lambda expression here because:
        // ********* A: The lambda expression is less verbose
        // ********* B: The lambda expression is easier to comprehend
        // ********* C: I have no need to pass the inner method around my code base by name
        // Add event listener that detects when date picker field loses focus
        //    dateField.focusedProperty().addListener(new ChangeListener<Boolean>() {
        //        @Override
        //        public void changed(ObservableValue<? extends Boolean> observable, Boolean unfocused, Boolean focused) {
        //            if(unfocused) {
        //                LocalDate today = LocalDate.now();
        //                LocalDate selectedDate = dateField.getValue();
        //            
        //                // If the user tries to create an appointment before today's date
        //                if(selectedDate.isBefore(today)) {
        //                    Utils.throwErrorAlert("You cannot schedule an appointment in the past.");
        //                }
        //            } 
        //        }
        //    });
        
        dateField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean unfocused, Boolean focused) -> {
            if(unfocused) {
                LocalDate today = LocalDate.now();
                LocalDate selectedDate = dateField.getValue();
                
                // If the user tries to create an appointment before today's date
                if(selectedDate.isBefore(today)) {
                    Utils.throwErrorAlert("You cannot schedule an appointment in the past.");
                } 
            }
        });
    } 
}

