package chapter4;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utils;


/**
 * 
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises2 {

	/**
	 * @param args - <code>{@link String}[]</code> of input
	 * @return {@code void}
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Utils.newLine(4.08);
			x4_08(s);
			Utils.newLine(4.11);
			x4_11();
			Utils.newLine(4.30);
			x4_30(s);
			Utils.newLine(4.40);
			x4_40();
		}catch (InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure to enter a valid input!"); //exit(1)
		}
	}
	
	/**
	 * <code>private static void 4_08({@link Scanner} s)</code>
	 * <p>
	 * 4.08 - Prompts the user for # of students, and then takes each students
	 * name and score, printing the name of the student with the highest score
	 * @param s - a <code>{@link Scanner}</code> on <code>System.in</code>
	 * @return {@code void}
	 */
	private static void x4_08(Scanner s) {
		System.out.print("Enter total number of students: ");
		int num = s.nextInt(), highest = Integer.MIN_VALUE; //number of students, highest score
		String student = ""; //student with highest score
		
		for(int i=1; i<=num; i++) { 
			System.out.printf("Enter Student #%d's name and grade: ", i); //prompt
			String name = s.next(); //get name
			int temp = s.nextInt(); //get score
			if(temp > highest) { //if score bigger than previous highest
				highest = temp; //set highest to new highest
				student = name; //set name to this student
			}
		}
		System.out.println("The student with the highest score is " + student);
	}
	
	/**
	 * <code>private static void x4_11()</code>
	 * <p>
	 * 4.11 - Prints all numbers between 100 and 1,000 that are divisible by
	 * both 5 xor 6, 10 per line separated by one space each
	 * @return {@code void}
	 */
	private static void x4_11() {
		int count = 0; //number printed per line
		
		for(int i=100; i<=1000; i++) {
			if(i % 5 == 0 ^ i % 6 == 0) { //mod 5 xor mod 6
				System.out.print(i); //print number
				
				if(++count % 10 == 0) { //if 10 on line
					System.out.println(); //new line
				}else {
					System.out.print(' '); //print space
				}
			}
		}
	}
	
	/**
	 * <code>private static void x4_30({@link Scanner} s)</code>
	 * <p>
	 * 4.30 - Prompts for an amount to add monthly, an annual interest rate, 
	 * and a number of months, and prints the resulting amount
	 * @param s - a <code>{@link Scanner}</code> on <code>System.in</code>
	 * @return {@code void}
	 */
	private static void x4_30(Scanner s) {
		System.out.print("Enter an amount to add to the account each month: ");
		double monthlyDeposit = s.nextDouble();
		System.out.print("Enter the annual interest rate for the account: ");
		double interest = s.nextDouble()/12/100;
		System.out.print("Enter how many months you wish to run for: ");
		int months = s.nextInt();
		
		double total = 0;
		for(int i=0; i<months; i++) {
			total += monthlyDeposit;
			total *= 1 + interest;
		}
		System.out.printf("Your total after %d months is $%.02f!\n", months, total);
	}
	
	/**
	 * <code>private static void x4_40()</code>
	 * <p>
	 * 4.40 - Simulates flipping a coin 1,000,000 (1 million) times and prints 
	 * how many of each heads and tails were achieved
	 * @return {@code void}
	 */
	private static void x4_40() {
		int numHeads = 0;
		for(int i=0; i<1_000_000; i++) {
			if(Math.random() < 0.5) numHeads++;
		}
		System.out.printf("Heads: %,d\nTails: %,d", numHeads, 1_000_000 - numHeads);
	}

}
