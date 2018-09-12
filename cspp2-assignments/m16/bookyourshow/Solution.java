import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
class Show {
	String movieName;
	String dateTime;
	String[] seats;
	Show(String movieName, String dateTime, String seats){
		this.movieName = movieName;
		this.dateTime = dateTime;
		seats = seats.replace("[","");
		seats = seats.replace("]","");
		this.seats = seats.split(",");
		System.out.println(Arrays.toString(this.seats) + " seats");
	}

}

class Patron {

}

class BookYourShow {
void addAShow(String inp) {
	String[] tokens = inp.split(",", 3);
	Show show = new Show(tokens[0],tokens[1],tokens[2]);

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
            	// String[] tokens = keys[1].split(",", 3);
            	// System.out.println(tokens[0] + " t 0" );
            	// System.out.println(tokens[1] + " t 1" );
            	// System.out.println(tokens[2] + " t 2" );
            	
            }
        }

 }
}