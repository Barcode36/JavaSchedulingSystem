
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
import javafx.stage.Stage;


public class AppointmentsViewController implements Initializable {

    @FXML private Button addApptButton;
    @FXML private RadioButton viewWeekRadio;
    @FXML private RadioButton viewMonthRadio;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    // Change scene to Add Appt View
    public void addApptButtonHandler(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AddAppointmentView.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
