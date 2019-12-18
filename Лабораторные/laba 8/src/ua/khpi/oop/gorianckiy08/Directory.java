package ua.khpi.oop.gorianckiy08;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Directory {
	
	private String Address;
	private String Name;
	private String Special;
	private String Phone;
	private Date StartTime;
	private Date EndTime;
	String str1;
	String str2;
	
	Directory(){
		Address = null;
		Name = null;
		Special = null;
		Phone = null;
		StartTime = null;
		EndTime = null;
	}
	
	Directory(final Directory obj){
		Address = obj.Address;
		Name = obj.Name;
		Special = obj.Special;
		Phone = obj.Phone;
		StartTime = obj.StartTime;
		EndTime = obj.EndTime;
		
	}
	public void setAddress(String Address) {
		this.Address =Address;
	}
	public void setName(String Name) {
		this.Name = Name;
	}	
	public void setSpecial(String Special) {
		this.Special = Special;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
		
	}
	public void setTime(final String d) throws ParseException {
		if(checkTime(d)) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		this.StartTime = sdf.parse(d);
		}
	}
	public void setTime1(String d) throws ParseException{
		if(checkTime(d)) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		this.EndTime = sdf.parse(d);
		}
	}
	
	private boolean checkTime(final String d) {
        final String tf = "HH:mm";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(tf);
            sdf.setLenient(false);
            sdf.parse(d);
            
            return true;	
        } catch (ParseException e) {
        	System.out.println("Error:" + e);
            return false;
        }
    }	
//	private boolean checkNumber(String Phone) {
//		Pattern pattern = Pattern.compile("[0-9]");
//		Matcher matcher = pattern.matcher(Phone);
//		return matcher.matches();
//	}
	String getAddress() {
		return Address;
	}
	String getName() {
		return Name;
	}	
	String getSpecial() {
		return Special;
	}
	String getPhone() {
		return Phone;
	}
	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(this.StartTime);
	}
	public String getTime1() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(this.EndTime);
	}
	
		
	 public void generateStore() throws ParseException,IOException {
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter name of outlet");
		 Name = s.nextLine();
		 System.out.println("Enter Address");
		 Address = s.nextLine();
		 System.out.println("Enter Specialization");
		 Special = s.nextLine();
		 Pattern pattern = Pattern.compile("\\d{10,12}");
			String str = null;
			Matcher m = null;
			do {
				System.out.println("Enter Phone number");
				str = s.nextLine();
				m = pattern.matcher(str);
			}while(!m.matches());
		 Phone = str;
		 
		 do {
			 System.out.println("Enter begining of work");
			 str1 = s.nextLine();
		 }while(!checkTime(str1));
		 setTime(str1);
		 do {
			 System.out.println("Enter ending of work");
			 str1 = s.nextLine();
		 }while(!checkTime(str1));
		 setTime1(str1);
		 
	 }
	
}
