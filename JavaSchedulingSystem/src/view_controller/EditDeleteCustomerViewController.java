
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Address;
import models.Appointment;
import models.CustomerShort;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
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
            Utils.sceneChanger("view_controller/AppointmentsView.fxml", event);
        } else {
            Utils.throwErrorAlert("This customer cannot be deleted because they are scheduled for an appointment.");
        }
        
    }
    
    
    
    // Do nothing and return to Appointments View
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        // Change scene to Appointments View
        Utils.sceneChanger("view_controller/AppointmentsView.fxml", event);
    }
    
    
    // Edit customer and change scene to Appointments View
    public void saveButtonHandler(ActionEvent event) throws IOException, SQLException {
    
        String customerName = customerNameField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();
        
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
        Utils.sceneChanger("view_controller/AppointmentsView.fxml", event);
        
    }
   
}
