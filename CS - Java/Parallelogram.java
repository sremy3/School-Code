import java.util.Scanner;
import java.util.Locale;
import java.text.*;
/**
 * This class creates a Parallelogram polygon, finds its area, how much it costs, determines the price if it is in demand, and prints a string for the final object.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class Parallelogram extends Polygon {
	
	private double base;
	private double height;
	String id;
	static boolean inDemand=false;
    /**
     * Constructor for Parallelogram. Sets up the Polygon object.
     *
     * @param base, height, id. To set up the object id and size.
     */

	 public Parallelogram(double base, double height, String id) {
		super (id);
		this.base=base;
		this.height=height;
		this.id=id;
	 }
	/**
     * Constructor for Parallelogram. Sets up the default Polygon object.
     *
     * 
     */
	public Parallelogram() {
		this(5,5,"None");
	}
    /**
     * Gets the area of the polygon you set up in the constructor.
     *
     * @return The area.
     */
	 
	public double getArea() {
		double area= (this.base)*(this.height);
		return area;
	}
    /**
     * Gets the string printout of the polygon you set up in the constructor.
     *
     * @return The string printout.
     */
	public String toString() {
		String a=("Parallelogram with base " + this.base + ", with height "+ this.height +", and id " + id);
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