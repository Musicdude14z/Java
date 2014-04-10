package exams;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main Class for Counting and Summing Digits Exam
 * @author Zach Kaplan
 * @version 1.0
 */
public class DigitPlay {
	
	/**
	 * TESTS PROBLEM 2 (uncommented portion)
	 * TESTS PROBLEM 1 (commented portion)
	 * Main method for the DigitPlay class
	 * Tests the static methods of the DigitPlay class
	 * @param args - stdin args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please enter an identification number: ");
		int id = 0; //init in scope outside of try-catch
		try {
			id = s.nextInt();
		} catch (InputMismatchException ime) { //not a valid integer
			s.close();
			System.err.println("\nERROR: Please be sure to enter a positive integer " +
					"-- start over!!\n");
		}
		
		if(id <= 0) { //not a positive integer
			System.err.printf("\nERROR: %d is not positive -- start over!!\n", id);
		}
		
		if(sumDigits(id) % 7 == 0) 
			System.out.printf("\nOK: %d is a valid identification number.\n", id);
		else
			System.err.printf("\nERROR: %d is NOT a valid identification number.\n", id);
		
		/*OLD MAIN METHOD
		Scanner s = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter a positive integer: ");
		int num = s.nextInt();
		
		if(num <= 0)
			System.out.println(num + " isn't positive -- start over!!");
		else {
			System.out.printf("\nThe number %d contains %d digits.", num, numDigits(num));
			System.out.println();
			System.out.printf("\nThe number %d's digits sum to %d.", num, sumDigits(num));
			System.out.println();
		}
		*/
	}
	
	/**
	 * GIVEN
	 * Recursively counts the digits in a positive integer
	 * @param num - number to count digits of
	 * @return number of digits in num
	 */
	public static int numDigits(int num) {
		if(num < 10)
			return 1;
		else
			return 1 + numDigits(num/10);
	}
	
	/**
	 * PROBLEM 1
	 * Recursively sums the digits in a positive integer
	 * @param n - number to sum digits of
	 * @return sum of digits in n
	 */
	public static int sumDigits(int n) {
		if(n < 10)
			return n;
		else
			return (n % 10) + sumDigits(n/10);
	}
	
	
	
}
