package com.coforge.day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class LinkedListTest {

	public static void main(String[] args) {
		
//		ArrayList<Integer> list = new ArrayList<>();
		
		List<Integer> list1 = new LinkedList<>();
		// vector is a legacy class
		
		
		 
		list1.add(new Integer(10)); 
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
