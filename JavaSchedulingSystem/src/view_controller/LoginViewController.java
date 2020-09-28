
package view_controller;

import dao.UserDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.User;
import utilities.Utils;


public class LoginViewController implements Initializable {

    // FXML variables for view controls
    @FXML private Button exitButton;
    @FXML private Button submitButton;
    @FXML private Label titleLabel;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    private String language;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Get user geolocation
        Locale currentLocale = Locale.getDefault();
        this.language = currentLocale.getDisplayLanguage();
        
        // If user's language is Korean, change language on login screen
        if (this.language.equals("한국어")) {
            titleLabel.setText("윤년");
            usernameField.setPromptText("사용자 이름");
            passwordField.setPromptText("암호");
            exitButton.setText("출구");
            submitButton.setText("제출");
        }
    }    
    
    
    public void loginSubmitButtonHandler(ActionEvent event) throws IOException, SQLException {
        // Query dB for user entered into username field
        User user = UserDao.getUser(usernameField.getText());
        
        // If no such user, throw error alert
        if(user == null) {
            if (this.language.equals("한국어")) {
                Utils.throwErrorAlert("사용자 이름 또는 비밀번호가 유효하지 않습니다.", "Korean");
            } else {
                Utils.throwErrorAlert("Your username or password is invalid.");
            }
            
        } else {
            // Get that user's real password
            String officialPassword = user.getUserPassword();
        
            // Get what they entered into the password field
            String enteredPass = passwordField.getText();
        
            try {
                // If entered password, matches password from dB, change scene to Appointments View
                if (enteredPass == null ? officialPassword == null : enteredPass.equals(officialPassword)) {
                    Utils.sceneChanger("view_controller/AppointmentsView.fxml", event);
                } else {
                    // If password does not match, throw error alert
                    if (this.language.equals("한국어")) {
                        Utils.throwErrorAlert("사용자 이름 또는 비밀번호가 유효하지 않습니다.");
                    } else {
                        Utils.throwErrorAlert("Your username or password is invalid.");
                    }
                    
                } 
            } catch(IOException e) {
                System.out.println(e.getMessage());      
            }
        }      
    }
    
    // Close application
    public void loginExitButtonHandler(ActionEvent event) throws SQLException {
        if(this.language.equals("한국어")) {
            Utils.exitApplication("Korean");
        } else {
            Utils.exitApplication();
        }
    }
    
    
    
}
