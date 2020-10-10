
package models;


public class AppointmentMonth {
    private int year;
    private int month;
    private String type;
    private int typeCount;
    
    public AppointmentMonth (int year, int month, String type, int typeCount) {
        this.year = year;
        this.month = month;
        this.type = type;
        this.typeCount = typeCount;
    }
    
    // Year Getters and Setters
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    
    
    
    // Month Getters and Setters
    public int getMonth() {
        return this.month;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    
    
    // Type Getters and Setters
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    
    
    // TypeCount Getters and Setters
    public int getTypeCount() {
        return this.typeCount;
    }
    
    public void setTypeCount(int typeCount) {
        this.typeCount = typeCount;
    }
    
}
