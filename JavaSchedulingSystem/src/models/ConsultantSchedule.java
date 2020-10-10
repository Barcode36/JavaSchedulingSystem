
package models;

import java.sql.Timestamp;


public class ConsultantSchedule {
    private String username;
    private String type;
    private String customerName;
    private Timestamp start;
    
    public ConsultantSchedule(String username, String type, String customerName, Timestamp start) {
        this.username = username;
        this.type = type;
        this.customerName = customerName;
        this.start = start;
    }
    
    
    // Username Getters and Setters
    public String getUserName() {
        return this.username;
    }
    
    public void setUserName(String username) {
        this.username = username;
    }
    
    
    
    // Type Getters and Setters
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    
    
    // CustomerName Getters and Setters
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    
    
    // Start Getters and Setters
    public Timestamp getStart() {
        return this.start;
    }
    
    public void setStart(Timestamp start) {
        this.start = start;
    }  
    
}
