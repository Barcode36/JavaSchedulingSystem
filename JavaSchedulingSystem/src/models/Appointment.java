
package models;

// Object model for application appointments

import java.sql.Timestamp;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Appointment {
    
    // Appointment Object fields
    private SimpleIntegerProperty appointmentId = new SimpleIntegerProperty();
    private SimpleIntegerProperty customerId = new SimpleIntegerProperty();
    private SimpleIntegerProperty userId = new SimpleIntegerProperty();
    private SimpleStringProperty title = new SimpleStringProperty();
    private SimpleStringProperty description = new SimpleStringProperty();
    private SimpleStringProperty location = new SimpleStringProperty();
    private SimpleStringProperty contact = new SimpleStringProperty();
    private SimpleStringProperty appointmentType = new SimpleStringProperty();
    private SimpleStringProperty appointmentURL = new SimpleStringProperty();
    private Timestamp appointmentStart;
    private Timestamp appointmentEnd;
    private Timestamp createDate;
    private SimpleStringProperty createdBy = new SimpleStringProperty();
    private Timestamp lastUpdate;
    private SimpleStringProperty lastUpdateBy = new SimpleStringProperty();
    
    
    // Appointment Constructor
    public Appointment(int appointmentId, int customerId, int userId, String title, String description,
                       String location, String contact, String appointmentType, String appointmentURL,
                       Timestamp appointmentStart, Timestamp appointmentEnd, Timestamp createDate,
                       String createdBy, Timestamp lastUpdate, String lastUpdateBy) {
        setAppointmentId(appointmentId);
        setCustomerId(customerId);
        setUserId(userId);
        setTitle(title);
        setDescription(description);
        setLocation(location);
        setContact(contact);
        setAppointmentType(appointmentType);
        setAppointmentURL(appointmentURL);
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        this.createDate = createDate;
        setCreatedBy(createdBy);
        this.lastUpdate = lastUpdate;
        setLastUpdateBy(lastUpdateBy); 
    }
    
    
    // Appointment ID Getter and Setter
    public int getAppointmentId() {
        return appointmentId.get();
    }
    
    public void setAppointmentId(int appointmentId) {
        this.appointmentId.set(appointmentId);
    }
    

    // Customer ID Getter and Setter
    public int getCustomerId() {
        return customerId.get();
    }
    
    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }
    
    
    // User ID Getter and Setter
    public int getUserId() {
        return userId.get();
    }
    
    public void setUserId(int userId) {
        this.userId.set(userId);
    }
    
    
    // Title Getter and Setter
    public String getTitle() {
        return title.get();
    }
    
    public void setTitle(String title) {
        this.title.set(title);
    }
    
    
    // Description Getter and Setter
    public String getDescription() {
        return description.get();
    }
    
    public void setDescription(String description) {
        this.description.set(description);
    }
    
    
    // Location Getter and Setter
    public String getLocation() {
        return location.get();
    }
    
    public void setLocation(String location) {
        this.location.set(location);
    }
    
    
    // Contact Getter and Setter
    public String getContact() {
        return contact.get();
    }
    
    public void setContact(String contact) {
        this.contact.set(contact);
    }
    
    
    // Appointment Type Getter and Setter
    public String getAppointmentType() {
        return appointmentType.get();
    }
    
    public void setAppointmentType(String appointmentType) {
        this.appointmentType.set(appointmentType);
    }
    
    
    // Appointment URL Getter and Setter
    public String getAppointmentURL() {
        return appointmentURL.get();
    }
    
    public void setAppointmentURL(String appointmentURL) {
        this.appointmentURL.set(appointmentURL);
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
    

    // Create Date Getter and Setter
    public Timestamp getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    

    // CreatedBy Getter and Setter
    public String getCreatedBy() {
        return createdBy.get();
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy.set(createdBy);
    }
    

    // Last update Getter and Setter
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }
    
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    

    // Last Update By Getter and Setter
    public String getLastUpdateBy() {
        return lastUpdateBy.get();
    }
    
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy.set(lastUpdateBy);
    }
}