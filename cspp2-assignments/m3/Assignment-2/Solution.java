import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int number = i;
            final int ten = 10;
            final int seven = 7;
            while (number > 0) {
                int rem = number % ten;
                number /= ten;
                if (rem == seven) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
