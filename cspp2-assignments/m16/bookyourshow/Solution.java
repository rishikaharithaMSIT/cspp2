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
	String getMovie(){
		return movieName;
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

	static List<Show> al = new ArrayList<Show>();
	static String[][] booked = new String[10][3];
	static int index = 0;
	void addAShow(String inp) {
		String[] tokens = inp.split(",", 3);
		Show show = new Show(tokens[0],tokens[1],tokens[2]);
		// System.out.println("Here");
		// System.out.println(show.movieName + " name");
		al.add(show);
		//System.out.println(al + " ail");
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
		
		for(Show each: al){
			//System.out.println(each.getMovie());
			if(tokens[0].equals(each.movieName) && tokens[1].equals(each.dateTime)){

	             	booked[index][0] = tokens[3];
	             	booked[index][1] = tokens[0];
	             	booked[index][2] = tokens[1];
	             	System.out.println(Arrays.deepToString(booked) + " booked arr");
	             	index++;
	         }
	    }
		
	}
	void printTickets(String inp) {
		String[] tokens = inp.split(",", 2);
		
    		for(int j = 0; j<booked.length; j++) {
    			System.out.println(Arrays.toString(tokens) + " tok");
    			System.out.println(Arrays.toString(booked[0])+" book");
        		if(tokens.equals(booked[j])) {
        			System.out.println(tokens[0] + " boked");
        		}
        	}
        
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
            	case "get":
            		ArrayList shows = bys.getAShow(keys[1]);
            		if(shows.size() == 1) {
            			System.out.println(shows.get(0));
            		}
            		break;
            	case "book":
            		bys.bookAShow(keys[1]);
            		break;
            	case "print" :
            		bys.printTickets(keys[1]);
            		break;

            	
            }
        }

 }
}