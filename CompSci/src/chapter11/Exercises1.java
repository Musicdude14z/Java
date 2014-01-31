package chapter11;

import java.util.Date;
import java.util.Scanner;

import utils.Utils;
import chapter8.Exercises3.Account;

/**
 * Exercise Set 1 for Chapter 11
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises1 {

	/**
	 * Main Method
	 * @param args - cmd input
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try{
			Utils.newLine(11.01);
			x11_01(s);
			Utils.newLine(11.03);
			x11_03();
		} catch(Exception e) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure to enter a valid input!"); //exit(1);
		}
		
		s.close();
	}
	
	private static void x11_01(Scanner s) {
		System.out.print("Enter the three sides of a triangle: ");
		Triangle t = new Triangle(s.nextDouble(), s.nextDouble(), s.nextDouble());
		
		System.out.print("Enter the color of the triangle, and if it's filled (t/f): ");
		t.setColor(s.next());
		t.setFilled(s.next().equals("t"));
		
		System.out.printf("Area: %.5f\nPerimeter: %.5f\nColor: %s\nFilled: %b", 
				t.getArea(), t.getPerimeter(), t.getColor(), t.isFilled());
	}
	
	
	/**
	 * Super Class for 11.01, taken from book
	 * @author Book
	 * @version 1.0
	 */
	private static class GeometricObject {
		private String color = "white";
		private boolean filled;
		private java.util.Date dateCreated;
		
		public GeometricObject() {
			dateCreated = new java.util.Date();
		}
		
		public GeometricObject(String color, boolean filled) {
			this();
			this.color = color;
			this.filled = filled;
		}
		
		public String getColor() {
			return color;
		}
		
		public void setColor(String color) {
			this.color = color;
		}
		
		public boolean isFilled() {
			return filled;
		}
		
		public void setFilled(boolean filled) {
			this.filled = filled;
		}
		
		public java.util.Date getDateCreated() {
			return dateCreated;
		}
		
		public String toString() {
			return "created on " + dateCreated + "\ncolor: " + color +
					" and filled: " + filled;
		}
	}
	
	/**
	 * Helper Class for 11.01
	 * @author Zach Kaplan
	 * @version 1.0
	 */
	private static class Triangle extends GeometricObject {
		private double side1 = 1, side2 = 1, side3 = 1;
		
		public Triangle() {
			super();
		}
		
		public Triangle(double s1, double s2, double s3) {
			super();
			side1 = s1;
			side2 = s2;
			side3 = s3;
		}
		
		public double getSide1() {
			return side1;
		}
		
		public double getSide2() {
			return side2;
		}
		
		public double getSide3() {
			return side3;
		}
		
		public double getArea() {
			double semiP = getPerimeter() / 2;
			return Math.sqrt(semiP*(semiP-side1)*(semiP-side2)*(semiP-side3));
		}
		
		public double getPerimeter() {
			return side1 + side2 + side3;
		}
		
		@Override
		public String toString() {
			return "Triangle: side1 = " + side1 + " side2 = " + side2 +
					" side3 = " + side3;
		}
		
	}
	
	private static void x11_03() {
		CheckingAccount a1 = new CheckingAccount(), a2 = new SavingsAccount();
		System.out.println(a1);
		System.out.println(a2);
	}
	
	private static class CheckingAccount extends Account {
		
		protected double overdraft = 100;
		
		public CheckingAccount() {
			super();
		}
		
		public CheckingAccount(int id, int initBalance) {
			super(id, initBalance);
		}
		
		public void setOverdraft(double newOverdraft) {
			overdraft = newOverdraft;
		}
		
		public double getOverdraft() {
			return overdraft;
		}
		
		public void withdraw(double amt) throws IllegalArgumentException {
			if(getBalance()-amt < -overdraft) {
				throw new IllegalArgumentException("Overdrawn Account");
			}
			super.withdraw(amt);
		}
		
		public String toString() {
			return super.toString() + String.format("\nOverdraft Limit: $%.02f", overdraft);
		}
		
	}
	
	private static class SavingsAccount extends CheckingAccount {
		
		public SavingsAccount() {
			super();
			overdraft = 0;
		}
		
		public SavingsAccount(int id, int initBalance) {
			super(id, initBalance);
			overdraft = 0;
		}
		
		public void setOverdraft(double newOverdraft) {
			throw new UnsupportedOperationException("Cannot change overdraft in Savings Account");
		}
		
	}

}
