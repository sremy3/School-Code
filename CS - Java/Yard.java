/**
 * This class creates a Yard convertible.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class Yard extends Convertibles implements Convertible {

    private String name;
    private double x;
    private double conversionRate;
    private String fact;

    /**
     * Constructor for Yard. Creates a Yard Convertible.
     *
     * @param double rate. The rate of the unit.
     * @param String name. The name of the unit.
     * @param String fact. The fact of the unit.
     */
    public Yard(double rate , String name , String fact) {
        super(rate , name , fact);
        this.x = x;
        this.fact = fact;
        this.conversionRate = .9144;
    }
    /**
     * Constructor for Yard. Creates a Yard Convertible.
     *
     *
     * @param String name. The name of the unit.
     *
     */
    public Yard(String name) {
        super(name);
        x = x;
        fact = fact;
        conversionRate = .9144;
    }
    /**
     * The getConversionRate method returns the conversion rate from yards
     * to meters
     * @return double rate- the rate from yards to meters
     */
    public double getConversionRate() {
        return conversionRate;
    }
    /**
     * The convert to meters method converts the an amount of yards to meters
     * @param x the amount to convert
     * @return double amount - the amount after converting
     */
    public double convertToMeters(double x) {
        double amount = conversionRate * x;
        return amount;
    }
    /**
     * The specialInformation method returns a fun fact about yards
     * @return String - a fun fact about the unit
     */
    public String specialInformation() {
        String fact = "King Henry's nose to his thumb was a yard.";
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
     * the convertToDifferenceMeasurement method converts a set amount of yards
     * to another unit already defined.
     * @param x - the amount to convert
     * @param rate - the rate of conversion of the other type
     * @return double amount - the converted amount.
     */
    public double convertToDifferentMeasurement(double x, double rate) {
        double amount = (x * conversionRate) / rate;
        return amount;
    }
}
