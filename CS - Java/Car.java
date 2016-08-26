public abstract class Car {

/**
 * This class prompt sets up the daily rate, the capacity, and gets the license plate of a Dodge Caravan.
 * 
 *
 * @author Stephanie Remy
 * @version 1.0
 */

    protected String licensePlate;
    /**
     * Sets up the constructor for DodgeCaravan with the license plate, daily rate, and the capacity.
     *
     * 
     */
    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    /**
     * Sets up the daily rate for the DodgeCaravan.
     *@return A double with the daily rate.
     */
    public abstract double baseDailyRate();
    /**
     *Sets up the capacity for the DodgeCaravan.
     *@return An integer for the passengerCapacity.
     */
    public abstract int passengerCapacity();
    /**
     * Sets up the string output for the DodgeCaravan.
     *@return A string.
     */
    public abstract String toString();
}
