package ua.khpi.oop.gorianckiy09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaContainer {
	
	private ArrayList<Directory> arraylist = new ArrayList<>();
	private LinkedList<Directory> linkedlist = new LinkedList<>();
	public Scanner scan = new Scanner(System.in);

	public void Emptines() {
		if(arraylist.size() > 0) {
			System.out.println("Container isn't empty");
		}else {
			System.out.println("Container is empty");
		}

	}
	public void show() {
		for(Directory al :arraylist) {
			System.out.println(al);
		}
		System.out.println();
	}

	public void delete() {

		int index = scan.nextInt();
		arraylist.remove(index);
	}

	public  void add(Directory obj) {
		arraylist.add(obj);
	}

	public void sortByName() {
		arraylist.sort(Directory.comparatorName);
	}

	public void sortByAddres() {
		arraylist.sort(Directory.comparatorAddres);
	}

	public void sortBySpecial() {
		arraylist.sort(Directory.comparatorSpecailization);
	}

	public void search(Directory obj) {
		for(Directory dir : arraylist) {
			if(dir == obj ) {
			System.out.println(dir);
			}
		}
	}

	public  void save() {
		try {
			File file = new File("File.txt");
			if(!file.exists()) 
				file.createNewFile();
			PrintWriter pw = new PrintWriter(file);
			Directory temp ;
			System.out.println();
			pw.println(arraylist.size());
			for(Directory dir : arraylist) {
				temp = dir;
				pw.println(temp.getName());
				pw.println(temp.getAddress());
				pw.println(temp.getSpecial());
				pw.println(temp.getPhone());
				pw.println(temp.getTime() );
				pw.println(temp.getTime1());
				
			}
			pw.close();
		}catch(IOException e){
			System.out.print("Error: " + e);
		}
	}
	
	public void getFromFile() {
		BufferedReader br = null;
		Directory temp = new Directory();
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspace\\laba15\\File1.txt"));
			String Line;
			Line = br.readLine();
			int count = Integer.parseInt(Line);
			for(int i =0;i<count;i++){
				Pattern pat = Pattern.compile("^[a-zA-Z]{3,10}[0-9]{0,2}|[a-zA-Z]{3,10}\\s[a-zA-Z]{3,10}[0-9]{0,2}");
				 Matcher mat3 = null;
				 do {
					 System.out.println("Enter name of outlet");
					 Line = br.readLine();
					 mat3 = pat.matcher(Line);
				 }while(!mat3.matches());
				temp.setName(Line);
				
				Pattern patt = Pattern.compile("^[a-zA-Z]{3,10}[0-9]{0,2}|[a-zA-Z]{3,10}\\s[0-9]{0,2}|[a-zA-Z]{3,10}\\s[a-zA-Z]{3,10}[0-9]{0,2}");
				 Matcher mat4 = null;
				 do {
					 System.out.println("Enter Address");
					 Line = br.readLine();
					 mat4 = patt.matcher(Line);
				 }while(!mat4.matches());
				temp.setAddress(Line);
				
				Pattern patter = Pattern.compile("^[a-zA-Z]{3,10}|[a-zA-Z]{3,10}\\s[a-zA-Z]{3,10}");
				 Matcher mat5 = null;
				 do {
					 System.out.println("Enter Specialization");
					 Line = br.readLine();
					 mat5 = patter.matcher(Line);
				 }while(!mat5.matches());
				temp.setSpecial(Line);
				
				Pattern pattern = Pattern.compile("\\d{10,12}");
				Matcher m = null;
				do {
					System.out.println("Enter Phone number");
					Line = br.readLine();
					m = pattern.matcher(Line);
				}while(!m.matches());
				temp.setPhone(Line);
				
				 Pattern pattern1 = Pattern.compile("[0-9]{2}:[0-9]{2}");
				 Matcher mat1 = null;
				 do {
					 System.out.println("Enter StartTime:");
					 Line = br.readLine();
					 mat1 = pattern1.matcher(Line);
				 }while(!mat1.matches());
				temp.setTime(Line);
				
				 Pattern pattern2 = Pattern.compile("[0-9]{2}:[0-9]{2}");
				 Matcher mat2 = null;
				 do {
					 System.out.println("Enter EndTime:");
					Line = br.readLine();
					 mat2 = pattern2.matcher(Line);
				 }while(!mat2.matches());
				temp.setTime1(Line);
				arraylist.add(new Directory(temp));
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
