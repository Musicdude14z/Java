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
			Utils.newLine(3.16);
			x3_16();
			Utils.newLine(3.26);
			x3_26(s);
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
		System.out.printf("Your final pay is $%.2f\n", pay * (score > 90 ? 1.03 : 1.01));
	}
	
	/**
	 * <code>private static void x3_16()</code>
	 * <p>
	 * 3.16 - Return a random uppercase character using <code>{@link Math}.random()</code>
	 * @return {@code void}
	 */
	private static void x3_16() {
		System.out.println((char)(Math.random()*26+65));
	}
	
	/**
	 * <code>private static void x3_26({@linkScanner} s)</code>
	 * <p>
	 * 3.26 - Prompts user for integer, and prints if that integer is divisible by
	 * both 5 and 6, by 5 or 6, and by 5 or 6 but not both.
	 * @args s - A {@link Scanner} of <code>System.in</code>
	 * @return <code>void</code> 
	 */
	private static void x3_26(Scanner s) {
		System.out.print("Enter an integer: ");
		
		int n = s.nextInt();
		boolean mod5 = n%5 == 0, mod6 = n%6 == 0;
		
		System.out.printf("Is %1$d divisible by 5 and 6? %b\n" +
				"Is %1$d divisible by 5 or 6? %b\n" +
				"Is %1$d divisible by 5 or 6, but not both? %b\n",
				n, mod5 && mod6, mod5 || mod6, mod5 != mod6);
		  //user int , 5 and 6,   5 or 6,       5 doesn't equal 6 (xor)
	}

}
