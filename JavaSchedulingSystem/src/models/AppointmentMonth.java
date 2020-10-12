
package models;

// Object model for application appointment per month

public class AppointmentMonth {
    
    // AppointmentMonth Object fields
    private int year;
    private int month;
    private String type;
    private int typeCount;
    
    
    // AppointmentMonth constructor
    public AppointmentMonth (int year, int month, String type, int typeCount) {
        this.year = year;
        this.month = month;
        this.type = type;
        this.typeCount = typeCount;
    }
    
    
    // Year Getter and Setter
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    

    // Month Getter and Setter
    public int getMonth() {
        return this.month;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    

    // Type Getter and Setter
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    

    // TypeCount Getter and Setter
    public int getTypeCount() {
        return this.typeCount;
    }
    
    public void setTypeCount(int typeCount) {
        this.typeCount = typeCount;
    }   
}
