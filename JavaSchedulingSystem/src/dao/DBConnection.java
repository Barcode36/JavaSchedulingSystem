
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    
    // JDBC URL parts
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String ipAddress = "//wgudb.ucertify.com/U06ciQ";
    //JDBC URL
    private static final String jdbcURL = protocol + vendorName + ipAddress;
    
    // Reference to MySQL JDBC driver and Connection
    private static final String MYSQLJDBCDriver = "com.mysql.jdbc.Driver";
    private static Connection conn = null;
    
    // User info
    private static final String username = "U06ciQ";
    private static final String password = "53688727274";
    
    
    public static Connection startConnection() {
        try {
            Class.forName(MYSQLJDBCDriver);
            conn = (Connection)DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Database connection successful");
        }
            catch(ClassNotFoundException e) {
                System.out.println(e.getMessage());
        }
            catch(SQLException e) {
                System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
    
    public static void closeConnection() {
    
        try {
            conn.close();
            System.out.println("Database connection closed");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
