
package models;

// Object model for application users

import java.sql.Timestamp;
import java.time.LocalDate;


public class User {
    
    // User Object fields
    private int userId;
    private String username;
    private String userPassword;
    private int active;
    private LocalDate createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdateBy;
    
    
    // User Constructor
    public User(int userId, String username, String userPassword, int active, 
                LocalDate createDate, String createdBy, Timestamp lastUpdate, String lastUpdateBy) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
        this.active = active;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }
    
    // UserID Getters and Setters
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    // Username Getters and Setters
    
    public String getUserName() {
        return username;
    }
    
    public void setUserName(String username) {
        this.username = username;
    }
    
    
    // Password Getters and Setters
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
}
