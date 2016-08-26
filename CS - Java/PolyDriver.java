import java.util.Scanner;
import java.util.*;
import java.util.Random;

/**
 * This class prompt the user for input, picks a random Polygon class to be in demand.
 * 
 *
 * @author Stephanie Remy
 * @version 1.0
 */

public class PolyDriver {
    /**
     * Asks the user and gives the different options to add to the truck.
     *
     * @return The polygon type the user wants in a String.
     */
	public static String prompt() {
		System.out.println("");
		System.out.println("What would you like to put in?");
		System.out.println("");
		System.out.println("1. Default Square");
		System.out.println("2. Custom Square");
		System.out.println("3. Default Rectangle");
		System.out.println("4. Custom Rectangle");
		System.out.println("5. Default Triangle");
		System.out.println("6. Custom Triangle");
		System.out.println("7. Default Parallelogram");
		System.out.println("8. Custom Parallelogram");
		System.out.println("9. Default Hexagon");
		System.out.println("10. Custom Hexagon");
		System.out.println("11. Quit");
		System.out.println("");
		Scanner keyboard=new Scanner(System.in);
		String input= keyboard.nextLine();
		List<String> inputlist = new ArrayList<String>();
		inputlist.add("1");
		inputlist.add("2");
		inputlist.add("3");
		inputlist.add("4");
		inputlist.add("5");
		inputlist.add("6");
		inputlist.add("7");
		inputlist.add("8");
		inputlist.add("9");
		inputlist.add("10");
		inputlist.add("11");
		boolean test=inputlist.contains(input);
		while (test==false) {
			System.out.println("");
			System.out.println("I'm sorry that is not a valid answer. Please type in a number from the list.");
			System.out.println("");
			System.out.println("What would you like to put in?");
			System.out.println("");
			System.out.println("1. Default Square");
			System.out.println("2. Custom Square");
			System.out.println("3. Default Rectangle");
			System.out.println("4. Custom Rectangle");
			System.out.println("5. Default Triangle");
			System.out.println("6. Custom Triangle");
			System.out.println("7. Default Parallelogram");
			System.out.println("8. Custom Parallelogram");
			System.out.println("9. Default Hexagon");
			System.out.println("10. Custom Hexagon");
			System.out.println("11. Quit");
			System.out.println("");
			input= keyboard.nextLine();
			test=inputlist.contains(input);
		}
		return input;
	}
    /**
     * Randomly chooses one of the Polygon classes to be in demand and changes the boolean inDemand to true for that class.
     *
     */
	public static void whatisinDemand(){
		Random rand = new Random();
		int pickedNumber= rand.nextInt(7)+1;
		if (pickedNumber==1 || pickedNumber==2){ 
			System.out.println("Rectangles are in demand!");
			boolean z=Rectangle.inDemand();
		}
		if (pickedNumber==3 || pickedNumber==4){ 
			System.out.println("Triangles are in demand!");
			boolean z=Triangle.inDemand();
		}
		if (pickedNumber==5 || pickedNumber==6){ 
			System.out.println("Parallelograms are in demand!");
			boolean z=Parallelogram.inDemand();
		}
		if (pickedNumber==7 || pickedNumber==8){ 
			System.out.println("Hexagons are in demand!");
			boolean z=Hexagon.inDemand();
		}
	}
    /**
     * Takes the custom information for the Rectangle.
     *
     * @return The Rectangle object.
     */
	public static Polygon customReg() {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Please input the ID for your rectangle.");
		String id=keyboard.nextLine();
		System.out.println("Please input the first side length for your rectangle.");
		double sidelength1=keyboard.nextDouble();
		System.out.println("Please input the second side length for your rectangle.");
		double sidelength2=keyboard.nextDouble();
		Rectangle trying = new Rectangle(sidelength1,sidelength2,id);
		return trying;
	}
    /**
     * Takes the custom information for the Square.
     *
     * @return The Square object.
     */
	public static Polygon customSq() {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Please input the ID for your square.");
		String id=keyboard.nextLine();
		System.out.println("Please input the side length for your square.");
		double sidelength1=keyboard.nextDouble();
		Square trying = new Square(sidelength1,id);
		return trying;
	}
    /**
     * Takes the custom information for the Triangle.
     *
     * @return The Triange object.
     */
	public static Polygon customTriang() {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Please input the ID for your triangle.");
		String id=keyboard.nextLine();
		System.out.println("Please input the base for your triangle.");
		double base=keyboard.nextDouble();
		System.out.println("Please input the height for your triangle.");
		double height=keyboard.nextDouble();
		Triangle trying = new Triangle(base,height,id);
		return trying;
	}
    /**
     * Takes the custom information for the Parallelogram.
     *
     * @return The Parallelogram object.
     */
	public static Polygon customPara() {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Please input the ID for your parallelogram.");
		String id=keyboard.nextLine();
		System.out.println("Please input the side length for any base of your parallelogram.");
		double base=keyboard.nextDouble();
		System.out.println("Please input the height for your parallelogram.");
		double height=keyboard.nextDouble();
		Parallelogram trying = new Parallelogram(base,height,id);
		return trying;
	}
    /**
     * Takes the custom information for the Hexagon.
     *
     * @return The Hexagon object.
     */
	public static Polygon customHex() {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Please input the ID for your hexagon.");
		String id=keyboard.nextLine();
		System.out.println("Please input the side length for the bases for your hexagon.");
		double base=keyboard.nextDouble();
		Hexagon trying = new Hexagon(base,id);
		return trying;
	}
	public static void main (String[] args) {
		System.out.println("");
		System.out.println("Time to load up the truck!");
		PolyTruck truck = new PolyTruck();
		String wow=prompt();
		while (wow.contains("11")==false && truck.isFull()==false){
		if (wow.contains("1")==true) {
			Square sq = new Square();
			truck.addPoly(sq);
		}
		if (wow.contains("2")==true) {
			Polygon wowz=customSq();
			truck.addPoly(wowz);
		}
		if (wow.contains("3")==true) {
				Rectangle rec = new Rectangle();
				truck.addPoly(rec);
			}
			if (wow.contains("4")==true) {
				Polygon wowz=customReg();
				truck.addPoly(wowz);
			}
			if (wow.contains("5")==true) {
				Triangle triang = new Triangle();
				truck.addPoly(triang);
			}
			if (wow.contains("6")==true) {
				Polygon wowz=customTriang();
				truck.addPoly(wowz);
			}
			if (wow.contains("7")==true) {
				Parallelogram pent = new Parallelogram();
				truck.addPoly(pent);
			}
			if (wow.contains("8")==true) {
				Polygon wowz=customPara();
				truck.addPoly(wowz);
			}
			if (wow.contains("9")==true) {
				Hexagon hex = new Hexagon();
				truck.addPoly(hex);
			}
			if (wow.contains("10")==true) {
				Polygon wowz=customHex();
				truck.addPoly(wowz);
			}
			System.out.println("");
			System.out.println(truck);
			wow=prompt();
		} 
		System.out.println("");
		whatisinDemand();
		System.out.println("");
		System.out.println("The truck arrived at the destination!");
		System.out.println("");
		System.out.println(truck);
		System.out.println("");
		double testing= truck.getTotal();
		System.out.println("");
		System.out.printf("The truck made $%.2f this trip. %n",testing);
	}
}