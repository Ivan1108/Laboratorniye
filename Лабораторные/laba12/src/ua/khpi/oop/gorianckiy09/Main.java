package ua.khpi.oop.gorianckiy09;

import java.io.IOException;
import java.text.ParseException;

public class Main {

	public static void main(final String[] args) throws ParseException, IOException {
			if(args.length!= 0) {
				if(args[0].equals("-auto")) {
					TypeOfWork.auto();
			}
		}else {
			System.out.println("Could not find value: -auto\n"
					+ "Transition to manual mode");
			TypeOfWork.menu();
			}
	}
}
