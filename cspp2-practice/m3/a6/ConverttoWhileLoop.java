/**
 * Class for convertto while loop.
 */
public final class ConverttoWhileLoop {
    /**
     * Constructs the object.
     */
    private ConverttoWhileLoop() {
        //unused.
    }
    /**
     * for while loop.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int number = 2;
        final int ten = 10;
        while (number <= ten) {
            System.out.println(number);
            number += 2;
        }
        System.out.println("GoodBye!");
    }
}
