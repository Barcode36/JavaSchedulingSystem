
package models;

import java.sql.Timestamp;
import javafx.beans.property.SimpleStringProperty;




public class AppointmentShort {
    private int appointmentId;
     private Timestamp appointmentStart;
    private SimpleStringProperty appointmentType = new SimpleStringProperty();
    private SimpleStringProperty customerName = new SimpleStringProperty();
    
    // Constructor
    public AppointmentShort(int appointmentId, Timestamp appointmentStart, String appointmentType, String customerName) {
        setAppointmentId(appointmentId);
        this.appointmentStart = appointmentStart;
        setAppointmentType(appointmentType);
        setCustomerName(customerName);
    }
    
    
    
    // AppointmentId Getters and Setters
    public int getAppointmentId() {
        return this.appointmentId;
    }
    
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    
    
    // Appointment Start Getters and Setters
    public Timestamp getAppointmentStart() {
        return appointmentStart;
    }
    
    public void setAppointmentStart(Timestamp appointmentStart) {
       this.appointmentStart = appointmentStart;
    }
    
    
    
    // Appointment Type Getters and Setters
    public String getAppointmentType() {
        return this.appointmentType.get();
    }
    
    public void setAppointmentType(String appointmentType) {
        this.appointmentType.set(appointmentType);
    }
    
    
    
    // CustomerName Getters and Setters
    public String getCustomerName() {
        return this.customerName.get();
    }
    
    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }
    
    
}
