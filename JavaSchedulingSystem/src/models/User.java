
package models;

// Object model for application users

public class User {
    
    // User Object fields
    private int userId;
    private String username;
    private String userPassword;
    
    
    // User Constructor
    public User(int userId, String username, String userPassword) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
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
