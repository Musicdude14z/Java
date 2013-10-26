package chapter3;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utils;

/**
 * In class exercises for chapter 3
 * @author Zach Kaplan
 * @version 1.0
 */
public class InClassEx {

	/**
	 * <code>public static void main({@link String}[] args)</code>
	 * <p>
	 * main method
	 * @param args - Standard <code>{@link String}[]</code> input for main method
	 * @return {@code void}
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Utils.newLine(3.06);
			x3_6(s);
		} catch (InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure to enter a valid input!"); //exits w/ err code 1
		}
		
		s.close();
	}
	
	/**
	 * <code>private static void x3_6({@link Scanner} s)</code>
	 * <p>
	 * 3.06 - Prompts the user for a score and an initial pay, prints final pay
	 * which is 3% greater if score &gt; 90, and 1% greater in any other case
	 * @param s - A {@link Scanner} of {@code System.in}
	 * @return {@code void}
	 */
	private static void x3_6(Scanner s) {
		System.out.print("Enter a score and an initial pay: ");
		double score = s.nextDouble(), pay = s.nextDouble();
		System.out.printf("Your final pay is $%.2f", pay * (score > 90 ? 1.03 : 1.01));
	}

}
