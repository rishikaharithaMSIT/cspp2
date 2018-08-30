import java.util.Scanner;
/**
 * Class for first last 6.
 */
public final class FirstLast6 {
    /**
     * Constructs the object.
     */
    private FirstLast6() {

    }

    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        final int size = scan.nextInt();
        final int six = 6;
        int[] arr = new int[size];
        System.out.println("Enter elements in array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        if (arr[0] == six || arr[size - 1] == six) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
