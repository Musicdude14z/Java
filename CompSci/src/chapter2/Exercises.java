package chapter2;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import utils.*;

/**
 * CompSci Exercises for Chapter 2
 * <p>
 * Due 10/21/13
 * 
 * @author Zach Kaplan
 * @version 1.0
 */

public class Exercises {

	/**
	 * {@code private static void x2_16(Scanner s)}
	 * <p>
	 * 2.16 - Takes the side length of a hexagon and prints the area.
	 * 
	 * @param s
	 *            - a {@link Scanner} of {@code System.in}
	 * @return {@code void}
	 * @throws InputMismatchException
	 *             if the user input is not a valid decimal number
	 */
	private static void x2_16(Scanner s) throws InputMismatchException {
		System.out.print("Enter the side: ");

		double side = 0;
		try {
			side = s.nextDouble();
		} catch (InputMismatchException ime) {
			throw new InputMismatchException(
					"Please input a valid decimal number!");
		}

		System.out.printf("The area of the hexagon is %.4f\n", 3 * Math.sqrt(3)
				/ 2 * side * side);
		// the \n is a newline escape character
	}

	/**
	 * {@code private static void x2_18()}
	 * <p>
	 * 2.18 - Prints a table of powers of a^b for 0 &lt; a&lt; 6 and 1 &lt; b
	 * &lt; 7.
	 * 
	 * @return {@code void}
	 */
	private static void x2_18() {
		System.out.println("a\tb\tpow(a, b)");
		// the \t's are tab escape characters
		for (int i = 1; i <= 5; i++) {
			System.out.printf("%d\t%d\t%d\n", i, i + 1,
					(int) Math.pow(i, i + 1)); // prints a tab b tab a^b return
		}
	}

