import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.*;
class Show {
	String movieName;
	String dateTime;
	String[] seats;
	Show(String movieName, String dateTime, String seats) {
		this.movieName = movieName;
		this.dateTime = dateTime;
		seats = seats.replace("[","");
		seats = seats.replace("]","");
		this.seats = seats.split(",");
		//System.out.println(Arrays.toString(this.seats) + " seats");
	}

}

class Patron {

}

class BookYourShow {

	ArrayList al = new ArrayList();

	void addAShow(String inp) {
		String[] tokens = inp.split(",", 3);
		Show show = new Show(tokens[0],tokens[1],tokens[2]);
		al.add(show);
	}

	String getAShow(String inp) {
		String[] tokens = inp.split(",", 2);
		System.out.println(Arrays.toString(tokens) + " get show");
		return "No show";
	}


}

class Solution {
 public static void main(String[] args) {
 	Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] keys = line.split(" ",2);
            System.out.println(keys[0] + " keys 0 " );
            BookYourShow bys = new BookYourShow();
            // System.out.println(keys[1] + "keys 1" );
            // String[] tokens = keys[1].split(",", 3);
            switch(keys[0]) {
            	case "add":
	            	bys.addAShow(keys[1]);
	            	break;
	            	// String[] tokens = keys[1].split(",", 3);
            	// System.out.println(tokens[0] + " t 0" );
            	// System.out.println(tokens[1] + " t 1" );
            	// System.out.println(tokens[2] + " t 2" );
            	case "get":
            		String show = bys.getAShow(keys[1]);
            		break;

            	
            }
        }

 }
}