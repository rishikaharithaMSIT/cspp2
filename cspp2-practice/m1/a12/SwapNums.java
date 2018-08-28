/**
    Swap Numbers.
*/
import java.util.Scanner;
/**
    swap class file.
*/
public final class SwapNums {
    /**
        Constructor SwapNums.
    */
    private SwapNums() {
        //unused.
    }

    /**
    @param args to take input from command line
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        System.out.println("Before swap : x = " + x + " y : " + y);
        int temp = 0;
        temp = x;
        x = y;
        y = temp;
        System.out.println("After swap : x = " + x + " y : " + y);
    }
}
