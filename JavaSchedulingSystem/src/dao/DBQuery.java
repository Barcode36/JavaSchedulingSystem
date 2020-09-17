
// This class provides getter and setter for DB Statement object
package dao;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DBQuery {
    
    private static Statement statement;
    
    // Setter
    public static void setStatement(Connection conn) throws SQLException {
        statement = conn.createStatement();
    }
    
    // Getter
    public static Statement getStatement() {
        return statement;
    }
}
