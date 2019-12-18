package ua.khpi.oop.gorianckiy06;

import java.util.Scanner;


public class Main {
	public static void main(String []args) {
		
			
			container Mycontainer  = new container();
			String str2 = null;
			int loop = 1;
			while(loop == 1) {	
				Mycontainer.ChooseMenu();
				Scanner ch = new Scanner(System.in);
				int choose =ch.nextInt();
				switch(choose) {
				case 1:
					Scanner st1 = new Scanner(System.in);
					String str = st1.next();
					Mycontainer.add(str);
					break;
				case 2:
					Mycontainer.out();
					break;
				case 3:
					Mycontainer.func();
					break;
				case 4:
					Mycontainer.toString();
					break;
				case 5:
					Mycontainer.size();
					break;
				case 6:	
					 System.out.print(Mycontainer.contains());
					 System.out.println();
					break;
				case 7:
					Mycontainer.containsAll("s","hey","T");
					System.out.println();
					break;
				case 8:
					Mycontainer.remove();	
					break;
				case 9:
					Mycontainer.Clear();
					break;
				case 10:
					Mycontainer.Iterator();
				case 11:
//					Scanner sc = new Scanner(System.in);
//					String str1 = sc.next();
					Mycontainer.toFile();
					break;
				case 12:
					Mycontainer.fromFile();
					break;
				case 13:
					while(loop == 1) {
					Mycontainer.ChooseMenuLabOtherStud();
					int choose1 =ch.nextInt();
					switch(choose1) {
					case 1:
						str2 = Functions.initializeStr();
						break;
					case 2:
						Functions.showString(str2);
						break;
					case 3:
						System.out.print(Functions.sortAlphabetical(str2));
						break;
					case 4:
						System.out.print(Functions.sortByLength(str2));
						break;
					case 6:
						loop = 0;
						break;
					}
				}
				case 14:
					System.out.println(Mycontainer.comparasion());
					break;
				case 15:
					container.Alphabeticalsort();
					break;
				case 16:
					Mycontainer.Found();
					System.out.println();
					break;
				case 17:
					loop = 0;
					break;
				}
			}
	}
	}	


