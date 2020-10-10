
package utilities;

// Utility methods common to lots of view controllers

import com.sun.scenario.effect.Offset;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    
    // Alert for upcoming appointment
    public static void throwUpcomingAppointmentAlert(Timestamp timestamp) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Upcoming Appointment");
        alert.setHeaderText("There is an appointment coming up at: " + timestamp.toString());
        Optional<ButtonType> result = alert.showAndWait();
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
    public static Timestamp toUTC(Timestamp localTimestamp) {
        // Convert local Timestamp to an Instant
        Instant localInstant = localTimestamp.toInstant();
        
        // Get the time zone of the machine and get the UTC offset
        TimeZone tz = TimeZone.getDefault();
        int offset = tz.getOffset(System.currentTimeMillis());
        
        // Subtract offset from local instant to get utc millis
        Instant utcMillis = localInstant.minusMillis(offset);
        
        // Convert utc millis to utc timestamp
        Timestamp utcTimestamp = Timestamp.from(utcMillis);
        
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
    
    
    public static Boolean checkForValidTimes(String startTime, String endTime) {
        Integer startHour = Integer.parseInt(startTime.substring(0,2));
        Integer endHour = Integer.parseInt(endTime.substring(0, 2));
        if(startHour > endHour) {
            return true;
        } else {
            return false;
        }
    }
    
    public static Boolean checkPhoneNumbers(String phone) {
        String regex = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
        Pattern regexPattern = Pattern.compile(regex);
        Matcher matcher = regexPattern.matcher(phone);
        if(matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
    
}
