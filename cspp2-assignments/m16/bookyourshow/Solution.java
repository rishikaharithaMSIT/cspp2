import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		while (stdin.hasNext()) {
			String line = stdin.nextLine();
			String[] keys = line.split(" ", 2);
			//System.out.println(keys[0] + " keys 0 " );
			BookYourShow bys = new BookYourShow();
			// System.out.println(keys[1] + "keys 1" );
			// String[] tokens = keys[1].split(",", 3);
			switch (keys[0]) {
			case "add":
				bys.addAShow(keys[1]);
				break;
			case "get":
				ArrayList shows = bys.getAShow(keys[1]);
				if (shows.size() == 1) {
					System.out.println(shows.get(0));
				} else {
					for (int i = 0; i < shows.size(); i++) {
						System.out.println(shows.get(i));
					}
				}
				break;
			case "book":
				bys.bookAShow(keys[1]);
				break;
			case "print" :
				bys.printTickets(keys[1]);
				break;
			case "showAll":
				bys.showAll();
				break;
			default:

			}
		}
	}
}