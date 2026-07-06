package com.coforge.day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
//		ArrayList<Integer> list = new ArrayList<>();
		
		List<Integer> list1 = new ArrayList<>(); // dynamic method dispatch because List is superclass 
		 // and ArrayList is subclass
		
		// <> is generic, saying that im storing Integer object
		// generic is a compile time process
		 
		list1.add(new Integer(10)); // this is using 'Integer' class -- boxing
		list1.add(20); // this is directly by primitive because it converting primitive to wrapper object
		 // this is auto-boxing
		
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
		
		
		
	}

}
