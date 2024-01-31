package mainApp;

public class InvalidLevelFormatException extends Exception {
    private int distanceOff;
    
    public void distanceOff(int distanceOff) {
    	this.distanceOff = distanceOff;
    }
    public InvalidLevelFormatException(int distance) {
    	this.distanceOff(distance);
    }
    public int distanceOff() {
    	return distanceOff;
    }
    
}