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
			for(int i =0;i < files.length;i++) {
				for(int j =0;j < files.length;j++) {
					Distance map1 = new Distance(files[i]);
					Distance map2 = new Distance(files[j]);
					System.out.println(map1.angle(map2) + " : " + files[i] + " , "+ files[j]);
				}
				System.out.println("---------------------");
				
			}
			

			
		} catch(Exception e) {
			System.out.println("empty directory");
		}
		
	}
}