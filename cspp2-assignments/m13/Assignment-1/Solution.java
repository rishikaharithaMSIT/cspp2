import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : 
 */
class Set {
    //your code goes here...
    //Good luck :-)
    private int[] set;
    private int size;

    Set() {
        set = new int[10];
        size = 0;
    }
    void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }
    void add(int item) {
        try{
            if(!contains(item)){
                set[size] = item;
                size++;
            }
            //System.out.println(Arrays.toString(set));
        }catch (Exception e){
            resize();
        }
    }
    void add(int[] items) {
        for(int i =0;i<items.length;i++){
            add(items[i]);
        }
    }
    int size() {
        return size;
    }
    boolean contains(int item){
        for(int i =0;i<size;i++) {
            if(set[i] == item) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String printString = "{";
        for(int i = 0;i<size;i++){
            if(i == size-1) {
                printString += set[i];
            }else {
                printString += set[i] + ", ";
            }
        }
        printString += "}";

        return printString;
    }
    Set intersection(Set items) {
        Set intersectionSet = new Set();
        for (int i =0;i<size;i++) {
            for(int j=0;j<items.size;j++) {                
                if(set[i] == items.set[j]) {
                    intersectionSet.add(items.set[j]);
            }
            }
        }
        return intersectionSet;
        
    }

    Set retainAll(int[] items) {
        return new Set();
    }
    int[][] cartesianProduct(Set items) {
        int[][] abc = new int[1][1];
        return abc;
    }


}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
