
package view_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import utilities.Utils;


public class AppointmentsViewController implements Initializable {

    // FXML variables for Appointment View controls
    @FXML private Button addApptButton;
    @FXML private RadioButton viewAllRadio;
    @FXML private RadioButton viewWeekRadio;
    @FXML private RadioButton viewMonthRadio;
    @FXML private TableView apptsTable;
        
    // FXML variables for Customer View controls
    @FXML private Button newCustomerButton;
    @FXML private TableView customerTable;
 
    // FXML variables for Reports View controls
    @FXML private Button apptTypesReportButton;
    @FXML private Button consultantScheduleReportButton;
    @FXML private Button oneOtherReportButton;
    @FXML private Button loginReportButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    //**** Appointment View methods ****//

    // Change scene to Add Appt View
    public void addApptButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("/AddAppointmentView.fxml", event);
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
        Utils.sceneChanger("/AddCustomerView.fxml", event);
    }
    
    
    //**** Report View methods ****//
    // TODO - each of these methods should open the same view 
    // but display different reports in that view
    public void apptTypesByMonthReportButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("/SpecificReportView.fxml", event);
    }
    
    public void consultantScheduleReportButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("/SpecificReportView.fxml", event);
    }
    
    public void oneOtherReportButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("/SpecificReportView.fxml", event);
    }
    
    public void loginReportButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("/SpecificReportView.fxml", event);
    }
    
    
}
