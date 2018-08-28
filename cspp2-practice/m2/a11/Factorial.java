import java.util.Scanner;
/**
 * Area Circle.
 */
public final class Factorial {
    /**
     * Constructs the object.
     */
    private Factorial() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int varA = scan.nextInt();
        System.out.println(fact(varA));
    }
    /**
     * { function_description }.
     *
     * @param      varA  The variable a
     *
     * @return     { description_of_the_return_value }
     */
    public static int fact(final int varA) {
        if (varA == 0) {
            return 1;
        }
        return varA * fact(varA - 1);
    }
}
