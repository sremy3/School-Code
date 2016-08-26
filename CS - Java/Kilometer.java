/**
 * This class creates a Kilometer convertible.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class Kilometer extends Convertibles implements Convertible {

    private String name;
    private double x;
    private double conversionRate;
    private String fact;
    /**
     * Constructor for Kilometer. Creates a Kilometer Convertible.
     *
     * @param double rate. The rate of the unit.
     * @param String name. The name of the unit.
     * @param String fact. The fact of the unit.
    */
    public Kilometer(double rate , String name , String fact) {
        super(rate , name , fact);
        this.x = x;
        this.fact = fact;
        this.conversionRate = 1000;
    }
    /**
     * Constructor for Kilometer. Creates a Kilometer Convertible.
     *
     *
     * @param String name. The name of the unit.
     *
     */
    public Kilometer(String name) {
    super(name);
        x = x;
        fact = fact;
        conversionRate = 1000;
    }
    /**
     * The getConversionRate method returns the conversion rate from kilometers
     * to meters
     * @return double rate- the rate from kilometers to meters
     */
    public double getConversionRate() {
        return conversionRate;
    }
    /**
     * The convert to meters method converts
     * the an amount of kilometers to meters
     * @param x the amount to convert
     * @return double amount - the amount after converting
     */
    public double convertToMeters(double x) {
        double amount = conversionRate * x;
        return amount;
    }
    /**
     * The specialInformation method returns a fun fact about kilometers
     * @return String - a fun fact about the unit
     */
    public String specialInformation() {
        String fact = "The word kilo is Greek and comes from the word khilioi.";
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
    * the convertToDifferenceMeasurement method
    * converts a set amount of kilometers
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
