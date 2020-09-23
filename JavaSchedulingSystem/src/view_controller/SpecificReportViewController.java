 
package view_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import utilities.Utils;


public class SpecificReportViewController implements Initializable {

    // FXML variables for view controls
    @FXML private Button backButton;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void backButtonHandler(ActionEvent event) throws IOException {
        Utils.sceneChanger("/AppointmentsView.fxml", event);
    }
    
}
