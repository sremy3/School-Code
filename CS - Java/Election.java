import java.util.Scanner;

/**
 *  A class that prompts the user for a choice on a menu
 * to either add, remove, or do a few other options to
 * the ballot box.
 *
 *  @author Stephanie Remy
 */
public class Election {

    /**
     * Runs the switchMenu which runs the rest of the program.
     *
     * @param args  arguments from the command line
     */
    public static void main(String[] args) {
        switchMenu();
    }

    /**
     * Creates a switch to direct the choice from the user
     * to the appropriate method in BallotBox.
     *
     */
    private static void switchMenu() {
        BallotBox bb = new BallotBox();
        boolean quit = true;
        boolean keepgoing = true;
        int choice;
        do {
            choice = menu();
            System.out.println("");
            switch (choice) {
                case 1:
                    bb.vote();
                    System.out.println("");
                    break;
                case 2:
                    bb.countVotes();
                    System.out.println("");
                    break;
                case 3:
                    bb.removeVote();
                    System.out.println("");
                    break;
                case 4:
                    bb.totalVotes();
                    System.out.println("");
                    break;
                case 5:
                    bb.clearVotes();
                    System.out.println("");
                    break;
                case 6:
                    bb.printCandidates();
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("Quitting the program.");
                    keepgoing = false;
                    break;
                default:
                    System.out.println("That's not one of the "
                        + "choices. Please try again.");
                    System.out.println("");
            }
        } while (keepgoing);
    }

    /**
     * Sets up the printed menu for the user.
     *
     * @return integer that the user chooses from the menu
     */
    private static int menu() {
        System.out.println("Welcome to the election! "
            + "What would you like to do?");
        System.out.println("1: Vote for a candidate");
        System.out.println("2: Count the number of votes for a candidate");
        System.out.println("3: Remove a vote");
        System.out.println("4: Get number of votes in the ballot box");
        System.out.println("5: Empty the ballot box");
        System.out.println("6: Print all votes");
        System.out.println("7: Quit");
        System.out.print("Enter your choice (1-7) here: ");
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();
        return choice;
    }

}
