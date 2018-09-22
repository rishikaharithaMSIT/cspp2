import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) {
		// String s1 = "my name is Rishika.Scahipothe evadiki ekkuva cheppu assalu. Nijamga cheppali Nijamga cheptante sachipovatame best.".toLowerCase();
		// String s2 = "Your pkname is pranay.Nijamga cheptha".toLowerCase();
		// ArrayList<String> s3 = new ArrayList<>();
		try {
			File test1 = new File("file1.txt");
			Scanner scn = new Scanner(test1);
			String s1 = "";
			while(scn.hasNext()) {
                s1 = s1 + scn.nextLine() ;
			}
			// System.out.println(s1 + "first string");
			// scn.close();
			File test2 = new File("file2.txt");
			scn = new Scanner(test2);
			String s2 = "";
			while(scn.hasNext()) {
               s2 = s2 + scn.nextLine();
			}
			// System.out.println(s2 + "second string");
			String lcs = "";
			for (int i = 0; i < s2.length(); i++) {
				for (int j = i + 1 ; j <= s2.length(); j++) {
					if (s1.contains(s2.substring(i, j))) {
						if (s2.substring(i, j).length() > lcs.length()) {
							lcs = s2.substring(i, j).replaceAll(" ","");
						}
					}
				}
			}
			System.out.println(lcs + "\tand its length is\t" + lcs.length());
			int numerator = lcs.length() * 2 * 100;
			System.out.println(numerator);
			int denominator = s1.length() + s2.length();
			System.out.println(denominator);
			System.out.println((numerator/denominator)); 
			// double result = (((lcs.length()) * 2) / ((s1.length()) + (s2.length())));
			// System.out.println(result);
		} catch (Exception e) {
			System.out.println("FILE NOT FOUND");
		}
	}
}
