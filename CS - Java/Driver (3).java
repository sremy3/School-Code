
import java.util.Scanner;
import java.util.Random;
public class Driver {
	private static long bubbleTime;
	private static long insertTime;
	private static long selectTime;
	private static long quickTime;
	private static long mergeTime;
	private static long radixTime;
    /**
     * Calls the methods in sorting to sort.
     * @param size - the size of the array
     * @return boolean - whether to rerun the program or not;
     */
	public static boolean resultsPrinter(int size) {
		if (size == 0) {
			return false;
		} else {
			//Create array of random numbers and print it
		    Integer[] unsortedArray = new Integer[size];
		    Random generator = new Random();
		    for (int i = 0; i < size; i++) {
		    	unsortedArray[i] = generator.nextInt();
		    }
		    System.out.println();
		    System.out.print("The unsorted array is: ");
		    for (int i = 0; i < size; i++) {
		    	System.out.print(unsortedArray[i]);
		    	if (i != (size - 1)) {
		    		System.out.print(", ");
		    	}
		    }
		    System.out.println();
		    SortingInterface sort = new Sorting();
		    //Run sorts: bubble, insertion, selection, quick, merge, and radix sort and capture the times
		    for (int i = 0; i < 5; i++) {
		    	long startTime = System.nanoTime();
		    	long endTime;
		    	switch(i) {
		    	case 0:
		    		sort.bubblesort(unsortedArray);
		    		endTime = System.currentTimeMillis();
		    		bubbleTime = Math.abs(endTime - startTime);
		    		break;
		    	case 1:
		    		sort.insertionsort(unsortedArray);
		    		endTime = System.currentTimeMillis();
		    		insertTime = Math.abs(endTime - startTime);
		    	    break;
		    	case 2:
		    		sort.selectionsort(unsortedArray);
		    		endTime = System.currentTimeMillis();
		    		selectTime = Math.abs(endTime - startTime);
		    		break;
		    	case 3:
		    		sort.quicksort(unsortedArray, generator);
		    		endTime = System.currentTimeMillis();
		    		quickTime = Math.abs(endTime - startTime);
		    		break;
		    	case 4:
		    		sort.mergesort(unsortedArray);
		    		endTime = System.currentTimeMillis();
		    		mergeTime = Math.abs(endTime - startTime);
		    		break;
		    	default:
		    		break;
		    	}
		    }
		    int[] intList = new int[unsortedArray.length];
		    for (int v = 0; v < unsortedArray.length; v++) {
		    	int value = unsortedArray[v].intValue();
		    	intList[v] = value;
		    }
		    long startingTime = System.nanoTime();
		    sort.radixsort(intList);
		    long endTime = System.currentTimeMillis();
		    radixTime = Math.abs(endTime - startingTime);
		    System.out.print("The sorted array is: ");
		    for (int j = 0; j < size; j++) {
		    	System.out.print(unsortedArray[j]);
		    	if (j != (size - 1)) {
		    		System.out.print(", ");
		    	}
		    }
		    System.out.println();
		    System.out.println();
		    System.out.println("It took bubble sort " + bubbleTime + " seconds.");
		    System.out.println("It took insertion sort " + insertTime + " seconds.");
		    System.out.println("It took selection sort " + selectTime + " seconds.");
		    System.out.println("It took quick sort " + quickTime + " seconds.");
		    System.out.println("It took merge sort " + mergeTime + " seconds.");
		    System.out.println("It took radix sort " + radixTime + " seconds.");
		    return true;
		}
	}
	/**
	 * The main method that runs the program.
	 * @param args
	 */
	public static void main(String[] args) {
		boolean keepGoing = true;
		do {
		    System.out.print("Please enter the size of the array you would like to sort or enter 0 to exit: ");
            @SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);
            int arraySize = keyboard.nextInt();
            keepGoing = resultsPrinter(arraySize);
            System.out.println();
		} while (keepGoing);
		System.out.println("Exiting the program.");
	}

}
