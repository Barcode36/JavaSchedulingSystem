
package javaschedulingsystem;

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

    @FXML private Button addApptButton;
    @FXML private RadioButton viewWeekRadio;
    @FXML private RadioButton viewMonthRadio;
    @FXML private TableView apptsTable;
    @FXML private Button newCustomerButton;
    @FXML private TableView customerTable;
 
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
    
    // Change scene to Add Appt View
    public void addApptButtonHandler(ActionEvent event) throws IOException {
        sceneChangeHandler(event, "AddAppointmentView.fxml");
    }
    
    // Change scene to Add Customer View
    public void addCustomerButtonHandler(ActionEvent event) throws IOException {
        sceneChangeHandler(event, "AddCustomerView.fxml");
    }
    
}
