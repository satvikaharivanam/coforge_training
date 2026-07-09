package day6.java8;

import java.util.Arrays;
import java.util.List;

public class ForEachTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(10,20,30,40,50,33);
		
//		list.forEach(i -> System.out.println(i)); // using lambda 
		
		// trying to checking conditions using for each
		list.forEach(i ->{
			if(i%2==0) {
				System.out.println(i);
			}
		});
		
		list.forEach(System.out::println); 
		// out is the an object of printstream , and using that calling the println which is an instance method of the 
		// printstream class;
		
	}

}
