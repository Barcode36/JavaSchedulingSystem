
package view_controller;

import dao.AppointmentDao;
import dao.CustomerDao;
import models.AppointmentShort;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
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


public class EditDeleteAppointmentsViewController implements Initializable {

    // FXML variables for view controls
    @FXML private ChoiceBox apptTypeChoiceBox;
    @FXML private DatePicker dateField;
    @FXML private ComboBox startTimeChoice;
    @FXML private ComboBox endTimeChoice;
    @FXML private ChoiceBox customerChoiceBox;
    @FXML private Button deleteButton;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    
    private int appointmentId;
    User user;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Set up options for appointment type
        ObservableList<String> appointmentTypes = FXCollections.observableArrayList(
                                                 "Concert", "Gig", "Practice", "Festival", "Tour stop");
        apptTypeChoiceBox.setItems(appointmentTypes);
        
        // Fetch all customers, put their names in an array and add them to customer choicebox
        ObservableList<String> customerNames = FXCollections.observableArrayList();
        try {
            ObservableList<CustomerShort> customers = CustomerDao.getAllCustomers();
            
            for(CustomerShort cs : customers) {
                customerNames.add(cs.getCustomerName());
            }
            customerChoiceBox.setItems(customerNames);
            
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
    
    // Load initial customer data into edit fields
    public void initAppointment(AppointmentShort appointment) {
        appointmentId = appointment.getAppointmentId();
        apptTypeChoiceBox.setValue(appointment.getAppointmentType());
        customerChoiceBox.setValue(appointment.getCustomerName());
        
        // Get start and end timestamps and parse them out
        String startTime = appointment.getAppointmentStart().toString();
        Timestamp endTime = appointment.getAppointmentEnd();
        
        String datePart = startTime.substring(0, 10);
        LocalDate date = LocalDate.parse(datePart);
        dateField.setValue(date);
        
        String startTimePart = startTime.substring(11, 16);
        startTimeChoice.setValue(startTimePart);
        startTimeChoice.setValue(startTimePart);
        
        String endTimePart = endTime.toString().substring(11, 16);
        endTimeChoice.setValue(endTimePart);
        endTimeChoice.setValue(endTimePart);
        
    }
    
    // Delete appointment and return to Appointments View
    public void deleteButtonHandler(ActionEvent event) throws IOException, SQLException {
        AppointmentDao.deleteAppointment(this.appointmentId);
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

    // Do nothing in dB and return to Appointments View
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
    
    // Update appointment and return to Appointment View
    public void saveButtonHandler(ActionEvent event) throws IOException, SQLException {
        String appointmentType = apptTypeChoiceBox.getValue().toString();
        int customerId = CustomerDao.getCustomer(customerChoiceBox.getValue().toString()).getCustomerId();
        
        // Get start and end times
        LocalDate startDate = dateField.getValue();
        String startDateString = startDate.toString();
        String startTimeString = startTimeChoice.getValue().toString();
        String endTimeString = endTimeChoice.getValue().toString();
        Timestamp startTime = Timestamp.valueOf(startDateString + " " + startTimeString + ":00");        
        Timestamp endTime = Timestamp.valueOf(startDateString + " " + endTimeString + ":00"); 
         
        // First, check to make sure start and end times are valid
        if (Utils.checkForValidTimes(startTimeString, endTimeString)) {
            Utils.throwErrorAlert("Your end time cannot be scheduled prior to your start time.");
        } else {
            AppointmentDao.updateAppointment(this.appointmentId, appointmentType, Utils.toUTC(startTime), 
                                             Utils.toUTC(endTime), customerId);
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
    
    
    // Check to make sure user isn't trying to schedule an appointment in the past
    public void checkForValidDate() {
        // Add event listener that detects when date picker field loses focus
        dateField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean unfocused, Boolean focused) {
                if(unfocused) {
                    LocalDate today = LocalDate.now();
                    LocalDate selectedDate = dateField.getValue();
                    
                    // If the user tries to create an appointment before today's date
                    if(selectedDate.isBefore(today)) {
                        Utils.throwErrorAlert("You cannot schedule an appointment in the past.");
                    }
                } 
            }
        });
    }
    
    
}
