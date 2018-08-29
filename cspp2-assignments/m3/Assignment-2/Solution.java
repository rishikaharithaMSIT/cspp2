import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
		for (int i = 1; i <= n; i++) {
			int number = i;
			while (number > 0) {
				int rem = number % 10;
				number /= 10;
				if (rem == 7) {
					count++;
				}
			}
		}
		System.out.print(count);        
    }
}