import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { var_description }.
     */
    private String input;
    /**
     * Constructs the object.
     */
    InputValidator() {

    }
    /**
     * Constructs the object.
     *
     * @param      input  The input
     */
    InputValidator(String input) {
        this.input = input;
    }


    /**
     * validate data.
     *
     * @return     { description_of_the_return_value }.
     */
    public boolean validateData() {
        final int six = 6;
        return input.length() >= six;
    }
}
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
         * @param     args input from cmd.
         */
        public static void main(final String[] args) {
            Scanner s = new Scanner(System.in);
            String input = s.next();
            InputValidator i = new InputValidator(input);
            System.out.println(i.validateData());

        }

    }
