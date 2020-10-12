
package models;

// Object model for application customer appearances

public class CustomerAppearance {
    
    // CustomerAppearance Object fields
    private String customerName;
    private int appearances;
    
    
    // CustomerAppearance constructor
    public CustomerAppearance(String customerName, int appearances) {
        this.customerName = customerName;
        this.appearances = appearances;
    }
    

    // CustomerName Getter and Setter
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    

    // Appearances Getter and Setter
    public int getAppearances() {
        return this.appearances;
    }
    
    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }
}
