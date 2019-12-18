package ua.khpi.oop.gorianckiy08;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.text.ParseException;

import java.util.Scanner;


public class main {

	public static void main(String []args) throws ParseException, IOException {
		Directory MyDirectory = new Directory();
		Functions MyFunctions = new Functions();
		
		
		
		int loop = 1;
		while (loop == 1) {
			MyFunctions.ChooseMenu();
			Scanner sc = new Scanner(System.in);
			int choose = sc.nextInt();	
			switch(choose) {
			case 1:
				MyDirectory.generateStore();
				MyFunctions.add(MyDirectory);
				break;
			case 2:
				MyFunctions.show();
				break;
			case 3 :
				MyFunctions.toFile();
				break;
			case 4:
				MyFunctions.FromFile();
				break;
			case 5:
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.newDocument();
				Element root  = document.createElement( "root" );
				Element store = document.createElement("Store");


				document.appendChild(root);
				root.appendChild(store);
				store.setAttribute("Name","Posad");
				store.setAttribute("Addres:","Pushkinskaya 85");
				store.setAttribute("Specialization","Grocery store");
				store.setAttribute("Hotline:","+380665992793");
				store.setAttribute("Work_Time:","08:00 - 22:00");
				
				DOMImplementation impl = document.getImplementation();
				DOMImplementationLS implLS = (DOMImplementationLS)impl.getFeature("LS", "3.0");
				LSSerializer ser = implLS.createLSSerializer();
				ser.getDomConfig().setParameter("Format-pretty-print",true);
				String str =ser.writeToString(document);
				System.out.print(str);
				
				LSOutput out = implLS.createLSOutput();
				out.setEncoding("UTF-8");
				out.setByteStream(Files.newOutputStream(Paths.get("laba.xml")));
				ser.write(document,out);

				}catch (ParserConfigurationException ex) {
                    ex.printStackTrace(System.out);
                }
				break;
			case 6:
				
				int loop1 = 1;
				while(loop1==1) {
					MyFunctions.ChooseMenuFile();
					Scanner scan = new Scanner(System.in);
					int choose1 = sc.nextInt();
				switch(choose1) {
				case 1:
					System.out.println("Enter the path to file");
					Scanner scan1 = new Scanner(System.in);
					String myDir = scan1.next();
					File dir = new File(myDir);
				if(dir.isDirectory())
		        {
		            
		            for(File item : dir.listFiles()){
		              
		                 if(item.isDirectory()){
		                      
		                     System.out.println(item.getName() + "  \t folder");
		                 }
		                 else{
		                      
		                     System.out.println(item.getName() + "\t file");
		                 }
		             }
		        }
				break;
				case 3:
					System.out.println("Enter the path to file and his name ");
					Scanner scan3 = new Scanner(System.in);
					String newDir = scan3.next();
					File dir2 = new File(newDir);
					System.out.println("Enter the path to file and his new name ");
					Scanner sca = new Scanner(System.in);
					String str = scan.next();
					File reDir = new File(str);
					dir2.renameTo(reDir);
					break;
				case 2:
					System.out.println("Enter the path to file");
					Scanner scan2 = new Scanner(System.in);
					String newDir1 = scan2.next();
					File dir1 = new File(newDir1);
					boolean created = dir1.mkdir();
			        if(created)
			            System.out.println("Folder has been created");
					break;
				case 4:
					System.out.println("Enter the path to file");
					Scanner scan5 = new Scanner(System.in);
					String newDir2 = scan5.next();
					File newFile = new File(newDir2);
					 try
				        {
				            boolean created1 = newFile.createNewFile();
				            if(created1)
				                System.out.println("File has been created");
				        }
				        catch(IOException ex){
				             
				            System.out.println(ex.getMessage());
				        }  
					break;
				case 5:
					Scanner scan6 = new Scanner(System.in);
					String Path1 = scan6.next();
					File file = new File(Path1);
					if(!file.exists()) {
						System.out.println("Please,follow point 4");
					}else {
						System.out.print("Please,enter the path to file");
						Scanner scan4 = new Scanner(System.in);
						String Path = scan4.next();
						//String Path = "C:\\Users\\User\\eclipse-workspace\\laba 8\\File1.txt";
						MyFunctions.toFile(Path);
					}
					break;
				case 6:
					loop1= 0;	
					break;
			}
		}
		
			case 0 :
				loop = 0;
				break;
			}
		}
	}
}
