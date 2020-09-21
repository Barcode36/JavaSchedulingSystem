
package dao;


import static dao.DBConnection.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Customer;



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
        
        
        // Get Customer info from dB query
        while(rs.next()) {
            int customerId = rs.getInt("customerId");
            String name = rs.getString("customerName");
            int addressId = rs.getInt("addressId");
            int active = rs.getInt("active");
            Timestamp createDate = rs.getTimestamp("createDate");
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = rs.getTimestamp("lastUpdate");
            String lastUpdateBy = rs.getString("lastUpdateBy");
            
            selectedCustomer = new Customer(customerId, name, addressId, active, 
                                            createDate, createdBy, lastUpdate, lastUpdateBy);    
        }
       
        return selectedCustomer;
    }
    
    

    // Get all customers
    public static ObservableList<Customer> getAllCustomers() throws SQLException {
        
        // Prepare Observable List variable to hold all users
        ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
        
        // Create SQL select all users statement
        String sqlStatement = "SELECT * FROM customer";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
        
        Customer nextCustomer;
        
        // Get User info from dB query
        while(rs.next()) {
            int customerId = rs.getInt("customerId");
            String name = rs.getString("customerName");
            // TODO - look up proper address
            int address = rs.getInt("addressId");
            int active = rs.getInt("active");
            Timestamp createDate = rs.getTimestamp("createDate");
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = rs.getTimestamp("lastUpdate");
            String lastUpdateBy = rs.getString("lastUpdateBy");
            
            nextCustomer = new Customer(customerId, name, address, active, createDate, 
                                    createdBy, lastUpdate, lastUpdateBy);  
            allCustomers.add(nextCustomer);
            
        }
        
        // Return observable list
        return allCustomers;
    }
    
    
    
    // Add a new customer to dB
    public static void createCustomer(String customerName, int addressId, int active, 
                                      Timestamp createDate, String createdBy, Timestamp lastUpdate, 
                                      String lastUpdateBy) throws SQLException {
        // Create SQL insert statement using Customer info
        String sqlStatement = "INSERT INTO customer(customerName, addressId, active,"
                              + "createDate, createdBy, lastUpdate, lastUpdateBy)"
                              + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, customerName);
        ps.setInt(2, addressId);
        ps.setInt(3, active);
        ps.setTimestamp(4, createDate);
        ps.setString(5, createdBy);
        ps.setTimestamp(6, lastUpdate);
        ps.setString(7, lastUpdateBy);
        ps.execute();
    }
    
    public static void updateCustomer(int customerId, String customerName, String address, String phone) throws SQLException {
    
        // Create SQL select statement using customerName
        String sqlStatement = "UPDATE customer SET customerName = ?, address = ?, "
                              + "phone = ? WHERE customerId = ?";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, customerName);
        ps.setString(2, address);
        ps.setString(3, phone);
        ps.setInt(4, customerId);
        ps.execute();
        
    }
    
    public static void deleteCustomer(int customerId) throws SQLException {
    
        // Create SQL select statement using customerName
        String sqlStatement = "DELETE FROM customer WHERE customerId = ?";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setInt(1, customerId);
        ps.execute();
        
    }
    
}
