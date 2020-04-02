package ua.khpi.oop.gorianckiy09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuncNine {

	public static void ChooseMenu() {
			System.out.println("\n\nChoose what you want to do:");
	        System.out.println("1. Delete all from  Container");
	        System.out.println("2. Output to File ");
	        System.out.println("3. Output from File ");
	        System.out.println("4. Check for emptiness");
	        System.out.println("5. Output container to screen");
	        System.out.println("6. Add to our directory new data");
	        System.out.println("7. Sort directory by Name");
	        System.out.println("8. Sort directory by Addres");
	        System.out.println("9. Sort directory by Spicialization");
	        System.out.println("10. Word processing");
	        System.out.println("0. Exit");
	        System.out.print("Write:");
	}
	public static<T extends Directory> void sortByName(LinkedContainer<T> t) {
		Directory [] array = new Directory[t.size()];
		for(int i = 0;i<t.size();i++) {
			array[i] = t.getElementByIndex(i);
		}
		Arrays.sort(array,Directory.comparatorName);
		t.clear();
		for(int i =0;i<array.length;i++) {
			t.add((T)array[i]);
		}
	}
	public static<T extends Directory> void sortByAddres(LinkedContainer<T>t) {
		Directory []array = new Directory[t.size()];
		for(int i =0;i<t.size();i++) {
			array[i] = t.getElementByIndex(i);
		}
		Arrays.sort(array,Directory.comparatorAddres);
		t.clear();
		for(int i =0;i<array.length;i++) {
			t.add((T)array[i]);
		}
	}
	public static<T extends Directory> void sortBySpecial(LinkedContainer<T>t ) {
		Directory [] array = new Directory[t.size()];
		for(int i =0;i<t.size();i++) {
			array[i] = t.getElementByIndex(i);
		}
		Arrays.sort(array,Directory.comparatorSpecailization);
		t.clear();
		for(int i =0;i<array.length;i++) {
			t.add((T)array[i]);
		}
	}
	public static <T extends Directory> void find(LinkedContainer<T>t ) {
		if(t!=null) {
			for(Directory s : t) {
				Pattern p = Pattern.compile("No");
				Matcher m = p.matcher(s.getFreeTime());
				if(m.find()) {
						Pattern pat = Pattern.compile("Yes");
						Matcher mat = pat.matcher(s.getConsultation());
						if(mat.find()) {
							System.out.println(s);
					}
				}
			}
		}else {
			System.out.println("No matches found");
		}
	}
	public static <T extends Directory> void find1(LinkedContainer<T>t,String filter,String filter1 ) {
		if(t!=null) {
			for(Directory s : t) {
				Pattern p = Pattern.compile("No");
				Matcher m = p.matcher(s.getFreeTime());
				if(m.find()) {
						Pattern pat = Pattern.compile("Yes");
						Matcher mat = pat.matcher(s.getConsultation());
						if(mat.find()) {
							System.out.println(s);
					}
				}
			}
		}else {
			System.out.println("No matches found");
		}
	}
}
