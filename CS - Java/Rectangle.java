import java.util.Scanner;
import java.util.Locale;
import java.text.*;

/**
 * This class creates a Rectangle polygon, finds its area, how much it costs, determines the price if it is in demand, and prints a string for the final object.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class Rectangle extends Polygon {
	
	private double sidelength1;
	private double sidelength2;
	String id;
	static boolean inDemand=false;
    /**
     * Constructor for Rectangle. Sets up the Polygon object.
     *
     * @param side1,side2, id. To set up the object id and size.
     */

	 public Rectangle(double sidelength1, double sidelength2, String id) {
		super (id);
		this.sidelength1=sidelength1;
		this.sidelength2=sidelength2;
		this.id=id;
	 }
	/**
     * Constructor for Rectangle. Sets up the default Polygon object.
     *
     * 
     */
	public Rectangle() {
		this(5,6,"None");
	}
    /**
     * Gets the area of the polygon you set up in the constructor.
     *
     * @return The area.
     */
	public double getArea() {
		double area = (this.sidelength1*this.sidelength2);
		return area;
	}
    /**
     * Gets the string printout of the polygon you set up in the constructor.
     *
     * @return The string printout.
     */
	public String toString() {
		String a=("Rectangle with side lengths " + this.sidelength1 + " and " + this.sidelength2 + " and id " + id);
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