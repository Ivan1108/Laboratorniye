package ua.khpi.oop.gorianckiy02;

//
//
//
//�� ������!!!!!!!!!
//
//
//

import java.lang.String;
import java.util.Scanner;
public class laba3 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		Scanner count1 = new Scanner(System.in);
		String str = scan.next();
		char[] strtoChar = str.toCharArray();
		for(int i =0;i< strtoChar.length;i+=2) {
			if(i>strtoChar.length) {
				System.out.println("Word if end");	
			}else {
			strtoChar[i] = '$';
			}
		}
		System.out.println(strtoChar);	
	}
}
