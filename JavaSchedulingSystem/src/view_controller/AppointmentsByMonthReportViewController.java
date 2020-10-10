
package view_controller;

import dao.AppointmentDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
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
import models.AppointmentShort;
import models.User;
import models.AppointmentMonth;
import utilities.Utils;


public class AppointmentsByMonthReportViewController implements Initializable {
    User user;
    @FXML private Button backButton;
    @FXML private TextArea textArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textArea.setEditable(false);
        
        try {
            ObservableList<AppointmentMonth> appointments = AppointmentDao.getAllAppointmentsByMonth();
            for(AppointmentMonth am : appointments) {
                         
                String year = String.valueOf(am.getYear());
                String month = String.valueOf(am.getMonth());
                String type = am.getType();
                String count = String.valueOf(am.getTypeCount());
                
                textArea.appendText("--------------------\n");
                textArea.appendText(month + "/" + year + "\n");
                textArea.appendText(type +"s: " + count + "\n");
                textArea.appendText("--------------------\n\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentsByMonthReportViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
    
    // Set current user of application
    public void initUser(User user) {
        this.user = user;
    }
    
    
    
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
