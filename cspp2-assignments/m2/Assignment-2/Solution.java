import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/**
	 * { function_description }.
	 *
	 * @param      a     { parameter_description }
	 * @param      b     { parameter_description }
	 * @param      c     { parameter_description }
	 */
	public static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
		final int four = 4;
		double det = Math.sqrt((b * b) - (four * a * c));
		double root1 = ((-b) + det) / (2 * a);
		double root2 = ((-b) - det) / (2 * a);
		System.out.println(root1 + " " + root2);
	}
}
