import java.util.List;
import java.util.Scanner;


public class Driver {
	private static StringSearch ss = new StringSearch();
    @SuppressWarnings("resource")
	public static boolean continueOrNot() {
    	boolean continueOrNot = false;
    	System.out.print("Would you like to give another needle and haystack? [1 for yes, 2 for no]: ");
    	Scanner keyboard = new Scanner(System.in);
    	int answer = keyboard.nextInt();
    	System.out.println();
    	switch(answer) {
    	case 1:
    		continueOrNot = true;
    		break;
    	case 2:
    		break;
    	default:
    		System.out.println("Sorry that is not a choice.");
    		continueOrNot = continueOrNot();
    	}
    	return continueOrNot;
    }
	public static void switchMenu(String needle, String haystack, int algorithm) {
		long startTime = System.nanoTime();
    	long endTime;
		switch(algorithm) {
		case 1:
			List<Integer> bm = ss.boyerMoore(needle, haystack);
    		endTime = System.currentTimeMillis();
    		System.out.println("There is (are) " + bm.size()  + " match(es).");
    		System.out.println("The algorithm took: " + Math.abs(endTime - startTime) + " nanoseconds");
    		System.out.println();
			break;
		case 2:
			List<Integer> rk = ss.rabinKarp(needle, haystack);
    		endTime = System.currentTimeMillis();
    		System.out.println("There is (are) " + rk.size() + " match(es).");
    		System.out.println("The algorithm took: " + Math.abs(endTime - startTime) + " nanoseconds");
    		System.out.println();
			break;
		default:
			System.out.println("I'm sorry, that's not one of the choices. Try again.");
			System.out.println();
			System.out.print("Which algorithm would you like to run? [Boyer Moore = 1, Rabin Karp = 2]. Please insert 1 or 2: ");
			Scanner keyboard = new Scanner(System.in);
			algorithm = keyboard.nextInt();
			System.out.println();
			switchMenu(needle, haystack, algorithm);
			break;
		}
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		boolean keepGoing = true;
		do {
		    Scanner keyboard = new Scanner(System.in);
		    System.out.print("Insert the needle being searched for: ");
		    String needle = keyboard.nextLine();
		    System.out.println();
		    System.out.print("Insert the haystack being searched in: ");
		    String haystack = keyboard.nextLine();
		    System.out.println();
		    System.out.print("Which algorithm would you like to run? [Boyer Moore = 1, Rabin Karp = 2]. Please insert 1 or 2: ");
		    int algorithm = keyboard.nextInt();
		    System.out.println();
		    switchMenu(needle, haystack, algorithm);
		    keepGoing = continueOrNot();
		} while(keepGoing);
		System.out.println("Quitting the program.");
	}

}
