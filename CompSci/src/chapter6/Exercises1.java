package chapter6;

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
	 * @param args - standard input
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Utils.newLine(6.02);
			x6_02(s);
			Utils.newLine(6.04);
			x6_04(s);
			Utils.newLine(6.08);
			x6_08(s);
		}catch(InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure to enter a valid input!"); //exit(1)
		}
		
		s.close();
	}
	
	/**
	 * Exercise 6.02
	 * Reversed 10 integers entered
	 * @param s - System.in
	 */
	private static void x6_02(Scanner s) {
		System.out.print("Enter 10 integers separated by spaces: ");
		int[] numsReversed = new int[10];
		for(int i=9; i>=0; i--) { //9 8 ... 2 1
			numsReversed[i] = s.nextInt();
		}
		System.out.print("The numbers reversed are:");
		for(int i : numsReversed) {
			System.out.print(" " + i);
		}
		System.out.println();
	}
	
	/**
	 * Exercise 6.04
	 * Prints # of values higher than and lower than the average of a set
	 * @param s System.in
	 */
	private static void x6_04(Scanner s) {
		System.out.print("Enter the grades: ");
		
		int scores[] = new int[100], size = 0, sum = 0;
		scores[size] = s.nextInt();
		while(scores[size] >= 0) {
			sum += scores[size];
			scores[++size] = s.nextInt();
		}
		scores[size] = 0; //set last neg val to 0
		int greaterThan = 0;
		double avg = (double)sum/size;
		for(int i=0; i<size; i++){
			if(scores[i] > avg) greaterThan++;
		}
		System.out.printf("There are %d scores greater than, and %d scores less than the " +
				"average %.02f\n", greaterThan, size-greaterThan, avg);
	}
	
	/**
	 * Driver Method Exercise 6.08
	 * Prints averages of arrays
	 * @param s - System.in
	 */
	private static void x6_08(Scanner s) {
		System.out.print("Enter 10 integers separated by a space: ");
		int dec[] = new int[10];
		for(int i=0; i<10; i++) dec[i] = s.nextInt();
		
		System.out.print("Enter 10 decimal numbers separaed by a space: ");
		double dubs[] = new double[10];
		for(int i=0; i<10; i++) dubs[i] = s.nextDouble();
		
		System.out.printf("The average of the integer array is %d, and the" +
				" average of the decimal array is %f\n", average(dec), average(dubs));
	}
	
	/**
	 * Helper Method for Exercise 6.08
	 * Returns integer average of int array
	 * @param arr - int[]
	 * @return average integer
	 */
	private static int average(int[] arr) {
		int sum = 0;
		for(int i : arr) sum += i;
		return sum/arr.length;
	}
	
	/**
	 * Helper Method for Exercise 6.08
	 * Returns integer average of double array
	 * @param arr - double[]
	 * @return average double
	 */
	private static double average(double[] arr) {
		double sum = 0;
		for(double i : arr) sum += i;
		return sum/arr.length;
	}

}
