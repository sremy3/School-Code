/**
 * This class prompt sets up the daily rate, the capacity, and gets the licenseplate of a Dodge Caravan.
 * 
 *
 * @author Stephanie Remy
 * @version 1.0
 */

public class DodgeCaravan extends Car{

    private String licensePlate;
    private double baseDailyRate;
    private int passengerCapacity;
    /**
     * Sets up the constructor for DodgeCaravan with the license plate, daily rate, and the capacity.
     *@param a string for the license plate.
     * 
     */
    public DodgeCaravan(String licensePlate) {
        super(licensePlate);
        baseDailyRate = 30.00;
        passengerCapacity = 8;
    }
    /**
     * Sets up the daily rate for the DodgeCaravan.
     *@return A double with the daily rate.
     */
    public double baseDailyRate() {
        return baseDailyRate;
    }
    /**
     *Sets up the capacity for the DodgeCaravan.
     *@return An integer for the passengerCapacity.
     */
    public int passengerCapacity() {
        return passengerCapacity;
    }
    /**
     * Sets up the string output for the DodgeCaravan.
     *@return A string.
     */
    public String toString() {
        return "Dodge Caravan with license plate " + licensePlate;
    }
}
