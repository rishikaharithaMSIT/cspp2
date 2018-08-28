import java.util.Scanner;

/**
    solution.
*/
public final class Solution {
    /**
        private constructor.
    */
    private Solution() {
        //unused
    }

    /**
        Do not modify this main function.
        @param args to take inputs from cmd lines.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        areaOfTriangle(base, height);
    }

    /**
        Need to fill the areaOfTriangle function and print the output
        of fahrenheit.
        @param base to take inputs from function call.
        @param height to take inputs from function call.
    */
    public static void areaOfTriangle(final int base, final int height) {
        final float zeroPointFive = (float) 0.5;
        System.out.println(zeroPointFive * base * height);
    }
}
