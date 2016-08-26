/**
 * This class is the parent class of all Polygon objects. 
 * You will be subclassing this in all of your non-driver classes.
 *
 * @author Aaron Friesen
 * @version 1.5
 */
public abstract class Polygon {

    protected String id;
    
    /**
     * Constructor for polygon.
     * 
     * @param id The ID of this polygon.
     */
    public Polygon(String id) {
        this.id = id;
    }
    
    /**
     * This method gets the area of a specific polygon. Must be overridden by children!
     *
     * @return The area of this polygon
     */
    public abstract double getArea();
    
    
    
    /**
     * This method gets the money total of a polygon. Must be overridden by children!
     * If the polygon is in demand, it costs twice its area - otherwise, it costs its area.
     *
     * @return The total cost of this polygon
     */
    public abstract double getTotal();
    
    
    /**
     * Basic toString of the polygon. Should be overridden - you should never see this printed out.
     *
     * @return Base polygon with [ID].
     */
    public String toString() {
        //Override this in child classes!
        return "Base Polygon with id = " + id;    
    }
    



}