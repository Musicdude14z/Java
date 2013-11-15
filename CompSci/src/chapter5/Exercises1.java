package chapter5;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utils;

/**
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises1 {

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Utils.newLine(5.02);
			x5_02(s);
			Utils.newLine(5.08);
			x5_08();
			Utils.newLine(5.09);
			x5_09();
			Utils.newLine(5.12);
			x5_12();
		}catch(InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure to enter a valid input!"); //Exits w/ err code of 1
		}
		
		s.close();
	}
	
	/**
	 * Driver method for exercise 5.02
	 * @param s
	 */
	private static void x5_02(Scanner s) {
		System.out.print("Enter an integer: ");
		System.out.println("The sum of the digits is " + sumDigits(s.nextLong()));
	}
	
	/**
	 * Helper method for Exercise 5.02
	 * Sums Digits
	 * @param n - a {@code long}
	 * @return sum of digits of {@code n}
	 */
	private static int sumDigits(long n) {
		int sum = 0;
		do {
			sum += n%10;
			n/=10;
		}while(n!=0); //support for negatives
		return sum;
	}
	
	/**
	 * Driver method for exercise 5.08
	 */
	private static void x5_08() {
		String space = "\t\t";
		
		System.out.printf("Celsius%1$sFahrenheit\t|%1$sFahrenheit\tCelsius\n", space); //header
		System.out.println("______________________________________________________________________");
		for(double initialC = 40, initialF = 120; initialC>30; initialC--, initialF -= 10) {
			//declares the starting C and F for both sides of the chart
			System.out.printf("%.1f%5$s%.1f%5$s|%5$s%.1f%5$s%.2f\n",
					initialC, celsiusToFahrenheit(initialC), initialF, 
					fahrenheitToCelsius(initialF), space);
				//  C (round .1) SPACE F (round .1) SPACE | SPACE F (round .1) SPACE C (round .2)\n
		}
	}
	
	/**
	 * Helper method for 5.08
	 * @param celsius - degrees in Celsius
	 * @return equivalent temperature in Fahrenheit
	 */
	private static double celsiusToFahrenheit(double celsius) {
		return (9.0 / 5) * celsius + 32;
	}
	
	/**
	 * Helper method for 5.08
	 * @param fahrenheit - degrees in Fehrenheit
	 * @return equivalent temperature in Celsius
	 */
	private static double fahrenheitToCelsius(double fahrenheit) {
		return (5.0 / 9) * (fahrenheit - 32);
	}
	
	/**
	 * Driver method for 5.09
	 */
	private static void x5_09() {
		String space = "\t\t";
		
		System.out.printf("Feet%1$sMeters%1$s|%1$sMeters%1$sFeet\n", space); //header
		System.out.println("______________________________________________________________________");
		for(double initialF = 1, initialM = 20; initialF<11; initialF++, initialM += 5) {
			//declares the starting F and M for both sides of the chart
			System.out.printf("%.1f%5$s%.3f%5$s|%5$s%.1f%5$s%.3f\n",
					initialF, footToMeter(initialF), initialM, 
					meterToFoot(initialM), space);
				//  F (round .1) SPACE M (round .3) SPACE | SPACE M (round .1) SPACE F (round .3)\n
		}
	}
	
	/**
	 * Helper method for 5.09
	 * @param foot - length in feet
	 * @return length in meters
	 */
	private static double footToMeter(double foot) {
		return 0.305 * foot;
	}
	
	/**
	 * Helper method for 5.09
	 * @param meter - length in meters
	 * @return length in feet
	 */
	private static double meterToFoot(double meter) {
		return 3.279 * meter;
	}
	
	/**
	 * Driver method for 5.12
	 */
	private static void x5_12() {
		printChars('1', 'Z', 10);
	}
	
	/**
	 * Helper method for 5.12
	 * @param chr1 - character to start from
	 * @param chr2 - character to end with
	 * @param numberPerLine - number of characters to print per line
	 */
	private static void printChars(char chr1, char chr2, int numberPerLine) {
		for(char c = chr1; c <= chr2; c++) { //cycles through all characters
			for(int i=1; i<numberPerLine; i++) { //1 less than number needed
				System.out.print(c + " ");
			}
			System.out.println(c); //print final character with no space and new line
		}
	}

}
