import java.util.Scanner;
/**
 * Class for convertto while loop.
 */
public final class Pattern {
    /**
     * Constructs the object.
     */
    private Pattern() {
        //unused.
    }
    /**
     * for while loop.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
