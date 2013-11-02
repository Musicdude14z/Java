package chapter4;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utils;

/**
 * Chapter 4 Exercises
 * @author Zach
 * @version 1.0
 */
public class Exercises {

	/**
	 * Main Method
	 * @param args - a <code>{@link String}[]</code>
	 * @return {@code void}
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Utils.newLine(4.01);
			x4_01(s);
			Utils.newLine(4.08);
			x4_08(s);
			Utils.newLine(4.10);
			x4_10();
			Utils.newLine(4.12);
			x4_12();
		} catch(InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err(ime.getMessage()); //exits with err code of 1
		}
		
		s.close();
	}
	
	/**
	 * <code>private static void x4_01({@link Scanner} s)</code>
	 * <p>
	 * 4.01 - Prompts the user for an un-set amount of integers terminating with 0,
	 * then prints the number of negative and positive integers, the sum, and 
	 * the average
	 * @param s - a <code>{@link Scanner}</code> on <code>System.in</code>
	 * @return {@code void}
	 */
	private static void x4_01(Scanner s) {
		int count = 0, numPos = 0, total = 0; //count of numbers, number positive, sum 
		System.out.print("Enter an integer, the input ends if it is 0: ");
		int num = s.nextInt(); //take first number
		while(num != 0) { 
			count++; //increment count of numbers
			if(num > 0) numPos++; //if positive increment number positive
			total += num; //add into sum
			num = s.nextInt(); //get next number
		}
		System.out.printf("The number of positives is %d\n" + //numPos
				"The number of negatives is %d\n" +  //count - numPos
				"The total is %d\n" + //total
				"The average is %f\n", //(double) total / count
				numPos, count-numPos, total, (double)total/count);
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
	 * <code>private static void x4_10()</code>
	 * <p>
	 * 4.10 - Prints all numbers between 100 and 1,000 that are divisible by
	 * both 5 and 6, 10 per line separated by one space each
	 * @return {@code void}
	 */
	private static void x4_10() {
		int count = 0; //number printed per line
		
		for(int i=100; i<=1000; i++) {
			if(i % 30 == 0) { //modulus 30 because the LCM of 5 and 6 is 30
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
	 * <code>private static void x4_12()</code>
	 * <p>
	 * 4.12 - Prints the smallest integer whose square is greater than 12,000
	 * @return {@code void}
	 */
	private static void x4_12() {
		/* The easiest way to do this is to keep a counter n, which represents 
		 * the integer n, and i which represents n^2.  Using n, we can continually
		 * add the next odd number to i, which is an efficient way of cycling through
		 * perfect squares
		 */
		int n = 1, i = 1;
		while(i < 12_000) {
			i += 2*n+1;
			n++;
		}
		System.out.println("The smallest integer whose square is above 12,000 is " +
					n + ", with a square of " + i);
	}
	
}
