
package dao;


import static dao.DBConnection.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import models.City;



public class CityDao {
    
    
    // Get single city
    public static City getCity(String city) throws SQLException {
    
         // Create SQL select statement using cityId
        String sqlStatement = "SELECT * FROM city WHERE city = ?";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, city);
        ps.execute();
        
        ResultSet rs = ps.getResultSet();
        
        City selectedCity = null;
        
        // Get City info from dB query
        while(rs.next()) {
            int cityId = rs.getInt("cityId");
            String cityName = rs.getString("city");
            int countryId = rs.getInt("countryId");
            Timestamp createDate = rs.getTimestamp("createDate");
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = rs.getTimestamp("lastUpdate");
            String lastUpdateBy = rs.getString("lastUpdateBy");

            
            selectedCity = new City(cityId, cityName, countryId, createDate, createdBy,
                                    lastUpdate, lastUpdateBy);    
        }

        // Return city
        return selectedCity;
    }
    
    
    // Add new city to dB
    public static void createCity(int cityId, String city, int countryId, Timestamp createDate, 
                                  String createdBy, Timestamp lastUpdate, String lastUpdateBy) throws SQLException {
        
        // Create SQL insert statement using city info
        String sqlStatement = "INSERT INTO city(city, countryId, createDate, createdBy,"
                                                + " lastUpdate, lastUpdatedBy) "
                                                + "VALUES(?, 1, ?, ?, ?, ?)";
        
        // Get reference to PreparedStatement
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, city);
        ps.setTimestamp(2, createDate);
        ps.setString(3, createdBy);
        ps.setTimestamp(4, lastUpdate);
        ps.setString(5, lastUpdateBy);
        ps.execute();
    }
}
