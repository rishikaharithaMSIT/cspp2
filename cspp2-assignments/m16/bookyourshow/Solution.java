import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
class Show {

}

class Patron {

}

class BookYourShow {

}

class Solution {
 public static void main(String[] args) {
 	Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] keys = line.split(" ",2);
            String[] tokens = line.split(",", 3);
            switch(keys[0]) {
            	case "add":
            	System.out.println(tokens[2]);
            }
        }

 }
}