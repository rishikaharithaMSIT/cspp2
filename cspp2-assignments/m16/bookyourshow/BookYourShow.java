import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.*;
class BookYourShow {

	static List<Show> al = new ArrayList<Show>();
	static String[][] booked = new String[10][3];
	static int index = 0;
	void addAShow(String inp) {
		String[] tokens = inp.split(",", 3);
		Show show = new Show(tokens[0], tokens[1], tokens[2]);
		al.add(show);
	}

	ArrayList getAShow(String inp) {
		String[] tokens = inp.split(",", 2);
		ArrayList showsAvailable = new ArrayList();
		for (Show each : al) {
			if (tokens[0].equals(each.movieName) && tokens[1].equals(each.dateTime)) {
				showsAvailable.add(each.movieName + "," + each.dateTime);
			}
		}
		if (showsAvailable.size() == 0) {
			showsAvailable.add("No show");
		}
		return showsAvailable;
	}
	boolean checkAvailable(String inp, String[] sea, Show each) {
		String[] seats;
		inp = inp.replace("[", "");
		inp = inp.replace("]", "");
		seats = inp.split(",");
		int len = seats.length;
		int flag = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < sea.length; j++) {
				if (seats[i].equals(sea[j])) {
					each.seats[j] = "N/A";
					flag = 1;
				}
			}
		}
		if (flag == 1) {
			return true;
		}
		return false;
	}
	void bookAShow(String inp) {
		String[] tokens = inp.split(",", 5);
		Patron p = new Patron(tokens[2], tokens[3]);
		int flag = 0;
		for (Show each : al) {
			if (tokens[0].equals(each.movieName) && tokens[1].equals(each.dateTime)) {
				flag = 1;
				if (checkAvailable(tokens[4], each.seats, each)) {
					booked[index][0] = tokens[0];
					booked[index][1] = tokens[1];
					booked[index][2] = tokens[3];
					index++;
				}
			}
		}
		if (flag == 0) {
			System.out.println("No show");
			return;
		}
	}
	void printTickets(String inp) {
		String[] tokens = inp.split(",", 3);
		int flag = 0;
		for (int j = 0; j < booked.length; j++) {
			if (tokens[0].equals(booked[j][0]) && tokens[1].equals(booked[j][1]) && tokens[2].equals(booked[j][2])) {
				flag = 1;
				System.out.println(tokens[2] + " " + tokens[0] + " " + tokens[1]);
			}
		}
		if (flag == 0) {
			System.out.println("Invalid");
		}

	}
	void showAll() {
		for (Show each : al) {
			System.out.println(each.movieName + "," + each.dateTime + "," + each.getSeats());

		}
	}
}
