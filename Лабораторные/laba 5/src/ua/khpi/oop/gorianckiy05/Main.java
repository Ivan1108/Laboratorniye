package ua.khpi.oop.gorianckiy05;
public class Main {
	public static void main(String []args) {
		
			
			container Mycontainer  = new container();
			String  str = null;
			str = Mycontainer.func();
		 
			                          																								
			Mycontainer.add(str);
			Mycontainer.add("s");
			Mycontainer.out();
			
			Mycontainer.toString();
			
			String st = "hey";
			Mycontainer.add(st);
			Mycontainer.add("T");
			Mycontainer.out();
			Mycontainer.size();
			
			System.out.println(Mycontainer.contains());
			
			System.out.println(Mycontainer.containsAll("s","hey","T"));
			Mycontainer.remove();
			
			Mycontainer.Clear();

			Mycontainer.Iterator();
	}
	
}
