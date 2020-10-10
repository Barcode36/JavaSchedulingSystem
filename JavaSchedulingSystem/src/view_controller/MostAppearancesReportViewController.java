
package view_controller;

import dao.CustomerDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import models.CustomerAppearance;
import models.User;


public class MostAppearancesReportViewController implements Initializable {
    User user;
    @FXML private TextArea textBlock;
    @FXML private Button backButton;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textBlock.setEditable(false);
        ObservableList<CustomerAppearance> allCustomerAppearances;
        try {
            allCustomerAppearances = CustomerDao.getAllCustomerAppearances();
            for(CustomerAppearance ca : allCustomerAppearances) {
            textBlock.appendText("---------------\n");
            textBlock.appendText(ca.getCustomerName() + " has " + ca.getAppearances() + " public appearances.\n");
            textBlock.appendText("---------------\n\n\n");
        }
        } catch (SQLException ex) {
            Logger.getLogger(MostAppearancesReportViewController.class.getName()).log(Level.SEVERE, null, ex);
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
