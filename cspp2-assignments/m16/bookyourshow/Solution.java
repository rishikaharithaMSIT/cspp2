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
	String namePerson;
	String phoneNumber;
	Patron(String namePerson, String phoneNumber){
		this.namePerson = namePerson;
		this.phoneNumber = phoneNumber;
		//System.out.println("name re : " + namePerson);
	}
}

class BookYourShow {

	List al = new ArrayList();

	void addAShow(String inp) {
		String[] tokens = inp.split(",", 3);
		Show show = new Show(tokens[0],tokens[1],tokens[2]);
		System.out.println("Here");
		al.add(show.movieName);
	}

	ArrayList getAShow(String inp) {
		String[] tokens = inp.split(",", 2);
		//System.out.println(Arrays.toString(tokens) + " get show");
		ArrayList showsAvailable = new ArrayList();
		//System.out.println(al + " getClass");
		for(Object each: al){
			
            // if(tokens[0].equals(each.movieName) && tokens[1].equals(each.dateTime)){
            // 	showsAvailable.add(each);
            // }
        }
        if(showsAvailable.size() == 0) {
        	showsAvailable.add("No Show");
        }


		return showsAvailable;
	}

	void bookAShow(String inp){
		String[] tokens = inp.split(",", 5);
		Patron p = new Patron(tokens[2],tokens[3]);

		System.out.println(al);
	}


}

class Solution {
 public static void main(String[] args) {
 	Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] keys = line.split(" ",2);
            //System.out.println(keys[0] + " keys 0 " );
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
            		ArrayList shows = bys.getAShow(keys[1]);
            		if(shows.size() == 1) {
            			System.out.println(shows.get(0));
            		}
            		break;
            	case "book":
            		bys.bookAShow(keys[1]);

            	
            }
        }

 }
}