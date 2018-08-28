/**
 * Degree to Farenheit.
 */
import java.util.Scanner;
/**
    class convert temperture.
*/
public final class Solution {
    /**
        private constructor.
    */
    private Solution() {
        //unused.
    }

    /**
        @param args to take inputs from cmd lines.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        final int thirtytwo = 32;
        final Double onepointeight = (double) 1.8;
        String centi = scan.next();
        try {
            int cen = Integer.parseInt(centi);
            // System.out.println(cen);
            System.out.println((cen * onepointeight) + thirtytwo);
        } catch (Exception ex) {
            Double cen = Double.parseDouble(centi);
            // System.out.println(cen);
            System.out.println((cen * onepointeight) + thirtytwo);
        }
    }
}
