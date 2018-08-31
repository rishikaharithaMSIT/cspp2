import java.util.Scanner;
/**
 * Solution class.
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static String binaryToDecimal(final String s) {
        String decimalDigit = "";
        int decimal = 0;
        for (int i = 1; i <= s.length(); i++) {
            //System.out.println(s.charAt(i));
            decimal += (int) Math.pow(2, s.length() - i)
            * Character.getNumericValue(s.charAt(i - 1));

        }
        decimalDigit = Integer.toString(decimal);
        return decimalDigit;

    }

}
