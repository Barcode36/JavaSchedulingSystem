
package dao;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBQuery {
    
    private static PreparedStatement statement;
    
    // Setter
    public static void setPreparedStatement(Connection conn, String sqlStatement) throws SQLException {
        statement = conn.prepareStatement(sqlStatement);
    }
    
    // Getter
    public static PreparedStatement getPreparedStatement() {
        return statement;
    }
}
