
import java.util.*;
public class Solution
{/*
	Fill this main function to print maximum of given array
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int size= sc.nextInt();
		int[] arr = new int[size];
		arr[0] = sc.nextInt();
		int max = arr[0];
		for (int i = 1; i < size;i++){
			arr[i] = sc.nextInt();
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max);

		

	}
}
