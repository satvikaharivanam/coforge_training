package day6.java8;

@FunctionalInterface
interface Calculator{
	public int calc(int a,int b);
}
public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calculator = (a,b) -> a+b;
		System.out.println("SUM : "+calculator.calc(9,8));
		
		calculator = (a,b) -> a-b;
		System.out.println("DIFFERENCE : "+calculator.calc(9, 2));
		
	}

}
