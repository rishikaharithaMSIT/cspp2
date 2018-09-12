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
            String[] tokens = line.split(",");
            System.out.println(Arrays.toString(tokens));
        }

 }
}