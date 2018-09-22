import java.util.Scanner;
import java.io.File;
/**
 * Solution Class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();
            File dir = new File(line);
            File[] files = dir.listFiles();
            double maxVal = 0;
            String file1 = null;
            String file2 = null;
            System.out.print("\t\t");
            for (int i = 0; i < files.length - 1; i++) {
                System.out.print(files[i].getName() + "        ");
            }
            System.out.print(files[files.length - 1].getName());
            System.out.println();
            for (int i = 0; i < files.length; i++) {
                System.out.print(files[i].getName() + "        ");
                for (int j = 0; j < files.length; j++) {
                    Distance map1 = new Distance(files[i], files[j]);
                    //Distance map2 = new Distance(files[j]);
                    double similar = map1.getSimilarity();
                    if (similar > maxVal && !files[i].getName().equals(
                                files[j].getName())) {
                        maxVal = similar;
                        file1 = files[i].getName();
                        file2 = files[j].getName();
                    }

                    //System.out.print(similar + "\t\t");
                }
                System.out.println();
            }
            System.out.println("Maximum similarity is between " + file1
                               + " and " + file2);
        } catch (Exception e) {
            System.out.println("Empty Directory");
        }
    }
}


// import java.util.*;
// import java.io.*;
// class Solution {
//  public static void main(String[] args) {
//      // String s1 = "my name is Rishika.Scahipothe evadiki ekkuva cheppu assalu. Nijamga cheppali Nijamga cheptante sachipovatame best.".toLowerCase();
//      // String s2 = "Your pkname is pranay.Nijamga cheptha".toLowerCase();
//      // ArrayList<String> s3 = new ArrayList<>();
//      try {
//          File test1 = new File("file1.txt");
//          Scanner scn = new Scanner(test1);
//          String s1 = "";
//          while(scn.hasNext()) {
//                 s1 = s1 + scn.nextLine() ;
//          }
//          // System.out.println(s1 + "first string");
//          // scn.close();
//          File test2 = new File("file2.txt");
//          scn = new Scanner(test2);
//          String s2 = "";
//          while(scn.hasNext()) {
//                s2 = s2 + scn.nextLine();
//          }
//          // System.out.println(s2 + "second string");
//          String lcs = "";
//          for (int i = 0; i < s2.length(); i++) {
//              for (int j = i + 1 ; j <= s2.length(); j++) {
//                  if (s1.contains(s2.substring(i, j))) {
//                      if (s2.substring(i, j).length() > lcs.length()) {
//                          lcs = s2.substring(i, j).replaceAll(" ","");
//                      }
//                  }
//              }
//          }
//          System.out.println(lcs + "\tand its length is\t" + lcs.length());
//          int numerator = lcs.length() * 2 * 100;
//          System.out.println(numerator);
//          int denominator = s1.length() + s2.length();
//          System.out.println(denominator);
//          System.out.println((numerator/denominator));
//          // double result = (((lcs.length()) * 2) / ((s1.length()) + (s2.length())));
//          // System.out.println(result);
//      } catch (Exception e) {
//          System.out.println("FILE NOT FOUND");
//      }
//  }
// }
