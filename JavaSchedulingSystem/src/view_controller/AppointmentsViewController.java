
package view_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


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
    
    public void sceneChangeHandler(ActionEvent event, String view) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(view));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    //**** Appointment View methods ****//

    // Change scene to Add Appt View
    public void addApptButtonHandler(ActionEvent event) throws IOException {
        sceneChangeHandler(event, "AddAppointmentView.fxml");
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
        sceneChangeHandler(event, "AddCustomerView.fxml");
    }
    
    
    //**** Report View methods ****//
    // TODO - each of these methods should open the same view 
    // but display different reports in that view
    public void apptTypesByMonthReportButtonHandler(ActionEvent event) throws IOException {
        sceneChangeHandler(event, "SpecificReportView.fxml");
    }
    
    public void consultantScheduleReportButtonHandler(ActionEvent event) throws IOException {
        sceneChangeHandler(event, "SpecificReportView.fxml");
    }
    
    public void oneOtherReportButtonHandler(ActionEvent event) throws IOException {
        sceneChangeHandler(event, "SpecificReportView.fxml");
    }
    
    public void loginReportButtonHandler(ActionEvent event) throws IOException {
        sceneChangeHandler(event, "SpecificReportView.fxml");
    }
    
    
}
