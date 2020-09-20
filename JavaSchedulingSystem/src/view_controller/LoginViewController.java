
package view_controller;

import dao.CustomerDao;
import dao.UserDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
import models.User;


public class LoginViewController implements Initializable {

    // FXML variables for view controls
    @FXML private Button exitButton;
    @FXML private Button submitButton;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Do I need to do anything upon initialize?
    }    
    
    
    public void loginSubmitButtonHandler(ActionEvent event) throws IOException, SQLException {
        // Query dB for user entered into username field
        User user = UserDao.getUser(usernameField.getText());
        
        // Get that user's real password
        String officialPassword = user.getUserPassword();
        
        // Get what they entered into the password field
        String enteredPass = passwordField.getText();
        
        try {
            // If entered password, matches password from dB, change scene to Appointments View
            if (enteredPass == null ? officialPassword == null : enteredPass.equals(officialPassword)) {
                Parent parent = FXMLLoader.load(getClass().getResource("AppointmentsView.fxml"));
                Scene scene = new Scene(parent);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            } else {
                // TODO - add mismatched password error handling
                System.out.println("Passwords do not match");
            } 
        } catch(IOException e) {
            System.out.println(e.getMessage());      
          }
        
    }
    
    
    public void loginExitButtonHandler(ActionEvent event) throws SQLException {
        // TODO - finish implementing sign in process
        Timestamp timestamp = Timestamp.valueOf(LocalDate.now().atStartOfDay());
        

        
//        CustomerDao.createCustomer(2, "Bob", 1, 1, asdf, "admin", timestamp, "admin"); 
    }
    
    
    
}
