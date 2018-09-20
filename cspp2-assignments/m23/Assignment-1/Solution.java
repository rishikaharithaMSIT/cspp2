import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);	
			String line = scan.nextLine();
			File dir = new File(line);
			File[] files = dir.listFiles();
			for(int i =0;i < files.length-1;i++) {
				for(int j =0;j < files.length-1;j++) {
					Distance map1 = new Distance(files[0]);
					Distance map2 = new Distance(files[1]);
					System.out.println(map1.angle(map2) + " : " + files[0] + " , "+ files[1]);
				}
				
			}
			

			
		} catch(Exception e) {
			System.out.println("empty directory");
		}
		
	}
}