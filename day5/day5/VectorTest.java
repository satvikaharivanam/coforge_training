package com.coforge.day5;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		
		Vector<Integer> list1 = new Vector<Integer>();
		list1.add(new Integer(10)); 
		list1.add(20);
		list1.add(30);
		list1.add(40);
		list1.add(20);
		System.out.println(list1);
		
		list1.remove(3);
		
		System.out.println(list1);
		list1.remove(Integer.valueOf(20));
		System.out.println(list1);
		
		list1.set(2, 60);
		
		System.out.println(list1);
		System.out.println("using for loop");
		for(int i=0;i<list1.size();i++) System.out.println(list1.get(i));
		
		System.out.println();
		System.out.println("using enhanced loop");
		for(int i:list1) System.out.println(i);
		
		System.out.println();
		System.out.println("using iterator");
		Iterator<Integer> iterator = list1.iterator();
		while(iterator.hasNext()) System.out.println(iterator.next());
		
		System.out.println();
		
		System.out.println("using enmueration");
		Enumeration<Integer> e = list1.elements();
		while(e.hasMoreElements()) System.out.println(e.nextElement());
		
		
		
	}

}
