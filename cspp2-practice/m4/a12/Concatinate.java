import java.util.Scanner;
/**
 * Class for first last 6.
 */
public final class Concatinate {
    /**
     * Constructs the object.
     */
    private Concatinate() {

    }

    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        final String name = scan.next();
        final String greeting = "Hello " + name + "!";
        System.out.println(greeting);

    }
}
