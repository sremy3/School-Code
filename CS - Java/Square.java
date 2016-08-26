import java.util.Scanner;
import java.util.Locale;
import java.text.*;

/**
 * This class creates a Square polygon, finds its area, how much it costs, determines the price if it is in demand, and prints a string for the final object.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class Square extends Rectangle {
	
	private double sidelength1;
	String id;
    /**
     * Constructor for Square. Sets up the Polygon object.
     *
     * @param base, id. To set up the object id and size.
     */

	 public Square(double sidelength1, String id) {
		super(sidelength1,sidelength1,id);
		this.sidelength1=sidelength1;
		this.id=id;
	 }
	/**
     * Constructor for Square. Sets up the default Polygon object.
     *
     * 
     */
	public Square() {
		this(2,"None");
	}
    /**
     * Gets the string printout of the polygon you set up in the constructor.
     *
     * @return The string printout.
     */
	public String toString() {
		String a=("Square with base " + this.sidelength1 + " and id " + id);
		return a;
	}

}