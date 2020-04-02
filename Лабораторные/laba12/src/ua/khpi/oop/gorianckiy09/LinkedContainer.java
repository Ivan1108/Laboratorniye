package ua.khpi.oop.gorianckiy09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkedContainer<T extends Directory> implements Linked<T>, Iterable<T>,DescendingIterator<T> {
    //конструктор инициализации
	private class Node<T> {
        private T currElem; //текущий
        private Node<T> prevElem; //предыдущий
        private Node<T> nextElem; //следущий

        //конструктор копирования
        Node( T currElem, Node<T> prevElem, Node<T> nextElem) {
            this.currElem = currElem;
            this.prevElem = prevElem;
            this.nextElem = nextElem;
        }


        //геттеры и сеттеры
        public T getCurrentElem() {
            return currElem;
        }

        public void setCurrentElem( T currentElem) {
            this.currElem = currentElem;
        }

        public Node<T> getPrevElem() {
            return prevElem;
        }

        public void setPrevElem(Node<T> prevElem) {
            this.prevElem = prevElem;
        }

        public Node<T> getNextElem() {
            return nextElem;
        }

        public void setNextElem(Node<T> nextElem) {
            this.nextElem = nextElem;
        }
    }

	private Node<T> fstNode;
	private Node<T> lstNode;
	private int size = 0;
	
	public LinkedContainer() {
	fstNode = new Node<T>(null,null,lstNode);
	lstNode = new Node<T>(null,fstNode,null);
	fstNode = new Node<T>(null,null,lstNode);
}

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public T next() {
                if (this.hasNext()) {
                    return getElementByIndex(position++);
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int position = size - 1;

            @Override
            public boolean hasNext() {
                return position >= 0;
            }

            @Override
            public T next() {
                if (this.hasNext()) {
                    position--;
                    return getElementByIndex(position--);
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

 

    @Override
    public void clear() {
        for (Node<T> x = fstNode; x != null; ) {
            Node<T> next = x.nextElem;
            x.currElem = null;
            x.nextElem = null;
            x.prevElem = null;
            x = next;
        }
        fstNode = null;
        lstNode = null;
        lstNode = new Node<>(null, fstNode, null);
        fstNode = new Node<>(null, null, lstNode);
        size = 0;
    }
   
    

    @Override
    public void add(final T t) {
        addLast(t);
    }


    @Override
    public void toFile()  {
		try {
		File file = new File("File.txt");
		if(!file.exists()) 
			file.createNewFile();
		PrintWriter pw = new PrintWriter(file);
		Directory temp ;
		System.out.println();
		pw.println(size);
		for(int i=0;i<size;i++) {
			temp =(Directory)getElementByIndex(i);
			pw.println(temp.getName());
			pw.println(temp.getAddress());
			pw.println(temp.getSpecial());
			pw.println(temp.getPhone());
			pw.println(temp.getTime() );
			pw.println(temp.getTime1());
			
		}
		pw.close();
	}
		catch(IOException e){
		System.out.print("Error: " + e);
	}

}

    @Override
    public void readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader("File1.txt"))) {
            Object temp;
            String line;
            line = br.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                temp = line;
                add((T) temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
	public void FromFile() throws ParseException {
	BufferedReader br = null;
	Directory temp = new Directory();
	try {
		br = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspace\\laba12\\File1.txt"));
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
			Line = br.readLine();
			temp.setFreeTime(Line);
			Line = br.readLine();
			temp.setConsultation(Line);
			add((T) new Directory(temp));
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


    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> temp = fstNode; i < size; temp = temp.nextElem) {
            result[i++] = temp.currElem;
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }



    @Override
    public void addLast(final T obj) {
        Node<T> prev = lstNode; //сохранение данных хвоста
        prev.setCurrentElem((T)new Directory(obj)); //установка значения
        lstNode = new Node<>(null, prev, null); //изменение указателя хвоста
        prev.setNextElem(lstNode); //установка указателя на хвост
        size++; //увелечение размера списка
    }

    @Override
    public void addFirst(final T obj) {
        Node<T> next = fstNode;
        next.setCurrentElem(obj);
        fstNode = new Node<>(null, null, next);
        next.setPrevElem(fstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getElementByIndex(final int index) {
        Node<T> target = fstNode.getNextElem(); //след элемент первого узла
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElem();
    }

    private Node<T> getNextElement(final Node<T> index) {
        return index.getNextElem();
    }

	@Override
	public void DelAll() {
		  fstNode = null;
	        lstNode = null;
	        lstNode = new Node<>(null, fstNode, null);
	        fstNode = new Node<>(null, null, lstNode);
	        size = 0;
	    
		
	}

	@Override
	public void toFileAll() {
		try {
			File file = new File("File.txt");
			if(!file.exists()) 
				file.createNewFile();
			PrintWriter pw = new PrintWriter(file);
			System.out.println();
			pw.println(size);
			for(int i=0;i<size;i++) {
				pw.println(getElementByIndex(i));
			}
			pw.close();
		}
			catch(IOException e){
			System.out.print("Error: " + e);
		}
		
		
	}

	@Override
	public void checkEmptiness() {
		if(size >0) {
			System.out.println("Container is not empty");
		}else {
			System.out.println("Conteiner is empty");
		}
		
		
		
	}

	

    
}


	


