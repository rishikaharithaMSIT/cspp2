import java.util.Scanner;
/**
 * Class for first last 6.
 */
public final class Average {
    /**
     * Constructs the object.
     */
    private Average() {

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
        int sum = 0;
        System.out.println("Enter elements in array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
            sum += arr[i];
        }
        System.out.println((float) sum / size);
    }
}
