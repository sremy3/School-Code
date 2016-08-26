import java.util.List;
import java.util.Scanner;
/**
 * A public class that drives the whole program for the BST and User.
 * @author Stephanie Remy
 *
 */
public class Driver {
    /**
     * A public static class that prints out the choices for the person
     * running the program. It also returns the person's choice in the
     * form of a string.
     * @return String The person's choice from the menu.
     */
	public static String choiceMenu() {
		System.out.println("Your choices for commands are: add, remove, find, list, debug, and exit");
		System.out.println();
		System.out.print("Please enter a command:  ");
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		String choice = keyboard.nextLine();
		return choice;
	}
	/**
	 * The switch menu takes in the person's choice from the choiceMenu method and
	 * chooses the case that matches the choice. Basically runs the program.
	 */
	public static void switchMenu() {
		boolean keepGoing = true;
		BSTInterface<User> list = new BST<User>();
		do {
			String choice = choiceMenu();
			System.out.println("");
			switch(choice) {
			   case "add":
				   System.out.print("Please enter a username: ");
				   Scanner keyboard = new Scanner(System.in);
				   String username = keyboard.nextLine();
				   System.out.println("");
				   System.out.print("Please enter a name: ");
				   String name = keyboard.nextLine();
				   System.out.println();
				   if (!list.contains(new User(name, username))) {
				       list.add(new User(name, username));
				   }
				   break;
			   case "remove":
				   System.out.print("Please enter a username you would like to remove: ");
				   keyboard = new Scanner(System.in);
				   String username2 = keyboard.nextLine();
				   String name2 = "aName";
				   System.out.println("");
				   if (!list.contains(new User(name2, username2))) {
				       System.out.println("No user has that username!");
				       System.out.println("");
				   } else {
					   User removedUser = list.remove(new User(name2, username2));
					   System.out.println("Remove was successful! Removed: " + removedUser);
					   System.out.println("");
				   }
				   break;
			   case "find":
				   System.out.print("Please enter a username you would like to find: ");
				   keyboard = new Scanner(System.in);
				   String username3 = keyboard.nextLine();
				   System.out.println("");
				   String name3 = "aName";
				   User theUser = list.get(new User(name3, username3));
				   try {
				       String theName = theUser.getName();
				       System.out.println("The name for that username is: " + theName);
				       System.out.println();
				   } catch (NullPointerException e) {
					   System.out.println("There is no user with that username.");
					   System.out.println();
				   }
				   break;
			   case "list":
				   List<User> theList = list.inOrder();
				   int size = list.size();
				   if (size == 0) {
					   System.out.println("There are no users!");
					   System.out.println();
					   break;
				   }
				   System.out.println("List of current users: ");
				   System.out.println();
				   for (int i = 0; i < size; i++) {
					   User nextUser = theList.get(i);
					   System.out.print(nextUser);
					   if (i < (size - 1)) {
						   System.out.print(", ");
					   }
				   }
				   System.out.println();
				   System.out.println(" ");
				   break;
			   case "debug":
				   System.out.println("String representation of this tree: ");
				   String theString = list.toString();
				   System.out.println(theString);
				   System.out.println();
				   break;
			   case "exit":
				   System.out.println("Quitting the program.");
				   keepGoing = false;
				   break;
			   default:
				   System.out.println("Sorry that is not a proper command. Please try again. (All commands are in lower case)");
				   System.out.println("");
			}
		} while (keepGoing);
	}
	/**
	 * The main method that basically calls the switchMenu method.
	 * @param args
	 */
    public static void main(String[] args) {
    	switchMenu();
    }
}
