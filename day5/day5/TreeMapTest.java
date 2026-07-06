package com.coforge.day5;

import java.util.Map.Entry;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		
		Map<Integer,String> map = new TreeMap<>(Collections.reverseOrder());
		
		map.put(10, "banana");
		map.put(5, "mango");
		map.put(20, "kiwi");
		map.put(40, "watermelon");
		
		System.out.println(map);
		
		map.put(10, "apricot");
		System.out.println(map);
		
		map.remove(20);
		System.out.println(map);
		
		System.out.println(map.get(10));
		
		
		
		for(int i:map.keySet()) System.out.println(map.get(i));
		
		Set<Integer> keys = map.keySet();
		for(int i:keys) System.out.println(i);
		
		Set<Entry<Integer,String>> entires = map.entrySet();
  		
		for(Entry<Integer,String> entry:entires) System.out.println(entry.getKey() +" "+entry.getValue());

	}

}
