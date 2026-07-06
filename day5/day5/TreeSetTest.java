package com.coforge.day5;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		
//		ArrayList<Integer> list = new ArrayList<>();
		
		Set<Integer> set = new TreeSet<>();  
		 
		 
		set.add(new Integer(10)); 
		
		set.add(30);
		set.add(40);
		set.add(20);
		System.out.println(set);
		
		set.remove(20);
		
		System.out.println(set);
//		set.remove(Integer.valueOf(20));
		System.out.println(set);
		
//		set.set(2, 60); there is no set method in hashset
		
		System.out.println(set);
		
//		for(int i=0;i<set.size();i++) System.out.println(set.get(i)); there is no get in hashset
		
		System.out.println();
		System.out.println("using enhanced loop");
		for(int i:set) System.out.println(i);
		
		System.out.println();
		
		System.out.println("using iterator");
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()) System.out.println(iterator.next());
		
		
		
	}

}
