package ua.khpi.oop.gorianckiy08;

import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
	
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
	public void ChooseMenu() {
		  System.out.println("\n\nChoose what you want to do:");
	        System.out.println("1. Add directory");
	        System.out.println("2. Show directory");
	        System.out.println("3. Out to File ");
	        System.out.println("4. Out from File ");
	        System.out.println("5. Xml");
	        System.out.println("6. Work with File ");
	        System.out.println("0. Exit");
	        System.out.print("Write:");
	}
	public void ChooseMenuFile() {
		System.out.println("\n\nChoose what you want to do:");
        System.out.println("1. Show directory");
        System.out.println("2. Create directory");
        System.out.println("3. Rename directory");
        System.out.println("4. Create File");
        System.out.println("5. Data output to a file ");
        System.out.println("6. Exit");
        System.out.print("Write:");
	}
	void toFile()  {
		try {
		File file = new File("File.txt");
		if(!file.exists()) 
			file.createNewFile();
		PrintWriter pw = new PrintWriter(file);
		System.out.println();
		for(int i=0;i<array.length;i++) {
			pw.println(size);
			pw.println(array[i].getName());
			pw.println(array[i].getAddress());
			pw.println(array[i].getSpecial());
			pw.println(array[i].getPhone());
			pw.println(array[i].getTime() );
			pw.println(array[i].getTime1());
			
		}
		pw.close();
	}
		catch(IOException e){
		System.out.print("Error: " + e);
	}

}
	void toFile(String Path)  {
		try {
		File file = new File(Path);
		if(!file.exists()) 
			file.createNewFile();
		PrintWriter pw = new PrintWriter(file);
		for(int i=0;i<array.length;i++) {
			pw.println(size);
			pw.println(array[i].getName());
			pw.println(array[i].getAddress());
			pw.println(array[i].getSpecial());
			pw.println(array[i].getPhone());
			pw.println(array[i].getTime() );
			pw.println(array[i].getTime1());
			
		}
		pw.close();
	}
		catch(IOException e){
		System.out.print("Error: " + e);
	}

}
	void FromFile() throws ParseException {
		BufferedReader br = null;
		Directory temp = new Directory();
		try {
			br = new BufferedReader(new FileReader("File.txt"));
			String Line;
			Line = br.readLine();
			size = Integer.parseInt(Line);
			for(int i =0;i<array.length;i++){
				Line = br.readLine();
				temp.setName(Line);
				Line = br.readLine();
				temp.setAddress(Line);
				Line = br.readLine();
				temp.setSpecial(Line);
				Line = br.readLine();
				temp.setPhone(Line);
				Line = br.readLine();
				temp.setTime(Line);
				Line = br.readLine();
				temp.setTime1(Line);
				array[i] = new Directory(temp);	
			}
			
				}catch(IOException e) {
					System.out.print("Error: " + e);
					}finally {
			try {
				br.close();
		}catch(IOException e ) {	
			System.out.print("Error: " + e);
		}
	}
	}
}