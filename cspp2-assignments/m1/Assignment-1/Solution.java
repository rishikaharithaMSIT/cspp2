/**
    solution.
*/
public final class Solution {
    /**
        private constructor.
    */
    private Solution() {
        //unused
    }

    /**
    @param args to take args from command line
    */
    public static void main(final String[] args) {
        int rollNum = Integer.parseInt(args[0]);
        String name = args[1];
        System.out.println("Name : " + rollNum + ", Roll Number : " + name);
    }
}
