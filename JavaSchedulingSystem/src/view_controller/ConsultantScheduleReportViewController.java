
package view_controller;

import dao.UserDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.ConsultantSchedule;
import models.User;


public class ConsultantScheduleReportViewController implements Initializable {

    // FXML variables for view controls
    @FXML private Button backButton;
    @FXML private TextArea textBlock;
    User user;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Print schedule for all consultants
        try {
            ObservableList<ConsultantSchedule> consultantSchedules = UserDao.getAllConsultantSchedules();
            for(ConsultantSchedule cs : consultantSchedules) {
                textBlock.appendText("--------------------------------------------\n");
                textBlock.appendText("User: " + cs.getUserName() + "\n");
                textBlock.appendText("Appointment Type: " + cs.getType() + "\n");
                textBlock.appendText("Customer Name: " + cs.getCustomerName() + "\n");
                textBlock.appendText("Appointment Start Time: " + cs.getStart() + "\n");
                textBlock.appendText("--------------------------------------------\n\n\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultantScheduleReportViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Set current user of application
    public void initUser(User user) {
        this.user = user;
    }    
    

    // Handle clicks on back button
    public void backButtonHandler(ActionEvent event) throws IOException {
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
