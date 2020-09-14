
package models;

// Object model for application appointments

public class Appointment {
    
    // Appointment Object fields
    private int appointmentId;
    private String appointmentDate;
    private String appointmentTime;
    private String appointmentType;
    private String appointmentCustomer;
    
    
    // Appointment Constructor
    public Appointment(int appointmentId, String appointmentDate, String appointmentTime,  
                       String appointmentType, String appointmentCustomer) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentType = appointmentType;
        this.appointmentCustomer = appointmentCustomer;
    }
    
    // Appointment ID Getters and Setters
    
    public int getAppointmentId() {
        return appointmentId;
    }
    
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    
    
    // Appointment Date Getters and Setters
    
    public String getAppointmentDate() {
        return appointmentDate;
    }
    
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
    
    // Appointment Time Getters and Setters
    
    public String getAppointmentTime() {
        return appointmentTime;
    }
    
    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
    
    // Appointment Type Getters and Setters
    
    public String getAppointmentType() {
        return appointmentType;
    }
    
    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
    
    
    // Appointment Customer Getters and Setters
    
    public String getAppointmentCustomer() {
        return appointmentCustomer;
    }
    
    public void setAppointmentCustomer(String appointmentCustomer) {
        this.appointmentCustomer = appointmentCustomer;
    }
    
}
