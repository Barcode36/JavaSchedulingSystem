
package view_controller;

import dao.AddressDao;
import dao.AppointmentDao;
import dao.CustomerDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
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
import models.Address;
import models.Appointment;
import models.CustomerShort;
import models.User;
import utilities.Utils;


public class EditDeleteCustomerViewController implements Initializable {

    // FXML variables for view controls
    @FXML private TextField customerNameField;
    @FXML private TextField addressField;
    @FXML private TextField phoneField;
    @FXML private Button deleteButton;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    
    private int customerId;
    User user;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    
    // Set current user of application
    public void initUser(User user) {
        this.user = user;
    }
    
    // Load initial customer data into edit fields
    public void initCustomer(CustomerShort customer) {
        customerId = customer.getCustomerId();
        customerNameField.setText(customer.getCustomerName());
        addressField.setText(customer.getAddress());
        phoneField.setText(customer.getPhone());
    }
    
    
    
    // Delete customer and change scene to Appointments View
    public void deleteButtonHandler(ActionEvent event) throws IOException, SQLException {
        
        Appointment appointment = AppointmentDao.getAppointmentByCustomerId(customerId);
        if (appointment == null) {
            // Delete customer and change scene to Appointments View
            CustomerDao.deleteCustomer(customerId);
            FXMLLoader loader = new FXMLLoader(getClass()
                                           .getResource("AppointmentsView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        
            AppointmentsViewController controller = loader.getController();
            controller.initUser(user);
            stage.show();
        } else {
            Utils.throwErrorAlert("This customer cannot be deleted because they are scheduled for an appointment.");
        }
        
    }
    
    
    
    // Do nothing and return to Appointments View
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
    
    
    // Edit customer and change scene to Appointments View
    public void saveButtonHandler(ActionEvent event) throws IOException, SQLException {
    
        String customerName = customerNameField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();
        boolean phoneValid = Utils.checkPhoneNumbers(phone);
        
        // If the phone number contains letters, throw error
        if(!phoneValid) {
            Utils.throwErrorAlert("Phone number must not contain letters.");
            FXMLLoader loader = new FXMLLoader(getClass()
                                           .getResource("AddCustomerView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        
            AddCustomerViewController controller = loader.getController();
            controller.initUser(user);
            stage.show();
        } else if(customerName.isEmpty()) {         // if customer name field is blank, throw error
            Utils.throwErrorAlert("Customer Name field must not be blank.");
            FXMLLoader loader = new FXMLLoader(getClass()
                                           .getResource("AddCustomerView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        
            AddCustomerViewController controller = loader.getController();
            controller.initUser(user);
            stage.show();
        } else if(address.isEmpty()) {              // if address field is blank, throw error
            Utils.throwErrorAlert("Address field must not be blank.");
            FXMLLoader loader = new FXMLLoader(getClass()
                                           .getResource("AddCustomerView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        
            AddCustomerViewController controller = loader.getController();
            controller.initUser(user);
            stage.show();
        } else {                                    // if all fields are valid, add the new customer
            
            // If address does not exist, create it first
            Address dBAddress = AddressDao.getAddress(address);
            if(dBAddress == null) {
                Timestamp timestamp = Timestamp.valueOf(LocalDate.now().atStartOfDay());
                AddressDao.createAddress(address, "", 1, "", phone, timestamp, "admin", timestamp, "admin");
            }
        
            int addressId = AddressDao.getAddress(address).getAddressId();
        
            // If the phone number for the current address is
            // different from the value in the dB, update it
            String addressPhone = AddressDao.getAddress(address).getPhone();
            if (phone == null ? addressPhone != null : !phone.equals(addressPhone)) {
                AddressDao.updatePhone(addressId, phone);
            }
        
        
            // Update customer
            CustomerDao.updateCustomer(customerId, customerName, addressId);
        
            // Change scene to Appointments View
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
}
