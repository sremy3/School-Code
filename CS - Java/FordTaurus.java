/**
 * This class creates a Ford Taurus car.
 * 
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class FordTaurus extends Car{

    private String licensePlate;
    private double baseDailyRate;
    private int passengerCapacity;
    /**
     * Sets up the constructor for car and gets a license plate for the car,, the daily rate and the passenger capacity.
     **@param string for the license plate.
     * 
     */
    public FordTaurus(String licensePlate) {
        super(licensePlate);
        baseDailyRate = 30.00;
        passengerCapacity = 4;
    }
    /**
     * Gets the daily rate for the Ford Taurus car.
     *@return A double with the daily rate.
     */
    public double baseDailyRate() {
        return baseDailyRate;
    }
    /**
     * Gets passenger capacity for the car.
     *@return an integer with the passenger capacity.
     */
    public int passengerCapacity() {
        return passengerCapacity;
    }
    /**
     * Creates a string with the rental car.
     *@return A string with the plate of the rental car.
     */
    public String toString() {
        return "Ford Taurus with license plate " + licensePlate;
    }
}
