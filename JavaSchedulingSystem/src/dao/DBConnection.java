
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    
    // JDBC URL parts
    private static final String PROTOCOL = "jdbc";
    private static final String VENDORNAME = ":mysql:";
    private static final String IPADDRESS = "//wgudb.ucertify.com/U06ciQ";
    
    //JDBC URL
    private static final String JDBCURL = PROTOCOL + VENDORNAME + IPADDRESS;
    
    // Reference to MySQL JDBC driver and Connection
    private static final String MYSQLJDBCDRIVER = "com.mysql.jdbc.Driver";
    static Connection conn = null;
    
    // User info
    private static final String USERNAME = "U06ciQ";
    private static final String PASSWORD = "53688727274";
    
    // Start connection to database
    public static Connection startConnection() {
        try {
            Class.forName(MYSQLJDBCDRIVER);
            conn = (Connection)DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
            System.out.println("Database connection successful");
        }
            catch(ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
        }
        return conn;
    }
    
    // Close connection to database
    public static void closeConnection() {
    
        try {
            conn.close();
            System.out.println("Database connection closed");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
