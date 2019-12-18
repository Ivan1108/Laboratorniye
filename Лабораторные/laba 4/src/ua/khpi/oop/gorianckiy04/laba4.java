package ua.khpi.oop.gorianckiy04;

	import java.lang.String;
	import java.util.Scanner;
	
	public class laba4 {
		public static void main(String[] args) {
			for(int i =0;i<args.length;i++) {
			if(args[i].equals("-h") ) {
				System.out.println("Author: Gorianskyi Ivan.");
				System.out.println("Group:101.8Б");
				System.out.println("Task: Використовуючи програму рішення завдання лабораторної роботи №3, відповідно до прикладної задачі забезпечити обробку команд користувача у вигляді текстового меню:\r\n" + 
						"введення даних;\r\n" + 
						"перегляд даних;\r\n" + 
						"виконання обчислень;\r\n" + 
						"відображення результату;\r\n" + 
						"завершення програми і т.д.");
				System.out.println("Case 1 - Ввод данных");
				System.out.println("Case 2 - Вывод данных");
				System.out.println("Case 3 - Решения задания");
				System.out.println("Case 4 - Результат решения");
				System.out.println("Case 5 - Вывод для консоли");
				System.out.println("Case 6 - Выход из програми");
			}else {
				if(args[i].equals("-d")) {
					String STR = null;
					int k = 0;
					char[] strtoChar = null;
					STR=funcs.Data();
					k= funcs.data();
					strtoChar = STR.toCharArray();
					STR = funcs.solution(strtoChar, k);
					funcs.out(STR,k);
				}
			}
			}
			int loop = 1;
			String str = null;
			int k = 0;
			char[] strtoChar = null;
			
			
			while(loop == 1) {	
				funcs.ChooseMenu();
				Scanner ch = new Scanner(System.in);
				int choose =ch.nextInt();
				switch(choose) {
				case 1:
					str=funcs.Data();
					k=funcs.data();
					break;
				case 2:
					funcs.out(str,k);
					break;
				case 3:
					strtoChar = str.toCharArray();
					str = funcs.solution(strtoChar,k);
					break;
				case 4:
					System.out.println("Result: " + str);
					break;
				case 5:	
					funcs.console();
					break;
				case 6:
					loop = 0;
					break;
				}
			}
		}
	}
	

	
		
		
	
	

