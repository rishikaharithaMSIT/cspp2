/**
    Quotient and Remainder.
*/
import java.util.Scanner;
/**
    class to find division.
*/
public final class Division {
    /**
        private constructor.
    */
    private Division() {
        //unused.
    }

    /**
        @param args to take inputs from cmd lines.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            int x = scan.nextInt();
            int y = scan.nextInt();

            System.out.println("Quotient is : " + x / y);
            System.out.println("Remainder is : " + x % y);
        } catch (Exception ex) {
            System.out.println("Wrong Input");
        }
    }
}
