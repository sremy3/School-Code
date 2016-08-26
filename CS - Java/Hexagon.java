import java.util.Scanner;
import java.util.Locale;
import java.text.*;
/**
 * This class creates a Hexagon polygon, finds its area, how much it costs, determines the price if it is in demand, and prints a string for the final object.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class Hexagon extends Polygon {
	
	private double base;
	String id;
	static boolean inDemand=false;
    /**
     * Constructor for Hexagon. Sets up the Polygon object.
     *
     * @param base, id. To set up the object id and size.
     */

	 public Hexagon(double base, String id) {
		super (id);
		this.base=base;
		this.id=id;
	 }
	/**
     * Constructor for Hexagon. Sets up the default Polygon object.
     *
     * 
     */
	public Hexagon() {
		this(5,"None");
	}
    /**
     * Gets the area of the polygon you set up in the constructor.
     *
     * @return The area.
     */
	public double getArea() {
		double area = (3*(Math.sqrt(3))*((this.base)*(this.base)))/2;
		return area;
	}
    /**
     * Gets the string printout of the polygon you set up in the constructor.
     *
     * @return The string printout.
     */
	public String toString() {
		String a=("Hexagon with base " + this.base + " and id " + id);
		return a;
	}
    /**
     * Gets the total cost of the polygon you set up in the constructor.
     *
     * @return The total cost.
     */
	public double getTotal() {
		double finalarea;
		if (inDemand==true) {
			finalarea=2*(getArea());
		}
		else
			finalarea=getArea();
		return finalarea;
	}
    /**
     * Changes inDemand to true if called.
     *
     * @return The boolean inDemand.
     */
	public static boolean inDemand(){
		inDemand=true;
		return inDemand;
	}
}