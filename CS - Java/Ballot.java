import java.lang.String;

/**
 *  A class that creates a ballot
 * for the ballot box.
 *  @author Stephanie Remy
 */
public class Ballot {

    private String name;
    private double bribe;

    /**
     * Constructor for the class. Sets up the Ballot.
     *
     */
    public Ballot(String name, double bribe) {
        this.name = name;
        this.bribe = bribe;
    }

    /**
     * Gives the program a way to compare two ballots for
     * equality.
     *
     * @param other  another ballot to be compared to
     * @return true if both ballots have the same name, false otherwise
     */
    public boolean equals(Object other) {
        if (other == null) { return false; }
        boolean equalsOrNot = this.name.equals(((Ballot) other).getName());
        return equalsOrNot;
    }

    /**
     * Creates a unique hash code for the ballots.
     *
     * @return the hash code associated with the ballot
     */
    public int hashCode() {
        int hash = 7;
        for (int i = 0; i < this.name.length(); i++) {
            hash = hash * 31 + this.name.charAt(i);
        }
        return hash;
    }

    /**
     * A get method for the name of the candidate.
     *
     * @return the name on the ballot
     */
    public String getName() {
        return this.name;
    }

    /**
     * A get method for the bribe amount.
     *
     * @return amount of the bribe
     */
    public double getBribe() {
        return this.bribe;
    }

    /**
     * Prints out a String representation of the ballot.
     *
     * @return a string with candidate name and bribe amount
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Candidate: ");
        output.append(this.name);
        output.append(". Bribe: ");
        output.append(this.bribe);
        output.append(".");
        String out = output.toString();
        return out;
    }
}
