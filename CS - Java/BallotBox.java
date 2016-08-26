import java.util.Scanner;

/**
 *  A wrapper class that collects the ballots and
 * removes the ballots from a array list bag.
 *  @author Stephanie Remy
 */
public class BallotBox {

    private BagInterface<Ballot> ballots;

    /**
     * Constructor for the class. Sets up the ballot box.
     *
     */
    public BallotBox() {
        ballots = new ArrayListBag<Ballot>();
    }

    /**
     * Adds a new entry to this box.
     *
     */
    public void vote() {
        System.out.println("Enter the name of the "
            + "candidate you would like to vote for: ");
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();
        System.out.println("");
        System.out.println("Enter bribe amount: ");
        keyboard = new Scanner(System.in);
        double bribe = keyboard.nextDouble();
        System.out.println("");
        Ballot ball = new Ballot(name, bribe);
        boolean added = ballots.add(ball);
        System.out.println("");
        System.out.println("The ballot was added: " + added);
        System.out.println("");
    }

    /**
     * Counts the number of votes for a candidate.
     *
     */
    public void countVotes() {
        System.out.print("What is the name of the "
            + "candidate you want to know the number of votes for: ");
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();
        Ballot candidate = new Ballot(name, 0);
        int frequency = ballots.getFrequencyOf(candidate);
        if (frequency == 0) {
            System.out.println("There is no candidate with that name.");
        } else {
            System.out.println("");
            System.out.println("The number of votes "
                + name + " has is " + frequency + ".");
            System.out.println("");
        }
    }

    /**
     * Removes a selected candidate or a random candidate from the box.
     *
     */
    public void removeVote() {
        boolean emptyOrNot = ballots.isEmpty();
        if (emptyOrNot) {
            System.out.println("There are no votes "
                + "in the ballot box to remove.");
        } else {
            Object[] array = ballots.toArray();
            System.out.println("The names of all the "
                + "votes in the ballot box are: ");
            for (Object b: array) {
                String names = b.toString();
                System.out.println(names);
            }
            System.out.print("Would you like to: 1) pick a specific "
                + "candidate to remove or 2) remove a random vote? Please "
                + "enter the number 1 or 2: ");
            Scanner keyboard = new Scanner(System.in);
            int choice = keyboard.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("What is the name "
                        + "of the candidate  you want remove: ");
                    keyboard = new Scanner(System.in);
                    String name = keyboard.nextLine();
                    Ballot candidate = new Ballot(name, 0);
                    boolean removed = ballots.remove(candidate);
                    System.out.println("");
                    System.out.println("The first occurrence of the "
                        + "candidate with that name has been removed: "
                        + removed);
                    System.out.println("");
                    break;
                case 2:
                    Ballot candidate2 = ballots.remove();
                    System.out.println("The random candidate chosen is: "
                        + candidate2);
                    break;
                default:
                    System.out.println("That's not a valid choice");
            }
        }
    }

    /**
     * Produces the total number of votes in the box.
     *
     */
    public void totalVotes() {
        int votes = ballots.getCurrentSize();
        System.out.println("The number of votes in the "
            + "ballot box are: " + votes);
        System.out.println("");
    }

    /**
     * Clears the votes in the ballot box.
     *
     */
    public void clearVotes() {
        ballots.clear();
        boolean answer = ballots.isEmpty();
        System.out.println("The number of votes in the "
            + "ballot box are now zero: " + answer);
        System.out.println("");
    }

    /**
     * Prints the candidates in the ballot box.
     *
     */
    public void printCandidates() {
        boolean emptyOrNot = ballots.isEmpty();
        if (emptyOrNot) {
            System.out.println("There are no votes in the ballot box.");
        } else {
            Object[] array = ballots.toArray();
            System.out.println("The names of all "
                + "the votes in the ballot box are: ");
            for (Object b: array) {
                String names = b.toString();
                System.out.println(names);
            }
        }
    }
}
