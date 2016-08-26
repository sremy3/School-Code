/**
 * This class creates a user created convertible.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class UserCreatedConvertible extends Convertibles
                                    implements Convertible {

    private String name;
    private double x;
    private double conversionRate;
    private String fact;
    /**
     * Constructor for UserCreatedConvertible. Creates
     * a User Created Convertible.
     *
     * @param double rate. The rate of the unit.
     * @param String name. The name of the unit.
     * @param String fact. The fact of the unit.
     */
    public UserCreatedConvertible(double rate , String name , String fact) {
        super(rate , name , fact);
        this.name = name;
        this.x = x;
        this.fact = fact;
    this.conversionRate = rate;
    }
    /**
     * The getConversionRate method returns the conversion
     * rate from user created convertibles
     * to meters
     * @return double rate- the rate from user created convertibles to meters
     */
    public double getConversionRate() {
        return conversionRate;
    }
    /**
     * The convert to meters method converts the an amount of
     * user created convertibles to meters
     * @param x the amount to convert
     * @return double amount - the amount after converting
     */
    public double convertToMeters(double x) {
        double amount = conversionRate * x;
        return amount;
    }
    /**
     * The specialInformation method returns a
     * fun fact about user created convertibles
     * @return String - a fun fact about the unit
     */
    public String specialInformation() {
        return fact;
    }
    /**
     * The getName method returns the name of the unit.  The name will be used
     * for identifying what type of Convertible it is.
     *
     * @return String- the name of the unit
     */
    public String getName() {
        return name;
    }
    /**
     * the convertToDifferenceMeasurement method converts
     * a set amount of user created convertibles
     * to another unit already defined.
     * @param x - the amount to convert
     * @param rate - the rate of conversion of the other type
     * @return double amount - the converted amount.
     */
    public double convertToDifferentMeasurement(double x , double rate) {
        double amount = (x * conversionRate) / rate;
        return amount;
    }
    /**
     * the toString method returns the convertible in a
     * String format.
     *
     *
     * @return String outputs - the name of the convertible.
     */
    public String toString() {
        String outputs = this.name;
        return outputs;
    }

}
