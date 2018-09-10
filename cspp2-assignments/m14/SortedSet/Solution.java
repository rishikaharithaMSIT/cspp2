import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Rishika Haritha - 20186041
 */

/**
 * Class for set.
 */
class Set {
    //your code goes here...
    //Good luck :-)

    /**
     * { int[] set }.
     */
    int[] set;
    /**
     * { int size }.
     */
    int size;

    /**
     * Constructs the object set.
     */
    Set() {
        final int ten = 10;
        set = new int[ten];
        size = 0;
    }

    /**
     * { resize function}.
     */
    void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }

    /**
     * { add }.
     *
     * @param      item  int type
     */
    void add(final int item) {
        try {
            if (!contains(item)) {
                set[size] = item;
                size++;
            }
            //System.out.println(Arrays.toString(set));
        } catch (Exception e) {
            resize();
        }
    }

    /**
     * { add array }.
     *
     * @param      items  array type
     */
    void addAll(final int[] items) {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }

    /**
     * { size }.
     *
     * @return     { int type }
     */
    int size() {
        return size;
    }

    /**
     * { contains}.
     *
     * @param      item  int type
     *
     * @return     { boolean type}
     */
    boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String printString = "{";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                printString += set[i];
            } else {
                printString += set[i] + ", ";
            }
        }
        printString += "}";

        return printString;
    }

    /**
     * {intersection}.
     *
     * @param      items  set type
     *
     * @return     { set type }
     */
    Set intersection(final Set items) {
        Set intersectionSet = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < items.size; j++) {
                if (set[i] == items.set[j]) {
                    intersectionSet.add(items.set[j]);
                }
            }
        }
        return intersectionSet;

    }

    /**
     * { retain all }.
     *
     * @param      items  array type
     *
     * @return     { set type }
     */
    Set retainAll(final int[] items) {
        Set retainSet = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < items.length; j++) {
                if (set[i] == items[j]) {
                    retainSet.add(items[j]);
                }
            }
        }
        return retainSet;
    }

    /**
     * { cartesianProduct }.
     *
     * @param      items  set type
     *
     * @return     { 2d array type }
     */
    int[][] cartesianProduct(final Set items) {
        if (size == 0 || items.size == 0) {
            return null;
        }
        int[][] product = new int[items.size * size][2];
        int k = 0;
        for (int i = 0; i < size; i++) {


            for (int j = 0; j < items.size; j++) {
                product[k][0] = set[i];
                product[k][1] = items.set[j];
                k++;
            }

        }
        return product;
    }


}
/**
 * Solution class for code-eval.
 */
class SortedSet extends Set {
    // /**
    //  * Constructs the object.
    //  */
    // SortedSet() {
    //     super();
    // }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        Arrays.sort(set, 0, size);
        return super.toString();
    }
    

    /**
     * { function_description }.
     *
     * @param      fromElement  The from element
     * @param      toElement    To element
     *
     * @return     { description_of_the_return_value }
     */
    int[] subSet(int fromElement, int toElement) {
        int start = fromElement;
        int end = toElement;
        if (end < start) {
            System.out.println("Invalid Arguments to Subset Exception");
            return null;
        }
        Set sub = new Set();

        while (start < end) {
            //System.out.println("here" + start);
            if (contains(start)) {
                sub.add(start);
            }
            start++;
        }

        //System.out.println(Arrays.toString(sub.set));
        return sub.set;
    }

    /**
     * { function_description }.
     *
     * @param      toElement  To element
     *
     * @return     { description_of_the_return_value }
     */
    Set headSet(int toElement) {
        Set sub = new Set();
        for (int i = 0; i < size; i++) {
            if (set[i] < toElement) {
                sub.add(set[i]);
            }
        }
        return sub;
    }

    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    int last() {
        if (size <= 0) {
            System.out.println("Set Empty Exception");
            return -1;
        }
        Arrays.sort(set, 0, size);
        int s = size - 1;
        return set[s];
    }

}
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
        SortedSet s = new SortedSet();
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
            case "addAll":
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.addAll(intArray);
                }
                break;
            case "subSet":
                String[] strArray = tokens[1].split(",");
                intArray = new int[2];
                intArray[0] = Integer.parseInt(strArray[0]);
                intArray[1] = Integer.parseInt(strArray[1]);
                Set si = new Set();
                si.set = s.subSet(intArray[0], intArray[1]);

                if ( si.set != null) {
                    System.out.println(si.set);
                }
                break;
            case "headSet":
                String[] strArray1 = tokens[1].split(",");
                intArray = new int[1];
                intArray[0] = Integer.parseInt(strArray1[0]);
                System.out.println(s.headSet(intArray[0]));
                break;
            case "last":
                System.out.println(s.last());
                break;
            // case "intersection":
            //     s = new Set();
            //     Set t = new Set();
            //     intArray = intArray(tokens[1]);
            //     s.addAll(intArray);
            //     intArray = intArray(tokens[2]);
            //     t.addAll(intArray);
            //     System.out.println(s.intersection(t));
            //     break;
            // case "retainAll":
            //     s = new Set();
            //     intArray = intArray(tokens[1]);
            //     s.addAll(intArray);
            //     intArray = intArray(tokens[2]);
            //     System.out.println(s.retainAll(intArray));
            //     break;
            // case "cartesianProduct":
            //     s = new Set();
            //     t = new Set();
            //     intArray = intArray(tokens[1]);
            //     s.addAll(intArray);
            //     intArray = intArray(tokens[2]);
            //     t.addAll(intArray);
            //     System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
            //     break;
            default:
                break;
            }
        }
    }
}
