package ua.khpi.oop.gorianckiy09;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Iterator;

public interface Linked<T> {
    void addLast(T obj);
    void addFirst(T obj);
    int size();
    T getElementByIndex(int index);
    void add(T obj);
    void clear();
	void toFile();
	void FromFile() throws ParseException;
	void readAll();
	void DelAll();
	void toFileAll();
	void checkEmptiness();
}

