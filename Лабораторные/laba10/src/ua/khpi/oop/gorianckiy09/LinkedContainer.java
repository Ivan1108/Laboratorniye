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
		br = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspace\\laba10\\File1.txt"));
		String Line;
		Line = br.readLine();
		int count = Integer.parseInt(Line);
		for(int i =0;i<count;i++){
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
        prev.setCurrentElem((T)new Directory (obj)); //установка значения
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


	


