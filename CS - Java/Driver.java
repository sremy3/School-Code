import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
/**
  *  This class drives the conversion program.
  *
  *
  *  @author Stephanie Remy
  *  @version 1.0
  */
public class Driver  {
    public static void main(String[] args)  {
        MetricConverter list =  new MetricConverter();


        String answer =  null;
        boolean isExit = true;
        ArrayList<String> choices = new ArrayList<String>();

        choices.add("1");
        choices.add("2");
        choices.add("3");
        choices.add("4");
        choices.add("5");
        System.out.println("Welcome to the converter!");
        System.out.println();
        do  {
            System.out.println("What would you like to do?");
            System.out.println("1. Learn cool facts");
            System.out.println("2. Convert to meters");
            System.out.println("3. Convert to another unit");
            System.out.println("4. Add a temporary unit to converter");
            System.out.println("5. Exit this program");
            System.out.println();
            Scanner keyboard =  new Scanner(System.in);
            answer =  keyboard.nextLine();
            System.out.println();
            boolean isChoice = false;
            do  {
                isChoice = choices.contains(answer);
                if (isChoice)  {
                    isChoice = false;
                } else  {
                    System.out.println();
                    System.out.println(
                    "Sorry that is not a valid choice. Please try again.");
                    System.out.println();
                    answer =  keyboard.nextLine();
                    System.out.println();
                    isChoice = true;
                }
            } while (isChoice);
            if ("1".equals(answer)) {
                System.out.println(list);
                System.out.println(
                "What unit would you like to learn a cool fact about?");
                System.out.println();
                keyboard = new Scanner(System.in);
                String whichone  =  keyboard.nextLine();
                String[] az;
                az = list.getNames();
                boolean isIn = false;
                for (String items: az) {
                    if (items.equals(whichone)) {
                        list.isIn();
                        isIn = true;
                    }
                }
                if (isIn) {
                    try  {
                        String factz =  list.getCoolFact(whichone);
                        System.out.println();
                        System.out.println(factz);
                        System.out.println();
                        System.out.println("--------------------------");
                        list.turnOff();
                    } catch (Exception e)  {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                        list.turnOff();
                        System.out.println("-------------------------");
                    }
                } else  {
                    System.out.println();
                    System.out.println("Sorry not in list. Try again");
                    System.out.println();
                }
            }
            if ("2".equals(answer)) {
                System.out.println(list);
                System.out.println("What unit are you converting to meters?");
                System.out.println();
                keyboard =  new Scanner(System.in);
                String typeofunit  =  keyboard.nextLine();
                System.out.println();
                String[] az = list.getNames();
                boolean isIn = false;
                for (String items: az) {
                    if (items.equals(typeofunit)) {
                        list.isIn();
                        isIn = true;
                    }
                }
                System.out.println(
                "How many of these are you converting to meters?");
                System.out.println();
                boolean loop  =  true;
                double howmuchofunit = 0;
                while (loop)  {
                    try  {
                        keyboard =  new Scanner(System.in);
                        howmuchofunit =  keyboard.nextDouble();
                        loop = false;
                    } catch (InputMismatchException e)  {
                        System.out.println("Sorry! Not a valid number!");
                        keyboard.next();
                    }
                }
                if (isIn)  {
                    try  {
                        double finalconversion  =  list.convertToMeters(
                        typeofunit , howmuchofunit);
                        System.out.println();
                        System.out.println(typeofunit + ": " + howmuchofunit);
                        System.out.println();
                        System.out.println(
                        "The total number of meters is: " + finalconversion);
                        System.out.println();
                        System.out.println("--------------------------");
                        list.turnOff();
                    } catch (Exception e)  {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                        list.turnOff();
                        System.out.println("------------------------");
                    }
                } else {
                    System.out.println();
                    System.out.println(
                    "That is not a supported unit. Try again.");
                    System.out.println();
                }
            }
            if ("3".equals(answer)) {
                System.out.println(list);
                System.out.println("What unit would you like to convert from?");
                System.out.println();
                keyboard = new Scanner(System.in);
                String fromunit  =  keyboard.nextLine();
                String[] az = list.getNames();
                boolean isIn = false;
                boolean oneTrue = false;
                boolean twoTrue = false;
                for (String items: az) {
                    if (items.equals(fromunit)) {
                        oneTrue = true;
                    }
                }
                System.out.println();
                System.out.println("What unit would you like to convert to?");
                System.out.println();
                String tounit =  keyboard.nextLine();
                az = list.getNames();
                for (String items: az) {
                    if (items.equals(tounit)) {
                        twoTrue = true;
                    }
                }
                if (oneTrue && twoTrue) {
                    list.isIn();
                    isIn = true;
                }
                System.out.println();
                System.out.println(
                "How many " + fromunit + "s are you converting?");
                System.out.println();
                boolean loop  =  true;
                double howmuchofunit = 0;
                while (loop)  {
                    try  {
                        keyboard =  new Scanner(System.in);
                        System.out.println();
                        howmuchofunit =  keyboard.nextDouble();
                        loop = false;
                    } catch (InputMismatchException e)  {
                        System.out.println();
                        System.out.println("Sorry! Not a valid number!");
                        System.out.println();
                        keyboard.next();
                    }
                }
                if (isIn)  {
                    try {
                        double finalconversion  =  list.convertToDifferentUnit(
                        fromunit , tounit ,  howmuchofunit);
                        System.out.println();
                        System.out.println(fromunit + ": " + howmuchofunit);
                        System.out.println();
                        System.out.println("The total number of "
                        + tounit + "s is: " + finalconversion);
                        System.out.println();
                        System.out.println("---------------------------");
                        list.turnOff();
                    } catch (Exception e)  {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                        list.turnOff();
                        System.out.println("------------------------------");
                    }
                } else  {
                    System.out.println();
                    System.out.println(
                    "You put in an invalid unit. Try again.");
                    System.out.println();
                }
            }
            if ("4".equals(answer)) {
                System.out.println(list);
                System.out.println("What is the name of the new unit?");
                System.out.println();
                keyboard = new Scanner(System.in);
                String newunit  =  keyboard.nextLine();
                System.out.println();
                System.out.println("What is a cool fact about this unit?");
                System.out.println();
                String coolfact =  keyboard.nextLine();
                System.out.println();
                System.out.println("How many meters are in 1 of this unit?");
                System.out.println();
                boolean loop  =  true;
                double howmuch = 0;
                while (loop)  {
                    try  {
                        keyboard =  new Scanner(System.in);
                        System.out.println();
                        howmuch =  keyboard.nextDouble();
                        loop = false;
                    } catch (InputMismatchException e)  {
                        System.out.println();
                        System.out.println("Sorry! Not a valid number!");
                        System.out.println();
                        keyboard.next();
                    }
                }
                try  {
                    list.addUnit(howmuch , newunit , coolfact);
                    System.out.println();
                } catch (Exception e)  {
                    System.out.println();
                    System.out.println(e.getMessage());
                    System.out.println();
                }
            }
            isExit =  "1".equals(answer) || "2".equals(answer)
            || "3".equals(answer) || "4".equals(answer);
        } while(isExit);
    }
}
