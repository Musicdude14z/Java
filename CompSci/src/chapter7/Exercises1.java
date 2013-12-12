package chapter7;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utils;

/**
 * 1st Exercise set for chapter 7
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
			Utils.newLine(7.01);
			x7_01(s);
			Utils.newLine(7.28);
			x7_28(s);
		}catch(InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure to enter valid input!"); //exit(1)
		}
		
		s.close();
	}
	
	/**
	 * Helper Method for 7.01
	 * @param arr - 2D double array
	 * @param column - number of column to sum
	 * @return - sum of all elements in column number column
	 */
	private static double sumColumn(double[][] arr, int column) {
		double sum = 0;
		for(double[] a : arr) {
			sum += a[column];
		}
		return sum;
	}
	
	/**
	 * Driver Method for 7.01
	 * Tests sumColumn with a 3x4 2D double array
	 * @param s - input Scanner
	 */
	private static void x7_01(Scanner s) {
		System.out.println("Enter a 3x4 matrix row by row:");
		
		double input[][] = new double[3][4];
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) input[i][j] = s.nextDouble();
		}
		
		for(int i=0; i<4; i++) {
			System.out.printf("Sum of elements at column %d is %.1f\n",
					i, sumColumn(input, i));
		}
	}
	
	/**
	 * Helper Method for 7.28
	 * @param a - a 2D int array
	 * @param b - another 2D int array
	 * @return - true if a and b are exactly the same dimensions and contain
	 * the same values in the same places
	 */
	private static boolean equals(int[][] a, int[][] b) {
		if(a.length != b.length) return false; //the arrays are not the same size
		for(int i=0; i<a.length; i++) {
			//the inner arrays are not the same size
			if(a[i].length != b[i].length) return false;
			for(int j=0; j<a[i].length; j++) {
				if(a[i][j] != b[i][j]) return false; //numbers aren't equal
			}
		}
		return true; //if it get's through all that, equal
	}
	
	/**
	 * Driver Method for 7.28
	 * Tests the equals method for two 3x3 2D int arrays
	 * @param s - input scanner
	 */
	private static void x7_28(Scanner s) {
		int[][] a = new int[3][3], b = new int[3][3];
		
		System.out.print("Enter list 1 (9 integers): ");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				a[i][j] = s.nextInt();
			}
		}
		
		System.out.print("Enter list 2 (9 integers): ");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				b[i][j] = s.nextInt();
			}
		}
		
		if(equals(a, b)) {
			System.out.println("The two arrays are strictly identical");
		} else {
			System.out.println("The two arrays are not strictly identical");
		}
	}

}
