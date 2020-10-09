
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
import models.MonthTypes;
import utilities.Utils;


public class AppointmentsByMonthReportViewController implements Initializable {
    User user;
    @FXML private Button backButton;
    @FXML private TextArea textArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textArea.setEditable(false);
        MonthTypes jan = new MonthTypes("January", 0, 0, 0, 0, 0);
        MonthTypes feb = new MonthTypes("February", 0, 0, 0, 0, 0);
        MonthTypes mar = new MonthTypes("March", 0, 0, 0, 0, 0);
        MonthTypes apr = new MonthTypes("April", 0, 0, 0, 0, 0);
        MonthTypes may = new MonthTypes("May", 0, 0, 0, 0, 0);
        MonthTypes jun = new MonthTypes("June", 0, 0, 0, 0, 0);
        MonthTypes jul = new MonthTypes("July", 0, 0, 0, 0, 0);
        MonthTypes aug = new MonthTypes("August", 0, 0, 0, 0, 0);
        MonthTypes sep = new MonthTypes("September", 0, 0, 0, 0, 0);
        MonthTypes oct = new MonthTypes("October", 0, 0, 0, 0, 0);
        MonthTypes nov = new MonthTypes("November", 0, 0, 0, 0, 0);
        MonthTypes dec = new MonthTypes("December", 0, 0, 0, 0, 0);
        
