/**
 * This class creates the lease for the car.
 * 
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class Lease {

    private Car car;
    private Customer customer;
    /**
     * Sets up the constructor for lease by setting up the car and the customer.
     **@param a car and a customer.
     * 
     */
    public Lease(Car aCar, Customer aCustomer) {
        car = aCar;
        customer = aCustomer;
    }
    /**
     * Gets the rental company.
     *@return A car.
     */
    public Car getCar() {
        return car;
    }
    /**
     * Gets the daily rate for the car.
     *@return A double for the daily rate.
     */
    public double dailyRate() {
        return car.baseDailyRate() * (1.0 - customer.getDiscount());
    }
    /**
     * Makes a string for the lease.
     *@return A string with the car and the lease.
     */
    public String toString() {
        return car.toString() + " leased to " + customer;
    }
}
