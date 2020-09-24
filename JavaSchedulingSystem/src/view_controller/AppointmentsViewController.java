
package view_controller;

import dao.AppointmentDao;
import dao.CustomerDao;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Appointment;
import models.Customer;
import utilities.Utils;


public class AppointmentsViewController implements Initializable {

    // FXML variables for Appointment View controls
    @FXML private Button addApptButton;
    @FXML private Button editApptButton;
    @FXML private RadioButton viewAllRadio;
    @FXML private RadioButton viewWeekRadio;
    @FXML private RadioButton viewMonthRadio;
    @FXML private TableView appointmentsTable;
    @FXML private TableColumn<Appointment, String> appointmentDateColumn;
    @FXML private TableColumn<Appointment, String> appointmentTypeColumn;
    @FXML private TableColumn<Appointment, Integer> appointmentCustomerColumn;
        
    // FXML variables for Customer View controls
    @FXML private Button newCustomerButton;
    @FXML private Button editCustomerButton;
    @FXML private TableView<Customer> customerTable;
    @FXML private TableColumn<Customer, String> customerNameColumn;
    @FXML private TableColumn<Customer, Integer> customerAddressColumn;
    @FXML private TableColumn<Customer, String> customerPhoneColumn;
 
    // FXML variables for Reports View controls
    @FXML private Button apptTypesReportButton;
    @FXML private Button consultantScheduleReportButton;
    @FXML private Button oneOtherReportButton;
    @FXML private Button loginReportButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
       //****** Appointments Table ******
       
       // Bind appointment table columns
       appointmentCustomerColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
       appointmentTypeColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
       appointmentDateColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentStart"));
       
        
        try {
            // Populate appointments table view
            ObservableList<Appointment> appointments = AppointmentDao.getAllAppointments();
            appointmentsTable.setItems(appointments);
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentsViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
       
        
       //****** Customer Table ******
       
       // Bind customer table columns
       customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
       customerAddressColumn.setCellValueFactory(new PropertyValueFactory<>("customerAddressId"));
       customerPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("customerCreatedBy"));
       
       // Populate customer table view
        try {
            ObservableList<Customer> customers = CustomerDao.getAllCustomers();
            customerTable.setItems(customers);
        }
         catch (SQLException ex) {
            Logger.getLogger(AppointmentsViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }   
    
    
    //**** Appointment View methods ****//

    // Change scene to Add Appt View
    public void addApptButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("view_controller/AddAppointmentView.fxml", event);
    }
    
    public void editApptButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("view_controller/EditDeleteAppointmentsView.fxml", event);
    }
    
    public void viewAllHandler(ActionEvent event) {
        // TODO - view all appts functionality
    }
    
    public void viewByWeekHandler(ActionEvent event) {
        // TODO - view appts by week functionality
    }
    
    public void viewByMonthHandler(ActionEvent event) {
        // TODO - view appts by month functionality
    }
    
    
    //**** Customer View methods ****//
    
    // Change scene to Add Customer View
    public void addCustomerButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("view_controller/AddCustomerView.fxml", event);
    }
    
    public void editCustomerButtonHandler(ActionEvent event) throws IOException {
        Customer customer = customerTable.getSelectionModel().getSelectedItem();
        Utils.sceneChanger("view_controller/EditDeleteCustomerView.fxml", event);
    }
    
    
    //**** Report View methods ****//
    // TODO - each of these methods should open the same view 
    // but display different reports in that view
    public void apptTypesByMonthReportButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("view_controller/SpecificReportView.fxml", event);
    }
    
    public void consultantScheduleReportButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("view_controller/SpecificReportView.fxml", event);
    }
    
    public void oneOtherReportButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("view_controller/SpecificReportView.fxml", event);
    }
    
    public void loginReportButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("view_controller/SpecificReportView.fxml", event);
    }
    
    
}
