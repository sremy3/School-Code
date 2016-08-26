
/** 
 * This class represents a truck that will load up Polygon objects. Has a capacity of 20.
 *
 * @author Aaron Friesen
 * @version 1.5
 */
public class PolyTruck {

    private final int TRUNK_CAPACITY = 20;
    private Polygon[] trunk;
    private int numPolys;
    
    /**
     * Constructor for polytruck. Initializes Polygon array.
     */
    public PolyTruck() {
        trunk = new Polygon[TRUNK_CAPACITY];
        numPolys = 0;
    }
    
    /**
     * Adds a polygon to the backing array if space is available.
     *
     * @param p The polygon to be added.
     */
    public void addPoly(Polygon p) {
        if (numPolys < TRUNK_CAPACITY) {
            trunk[numPolys++] = p;
        }
    }

    /**
     * Gets the total cost of all Polygon objects in the array by summing their getTotal() methods.
     *
     * @return The total cost of all polygons in this truck.
     */
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < numPolys; i++) {
            total += trunk[i].getTotal();
        }
        return total;
    }
    
    /**
     * This method tests whether the truck is full.
     *
     * @return True if the truck is full, false otherwise.
     */
    public boolean isFull() {
        return numPolys == TRUNK_CAPACITY;
    }

    /**
     * Returns the number of Polygons in the truck and each Polygon's toString().
     *
     * @return A formatted String representing the truck and all the Polygons in it.
     */
    public String toString() {
        String output = "Polytruck containing " + numPolys + " polygons:\n";
        for (int i = 0; i < numPolys; i++) {
            output += trunk[i] + "\n";
        }
        return output;
    }


}