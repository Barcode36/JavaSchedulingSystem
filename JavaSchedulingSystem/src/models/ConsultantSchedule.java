
package models;

// Object model for application consultant schedules

import java.sql.Timestamp;

public class ConsultantSchedule {
    
    // ConsultantSchedule Object fields
    private String username;
    private String type;
    private String customerName;
    private Timestamp start;
    
    
    // ConsultantSchedule constructor
    public ConsultantSchedule(String username, String type, String customerName, Timestamp start) {
        this.username = username;
        this.type = type;
        this.customerName = customerName;
        this.start = start;
    }
    
    
    // Username Getter and Setter
    public String getUserName() {
        return this.username;
    }
    
    public void setUserName(String username) {
        this.username = username;
    }
    

    // Type Getter and Setter
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    

    // CustomerName Getter and Setter
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    

    // Start Getter and Setter
    public Timestamp getStart() {
        return this.start;
    }
    
    public void setStart(Timestamp start) {
        this.start = start;
    }  
}
