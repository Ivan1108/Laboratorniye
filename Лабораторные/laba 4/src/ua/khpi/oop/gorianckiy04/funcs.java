package ua.khpi.oop.gorianckiy04;

import java.util.Scanner;

public class funcs {
	private static Scanner scan = new Scanner(System.in);
	public static void ChooseMenu() {
		System.out.println("Choose what do you want to do: ");
		System.out.println("1.Data entry");
		System.out.println("2.Data out");
		System.out.println("3.Solution");
		System.out.println("4.Result");
		System.out.println("5.Console");
		System.out.println("6.Exit from the program");
	}
	
	public static String Data() {
		String str = scan.nextLine();
		return str;
	}
	public static int data() {
		int k = scan.nextInt ();
		scan.nextLine();
		return k;
	}
	public static String  solution(char[] strtoChar,int k) {
		if(k>strtoChar.length) {
			System.out.println("Number > str.length()");	
		}else {
		for(int i =k-1;i< strtoChar.length;i+=k) {
			strtoChar[i] = '$';	
		}
		} 
		String str = new String(strtoChar);
		str.toString();
		return str;
	}
	
	public static void out(String str,int k) {
		System.out.println("String = " + str);
		System.out.println("Number = "+ k);
	}

	public static void console() {
		String symbol = scan.nextLine();
		String str = "h";
		String str1 = "Help";
		String str2 = "d";
		String str3 = "debug";
		if(symbol.equals(str)|| symbol.equals(str1)) {
			System.out.println("Author: Gorianskyi Ivan.");
			System.out.println("Group:101.8�");
			System.out.println("Task: �������������� �������� ������ �������� ����������� ������ �3, �������� �� ��������� ������ ����������� ������� ������ ����������� � ������ ���������� ����:\r\n" + 
					"�������� �����;\r\n" + 
					"�������� �����;\r\n" + 
					"��������� ���������;\r\n" + 
					"����������� ����������;\r\n" + 
					"���������� �������� � �.�.");
			System.out.println("Case 1 - ���� ������");
			System.out.println("Case 2 - ����� ������");
			System.out.println("Case 3 - ������� �������");
			System.out.println("Case 4 - ��������� �������");
			System.out.println("Case 5 - ����� ��� �������");
			System.out.println("Case 6 - ����� �� ��������");
		}
		if(symbol.equals(str2) || symbol.equals(str3)) {
			String STR = null;
			int k = 0;
			char[] strtoChar = null;
			STR=Data();
			k= data();
			strtoChar = STR.toCharArray();
			STR = solution(strtoChar, k);
			out(STR,k);
		}
		
	}
	
}