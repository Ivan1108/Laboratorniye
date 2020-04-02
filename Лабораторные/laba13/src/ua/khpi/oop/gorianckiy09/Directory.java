package ua.khpi.oop.gorianckiy09;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Directory {

	private String Address;
	private String Name;
	private String Special;
	private String Phone;
	private String StartTime;
	private String EndTime;
	private String FreeTime;
	private String Consultation;
	String str1;
	String str2;

	Directory() {
		Address = null;
		Name = null;
		Special = null;
		Phone = null;
		StartTime = null;
		EndTime = null;
		FreeTime = null;
		Consultation = null;
	}

	@Override
	public String toString() {
		return "\nAddress=" + Address + "\nName=" + Name + "\nSpecial=" + Special + "\nPhone=" + Phone + "\nStartTime="
				+ StartTime + "\nEndTime=" + EndTime + "\nFreeDay =" + FreeTime + "\nConsulation=" + Consultation;
	}

	Directory(final Directory obj) {
		Address = obj.Address;
		Name = obj.Name;
		Special = obj.Special;
		Phone = obj.Phone;
		StartTime = obj.StartTime;
		EndTime = obj.EndTime;
		FreeTime = obj.FreeTime;
		Consultation = obj.Consultation;

	}

	public void setAddress(String Address) {
		this.Address = Address;
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

	public void setTime(String Time) {
		this.StartTime = Time;
	}

	public void setTime1(String Time1) {
		this.EndTime = Time1;
	}

	public void setFreeTime(String FreeTime) {
		this.FreeTime = FreeTime;
	}

	public void setConsultation(String Consult) {
		this.Consultation = Consult;
	}

	String getFreeTime() {
		return FreeTime;
	}

	String getConsultation() {
		return Consultation;
	}

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
//			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//			return sdf.format(this.StartTime);
		return StartTime;
	}

	public String getTime1() {
//			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//			return sdf.format(this.EndTime);
		return EndTime;
	}

	public void generateStore() throws ParseException, IOException {
		Scanner s = new Scanner(System.in);
		Pattern pat = Pattern.compile("^[a-zA-Z]{3,10}[0-9]{0,2}|[a-zA-Z]{3,10}\\s[a-zA-Z]{3,10}[0-9]{0,2}");
		String str3 = null;
		Matcher mat3 = null;
		do {
			System.out.println("Enter name of outlet");
			str3 = s.nextLine();
			mat3 = pat.matcher(str3);
		} while (!mat3.matches());
		Name = str3;
		Pattern patt = Pattern.compile(
				"^[a-zA-Z]{3,10}[0-9]{0,2}|[a-zA-Z]{3,10}\\s[0-9]{0,2}|[a-zA-Z]{3,10}\\s[a-zA-Z]{3,10}[0-9]{0,2}");
		String str4 = null;
		Matcher mat4 = null;
		do {
			System.out.println("Enter Address");
			str4 = s.nextLine();
			mat4 = patt.matcher(str4);
		} while (!mat4.matches());
		Address = str4;
		Pattern patter = Pattern.compile("^[a-zA-Z]{3,10}");
		String str5 = null;
		Matcher mat5 = null;
		do {
			System.out.println("Enter Specialization");
			str5 = s.nextLine();
			mat5 = patter.matcher(str5);
		} while (!mat5.matches());
		Special = str5;
		Pattern pattern = Pattern.compile("\\d{10,12}");
		String str = null;
		Matcher m = null;
		do {
			System.out.println("Enter Phone number");
			str = s.nextLine();
			m = pattern.matcher(str);
		} while (!m.matches());
		Phone = str;
		Pattern pattern1 = Pattern.compile("[0-9]{2}:[0-9]{2}");
		String str1 = null;
		Matcher mat1 = null;
		do {
			System.out.println("Enter StartTime:");
			str1 = s.nextLine();
			mat1 = pattern1.matcher(str1);
		} while (!mat1.matches());
		StartTime = str1;
		Pattern pattern2 = Pattern.compile("[0-9]{2}:[0-9]{2}");
		String str2 = null;
		Matcher mat2 = null;
		do {
			System.out.println("Enter EndTime:");
			str2 = s.nextLine();
			mat2 = pattern2.matcher(str2);
		} while (!mat2.matches());
		EndTime = str2;
		System.out.println("Enter availability of FreeTime: ");
		FreeTime = s.nextLine();
		System.out.println("Enter availability of Consultation: ");
		Consultation = s.nextLine();

	}

	public static Comparator<Directory> comparatorName = new Comparator<Directory>() {
		@Override
		public int compare(Directory o1, Directory o2) {
			return o1.getName().compareTo(o2.getName());
		}
	};
	public static Comparator<Directory> comparatorAddres = new Comparator<Directory>() {

		@Override
		public int compare(Directory o1, Directory o2) {
			return o1.getAddress().compareTo(o2.getAddress());
		}
	};
	public static Comparator<Directory> comparatorSpecailization = new Comparator<Directory>() {

		@Override
		public int compare(Directory o1, Directory o2) {
			return o1.getSpecial().compareTo(o2.getSpecial());
		}

	};
}
