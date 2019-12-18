package ua.khpi.oop.gorianckiy07;

import java.io.IOException;
import java.text.ParseException;

public class Main {
	public static void main(String []args) throws ParseException, IOException {

	Directory MyDirectory = new Directory();
	Functions MyFunctions = new Functions();
	
	MyDirectory.generateStore();
	MyFunctions.add(MyDirectory);
	MyDirectory.generateStore();
	MyFunctions.add(MyDirectory);
	MyFunctions.show();
	}
}
