/**
 * This class creates a Inch convertible.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class Inch extends Convertibles implements Convertible {

    private String name;
    private double x;
    private double conversionRate;
    /**
     * Constructor for Inch. Creates a Inch Convertible.
     *
     * @param double rate. The rate of the unit.
     * @param String name. The name of the unit.
     * @param String fact. The fact of the unit.
    */
    public Inch(double rate , String name , String fact) {
        super(rate , name , fact);
        this.x = x;
        this.fact = fact;
        this.conversionRate = .0254;
    }
    /**
     * Constructor for Inch. Creates a Inch Convertible.
     *
     *
     * @param String name. The name of the unit.
     *
     */
    public Inch(String name) {
        super(name);
        x = x;
        fact = fact;
        conversionRate = .0254;
    }
    /**
     * The getConversionRate method returns the conversion rate from inchs
     * to meters
     * @return double rate- the rate from inchs to meters
     */
    public double getConversionRate() {
        return conversionRate;
    }
    /**
     * The convert to meters method converts the an amount of inchs to meters
     * @param x the amount to convert
     * @return double amount - the amount after converting
     */
    public double convertToMeters(double x) {
        double amount = conversionRate * x;
        return amount;
    }
    /**
     * The specialInformation method returns a fun fact about inchs
     * @return String - a fun fact about the unit
     */
    public String specialInformation() {
        String fact = "At first an inch was the width of a man's thumb.";
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
     * the convertToDifferenceMeasurement method converts a set amount of inchs
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
