 
package view_controller;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import models.User;


public class LoginReportViewController implements Initializable {

    // FXML variables for view controls
    @FXML private Button backButton;
    @FXML private TextArea textBlock;
    User user;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Path filePath = Paths.get("log.txt");
        Charset charset = StandardCharsets.UTF_8;
        String textBlockString = "";
        
        try {
            List<String> lines = Files.readAllLines(filePath, charset);
            for(String line : lines) {
                textBlockString = textBlockString + line + "\n";
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginReportViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        textBlock.setText(textBlockString);
        textBlock.setEditable(false);
    }   
    
    
    // Set current user of application
    public void initUser(User user) {
        this.user = user;
    }
    
    
    // Handle back button clicks
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
