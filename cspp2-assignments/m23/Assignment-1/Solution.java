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
			System.out.print("		");
			for(int i=0;i<files.length-1;i++) {
				System.out.print(files[i].getName()+"\t");
			}
			System.out.print(files[files.length-1].getName());
			System.out.println();
			for(int i =0;i < files.length;i++) {
				System.out.print(files[i]+"\t");
				for(int j =0;j < files.length;j++) {
					Distance map1 = new Distance(files[i]);
					Distance map2 = new Distance(files[j]);

					//printSimilarities(files[i].getName(), files[j].getName(), Math.round(map1.angle(map2)))
					System.out.print(Math.round(map1.angle(map2))+ "\t");
				}
				System.out.println();
				
			}
			

			
		} catch(Exception e) {
			System.out.println("empty directory");
		}
		
	}
	
}