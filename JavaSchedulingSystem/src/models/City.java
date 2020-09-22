
package models;

import java.sql.Timestamp;


public class City {
    
    // City Object fields
    private int cityId;
    private String city;
    private int countryId;
    private Timestamp createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdateBy;
    
    
    // City constructor
    public City(int cityId, String city, int countryId, Timestamp createDate, String createdBy,
                Timestamp lastUpdate, String lastUpdateBy) {
    
        this.cityId = cityId;
        this.city = city;
        this.countryId = countryId;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }
    
    
    
    // City ID Getters and Setters
    public int getCityId() {
        return cityId;
    }
    
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
    
    
    
    // City Getters and Setters
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    
    
    // Country ID Getters and Setters
    public int getCountryId() {
        return countryId;
    }
    
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    
    
    
    // Create Date Getters and Setters
    public Timestamp getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
    
    
    // Created By Getters and Setters
    public String getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    
    
    // Last Update Getters and Setters
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }
    
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    
    
    // Last Update By Getters and Setters
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }
    
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    
}
