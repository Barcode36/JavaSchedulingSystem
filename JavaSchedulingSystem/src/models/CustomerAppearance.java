
package models;


public class CustomerAppearance {
    private String customerName;
    private int appearances;
    
    public CustomerAppearance(String customerName, int appearances) {
        this.customerName = customerName;
        this.appearances = appearances;
    }
    
    
    
    // CustomerName Getters and Setters
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    
    
    // Appearances Getters and Setters
    public int getAppearances() {
        return this.appearances;
    }
    
    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }
}
