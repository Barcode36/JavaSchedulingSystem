
package view_controller;

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
import utilities.Utils;


public class AddCustomerViewController implements Initializable {

    // FXML variables for view controls
    @FXML private TextField customerNameField;
    @FXML private TextField addressField;
    @FXML private TextField phoneField;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    // Do nothing and return to Customer View
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("view_controller/AppointmentsView.fxml", event);
    }
    
    public void saveButtonHandler(ActionEvent event) throws IOException, SQLException {
        
        // TODO - go to dB and create new customer
        String customerName = customerNameField.getText();
        
        // TODO - look up proper address
        String address = addressField.getText();
        String phone = phoneField.getText();
        int addressId = 1;
        int active = 1;
        Timestamp timestamp = Timestamp.valueOf(LocalDate.now().atStartOfDay());
        
        // TODO - look up current userId and fetch the approriate strings here
        String createdBy = "admin";
        String lastUpdateBy = "admin";

        
        CustomerDao.createCustomer(customerName, addressId, active, timestamp, createdBy, timestamp, lastUpdateBy); 
        Utils.sceneChanger("view_controller/AppointmentsView.fxml", event);
        
    }
    
}
