package day6.java8;

import java.util.Optional;

public class OptionalClassTest {
	public static Optional<Employee> getEmployee(){
		Employee employee = null;
		Optional<Employee> optionalEmployee = Optional.ofNullable(employee);
		
		return optionalEmployee;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Optional<Employee> optionalEmployee = getEmployee();
		
		if(optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			System.out.println(employee.getEid());
		}else System.out.println("Employee Not Found");
		
	}

}
