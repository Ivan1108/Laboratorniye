package ua.khpi.oop.gorianckiy05;

import java.util.Arrays;
import java.util.Scanner;

public class container {

	private int size = 0;	
	private String[] mass = new String[size];

	public void Clear() {
		for(int i =0;i<mass.length;i++) {
			mass[i] = null;
		}
		for(String i :mass) {
			System.out.print(i+ " ");
		}
		System.out.println();
		
	}
	 public void out() {
			System.out.print("Array:");
		 for(String i :mass) {
				System.out.print(i+ " ");
			}
			System.out.println();
	 }


	public void add(String strnew) {
		if (mass.length == 0) {
			mass = new String[mass.length+1];
			mass[mass.length-1] = strnew;
		} else {
			String[] newMass = Arrays.copyOf(mass, mass.length+1);
			newMass[mass.length] = strnew;
			mass = Arrays.copyOf(newMass, newMass.length);	
		}
	
	}
	public  String func() {
		System.out.println("Enter your string: ");
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		System.out.println("Enter your number: ");
	Scanner n = new Scanner(System.in);
	int k = n.nextInt();
	char[] strtoChar = str1.toCharArray();
	if(k>strtoChar.length) {
		System.out.println("Number > str.length");
	}else {
	for(int i =k-1;i< strtoChar.length;i+=k) {
		strtoChar[i] = '$';
	}
	}
	
	String str = new String(strtoChar);
	str.toString();
	return str;
	
	

}	
	public String toString () {

//		String str = mass.toString();
//		
//		System.out.println(str);
		StringBuilder strbuild = new StringBuilder();
		for(int i =0;i<mass.length;i++) {
			strbuild.append(mass[i]);
			strbuild.append(" ");
		}
		String str = strbuild.toString();
		System.out.print("Array after StringBuilder :");
		for(int i =0;i<1;i++) {
			System.out.print(str);
		}
		System.out.println();
//		System.out.print("Array:");
//		for(String i:mass) {
//			System.out.print(i+ " ");
//		}
//		System.out.println();
		return null;
	}
	
	public void remove() {

		Scanner num = new Scanner(System.in);
		int curnum = num.nextInt();
		size = mass.length;
		String[] newmass = new String[mass.length-1];
		int j = 0;
	    for (int i = 0; i < size; i++) {      
	    	if(i == curnum) {
	    		continue;
	    	} else {
	    		newmass[j++] = mass[i];
	    	}
	    }
	    mass = Arrays.copyOf(newmass,newmass.length);
	    System.out.print("Array:");
	    for(String i:newmass) {
	    	System.out.print(i+ " ");
	    }
		System.out.println();
	}
	
	
//	public Object[] toArray(String[]mass) {
//		if(mass == null) {
//			return null;
//		}
//		return Arrays.copyOf(mass,mass.length);
//	}
	
	public int size() {
		System.out.println("Count of elements = " + mass.length);
		return mass.length;

	}
	public boolean contains() {
		Scanner elem = new Scanner(System.in);
		String el = elem.next();
		boolean st = false;
		for(int i =0;i<mass.length;i++) {
			if(mass[i].equals(el)) {
				st = true;
			}
		}
		return st;
	}
	
	public boolean containsAll(String str1,String str2,String str3) {	
		boolean res = false;
		for(int j=0;j<1;j++) {
			for(int i =0;i<mass.length;i++) {
				if(mass[i] == str1 || mass[i] == str2 || mass[i]==str3) {
					res = true;
				}
			}
		}
		return res;
	}
	
	
	
	public  void Iterator (){
		ArrayContainer arrayContainer = new ArrayContainer();
		Iterator iterator =arrayContainer.getIterator();
		
		while(iterator.hasNext()) {
			System.out.print((String)iterator.next()+ " ");
		}
		System.out.println(" ");
		System.out.print(iterator.remove());
	}
	
	
	interface Iterator{
		boolean hasNext();
		Object remove();
		Object next();
	}
	interface Container{
	Iterator getIterator();
	}

	 	class ArrayContainer implements Container{
		String[] array = {"Ivan","Horianckiy","18"};

		@Override
		public Iterator getIterator() {
			return new ArrayIterator();
		}
		
		private class ArrayIterator implements Iterator{
			int index = 0;
			
			@Override
			public boolean hasNext() {
				
				return (index < array.length) ? true : false;
			}
			
			@Override
			public Object next() {
				if(hasNext()) {
					return array[index++];
				}
				return null;
			}
			
			@Override
			public Object remove() {
				int temp = index;
				for(int i = index;i<array.length;i++) {
					array[temp++] =array[i+1];
				}
				return null;
			}
				
			}
		}

	
	
	}


