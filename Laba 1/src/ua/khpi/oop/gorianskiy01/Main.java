package ua.khpi.oop.gorianskiy01;
import java.lang.String;
import java.math.BigInteger;

public class Main {
	public static void func2(long number1) {
		String convert = Integer.toBinaryString( (int) number1);
        System.out.println(convert);
        
		int count;
        for (count = 0; number1 > 0; ++count) {
          number1 &= number1 - 1;
        }
        System.out.println(count);
	}
	public static void func(long number) {
		int res_ex2 =0;
		int pairNum=0;
		int notPairNum = 0;
			while(number!=0) {
				res_ex2 =(int) (number %10);
				number =  (number/10);
				if(res_ex2 !=0 && res_ex2 % 2 ==0) {
					pairNum =pairNum +1;
				}
				else {
					notPairNum =notPairNum +1;
			}
		}
			System.out.print("Count of even numbers = ");
			System.out.println(pairNum);
			System.out.print("Count of odd numbers = ");
			System.out.println(notPairNum);
			System.out.println(" ");
	}
	public static void func2(byte number) {
		int res_ex2 =0;
		int one =0;
			while(number!=0) {	
				res_ex2 =(int)number %10;
				number= (byte) (number/10);
				if(res_ex2  ==1) {
					one =one +1;
				}
		}
			System.out.print("Count of 1  = ");
			System.out.println(one);
	}
	public static void main(String []args) {
		int num_2 =5;
		int res = (num_2 -1) % 26+1;
		char engNum = (char) ((char)res+65);
		//System.out.println(engNum);
		
		int record =18018;
		long phone = 380665992793l;
		int phoneNum = 93;
		int numgroup = 5;
		
		
		func(record);
		func(phone);
		func(phoneNum);
		func(numgroup);
		func(engNum);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		func2(record);
        func2(phoneNum);
        func2(numgroup);
        func2(phone);
        func2(engNum);
	}
	
}
