import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
				while(scan.hasNext()) {
				String line = scan.nextLine();
				File dir = new File(line);
				File[] files = dir.listFiles();
				//System.out.println(Arrays.toString(files));

			}
		} catch(Exception e) {
			System.out.println("empty directory");
		}
		
	}
}