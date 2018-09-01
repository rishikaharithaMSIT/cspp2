import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Determines if odd.
     *
     * @param      i     { parameter_description }
     *
     * @return     True if odd, False otherwise.
     */
    public static boolean isOdd(final int i) {
        if (i % 2 == 0) {
            return false;
        }
        return true;
    }
    /**
     * Determines if prime.
     *
     * @param      i     { parameter_description }
     *
     * @return     True if prime, False otherwise.
     */
    public static boolean isPrime(final int i) {
        for (int k = 2; k < i; k++) {
            if (i % k == 0) {
                return true;
            }
        }
        return false;
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
        // write your code here
        for (int i = 1; i <= n; i++) {
            if (isOdd(i) && isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

