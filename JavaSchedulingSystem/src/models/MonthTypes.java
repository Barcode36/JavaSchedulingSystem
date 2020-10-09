
package models;


public class MonthTypes {
    private String month;
    private int concert;
    private int gig;
    private int tourstop;
    private int festival;
    private int practice;
    
    public MonthTypes (String month, int concert, int gig, int tourstop, int festival, int practice) {
        this.month = month;
        this.concert = concert;
        this.gig = gig;
        this.tourstop = tourstop;
        this.festival = festival;
        this.practice = practice;
    }
    
    // Month Getters and Setters
    public String getMonth() {
        return this.month;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }
    
    
    
    
    // Concert Getters and Setters
    public int getConcert() {
        return this.concert;
    }
    
    public void setConcert(int concert) {
        this.concert = concert;
    }
    
    public void addOneConcert() {
        this.concert += 1;
    }
    
    
    
    // Gig Getters and Setters
    public int getGig() {
        return this.gig;
    }
    
    public void setGig(int gig) {
        this.gig = gig;
    }
    
    public void addOneGig() {
        this.gig += 1;
    }
    
    
    
    // Tourstop Getters and Setters
    public int getTourStop() {
        return this.tourstop;
    }
    
    public void setTourStop(int tourstop) {
        this.tourstop = tourstop;
    }
    
    public void addOneTourStop() {
        this.tourstop += 1;
    }
    
    
    
    // Festival Getters and Setter
    public int getFestival() {
        return this.festival;
    }
    
    public void setFestival(int festival) {
        this.festival = festival;
    }
    
    public void addOneFestival() {
        this.festival += 1;
    }
    
    
    
    // Practice Getters and Setters
    public int getPractice() {
        return this.practice;
    }
    
    public void setPractice(int practice) {
        this.practice = practice;
    }
    
    public void addOnePractice() {
        this.practice += 1;
    }
    
}
