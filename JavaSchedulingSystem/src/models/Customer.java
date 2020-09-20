
package models;

// Object model for application customers

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Customer {
    
    // Customer Object fields
    private int customerId;
    private String customerName;
    private int addressId;
    private int active;
    private LocalDateTime createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdateBy;
    
    
    // Customer Constructor
    public Customer(int customerId, String customerName, int addressId, int active, 
                    LocalDateTime createDate, String createdBy, Timestamp lastUpdate, String lastUpdateBy) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.addressId = addressId;
        this.active = active;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }
    
    // CustomerID Getters and Setters
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    
    // First Name Getters and Setters
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    
    // Address Getters and Setters
    
    public int getCustomerAddressId() {
        return addressId;
    }
    
    public void setCustomerAddressId(int addressId) {
        this.addressId = addressId;
    }
    
    
    // Active Getters and Setters
    public int getCustomerActive() {
        return active;
    }
    
    public void setCustomerActive(int active) {
        this.active = active;
    }
    
    
    // Create Date Getters and Setters
    public LocalDateTime getCustomerCreateDate() {
        return createDate;
    }
    
    public void setCustomerCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    
    
    // Created By Getters and Setters
    public String getCustomerCreatedBy() {
        return createdBy;
    }
    
    public void setCustomerCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    
    // Last Update Getters and Setters
    public Timestamp getCustomerLastUpdate() {
        return lastUpdate;
    }
    
    public void setCustomerLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    
    // Last Updated By Getters and Setters
    public String getCustomerLastUpdateBy() {
        return lastUpdateBy;
    }
    
    public void setCustomerLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    
}
