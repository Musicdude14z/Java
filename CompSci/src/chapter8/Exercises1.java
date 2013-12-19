package chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utils;

/**
 * Exercise Set 1 Chapter 8
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises1 {

	/**
	 * Main Method
	 * @param args - standard input 
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Utils.newLine(8.01);
			x8_01();
			Utils.newLine(8.02);
			x8_02();
		} catch(InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure to enter a valid input!"); //exit(1)
		}
		
		s.close();
	}
	
	/**
	 * Rectangle Class for 8.01
	 * @author Zach Kaplan
	 * @version 1.0
	 */
	private static class Rectangle {
		
		//contents as described in the book
		
		double width = 1, height = 1;
		
		public Rectangle() {}
		
		public Rectangle(double w, double h) {
			width = w;
			height = h;
		}
		
		public double getArea() {
			return width * height;
		}
		
		public double getPerimeter() {
			return width*2 + height*2;
		}
		
	}
	
	/**
	 * Tester Method for Rectangle Class, 8.01
	 * Prints data about 2 different Rectangles
	 */
	private static void x8_01() {
		Rectangle[] r = { new Rectangle(4, 40), new Rectangle(3.5, 35.9) };
		for(int i=0; i<r.length; i++) {
			System.out.printf("Rectangle #%d:\n" +
					"  Dimensions: %.02fx%.02f\n" +
					"  Area: %.02f\n" +
					"  Permimeter: %.02f\n", i+1, r[i].width, r[i].height,
					r[i].getArea(), r[i].getPerimeter());
		}
	}
	
	/**
	 * Stock Class for 8.02
	 * @author Zach Kaplan
	 * @version 1.0
	 */
	private static class Stock {
		
		//contents as described in the book
		
		String symbol, name;
		double previousClosingPrice, currentPrice;
		
		public Stock(String sym, String n) {
			symbol = sym;
			name = n;
		}
		
		public double getChangePercent() {
			return (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
		}
		
	}
	
	/**
	 * Tester method for Stock Class, 8.02
	 * Creates a Stock and prints values
	 */
	private static void x8_02() {
		Stock s = new Stock("ORCL", "Oracle Corporation");
		s.previousClosingPrice = 34.5;
		s.currentPrice = 34.35;
		System.out.println("Percent Change is: " + s.getChangePercent() + "%");
	}

}
