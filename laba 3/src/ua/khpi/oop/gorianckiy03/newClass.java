package ua.khpi.oop.gorianckiy03;

import java.util.Scanner;

public class newClass {
	public static void func(char [] strtoChar,int k) {
		if(k>strtoChar.length) {
			System.out.println("Number > str.length");
		}else {
		for(int i =k-1;i< strtoChar.length;i+=k) {
			strtoChar[i] = '$';
		}
		}
	}
}
