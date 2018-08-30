import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution(){

    }

    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        arr[0] = sc.nextInt();
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);



    }
}
