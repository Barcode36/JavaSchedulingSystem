
package dao;


import static dao.DBConnection.conn;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import models.Customer;

// Get Customer
// Create Customer
// Update Customer
// Delete Customer
public class CustomerDao {
    
    public static Customer getCustomer(String customerName) throws SQLException {
        // Create SQL select statement using customerName
        String sqlStatement = "SELECT * FROM customer WHERE customerName = ?";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, customerName);
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
        
        Customer selectedCustomer = null;
        
        // Prep localDateTime for createDate
        Date date = rs.getDate("createDate");
        Timestamp createDateTS = new Timestamp(date.getTime());
        
        // Get Customer info from dB query
        while(rs.next()) {
            int customerId = rs.getInt("customerId");
            String name = rs.getString("customerName");
            int addressId = rs.getInt("addressId");
            int active = rs.getInt("active");
            LocalDateTime createDate = createDateTS.toLocalDateTime();
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = rs.getTimestamp("lastUpdate");
            String lastUpdateBy = rs.getString("lastUpdateBy");
            
            selectedCustomer = new Customer(customerId, name, addressId, active, 
                                            createDate, createdBy, lastUpdate, lastUpdateBy);    
        }
       
        return selectedCustomer;
    }
    
    public static void createCustomer(int customerId, String customerName, int addressId, int active, 
                                      LocalDateTime createDate, String createdBy, Timestamp lastUpdate, 
                                      String lastUpdateBy) throws SQLException {
        // Create SQL insert statement using Customer info
        String sqlStatement = "INSERT INTO customer(customerId, customerName, addressId, active,"
                              + "createDate, createdBy, lastUpdate, lastUpdateBy)"
                              + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setInt(1, customerId);
        ps.setString(2, customerName);
        ps.setInt(3, addressId);
        ps.setInt(4, active);
        ps.setObject(5, createDate);
        ps.setString(6, createdBy);
        ps.setTimestamp(7, lastUpdate);
        ps.setString(8, lastUpdateBy);
        ps.execute();
    }
    
    public static void updateCustomer() {
    
    }
    
    public static void deleteCustomer() {
    
    }
    
}
