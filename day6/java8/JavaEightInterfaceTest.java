package day6.java8;

interface MyInterface{
	public void myMethod1();
	public default void myMethod2() {
		// if we have default method in this then {} is  allowed 
		System.out.println("default method");
	};
	
	public static void myMethod3() {
		// if we have static method in this then {} is  allowed 
		System.out.println("static method");
	};
	
	// we can have any number of default and static methods 
	// from java 8 onwards the interface can come with definition if it is a static or default method 
	
}
public class JavaEightInterfaceTest implements MyInterface{

	@Override
	public void myMethod1() {
		// TODO Auto-generated method stub
		System.out.println("abstract method");
	}
	
	@Override
	public void myMethod2() {
		// if we have default method in this then {} is  allowed 
		System.out.println("default method");
	};
//	@Override
	public  void myMethod3() {
		// if we have static method in this then {} is  allowed 
		System.out.println("static method");
	};
	// static method cannot be overridden
	// overridden is identified based on the object and since static method don't generally need a object, it cannot be overridden
																																									
	
	
	
}
