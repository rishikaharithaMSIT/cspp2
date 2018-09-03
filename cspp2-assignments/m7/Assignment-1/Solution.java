import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    String input;
    /**
     * Constructs the object.
     */
    private InputValidator() {

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
     * @return     { description_of_the_return_value }
     */
    public boolean validateData() {
        final int six = 6;
        if (input.length() >= six) {
            return true;
        } else {
            return false;
        }
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * main.
     *
     * @param     args input from cmd.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
