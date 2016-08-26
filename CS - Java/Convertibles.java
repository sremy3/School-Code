/**
 * This abstract class implements convertible and
 * creates a template for the convertible classes.
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public abstract class Convertibles implements Convertible {

    protected String name;
    protected double x;
    protected double conversionRate;
    protected String fact;
    /**
     * Constructor for Convertibles. Creates a 
     * template for the Convertibles subclasses.
     *
     * @param double rate. The rate of the unit.
     * @param String name. The name of the unit.
     * @param String fact. The fact of the unit.
     */
    public Convertibles(double rate , String name , String fact) {
        name = name;
        x = x;
        fact = fact;
        conversionRate = conversionRate;
    }
    /**
     * Constructor for Convertibles. Creates a Convertible.
     *
     *
     * @param String name. The name of the unit.
     *
     */
    public Convertibles(String name) {
        name = name;
        x = x;
        fact = fact;
        conversionRate = conversionRate;
    }
    /**
     * The getConversionRate method returns the conversion rate from miles
     * to meters
     * @return double rate- the rate from miles to meters
     */
    public abstract double getConversionRate();
    /**
     * The convert to meters method converts the an amount of miles to meters
     * @param x the amount to convert
     * @return double amount - the amount after converting
     */
    public abstract double convertToMeters(double x);
    /**
     * The specialInformation method returns a fun fact about miles
     * @return String - a fun fact about the unit
     */
    public abstract String specialInformation();
    /**
     * The getName method returns the name of the unit.  The name will be used
     * for identifying what type of Convertible it is.
     *
     * @return String- the name of the unit
     */
    public abstract String getName();
    /**
     * the convertToDifferenceMeasurement method converts a set amount of miles
     * to another unit already defined.
     * @param x - the amount to convert
     * @param rate - the rate of conversion of the other type
     * @return double amount - the converted amount.
     */
    public abstract double convertToDifferentMeasurement(double x, double rate);
}
