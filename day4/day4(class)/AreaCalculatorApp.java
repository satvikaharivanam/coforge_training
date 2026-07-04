package com.coforge.day4;

public class AreaCalculatorApp {

	public static void main(String[] args) {
		/*
		Rectangle rectangle = new Rectangle();
		rectangle.area();
		
		Square square = new Square();
		square.area();
		
		Triangle triangle = new Triangle();
		triangle.area();
		*/
		
		
		// this is runtime polymorphosis - dynamic method dispatch 
		// one reference handling different objects. 
		Figure figure; // superclass reference for subclass object 
		figure = new Rectangle();
		figure.area();
		figure = new Square();
		figure.area();
		figure = new Triangle();
		figure.area();
		
//		Rectangle rectangle = (Rectangle) new Figure(5); 
		// java.lang.ClassCastException - the reverse of dmd is not possible 
	}

}
