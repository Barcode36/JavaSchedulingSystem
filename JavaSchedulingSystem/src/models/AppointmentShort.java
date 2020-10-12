
package models;

// Object model for short version of applications

import java.sql.Timestamp;
import javafx.beans.property.SimpleStringProperty;

public class AppointmentShort {
    
    // AppointmentShort Object fields
    private int appointmentId;
    private Timestamp appointmentStart;
    private SimpleStringProperty appointmentType = new SimpleStringProperty();
    private SimpleStringProperty customerName = new SimpleStringProperty();
    private Timestamp appointmentEnd;
    
    
    // AppointmentShort Constructor
    public AppointmentShort(int appointmentId, Timestamp appointmentStart, Timestamp appointmentEnd, String appointmentType, String customerName) {
        setAppointmentId(appointmentId);
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        setAppointmentType(appointmentType);
        setCustomerName(customerName);
    }
    
    
    // AppointmentId Getter and Setter
    public int getAppointmentId() {
        return this.appointmentId;
    }
    
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    
    
    // Appointment Start Getter and Setter
    public Timestamp getAppointmentStart() {
        return appointmentStart;
    }
    
    public void setAppointmentStart(Timestamp appointmentStart) {
       this.appointmentStart = appointmentStart;
    }
    
    
    // Appointment End Getter and Setter
    public Timestamp getAppointmentEnd() {
        return appointmentEnd;
    }
    
    public void setAppointmentEnd(Timestamp appointmentEnd) {
        this.appointmentEnd = appointmentEnd;
    }
    

    // Appointment Type Getter and Setter
    public String getAppointmentType() {
        return this.appointmentType.get();
    }
    
    public void setAppointmentType(String appointmentType) {
        this.appointmentType.set(appointmentType);
    }
    

    // CustomerName Getter and Setter
    public String getCustomerName() {
        return this.customerName.get();
    }
    
    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }
}
