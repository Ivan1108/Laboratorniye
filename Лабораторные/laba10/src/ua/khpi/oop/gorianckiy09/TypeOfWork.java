package ua.khpi.oop.gorianckiy09;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class TypeOfWork {

	
		public static void menu() throws ParseException, IOException {
			LinkedContainer<Directory>stringLinked = new LinkedContainer<>();
			Directory dir = new Directory();
			System.out.println("Welocme to Manual Mode");
			int loop = 1;
			while(loop ==1) {
				FuncNine.ChooseMenu();
				Scanner sc = new Scanner(System.in);
				int choose = sc.nextInt();
				
				switch(choose) {
				case 1:
					stringLinked.clear();
					break;
				case 2:
					stringLinked.toFileAll();
					break;
				case 3:
					stringLinked.readAll();
					break;
				case 4:
					stringLinked.checkEmptiness();
					break;
				case 5:
					for(Directory s :stringLinked) {
						System.out.println(s);
						System.out.println();
					}
					break;
				case 6:
					dir.generateStore();
					stringLinked.add(dir);
					break;
				case 7:
					FuncNine.sortByName(stringLinked);
					break;
				case 8:
					FuncNine.sortByAddres(stringLinked);
					break;
				case 9:
					FuncNine.sortBySpecial(stringLinked);
					break;
				case 0:
					loop = 0;
	
				}
			}
		}
		public static void auto() throws ParseException {
			LinkedContainer<Directory>dir = new LinkedContainer<>();
			
			System.out.println("Welcome to auto-mode");
			System.out.println("Add to container new elements");
			dir.FromFile();
			System.out.println("Check if there is something in container");
			dir.checkEmptiness();
			System.out.println("Let's see what we added");
			for(Directory s:dir) {
				System.out.println(s);
			}
			System.out.println("Check size of container");
			System.out.println(dir.size());	
			System.out.println("Output data to file");
			dir.toFileAll();
			
		}
}
