package day6.java8;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaEightStreamTest {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11,12,13,14,15);
		
//		List<Integer> even = list.stream().filter(n -> n%2==0).collect(Collectors.toList());
//		// stream is initial operation, filter intermediate operation(method) is the , and collect is the termination operation
//		System.out.println(even);
//		
//		long count = list.stream().filter(n -> n%2==0).count();
//		// stream is initial operation, filter intermediate operation(method) is the , and count is the termination operation
//		System.out.println(count);
//		
//
//		list.stream().filter(n -> n%2==0).forEach(i->System.out.println(i));
//		list.stream().filter(n -> n%2==0).forEach(System.out::println);
//		// stream is initial operation, filter intermediate operation(method) is the , and for each is the termination operation
////		System.out.println(count);
		
//		list.stream().filter(n -> n%2==0).map(n -> n * 2).forEach(n -> System.out.println(n));
		
		List<String> names = Arrays.asList("dosa","vada", "puri");
		
		names.stream().filter(n -> n.indexOf("a")!=-1).forEach(n-> System.out.println(n+ " "+n.length()));
		
		Date date = new Date();
		LocalTime localTime =  LocalTime.now();
		LocalDate localDate = LocalDate.now();
		System.out.println(date);
		System.out.println(localTime);
		System.out.println(localDate);
		
		Map<Integer,String> map = names.stream().collect(Collectors.toMap(x -> x.length(), x->x));
		System.out.println(map);
		
		// in stream it is parellel processing, therefore we get issue when it is same key
		
	}
}
