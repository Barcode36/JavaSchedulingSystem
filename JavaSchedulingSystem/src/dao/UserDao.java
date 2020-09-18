
package dao;

import models.User;
import static dao.DBConnection.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDao {
    
    // Get a single user from dB
    public static User getUser(String userName) throws SQLException {
        // Create SQL select statement using userName entered into login form
        String sqlStatement = "SELECT * FROM user WHERE userName = ?";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, userName);
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
        
        User selectedUser = null;
        
        // Get User info from dB query
        while(rs.next()) {
            int userId = rs.getInt("userId");
            String name = rs.getString("userName");
            String pass = rs.getString("password");
            int active = rs.getInt("active");
            LocalDate createDate = rs.getDate("createDate").toLocalDate();
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = rs.getTimestamp("lastUpdate");
            String lastUpdateBy = rs.getString("lastUpdateBy");
            
            selectedUser = new User(userId, name, pass, active, createDate, 
                                    createdBy, lastUpdate, lastUpdateBy);    
        }
       
        return selectedUser;
    }
    
    
    
    // Get all users
    public static ObservableList<User> getAllUsers() throws SQLException {
    
        // Prepare Observable List variable to hold all users
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        
        // Create SQL select all users statement
        String sqlStatement = "SELECT * FROM user";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
        
        User nextUser;
        
        // Get User info from dB query
        while(rs.next()) {
            int userId = rs.getInt("userId");
            String name = rs.getString("userName");
            String pass = rs.getString("password");
            int active = rs.getInt("active");
            LocalDate createDate = rs.getDate("createDate").toLocalDate();
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = rs.getTimestamp("lastUpdate");
            String lastUpdateBy = rs.getString("lastUpdateBy");
            
            nextUser = new User(userId, name, pass, active, createDate, 
                                    createdBy, lastUpdate, lastUpdateBy);  
            allUsers.add(nextUser);
            
        }
        
        // update this return
        return allUsers;
    }
    
    
}
