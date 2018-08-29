import java.util.Scanner;
/**
 * Class for convertto while loop.
 */
public final class SumOfNNumbers {
    /**
     * Constructs the object.
     */
    private SumOfNNumbers() {
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
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
