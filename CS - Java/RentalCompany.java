import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * This class creates the rental company with the cars.
 * 
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class RentalCompany {

    private String name;
    private List<Car> availableCars;
    private List<Lease> leases;
    /**
     * Sets up the constructor for the rental company with the name, and the kinds of cars in inventory.
     **@param a string for the name and the cars in inventory.
     * 
     */
    public RentalCompany(String aName, Car ... initialInventory) {
        name = aName;
        availableCars = new ArrayList<Car>();
        availableCars.addAll(Arrays.asList(initialInventory));
        leases = new ArrayList<Lease>();
    }
    /**
     * Gets the name for the rental company.
     *@return A string with the name of the company.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the list of available cars.
     *@return A list of available cars.
     */
    public List<Car> getAvailableCars() {
        return availableCars;
    }

    /**
     * Gets the list of leases.
     *@return A list of leases.
     */
    public List<Lease> getLeases() {
        return leases;
    }
    /**
     * Checks to see how many cars are available.
     *@return a boolean that says if the cars are available.
     */
    public boolean hasCarAvailable(int numPassengers) {
        return availableCars(numPassengers).size() > 0;
    }

    /**
     * Assumes #isCarAvailable returns true, otherwise behaviour is
     * undefined.
	 *@return an available car.
     */
    public Car nextAvailableCar(int numPassengers) {
        return availableCars(numPassengers).get(0);
    }
    /**
     * Creates a list of the available cars.
     *@return A big enough car for the number of passengers.
     */
    public List<Car> availableCars(int numPassengers) {
        List<Car> bigEnoughs = new ArrayList<Car>();
        for (Car car: availableCars) {
            if (car.passengerCapacity() >= numPassengers) {
                bigEnoughs.add(car);
            }
        }
        return bigEnoughs;
    }

    /**
     * Leases a car by removing it from the available list and adding
     * a lease to the lease list.  Assumes car is available.
	 *@return a lease for a car.
     */
    public Lease lease(Car car, Customer customer) {
        availableCars.remove(car);
        Lease lease = new Lease(car, customer);
        leases.add(lease);
        return lease;
    }
    /**
     * Returns the car to the list of availiable cars.
     *
     */
    public void returnCar(Lease lease) {
        availableCars.add(lease.getCar());
        leases.remove(lease);
    }
}
