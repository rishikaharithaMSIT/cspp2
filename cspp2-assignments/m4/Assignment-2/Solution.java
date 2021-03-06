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
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int[][] arr1 = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int[][] arr2 = new int[r2][c2];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        if ((r1 != r2) || (c1 != c2)) {
            System.out.println("not possible");
            return;
        }
        int[][] sum = new int[r1][c1];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2 - 1; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.print(sum[i][c2 - 1]);
            System.out.println();
        }
    }

}
