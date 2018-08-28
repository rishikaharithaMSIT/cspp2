import java.util.Scanner;
/**
 * Area Circle
 */
public final class AreaCircle {
	/**
	 * Constructs the object.
	 */
	private AreaCircle() {

	}

	/**
	 * main function
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int radius = scan.nextInt();
		System.out.println(area(radius));
	}

	/**
	 * area function
	 *
	 * @param      radius  The radius
	 *
	 * @return     takes radius as input
	 */
	public static double area(final int radius) {
		return pi() * radius * radius;
	}

	/**
	 * pi function
	 *
	 * @return     pi value
	 */
	public static double pi() {
		return (double) 3.14;
	}
}
