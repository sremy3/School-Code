
import java.util.Scanner;

public class Driver {
	public static void switchMenu() {
    	int choice;
    	LinkedListInterface<Integer> list = new DoublyLinkedList<Integer>();
    	boolean keepGoing = true;
    	do {
        	System.out.println();
    		choice = choiceMenu();
    		switch (choice) {
    		    case 1:
    		    	System.out.print("What number would you like to add? ");
    		    	Scanner keyboard = new Scanner(System.in);
    		    	int number = keyboard.nextInt();
    		    	System.out.print("Where would you like to add (Front or Back)? ");
    		    	Scanner a = new Scanner(System.in);
    		    	String frontOrBack = a.nextLine();
    		    	if (frontOrBack.equals("Front")) {
    		    		boolean added = list.add(0, number);
    		    		System.out.println(number + " was added to the list: " + added);
    		    	}
    		    	if (frontOrBack.equals("Back")) {
    		    		int size = list.size();
    		    		boolean added = list.add(size, number);
    		    		System.out.println(number + " was added to the list: " + added);
    		    	}
    		    	System.out.println();
    		    	break;
    		    case 2:
    		    	System.out.print("Where would you like to remove (Front or Back)? ");
    		    	keyboard = new Scanner(System.in);
    		    	frontOrBack = keyboard.nextLine();
    		    	if (frontOrBack.equals("Front")) {
    		    		try {
    		    		    int removed = list.remove(0);
    		    		    System.out.println(removed + " was removed from the list.");
    		    		} catch (Exception e) {
    		    			System.out.println("Can't remove on empty list.");
    		    		}
    		    	}
    		    	if (frontOrBack.equals("Back")) {
    		    		int size = list.size();
    		    		int removed = list.remove(size - 1);
    		    		System.out.println(removed + " was removed from the list.");
    		    	}
    		    	System.out.println();
    		    	break;
    		    case 3:
    		    	list.reverseList();
    		    	System.out.println();
    		    	break;
    		    case 4:
    		    	if (list.size() > 0) {
    		    	    System.out.print("List: ");
				        for (int items: list) {
					        System.out.print(items + " ");
				        }
				        System.out.println();
    		    	} else {
    		    		System.out.println("The list is empty.");
    		    	}
				    break;
    		    case 5:
    		    	System.out.println("Quitting the program.");
    		    	keepGoing = false;
    		    	break;
    		    default:
    		    	System.out.println("That's not a valid number. Try again.");
    		    	System.out.println();
    		}
    	} while (keepGoing);
    	
	}
    @SuppressWarnings("resource")
	public static int choiceMenu() {
    	System.out.println("1. Add - Add a node to the list");
    	System.out.println("2. Remove - Remove a node from the list");
    	System.out.println("3. Reverse - Reverse the list");
    	System.out.println("4. List - Prints the contents of the list");
    	System.out.println("5. Exit - Quits the program");
    	System.out.println("");
    	System.out.print("Enter a command: ");
    	Scanner keyboard = new Scanner(System.in);
    	int choice = keyboard.nextInt();
    	return choice;
    }
    public static void main(String[] args) {
        switchMenu();
    }
}
