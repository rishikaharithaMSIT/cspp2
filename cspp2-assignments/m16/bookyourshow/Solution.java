import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.*;
class Show {
	String movieName;
	String dateTime;
	String[] seats;
	String seatString;
	Show(String movieName, String dateTime, String seats) {
		this.movieName = movieName;
		this.dateTime = dateTime;
		seats = seats.replace("[","");
		seats = seats.replace("]","");		
		this.seats = seats.split(",");
		//System.out.println(Arrays.toString(this.seats) + " seats");
	}
	String getSeats(){
		seatString = "[";
		for(int i =0;i<seats.length;i++){
			if(i == seats.length -1) {
				seatString += seats[i];
			}else {
				seatString += seats[i] + ",";
			}
		}
		seatString += "]";
		return seatString;
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
		for(Show each: al){
			
            if(tokens[0].equals(each.movieName) && tokens[1].equals(each.dateTime)){
           			showsAvailable.add(each.movieName+","+each.dateTime);
             }
        }
        if(showsAvailable.size() == 0) {
        	showsAvailable.add("No show");
        }


		return showsAvailable;
	}
	boolean checkAvailable(String inp, String[] sea, Show each) {
		String[] seats;
		inp = inp.replace("[","");
		inp = inp.replace("]","");
		seats = inp.split(",");
		int len = seats.length;
		int flag = 0;
		//System.out.println(Arrays.toString(seats) + " seats");	
		//System.out.println(Arrays.toString(sea) + " sea");
		
		for(int i = 0; i < seats.length;i++) {
			for(int j =0;j<sea.length;j++) {
				if (seats[i].equals(sea[j])){
					each.seats[j] = "N/A";
					flag = 1;
				}
			}
		}
		if(flag == 1) {
			return true;
		}
		
		
		return false;
	}
	void bookAShow(String inp){
		String[] tokens = inp.split(",", 5);
		Patron p = new Patron(tokens[2],tokens[3]);
		int flag = 0;
		for(Show each: al){
			//System.out.println(each.getMovie());
			if(tokens[0].equals(each.movieName) && tokens[1].equals(each.dateTime)){
				flag = 1;
				//System.out.println(tokens[4] + " seats");	
				//System.out.println(Arrays.toString(each.seats) + " sea");
				if (checkAvailable(tokens[4], each.seats, each)){
	             	booked[index][0] = tokens[0];
	             	booked[index][1] = tokens[1];
	             	booked[index][2] = tokens[3];
	             	//System.out.println(Arrays.deepToString(booked) + " booked arr");
	             	
	             	index++;
	             }
	         }
	    }
	    if(flag == 0) {
	    	System.out.println("No show");
	    	return;
	    }

		
	}
	void printTickets(String inp) {
		String[] tokens = inp.split(",", 3);
		int flag = 0;
    		for(int j = 0; j<booked.length; j++) {
    			//System.out.println(Arrays.toString(tokens) + " tok");
    			//System.out.println(Arrays.toString(booked[j])+" book");
    			//System.out.println("each ele" + tokens[0] + " and " + booked[j][0]);
        		if(tokens[0].equals(booked[j][0]) && tokens[1].equals(booked[j][1]) && tokens[2].equals(booked[j][2])) {
        			flag = 1;
        			System.out.println(tokens[2] + " " + tokens[0] + " " + tokens[1]);
        		}
        	}
        	if(flag == 0) {
        		System.out.println("Invalid");
        	}
        
	}
	void showAll() {
		for(Show each: al){
			System.out.println(each.movieName+","+each.dateTime+","+each.getSeats());
			
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
            		}else {
            			for(int i = 0;i<shows.size();i++) {
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

            	
            }
        }
 }
}