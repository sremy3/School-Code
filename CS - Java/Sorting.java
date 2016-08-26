import java.util.Queue;
import java.util.Random;
import java.util.LinkedList;
import java.util.HashMap;

public class Sorting implements SortingInterface {
	
	@Override
	public <T extends Comparable<T>> void bubblesort(T[] arr) {
		int size = arr.length;
		int i = size;
		boolean keepGoing = true;
		do {
			for (int j = 0; j < size; j++) {
	    		if (j < (size - 1)) {
			        T left = arr[j];
	                T right = arr[j + 1];
	                if (left.compareTo(right) > 0) {
		                arr[j] = right;
		                arr[j + 1] = left;
		                keepGoing = true;
	                }
	    		}
			}
			i--;
		} while ((i > 0) && keepGoing);
	}
	@Override
	public <T extends Comparable<T>> void insertionsort(T[] arr) {
		int size = arr.length;
		for (int i = 1; i < size; i++) {
			T current = arr[i];
			boolean needsWork = true;
    		for (int holder = (i - 1); needsWork && holder >= 0; holder--) {
    			if (current.compareTo(arr[holder]) < 0) {
    				T old = arr[holder];
    				arr[holder] = current;
    				arr[holder + 1] = old;
    			} else if (current.compareTo(arr[holder]) > 0) {
    				needsWork = false;
    			}
    		}
		}
	}
	@Override
	public <T extends Comparable<T>> void selectionsort(T[] arr) {
		int size = arr.length;
		for (int j = 0; j < size; j++) {
			T minimum = arr[j];
			int minPosition = j;
		    for (int i = j; i < size; i++) {
			    if (arr[i].compareTo(minimum) < 0) {
			        minimum = arr[i];
			        minPosition = i;
			    }
		    }
		    T old = arr[j];
		    arr[j] = minimum;
		    arr[minPosition] = old;
		}
	}
	@Override
	public <T extends Comparable<T>> void quicksort(T[] arr, Random r) {
		int first = 0;
		int last = arr.length - 1;
		quicksortHelper(arr, first, last, r);
	}
	/**
	 * Helper method for Quicksort. Basically runs the sorting.
	 * @param arr -the array being sorted
	 * @param first - the first index
	 * @param last - the last index
	 * @param r - the random object used to get random pivot
	 */
    private <T extends Comparable<T>> void quicksortHelper(T[] arr, int first, int last, Random r)
    {
    	int index = partition(arr, first, last, r);
        if (first < index - 1) {
              quicksortHelper(arr, first, index - 1, r);
        }
        if (index < last) {
              quicksortHelper(arr, index, last, r);
        }
    }
    /**
     * Helper method for Quicksort. Used to partition the array into parts and actually sort.
     * @param arr - the array being sorted
     * @param first - the first index
     * @param last - the last index
     * @param r - the random object for the pivot
     * @return the first element
     */
    private <T extends Comparable<T>> int partition(T[] arr, int first, int last, Random r)
    {
    	int i = first, j = last;
        T tmp;
        T pivot = arr[r.nextInt(last - first) + first];

        while (i <= j) {
              while (arr[i].compareTo(pivot) < 0) {
                    i++;
              }
              while (arr[j].compareTo(pivot) > 0) {
                    j--;
              }
              if (i <= j) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
              }
        }
        return i;      
    }
	@Override
	public <T extends Comparable<T>> T[] mergesort(T[] arr) {
		if (arr.length > 1) {
            T[] first = divide(arr, 0, arr.length / 2);
            T[] last = divide(arr, arr.length / 2, arr.length);
            mergesort(first);
            mergesort(last);
            merge(arr, first, last);
        }
		return arr;
	}
	/**
	 * Helper method for mergesort
	 * @param arr - the array being sorted
	 * @param start - the starting point
	 * @param last - the last point
	 * @return a copied list;
	 */
	@SuppressWarnings("unchecked")
	private <T extends Comparable<T>> T[] divide(T[] arr, int start, int last) {
		T[] ret = (T[]) new Comparable[last - start];
        for (int i = 0; i < ret.length; i++) {
        	ret[i] = arr[start + i];
        }
        return ret;
    }
	/**
	 * Helper method for mergesort used to merge the subarrays
	 * back together in the right order.
	 * @param arr - the array
	 * @param a - the subarray
	 * @param b - the subarray
	 */
	private <T extends Comparable<T>> void merge(T[] arr, T[] a, T[] b) {
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) < 0) {
                arr[i + j] = a[i];
                ++i;
            } else {
                arr[i + j] = b[j];
                ++j;
            }
        }
        for (; i < a.length; i++) {
        	arr[i + j] = a[i];
        }
        for (; j < b.length; j++) {
        	arr[i + j] = b[j];
        }
    }
	@Override
	public int[] radixsort(int[] arr) {
		HashMap<Integer, Queue<Integer>> hm = new HashMap<Integer, Queue<Integer>>(10);
		boolean keepGoing = true;
		int divider = 1;
		do {
			keepGoing = false;
			for (int i = 0; i < 10; i++) {
				hm.put(i, new LinkedList<Integer>());
			}
			for (int item: arr) {
				if ((item / divider) > 0) {
					keepGoing = true;
				}
				int key = Math.abs(item / divider % 10);
				hm.get(key).add(item);
			}
			divider *= 10;
			for (int i = 0, index = 0; i < 10; i++) {
				Queue<Integer> subList = hm.get(i);
				while (!subList.isEmpty()) {
					arr[index] = subList.poll();
					index++;
				}
			}
		} while (keepGoing);
		return arr;
	}
}
