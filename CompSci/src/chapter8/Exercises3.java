package chapter8;

import java.util.Date;

import utils.Utils;

/**
 * Exercises for Chapter 8
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises3 {

	/**
	 * Main Method
	 * @param args - std input
	 */
	public static void main(String[] args) {
		Utils.newLine(8.07);
		x8_07();
		Utils.newLine(8.08);
		x8_08();
	}
	
	/**
	 * Utility Class for 8.07
	 * @author Zach Kaplan
	 * @version 1.0
	 */
	public static class Account {
		private int id = 0;
		private double balance = 0;
		private static double annualInterestRate = 0;
		private Date dateCreated;
		
		public Account() {
			dateCreated = new Date();
		}
		
		public Account(int id, int initBalance) {
			this.id = id;
			balance = initBalance;
			dateCreated = new Date();
		}
		
		public int getID() {
			return id;
		}
		
		public void setID(int id) {
			this.id = id;
		}
		
		public double getBalance() {
			return balance;
		}
		
		public void setBalance(double balance) {
			this.balance = balance;
		}
		
		public static double getAnnualInterestRate() {
			return annualInterestRate;
		}
		
		public static void setAnnualInterestRate(double newRate) {
			annualInterestRate = newRate;
		}
		
		public static double getMonthlyInterestRate() {
			return annualInterestRate / 12;
		}
		
		public double getMonthlyInterest() {
			return getMonthlyInterestRate()/100 * balance;
		}
		
		public void withdraw(double amt) {
			balance -= amt;
		}
		
		public void deposit(double amt) {
			balance += amt;
		}
		
		public String toString() {
			return "Balance: $" + String.format("%,.02f", balance) + "\nMonthly Interest: " 
					+ getMonthlyInterest() + "%\nDate Created: " + dateCreated.toString();
		}
		
	}
	
	/**
	 * Exercise 8.07
	 * Tests the Account Class
	 */
	private static void x8_07() {
		Account a = new Account(1122, 20_000);
		Account.setAnnualInterestRate(4.5);
		a.withdraw(2_500);
		a.deposit(3_000);
		System.out.println(a);
	}
	
	/**
	 * Utility Class for 8.08
	 * @author Zach Kaplan
	 * @version 1.0
	 */
	private static class Fan {
		public static final int SLOW = 1, MEDIUM = 2, FAST = 3;
		private int speed = SLOW;
		private boolean on = false;
		private double radius = 5;
		private String color = "blue";
		
		//Default Constructor Automatically Included
		
		public void setSpeed(int s) {
			speed = s;
		}
		
		public int getSpeed() {
			return speed;
		}
		
		public void toggleOn() {
			on = !on;
		}
		
		public boolean isOn() {
			return on;
		}
		
		public void setRadius(double r) {
			radius = r;
		}
		
		public double getRadius() {
			return radius;
		}
		
		public void setColor(String c) {
			color = c;
		}
		
		public String getColor() {
			return color;
		}
		
		public String toString() {
			if(on) {
				return String.format("Fan Speed: %d\nColor: %s\nRadius: %.02f", 
						speed, color, radius);
			} else {
				return String.format("Color: %s\nRadius: %.02f\nFan is off", 
						color, radius);
			}
		}
		
	}
	
	/**
	 * Exercise 8.08
	 * Tests Fan Class
	 */
	private static void x8_08() {
		Fan f1 = new Fan(), f2 = new Fan();
		//f1
		f1.setSpeed(Fan.FAST);
		f1.setColor("yellow");
		f1.setRadius(10);
		f1.toggleOn();
		System.out.println(f1);
		//f2
		f2.setSpeed(Fan.MEDIUM);
		System.out.println(f2);
	}

}
