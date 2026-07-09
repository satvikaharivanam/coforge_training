package day6.java8;

@FunctionalInterface
interface MyReference{
	void showMessage();
}
public class MethodReferenceTest {
	// referring myInstanceMethod by using the MyRefernce interface is called method reference
	void myInstanceMethod() {
		System.out.println("Example for Instance Method Refernce");
	}
	
	static void myStaticMethod() {
		System.out.println("Example for Static Method Reference");
	}
	
	MethodReferenceTest(){
		System.out.println("Constructor");
	}
	
	public static void main(String[] args) {
		MethodReferenceTest obj = new MethodReferenceTest();
		MyReference reference = obj::myInstanceMethod;
		reference.showMessage();
		
		reference = MethodReferenceTest::myStaticMethod;
		reference.showMessage();
		
		reference = MethodReferenceTest::new;
		reference.showMessage();
		
	}


}
