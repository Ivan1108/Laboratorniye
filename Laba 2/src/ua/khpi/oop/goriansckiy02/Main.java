package ua.khpi.oop.goriansckiy02;

import java.util.Random;

public class Main {
	public static void main(String []args) {
//		int x=4;
//		int res = 4%10+1;
//		System.out.println(res);
		
			Random rand=new Random();
			int n = rand.nextInt(100);	
			System.out.println(n);
	        int i;
	        boolean isComposite = false;
	        for (i = 2; i < n; i++) {
	            if (n % i == 0) {
	                isComposite = true;
	                break;
	            }
	        }
	        if (isComposite) {
	            System.out.println("����� ��������� ");
	        } else {
	            System.out.println("�����  ������� ");
	        }
	}
}
