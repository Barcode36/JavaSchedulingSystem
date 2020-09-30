
package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class CustomerShort {
    
    private SimpleIntegerProperty customerId = new SimpleIntegerProperty();
    private SimpleStringProperty customerName = new SimpleStringProperty();
    private SimpleStringProperty address = new SimpleStringProperty();
    private SimpleStringProperty phone = new SimpleStringProperty();
    
    public CustomerShort(int customerId, String customerName, String address, String phone) {
        setCustomerId(customerId);
        setCustomerName(customerName);
        setAddress(address);
        setPhone(phone);
    }
    
    // CustomerId Getters and Setters
    public int getCustomerId() {
        return this.customerId.get();
    }
    
    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }
    
    
    
    // Customer Name Getters and Setters
    public String getCustomerName() {
        return this.customerName.get();
    }
    
    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }
    
    
    
    // Address Getters and Setters
    public String getAddress() {
        return this.address.get();
    }
    
    public void setAddress(String address) {
        this.address.set(address);
    }
    
    
    // Phone Getters and Setters
    public String getPhone() {
        return this.phone.get();
    }
    
    public void setPhone(String phone) {
        this.phone.set(phone);
    }
    
    
}
