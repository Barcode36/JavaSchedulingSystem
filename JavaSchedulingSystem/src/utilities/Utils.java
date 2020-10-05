
package utilities;

// Utility methods common to lots of view controllers

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.Instant;
import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Utils {
    
    // Used in controllers to change scenes 
    public static void sceneChanger(String sceneName, ActionEvent event) throws IOException {
            Parent parent = FXMLLoader.load(Utils.class.getClassLoader().getResource(sceneName));
            Scene scene = new Scene(parent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
    }
    
    // Throws confirmation alert in Korean
    public static String throwConfirmationAlert(String language) {
        ButtonType koreanOK = new ButtonType("확인", ButtonBar.ButtonData.OK_DONE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", koreanOK);
        alert.setTitle("확인");
        alert.setHeaderText("확실해?");
        Optional<ButtonType> result = alert.showAndWait();
        return result.get().getText();
    }
    
    // Override method: Throws confirmation alert
    public static String throwConfirmationAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        return result.get().getText();
    }
    
    
    // Handles exit button click in Korean
    public static void exitApplication(String language) {
        if(throwConfirmationAlert("Korean").equals("확인")) {
            System.exit(0);
        } 
    }
    
    // Override method: Handles exit button click
    public static void exitApplication() {
        if(throwConfirmationAlert().equals("OK")) {
            System.exit(0);
        } 
    }
    
    // Throws error alert in Korean
    public static void throwErrorAlert(String message, String language) {
        ButtonType koreanOK = new ButtonType("확인", ButtonBar.ButtonData.OK_DONE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", koreanOK);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
    
    // Override method: Throws error alert in English
    public static void throwErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
    
    // Write login timestamp to logfile
    public static void loginTimestamp(String username, Timestamp timestamp) throws IOException {
        String logString = "Username: " + username + "   |   Login Timestamp: " + timestamp.toString() + "\n";
        File file = new File("log.txt");
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(logString);
        bufferedWriter.close();
    }    
    
    
    // Convert local timestamp to UTC timestamp and return UTC timestamp
    public static Timestamp toUTC() {
        Clock clock = Clock.systemUTC();
        Timestamp utcTimestamp = Timestamp.from(clock.instant());
        return utcTimestamp;
    }
    
    
    // Convert UTC timestamp to local timestamp and return local timestamp
    public static Timestamp fromUTC(Timestamp utcTimestamp) {
        long epochMillis = utcTimestamp.getTime();
        Instant ts = Instant.ofEpochMilli(epochMillis);
        int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
        Instant localMillis = ts.plusMillis(offset);
        Timestamp localTimestamp = Timestamp.from(localMillis);
        return localTimestamp;
    }
}