        try {
            ObservableList<AppointmentShort> appointments = AppointmentDao.getAllAppointments();
            for(AppointmentShort as : appointments) {
                Calendar calendar = Calendar.getInstance();
                Timestamp timestamp = Utils.fromUTC(as.getAppointmentStart());
                Date date = Date.valueOf(timestamp.toString().substring(0, 10));
                calendar.setTime(date);
                int month = calendar.get(Calendar.MONTH);
                String type = as.getAppointmentType();
                switch(month) {
                    case 0:
                        switch(type) {
                            case "Concert":
                                jan.addOneConcert();;
                            break;
                            
                            case "Practice":
                                jan.addOnePractice();
                            break;
                            
                            case "Gig":
                                jan.addOneGig();
                            break;
                            
                            case "Festival":
                                jan.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                jan.addOneTourStop();
                            break;
                        }
                    break;
                    
                    case 1:
                        switch(type) {
                            case "Concert":
                                feb.addOneConcert();;
                            break;
                            
                            case "Practice":
                                feb.addOnePractice();
                            break;
                            
                            case "Gig":
                                feb.addOneGig();
                            break;
                            
                            case "Festival":
                                feb.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                feb.addOneTourStop();
                            break;
                        }    
                    break;
                    
                    case 2:
                        switch(type) {
                            case "Concert":
                                mar.addOneConcert();;
                            break;
                            
                            case "Practice":
                                mar.addOnePractice();
                            break;
                            
                            case "Gig":
                                mar.addOneGig();
                            break;
                            
                            case "Festival":
                                mar.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                mar.addOneTourStop();
                            break;
                        }
                    break;
                    
                    case 3:
                        switch(type) {
                            case "Concert":
                                apr.addOneConcert();;
                            break;
                            
                            case "Practice":
                                apr.addOnePractice();
                            break;
                            
                            case "Gig":
                                apr.addOneGig();
                            break;
                            
                            case "Festival":
                                apr.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                apr.addOneTourStop();
                            break;
                        }
                    break;
                    
                    case 4:
                        switch(type) {
                            case "Concert":
                                may.addOneConcert();;
                            break;
                            
                            case "Practice":
                                may.addOnePractice();
                            break;
                            
                            case "Gig":
                                may.addOneGig();
                            break;
                            
                            case "Festival":
                                may.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                may.addOneTourStop();
                            break;
                        }
                    break;
                    
                    case 5:
                        switch(type) {
                            case "Concert":
                                jun.addOneConcert();;
                            break;
                            
                            case "Practice":
                                jun.addOnePractice();
                            break;
                            
                            case "Gig":
                                jun.addOneGig();
                            break;
                            
                            case "Festival":
                                jun.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                jun.addOneTourStop();
                            break;
                        }
                    break;
                    
                    case 6:
                        switch(type) {
                            case "Concert":
                                jul.addOneConcert();;
                            break;
                            
                            case "Practice":
                                jul.addOnePractice();
                            break;
                            
                            case "Gig":
                                jul.addOneGig();
                            break;
                            
                            case "Festival":
                                jul.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                jul.addOneTourStop();
                            break;
                        }
                    break;
                    
                    case 7:
                        switch(type) {
                            case "Concert":
                                aug.addOneConcert();;
                            break;
                            
                            case "Practice":
                                aug.addOnePractice();
                            break;
                            
                            case "Gig":
                                aug.addOneGig();
                            break;
                            
                            case "Festival":
                                aug.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                aug.addOneTourStop();
                            break;
                        }
                    break;
                    
                    case 8:
                        switch(type) {
                            case "Concert":
                                sep.addOneConcert();;
                            break;
                            
                            case "Practice":
                                sep.addOnePractice();
                            break;
                            
                            case "Gig":
                                sep.addOneGig();
                            break;
                            
                            case "Festival":
                                sep.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                sep.addOneTourStop();
                            break;
                        }
                    break;
                    
                    case 9:
                        switch(type) {
                            case "Concert":
                                oct.addOneConcert();;
                            break;
                            
                            case "Practice":
                                oct.addOnePractice();
                            break;
                            
                            case "Gig":
                                oct.addOneGig();
                            break;
                            
                            case "Festival":
                                oct.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                oct.addOneTourStop();
                            break;
                        }
                    break;
                    
                    case 10:
                        switch(type) {
                            case "Concert":
                                nov.addOneConcert();;
                            break;
                            
                            case "Practice":
                                nov.addOnePractice();
                            break;
                            
                            case "Gig":
                                nov.addOneGig();
                            break;
                            
                            case "Festival":
                                nov.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                nov.addOneTourStop();
                            break;
                        }
                    break;
                    
                    case 11:
                        switch(type) {
                            case "Concert":
                                dec.addOneConcert();;
                            break;
                            
                            case "Practice":
                                dec.addOnePractice();
                            break;
                            
                            case "Gig":
                                dec.addOneGig();
                            break;
                            
                            case "Festival":
                                dec.addOneFestival();
                            break;
                            
                            case "Tour stop":
                                dec.addOneTourStop();
                            break;
                        }
                    break;
                    
                }
        }
            textArea.appendText("JANUARY\n***************\n" + 
                        "Concerts: " + jan.getConcert() + "\n" +
                        "Practices: " + jan.getPractice() + "\n" +
                        "Gigs: " + jan.getGig() + "\n" +
                        "Festivals: " + jan.getFestival() + "\n" +
                        "Tour Stops: " + jan.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("FEBRUARY\n***************\n" + 
                        "Concerts: " + feb.getConcert() + "\n" +
                        "Practices: " + feb.getPractice() + "\n" +
                        "Gigs: " + feb.getGig() + "\n" +
                        "Festivals: " + feb.getFestival() + "\n" +
                        "Tour Stops: " + feb.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("MARCH\n***************\n" + 
                        "Concerts: " + mar.getConcert() + "\n" +
                        "Practices: " + mar.getPractice() + "\n" +
                        "Gigs: " + mar.getGig() + "\n" +
                        "Festivals: " + mar.getFestival() + "\n" +
                        "Tour Stops: " + mar.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("APRIL\n***************\n" + 
                        "Concerts: " + apr.getConcert() + "\n" +
                        "Practices: " + apr.getPractice() + "\n" +
                        "Gigs: " + apr.getGig() + "\n" +
                        "Festivals: " + apr.getFestival() + "\n" +
                        "Tour Stops: " + apr.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("MAY\n***************\n" + 
                        "Concerts: " + may.getConcert() + "\n" +
                        "Practices: " + may.getPractice() + "\n" +
                        "Gigs: " + may.getGig() + "\n" +
                        "Festivals: " + may.getFestival() + "\n" +
                        "Tour Stops: " + may.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("JUNE\n***************\n" + 
                        "Concerts: " + jun.getConcert() + "\n" +
                        "Practices: " + jun.getPractice() + "\n" +
                        "Gigs: " + jun.getGig() + "\n" +
                        "Festivals: " + jun.getFestival() + "\n" +
                        "Tour Stops: " + jun.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("JULY\n***************\n" + 
                        "Concerts: " + jul.getConcert() + "\n" +
                        "Practices: " + jul.getPractice() + "\n" +
                        "Gigs: " + jul.getGig() + "\n" +
                        "Festivals: " + jul.getFestival() + "\n" +
                        "Tour Stops: " + jul.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("AUGUST\n***************\n" + 
                        "Concerts: " + aug.getConcert() + "\n" +
                        "Practices: " + aug.getPractice() + "\n" +
                        "Gigs: " + aug.getGig() + "\n" +
                        "Festivals: " + aug.getFestival() + "\n" +
                        "Tour Stops: " + aug.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("SEPTEMBER\n***************\n" + 
                        "Concerts: " + sep.getConcert() + "\n" +
                        "Practices: " + sep.getPractice() + "\n" +
                        "Gigs: " + sep.getGig() + "\n" +
                        "Festivals: " + sep.getFestival() + "\n" +
                        "Tour Stops: " + sep.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("OCTOBER\n***************\n" + 
                        "Concerts: " + oct.getConcert() + "\n" +
                        "Practices: " + oct.getPractice() + "\n" +
                        "Gigs: " + oct.getGig() + "\n" +
                        "Festivals: " + oct.getFestival() + "\n" +
                        "Tour Stops: " + oct.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("NOVEMBER\n***************\n" + 
                        "Concerts: " + nov.getConcert() + "\n" +
                        "Practices: " + nov.getPractice() + "\n" +
                        "Gigs: " + nov.getGig() + "\n" +
                        "Festivals: " + nov.getFestival() + "\n" +
                        "Tour Stops: " + nov.getTourStop() + "\n" +
                        "***************\n\n");
                textArea.appendText("DECEMBER\n***************\n" + 
                        "Concerts: " + dec.getConcert() + "\n" +
                        "Practices: " + dec.getPractice() + "\n" +
                        "Gigs: " + dec.getGig() + "\n" +
                        "Festivals: " + dec.getFestival() + "\n" +
                        "Tour Stops: " + dec.getTourStop() + "\n" +
                        "***************\n\n");
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
