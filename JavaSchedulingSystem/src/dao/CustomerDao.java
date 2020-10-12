
package dao;


import static dao.DBConnection.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Customer;
import models.CustomerAppearance;
import models.CustomerShort;



public class CustomerDao {
    
    // Get single customer by customer name
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
        // Return customer
        return selectedCustomer;
    }
    
    
    // Get all customers
    public static ObservableList<CustomerShort> getAllCustomers() throws SQLException {
        ObservableList<CustomerShort> allCustomers = FXCollections.observableArrayList();
        
        // Create SQL select all users statement
        String sqlStatement = "SELECT c.customerId, c.customerName, a.address, a.phone FROM customer c INNER JOIN address a USING(addressId)";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
        
        CustomerShort nextCustomer;
        
        // Get customer info from dB query
        while(rs.next()) {
            int customerId = rs.getInt("customerId");
            String name = rs.getString("customerName");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            
            nextCustomer = new CustomerShort(customerId, name, address, phone);  
            allCustomers.add(nextCustomer);
        }
        
        // Return observable list of customers
        return allCustomers;
    }
    
    
    // Get all customer appearances
    public static ObservableList<CustomerAppearance> getAllCustomerAppearances() throws SQLException {
        ObservableList<CustomerAppearance> allCustomerAppearances = FXCollections.observableArrayList();
        
        // Create SQL select all customers appearances statement
        String sqlStatement = "SELECT c.customerName, COUNT(a.customerId) AS appearances FROM appointment a INNER JOIN customer c USING(customerId) GROUP BY c.customerName ORDER BY appearances DESC;";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
        
        CustomerAppearance nextCustomerAppearance;
        
        // Get customer info from dB query
        while(rs.next()) {
            String name = rs.getString("customerName");
            int appearances = rs.getInt("appearances");
            
            nextCustomerAppearance = new CustomerAppearance(name, appearances);  
            allCustomerAppearances.add(nextCustomerAppearance);  
        }
        
        // Return observable list of customer appearances
        return allCustomerAppearances;
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
    
    // Update existing customer
    public static void updateCustomer(int customerId, String customerName, int addressId) throws SQLException {
    
        // Create SQL update statement using customer info
        String sqlStatement = "UPDATE customer SET customerName = ?, addressId = ? WHERE customerId = ?";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, customerName);
        ps.setInt(2, addressId);
        ps.setInt(3, customerId);
        ps.execute();
    }
    
    // Delete customer
    public static void deleteCustomer(int customerId) throws SQLException {
    
        // Create SQL delete statement using customerName
        String sqlStatement = "DELETE FROM customer WHERE customerId = ?";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setInt(1, customerId);
        ps.execute();
    }
}
