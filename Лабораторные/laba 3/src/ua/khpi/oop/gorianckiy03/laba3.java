package ua.khpi.oop.gorianckiy03;




	import java.lang.String;
	import java.util.Scanner;
	public class laba3 {
		public static void main(String[]args) {
			String str = "labalabaf afafafa";
			System.out.print("Enter number of letter: ");
			Scanner n = new Scanner(System.in);
			int k = n.nextInt();
			char[] strtoChar = str.toCharArray();
			
			newClass.func(strtoChar,k);
			
			System.out.println(strtoChar);	
		}
	}

