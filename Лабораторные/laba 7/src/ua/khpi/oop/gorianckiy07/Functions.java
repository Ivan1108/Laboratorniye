package ua.khpi.oop.gorianckiy07;

import java.util.Arrays;

public class Functions {

	private static int size = 0;	
	private static Directory[] array = new Directory[size];
	void add(Directory temp) {
		Directory buf = new Directory(temp);
		if (size == 0) {
            array = Arrays.copyOf(array, array.length +1);
            array[array.length -1] = buf;
        } else {
        	Directory[] newArray = Arrays.copyOf(array, array.length+1);
			newArray[array.length] = buf;
			array = Arrays.copyOf(newArray,newArray.length);
        }
    

	}
	void show() {
		if(array.length == 0) {
		System.out.println("No data!");
		}else {
			for(int i =0;i<array.length;i++) {
				System.out.println("Shop centure #" + i+1);
				System.out.println("Name of Shop centure: "+array[i].getName());
				System.out.println("Address of Shop centure: "+array[i].getAddress());
				System.out.println("Specialization of Shop centure: "+array[i].getSpecial());
				System.out.println("Phone number of Shop centure: "+array[i].getPhone());
				System.out.println("Work time of Shop centure: "+array[i].getTime() + "-" + array[i].getTime1());
			}
		}
	}
}