	/**
	 * {@code private static void x2_19(Scanner s)}
	 * <p>
	 * 2.19 - Prompts user for Point (x1, y1) and Point (x2, y2) and prints the
	 * distance between the two points.
	 * 
	 * @param s
	 *            - a {@link Scanner} of {@code System.in}
	 * @return {@code void}
	 * @throws InputMismatchException
	 *             if the user inputs are not a valid decimal number
	 */
	private static void x2_19(Scanner s) throws InputMismatchException {
		System.out.print("Enter x1 and y1: ");

		double x1, x2, y1, y2;
		try {
			x1 = s.nextDouble();
			y1 = s.nextDouble();
			System.out.print("Enter x2 and y2: ");
			x2 = s.nextDouble();
			y2 = s.nextDouble();
		} catch (InputMismatchException ime) {
			throw new InputMismatchException(
					"Please input valid decimal numbers!");
		}

		System.out.printf("The distance between the two points is %.15f\n",
				Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
	}

	/**
	 * {@code private static void x2_22()}
	 * <p>
	 * 2.22 - Calls {@code System.currentTimeMillis} and uses this value to
	 * calculate a random number from 65 to 90. This {@code int} is then cast to
	 * a {@code char} resulting in a 'random' upper-case letter. This letter is
	 * printed to the console.
	 * 
	 * @return {@code void}
	 */
	private static void x2_22() {
		double rand = (double) System.currentTimeMillis() % 1000 / 1000;
		// gets last 3 digits and then divide that by 1000, to get a random
		// decimal on [0, 1)
		System.out.printf("Your random character is %c\n",
				(char) (rand * 26 + 65));
		// multiplies rand by 26 for range, and adds 65 for offset
	}

	/**
	 * {@code private static void x2_23(Scanner s)}
	 * <p>
	 * 2.23 - Prompts user for an ASCII code and prints the corresponding
	 * character.
	 * 
	 * @param s
	 *            - a {@link Scanner} of {@code System.in}
	 * @return {@code void}
	 * @throws InputMismatchException
	 *             if input is not a valid {@code int}
	 * @throws IllegalArgumentException
	 *             if input is not between 0 and 127 inclusive
	 */
	private static void x2_23(Scanner s) throws InputMismatchException,
			IllegalArgumentException {
		System.out.print("Enter an ASCII code: ");

		int code;
		try {
			code = s.nextInt();
		} catch (InputMismatchException ime) {
			throw new InputMismatchException("Please input a valid integer!");
		}

		if (code < 0 || code > 127)
			throw new IllegalArgumentException(
					"Please input a value between 0 and 127 inclusive!");
		// checks for range
		System.out.printf("The character is %c", code);
		// automatically casts to char for me
	}

	/**
	 * {@code private static void x2_24(Scanner s)}
	 * <p>
	 * 2.24 - Prompts the user for an amount of money in cents, and prints the
	 * necessary change to produce that amount
	 * 
	 * @param s
	 *            - a {@link Scanner} of {@code System.in}
	 * 
	 * @return {@code void}
	 * 
	 * @throws InputMismatchException
	 *             if the user input is not a valid integer
	 *             
	 * @throws IllegalArgumentException
	 * 			   if the user input is not positive (greater than 0)
	 */
	private static void x2_24(Scanner s) throws InputMismatchException{
		System.out.print("Enter an amount in cents, 1156 ($11.56) for example: ");
		
		int cents;
		try {
			cents = s.nextInt();
		} catch(InputMismatchException ime) {
			throw new InputMismatchException("Please enter a valid integer!");
		}
		if(cents <= 0) 
			throw new IllegalArgumentException("Please enter an positive integer!");
		
		System.out.printf("Your amount $%.2f consists of\n" +
				"\t%d dollars\n" +
				"\t%d quarters\n" +
				"\t%d dimes\n" +
				"\t%d nickels\n" +
				"\t%d pennies\n", 
				cents/100d, cents/100, cents%100/25, cents%25/10, cents%10/5, cents%5);
			//  amount in $ dollars    quarters      dimes        nickels     pennies
	}
	
	/**
	 * {@code private static void x2_25(Scanner s)}
	 * <p>
	 * 2.25 - Prompts user for name, hours a week, hourly salary, federal tax,
	 * and state tax. Prints out a standard payroll.
	 * 
	 * @param s
	 *            - a {@link Scanner} of {@code System.in}
	 * 
	 * @return {@code void}
	 * 
	 * @throws InputMismatchException
	 *             if user does not input valid decimal numbers for fields other
	 *             than name
	 */
	private static void x2_25(Scanner s) throws InputMismatchException {
		String name;
		double salary, hours, fedTax, stateTax;
		try {
			System.out.print("Enter employee's name: ");
			name = s.next();
			
			System.out.print("Enter number of hours worked in a week: ");
			hours = s.nextDouble();
			
			System.out.print("Enter hourly pay rate: ");
			salary = s.nextDouble();
			
			System.out.print("Enter federal tax withholding rate: ");
			fedTax = s.nextDouble();
			
			System.out.print("Enter state tax withholding rate: ");
			stateTax = s.nextDouble();
		} catch (InputMismatchException ime) {
			throw new InputMismatchException("Please enter a valid decimal integer!");
		}
		double gross = salary*hours, fedDed = fedTax*gross, stateDed = stateTax*gross,
				totalDed = fedDed + stateDed, net = gross - totalDed;
		
		System.out.printf("Employee Name: %s\n" + //name
				"Hours Worked:  %.1f\n" +  //hours worked
				"Pay Rate:  $%.2f\n" +  //salary
				"Gross Pay:  $%.2f\n" +  //gross pay
				"Deductions:\n" + 
				"  Federal Withholding (%.1f%%):  $%.2f\n" +  //fed tax rate / fed deduction
				"  State Withholding (%.1f%%):  $%.2f\n" +  //state tax rate / state deduction
				"  Total Deduction:  $%.2f\n" +  //total Deduction
				"Net Pay:   $%.2f\n",  //net
				name, hours, salary, gross, fedTax*100, fedDed, stateTax*100, 
				stateDed, totalDed, net);
	}

	/**
	 * {@code private static void x2_26()}
	 * <p>
	 * 2.24 - Prompts the user for an amount of money in cents, and prints the
	 * necessary change to produce that amount. Uses dialog boxes.
	 * 
	 * @return {@code void}
	 * 
	 * @throws InputMismatchException
	 *             if user does not enter a valid integer
	 */
	private static void x2_26() throws InputMismatchException {
		int cents;
		try{
			cents = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Enter an amount in cents, 1156 ($11.56) for example: ", "User Prompt", 
					JOptionPane.QUESTION_MESSAGE)); //no parent panel, message, title, type
		} catch(InputMismatchException ime) {
			throw new InputMismatchException("Please enter a valid integer greater than 0!");
		}
		
		String[] output = {
				String.format("Your amount $%.2f consists of", cents/100d),
				String.format("    %d dollars", cents/100),
				String.format("    %d quarters", cents%100/25),
				String.format("    %d dimes", cents%25/10),
				String.format("    %d nickels", cents%10/5),
				String.format("    %d pennies", cents%5)
		};
		
		JOptionPane.showMessageDialog(null, output, "Change", JOptionPane.INFORMATION_MESSAGE);
		//no parent panel, message, title, type
	}
	
	/**
	 * @param args
	 *            - {@link String}{@code []} as standard user input
	 * @return {@code void}
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		try {
			Utils.newLine(2.16);
			x2_16(s);
			Utils.newLine(2.18);
			x2_18();
			Utils.newLine(2.19);
			x2_19(s);
			Utils.newLine(2.22);
			x2_22();
			Utils.newLine(2.23);
			x2_23(s);
			Utils.newLine(2.24);
			x2_24(s);
			Utils.newLine(2.25);
			x2_25(s);
			Utils.newLine(2.26);
			x2_26();
		} catch (Exception e) {
			s.nextLine();
			s.close();
			Utils.err(e.getMessage()); // exits program
		}

		s.close();
	}

}
