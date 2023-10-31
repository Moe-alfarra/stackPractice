import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the recursion class that is used to run the program
 */
public class recursion {


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // Command used to create a Scanner object

        // Code for task 1

        boolean done = false;
        int num = 0;
        // While loop that keep running as long as the user enters an invalid input
        while (!done) {
            // Try-Catch that checks if the user enters an invalid input
            try {
                System.out.println("How many people are in the room?");
                num = keyboard.nextInt();
                if (num <= 0) {
                    throw new Exception();
                } else {
                    done = true;
                }
            } catch (Exception e) {
                keyboard.nextLine();
                System.out.println("Invalid Input!");
            }
        }

        int handshakes = handShakes(num); // Calls the recursive method and store the return value in this variable
        System.out.println("If everyone shakes hands once, there will be " + handshakes + " handshakes.");


        System.out.println();


        // Code for task 2

        int n = 0, r = 0;

        done = false;
        // While loop that checks if the user enters an invalid input for n
        while (!done) {
            // Try-Catch that checks if the user enters an invalid input for n
            try {
                System.out.println("Enter value for n: ");
                n = keyboard.nextInt();
                if (n < 0) {
                    throw new Exception();
                } else {
                    done = true;
                }
            } catch (Exception e) {
                keyboard.nextLine();
                System.out.println("Invalid Input!");
            }
        }

        done = false;
        // While loop that checks if the user enters an invalid input for r
        while (!done) {
            // Try-Catch that checks if the user enters an invalid input for r or if the user enter an r that is greater than n
            try {
                System.out.println("Enter value for r: ");
                r = keyboard.nextInt();
                if (r < 0) {
                    throw new Exception("Invalid Input!");
                } else if (r > n) {
                    throw new Exception("n should be greater than r!");
                }else {
                    done = true;
                }
            } catch(InputMismatchException e) {
                keyboard.nextLine();
                System.out.println("Invalid Input!");
            }catch(Exception e){
                keyboard.nextLine();
                System.out.println(e.getMessage());
            }
        }
        int answer = combination(n, r); // Calls the recursive method and store the return value in this variable
        if (answer == 1) {
            System.out.println("There is " + answer + " possible combination.");
        }
        else {
            System.out.println("There are " + answer + " possible combinations.");
        }

    }


    /**
     * This is the handShakes method which is a recursive method that is used to count how many handshakes will be if everyone shakes once
     * @param num int
     * @return int
     */
    public static int handShakes(int num) {
        // If no people are in the room then returns -1
        if (num == 0) {
            return -1;
        }
        // Else if there is 1 person then returns 0
        else if (num == 1) {
            return 0;
        }
        // Else if there are 2 in the room then returns 1
        else if (num == 2) {
            return 1;
        }
        else {
            return (num - 1) + handShakes(num - 1);
        }
    }

    /**
     * This is the combination recursive method that is used to compute the number of ways of choosing r from a set of n
     * @param n int
     * @param r int
     * @return int
     */
    public static int combination(int n, int r) {
        // If n is less than r then returns -1
        if (n < r) {
            return -1;
        }
        // Else if r is 0 or n and r are equal then returns 1 combination
        else if (r == 0 || r == n) {
            return 1;
        }
        else {
            return combination(n-1, r-1) + combination(n-1, r);
        }
    }
}

