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
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s=new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int g = gcd(n1,n2);
        System.out.println(g);
    }
    /**
     * { function_description }
     *
     * @param      n1    The n 1
     * @param      n2    The n 2
     *
     * @return     int value.
     */
    public static int gcd(final int n1, final int n2) {
        final int bigger = n1 > n2? n1 : n2;
        for (int i = bigger; i >= 1; i--) {
            if ((n1%i ==0 ) && (n2%i == 0)) {
                return i;
            }
        }
        return 1;
    }
}
