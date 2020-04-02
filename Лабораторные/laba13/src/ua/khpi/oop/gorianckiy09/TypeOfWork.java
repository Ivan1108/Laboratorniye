package ua.khpi.oop.gorianckiy09;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.concurrent.*;

import ua.khpi.oop.gorianckiy09.Threadik.ExampleThread;
import ua.khpi.oop.gorianckiy09.Threadik.ExampleThread1;
import ua.khpi.oop.gorianckiy09.Threadik.ExampleThread2;

public class TypeOfWork {

	public static void menu() throws ParseException, IOException, ExecutionException, InterruptedException {
		LinkedContainer<Directory> stringLinked = new LinkedContainer<>();
		Directory dir = new Directory();

		System.out.println("Welocme to Manual Mode");
		int loop = 1;
		while (loop == 1) {
			FuncNine.ChooseMenu();
			Scanner sc = new Scanner(System.in);
			int choose = sc.nextInt();

			switch (choose) {
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
				for (Directory s : stringLinked) {
					System.out.println(s);
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
			case 10:
				FuncNine.find(stringLinked);
				break;
			case 11:
				ExampleThread exampleThread = new ExampleThread();
				exampleThread.set(stringLinked);
				//new Thread(exampleThread).start();
				ExampleThread1 exampleThread1 = new ExampleThread1();
				exampleThread1.set1(stringLinked);
				//new Thread(exampleThread1).start();
				ExampleThread2 exampleThread2 = new ExampleThread2();
				exampleThread2.set2(stringLinked);
				//new Thread(exampleThread2).start();
				int time = sc.nextInt();
				long start = System.currentTimeMillis();
				ExecutorService executorService = Executors.newFixedThreadPool(3);
				Future<Boolean>future = (Future<Boolean>) executorService.submit(exampleThread);
				Future<Boolean> future1 = (Future<Boolean>) executorService.submit(exampleThread1);
				Future<Boolean> future2 = (Future<Boolean>) executorService.submit(exampleThread2);
				try {
					//Thread.sleep(40000);
					future.get(time, TimeUnit.SECONDS);
					future1.get(time, TimeUnit.SECONDS);
					future2.get(time,TimeUnit.SECONDS);
				}catch(TimeoutException ex){
					future.cancel(true);
					future1.cancel(true);
					future2.cancel(true);
				}
				long finish = System.currentTimeMillis();
				long res = finish - start;
				System.out.println(res);
				break;
			case 0:
				loop = 0;

			}
		}
	}

	public static void auto() throws ParseException {
		LinkedContainer<Directory> dir = new LinkedContainer<>();
		System.out.println("Welcome to auto-mode");
		System.out.println("Add to container new elements");
		dir.FromFile();
		System.out.println("Check if there is something in container");
		dir.checkEmptiness();
		System.out.println("Let's see what we added");
		for (Directory s : dir) {
			System.out.println(s);
		}
		System.out.println("Check size of container");
		System.out.println(dir.size());
		dir.toFile();

	}
}
