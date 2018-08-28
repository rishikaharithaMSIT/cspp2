/**
    Degree to Fahrenheit.
*/
import java.util.Scanner;
/**
    class convert temperture.
*/
public final class Temperature {
    /**
        private constructor.
    */
    private Temperature() {
        //unused.
    }

    /**
        @param args to take inputs from cmd lines.
        
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            final int thirtytwo = 32;
            final float onepointeight = (float) 1.8;
            int centi = scan.nextInt();

            System.out.println(centi + " Centigrade = "
                + ((centi * onepointeight) + thirtytwo) + " Fahrenheit");
        } catch (Exception ex) {
            System.out.println("Wrong Input");
        }
    }
}
