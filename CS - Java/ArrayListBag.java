import java.util.ArrayList;
/**
 *  An class that implements the BagInterface
 * that describes the operations of a bag of objects.
 *  @author Stephanie Remy
 */
public class ArrayListBag<T> implements BagInterface<T> {

    private ArrayList<T> bagArray;

    /**
     * Constructor for the class. Sets up the Arraylist.
     *
     */

    public ArrayListBag() {
        this.bagArray = new ArrayList<T>();
    }
    /**
     * Gets the current number of entries in this bag.
     *
     * @return the integer number of entries currently in the bag
     */
    public int getCurrentSize() {
        int size = bagArray.size();
        return size;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return true if the bag is empty, or false if not
     */
    public boolean isEmpty() {
        boolean answer = bagArray.isEmpty();
        return answer;
    }

    /**
     * Adds a new entry to this bag.
     * If the new entry is null it should not be added.
     *
     * @param newEntry  the object to be added as a new entry
     * @return true if the addition is successful, or false if not
     */
    public boolean add(T newEntry) {
        if (!newEntry.equals(null)) {
            bagArray.add(newEntry);
            return true;
        }
        return false;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * Entry must be randomly chosen. (NOTE: the book's code
     * in the ArrayBag implementation did not chose randomly.
     * This method must choose the entry randomly.)
     *
     * @return the removed entry if the removal was
     * successful, or null otherwise
     */
    public T remove() {
        int size = bagArray.size();
        if (size > 0) {
            int selection = ((int) (Math.random() * (size - 1)));
            T thing = bagArray.remove(selection);
            return thing;
        } else {
            return null;
        }
    }

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry  the entry to be removed
     * @return true if the removal was successful, or false otherwise
     */
    public boolean remove(T anEntry) {
        if (bagArray.contains(anEntry)) {
            bagArray.remove(anEntry);
            return true;
        }
        return false;
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        this.bagArray = new ArrayList<T>();
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry  the entry to be counted
     * @return the number of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for (T items: bagArray) {
            if (items.equals(anEntry)) {
                frequency++;
            }
        }
        return frequency;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry  the entry to locate
     * @return true if this bag contains anEntry, or false otherwise
     */
    public boolean contains(T anEntry) {
        for (T items: bagArray) {
            if (items.equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates an array of all entries that are in this bag.
     * It does not destroy or alter the bag in any way.
     * If the bag is actually empty, this will still create an
     * array, but it will have length 0.
     *
     * @return a newly allocated array of all the entries in the bag
     */
    public T[] toArray() {
        T[] entries = (T[]) bagArray.toArray();
        return entries;
    }
}
