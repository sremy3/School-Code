import java.util.Scanner;

/**
 * Runs the application
 * 
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class Main {

    /**
     * Takes the lease for the customer.
	 *@param a rental company.
     *
     */

    private static void takeLease(RentalCompany company) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Customer name: ");
        String name = keyboard.nextLine();
        Customer customer = new Customer(name);
        System.out.print("How many passengers will " + name + " have? ");
        int numPassengers = keyboard.nextInt();
        if (company.hasCarAvailable(numPassengers)) {
            company.lease(company.nextAvailableCar(numPassengers), customer);
        } else {
            System.out.println("There are no available cars that hold "
                               + numPassengers + " passengers.");
        }
    }
    /**
     * Lets the customer return the car.
	 *@param a rental company.
     *
     */
    private static void returnCar(RentalCompany company) {
        System.out.println("Which car would you like to return?");
        for (int i = 0; i < company.getLeases().size(); i++) {
            System.out.println(i + ": " + company.getLeases().get(i));
        }
        System.out.print("Enter the number: ");
        Scanner keyboard = new Scanner(System.in);
        int leaseIndex = keyboard.nextInt();
        company.returnCar(company.getLeases().get(leaseIndex));
    }

    public static void main(String[] args) {
        RentalCompany hertz = new RentalCompany("Hertz",
                                                new FordTaurus("0000"),
                                                new FordTaurus("1111"),
                                                new FordTaurus("2222"),
                                                new DodgeCaravan("3333"),
												new DodgeCaravan("4444"));

        boolean shouldContinue = true;
        Scanner keyboard = new Scanner(System.in);
        while (shouldContinue) {
            System.out.println("Options:");
            System.out.println("1 - Lease car");
            System.out.println("2 - Return car");
            System.out.println("3 - Quit");
            System.out.print("Enter option numer: ");
            int option = keyboard.nextInt();
            if (option == 1) {
                takeLease(hertz);
            } else if (option == 2) {
                returnCar(hertz);
            } else {
                shouldContinue = false;
                System.out.println("Bye!");
            }
            System.out.println();
            System.out.println(hertz.getName() + "'s current leases:");
            for (Lease lease: hertz.getLeases()) {
                System.out.println(lease);
            }
            System.out.println(hertz.getName() + "'s available cars:");
            for (Car car: hertz.getAvailableCars()) {
                System.out.println(car);
            }
            System.out.println();
        }
    }
}
