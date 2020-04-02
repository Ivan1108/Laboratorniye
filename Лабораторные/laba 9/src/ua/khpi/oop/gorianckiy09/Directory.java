package ua.khpi.oop.gorianckiy09;

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
		private String StartTime;
		private String EndTime;
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
		
		
		@Override
		public String toString() {
			return "Address=" + Address + "\nName=" + Name + "\nSpecial=" + Special + "\nPhone=" + Phone
					+ "\nStartTime=" + StartTime + "\nEndTime=" + EndTime;
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
		public void setTime(String Time) {
			this.StartTime = Time;
		}
		public void setTime1(String Time1) {
			this.EndTime = Time1;
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
			 Pattern pattern1 = Pattern.compile("[0-9]{2}:[0-9]{2}");
			 String str1 = null;
			 Matcher mat1 = null;
			 do {
				 System.out.println("Enter StartTime:");
				 str1 =s.nextLine();
				 mat1 = pattern1.matcher(str1);
			 }while(!mat1.matches());
			 StartTime = str1;
			 Pattern pattern2 = Pattern.compile("[0-9]{2}:[0-9]{2}");
			 String str2 = null;
			 Matcher mat2 = null;
			 do {
				 System.out.println("Enter StartTime:");
				 str2 =s.nextLine();
				 mat2 = pattern2.matcher(str1);
			 }while(!mat2.matches());
			 EndTime = str2;
			 
		 }
		
	}

