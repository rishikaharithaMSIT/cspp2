import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.ArrayList;

class ShoppingCart {

}
class Solution {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		while(stdin.hasNext()) {
			String line = stdin.nextLine();
			String[] keys = line.split(" ");
			System.out.println(keys[0]);
			//System.out.println(keys[1]);
		}
	}
}