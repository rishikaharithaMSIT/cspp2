
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int g = gcd(n1,n2);
        System.out.println(g);
    }
    public static int gcd(int n1, int n2) {
        if (n1 == 0) {
            return n1;
        } 
        return gcd(n1 , n1%n2);
    }
}
