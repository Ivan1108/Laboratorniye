package ua.khpi.oop.gorianckiy09;

import java.io.IOException;
import java.text.ParseException;

public class Main {

	public static void main(final String[] args) throws ParseException, IOException {
			LinkedContainer<String>stringLinked1 = new LinkedContainer<>();
			LinkedContainer<Directory>dirList = new LinkedContainer<>();
			Directory dir = new Directory();
			
			System.out.println("��������� ��������");
			stringLinked1.addLast("faf");
			for(String s : stringLinked1) {
				System.out.println(s);
			}
			
			System.out.println("������� ������");
			System.out.println(stringLinked1.size());
			System.out.println("������� ����������");
			stringLinked1.clear();
			System.out.println(stringLinked1.size());
			for(String s : stringLinked1) {
				System.out.println(s);
			}
			System.out.println("������ � �����");
			
			
			
		//	stringLinked1.readAll();
			
			
			for(String s : stringLinked1) {
				System.out.println(s);
			}
			System.out.println("������� �������");
			stringLinked1.DelAll();
			System.out.println(stringLinked1.size());
			System.out.println("��������� ���� �������");
			stringLinked1.addLast("faf");
			stringLinked1.addLast("ffad");
			stringLinked1.addLast("bvca");
			stringLinked1.addLast("fafafa");
			for(String s : stringLinked1) {
				System.out.println(s);
			}
			System.out.println("������� � ����");
			//stringLinked1.toFileAll();
			System.out.println("��������� �� ��������� ���������:");
			stringLinked1.checkEmptiness();
			
			System.out.println("���������� ������ ��� ���������� ������:");
			stringLinked1.clear();
			//dir.generateStore();
			//dirList.add(dir);
			dirList.FromFile();
			for(Directory s : dirList) {
				System.out.println(s);
			}
			//dirList.toFile(); 
	}
}
