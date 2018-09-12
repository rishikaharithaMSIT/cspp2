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
            System.out.println(keys[0] + "keys 0 " );
            System.out.println(keys[1] + "keys 1" );
            // String[] tokens = keys[1].split(",", 3);
            // switch(keys[0]) {
            // 	case "add":
            	
            // 	System.out.println(tokens[0] + "0");
            // 	System.out.println(tokens[1] + "1");
            // 	System.out.println(tokens[2] + "2");
            // }
        }

 }
}