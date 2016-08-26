/**
 * This class prompt sets up the customer and determines if there is a discount.
 * 
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class Customer {

    private String name;
    private double discount;
    /**
     * Sets up the constructor for Customer with the name and makes a discount of default to be zero.
     **@param a string for the name of the customer.
     * 
     */
    public Customer(String aName) {
        name = aName;
        // By default, customers get no discount
        discount = 0.0;
    }
    /**
     * Gets the name for the customer.
     *@return A string with the name of the customer.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the amount for the discount for the customer.
     *@return A string with the name of the customer.
     */
    public double getDiscount() {
        return discount;
    }
    /**
     * Sets up the discount for the customer.
     **@param a double for the discount rate.
     */
    public void setDiscount(double aDiscount) {
        discount = aDiscount;
    }
    /**
     * Makes the name for the customer be a string.
     *@return A string with the name of the customer.
     */
    public String toString() {
        return getName();
    }
}
