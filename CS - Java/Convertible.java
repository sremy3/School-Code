/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * The Convertible interface represents
 * an unit of measurement that has
 * @author Matt
 */
public interface Convertible {
    /**
     * The getConversionRate method returns the conversion rate form this unit
     * to meters
     * @return double rate- the rate from this unit to meters
     */
    double getConversionRate();
    /**
     * The convert to meters method converts
     * the an amount of this unit to meters
     * @param x the amount to convert
     * @return double amount - the amount after converting
     */
    double convertToMeters(double x);
    /**
     * The specialInformation method returns a fun fact about the unit
     * @return String - a fun fact about the unit
     */
    String specialInformation();
    /**
     * The getName method returns the name of the unit.  The name will be used
     * for identifying what type of Convertible it is.
     *
     * @return String fact -  a fun fact about the Convertible
     */
    String getName();
    /** the convertToDifferenceMeasurement method
     * converts a set amount of of this unit
     * to another unit already defined.
     * @param x - the amount to convert
     * @param rate - the rate of conversion of the other type
     * @return double amount - the converted amount.
     */
    double convertToDifferentMeasurement(double x, double rate);
}
