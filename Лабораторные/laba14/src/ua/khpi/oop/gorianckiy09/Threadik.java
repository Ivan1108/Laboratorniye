	package ua.khpi.oop.gorianckiy09;
	
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	
	public class Threadik {
	
		public static class ExampleThread implements Runnable {
	
			LinkedContainer<Directory> dir;
			int count = 0;
	
			@Override	
			public void run() {
	
				for (int i = 0; i < dir.size(); i++) {
					if (dir.getElementByIndex(i).getFreeTime().equals("Yes")) {
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						count++;
					}
				}
				System.out.println("FreeDay: ");
				System.out.println(count);
	
			}
	
			public void set(LinkedContainer<Directory> linkedContainer) {
				this.dir = linkedContainer;
			}
	
		}
	
		public static class ExampleThread1 implements Runnable {
			LinkedContainer<Directory> dir;
			int count1 = 0;
	
			public void set1(LinkedContainer<Directory> linkedContainer) {
				this.dir = linkedContainer;
			}
	
			@Override
			public void run() {
	
				for (int i = 0; i < dir.size(); i++) {
					if (dir.getElementByIndex(i).getTime().equals("11:00")) {
							try {
						Thread.sleep(40);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						}
						count1++;
					}
				}
				System.out.println("StartTime: ");
				System.out.println(count1);
			}
	
		}
	
		public static class ExampleThread2 implements Runnable {
			LinkedContainer<Directory> dir;
			int count2 = 0;
	
			public void set2(LinkedContainer<Directory> linkedContainer) {
				this.dir = linkedContainer;
			}
	
			@Override
			public void run() {
	
				for (int i = 0; i < dir.size(); i++) {
					if (dir.getElementByIndex(i).getTime1().equals("23:00")) {
						try {
							Thread.sleep(460);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						count2++;
						
						
					}
					
				}
				System.out.println("EndTime: ");
				System.out.println(count2);
			}
		}
	}
