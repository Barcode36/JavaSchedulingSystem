
package models;

// Object model for application customers

public class Customer {
    
    // Customer Object fields
    private int customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    
    
    // Customer Constructor
    public Customer(int customerId, String firstName, String lastName,  String address, String phone) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }
    
    // CustomerID Getters and Setters
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    
    // First Name Getters and Setters
    
    public String getCustomerFirstName() {
        return firstName;
    }
    
    public void setCustomerFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
    // Last Name Getters and Setters
    
    public String getCustomerLastName() {
        return lastName;
    }
    
    public void setCustomerLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    // Address Getters and Setters
    
    public String getCustomerAddress() {
        return address;
    }
    
    public void setCustomerAddress(String address) {
        this.address = address;
    }
    
    
    // Phone Getters and Setters
    
    public String getCustomerPhone() {
        return phone;
    }
    
    public void setCustomerPhone(String phone) {
        this.phone = phone;
    }
    
}
