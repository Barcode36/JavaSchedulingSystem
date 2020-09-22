
package models;

// Object model for application appointments

import java.sql.Timestamp;


public class Appointment {
    
    // Appointment Object fields
    private int appointmentId;
    private int customerId;
    private int userId;
    private String title;
    private String description;
    private String location;
    private String contact;
    private String appointmentType;
    private String appointmentURL;
    private Timestamp appointmentStart;
    private Timestamp appointmentEnd;
    private Timestamp createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdateBy;
    
    
    // Appointment Constructor
    public Appointment(int appointmentId, int customerId, int userId, String title, String description,
                       String location, String contact, String appointmentType, String appointmentURL,
                       Timestamp appointmentStart, Timestamp appointmentEnd, Timestamp createDate,
                       String createdBy, Timestamp lastUpdate, String lastUpdateBy) {
        this.appointmentId = appointmentId;
        this.customerId = customerId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.appointmentType = appointmentType;
        this.appointmentURL = appointmentURL;
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
       
    }
    
    
    
    // Appointment ID Getters and Setters
    public int getAppointmentId() {
        return appointmentId;
    }
    
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    
    
    
    // Customer ID Getters and Setters
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    
    // User ID Getters and Setters
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
    // Title Getters and Setters
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    // Description Getters and Setters
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    // Location Getters and Setters
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
    // Contact Getters and Setters
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
    
    // Appointment Type Getters and Setters
    
    public String getAppointmentType() {
        return appointmentType;
    }
    
    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
    
    
    
    // Appointment URL Getters and Setters
    public String getURL() {
        return appointmentURL;
    }
    
    public void setURL(String appointmentURL) {
        this.appointmentURL = appointmentURL;
    }
    
    
    
    // Appointment Start Getters and Setters
    public Timestamp getAppointmentStart() {
        return appointmentStart;
    }
    
    public void setAppointmentStart(Timestamp appointmentStart) {
        this.appointmentStart = appointmentStart;
    }
    
    
    
    // Appointment End Getters and Setters
    public Timestamp getAppointmentEnd() {
        return appointmentEnd;
    }
    
    public void setAppointmentEnd(Timestamp appointmentEnd) {
        this.appointmentEnd = appointmentEnd;
    }
    
    
    
    // Create Date Getters and Setters
    public Timestamp getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
    
    
    // CreatedBy Getters and Setters
    public String getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    
    
    // Last update Getters and Setters
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }
    
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    
    
    // Last Update By Getters and Setters
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }
    
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    
}