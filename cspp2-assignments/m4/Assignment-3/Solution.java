import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		for(int i=0;i<=n;i++){
			String s=sc.nextLine();
			String res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static String binaryToDecimal(final String s) {
		String decimalDigit = "";
		for (int i = 1; i <= s.length();i++){
			//System.out.println(s.charAt(i));
			int decimal= (int) Math.pow(2,s.length()-i) * Character.getNumericValue(s.charAt(i-1));
			System.out.println(decimal);
		}
		return decimalDigit;

	}

}
