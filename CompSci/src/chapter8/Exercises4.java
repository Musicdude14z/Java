package chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utils;

/**
 * Exercises for Chatper 8
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises4 {

	/**
	 * Main Method - Just Exercise 8.13
	 * @param args - std input
	 */
	
	public static void main(String[] args) {
		Utils.newLine(8.13);
		System.out.print("Enter the number of rows and columns in the array: ");
		
		Scanner s = new Scanner(System.in);
		int rows, cols = 0;
		double[][] a = new double[0][0];
		try {
			a = new double[rows = s.nextInt()][cols = s.nextInt()];
			
			System.out.println("Enter the array: ");
			for(int row = 0; row < rows; row++) {
				for(int col = 0; col < cols; col++) {
					a[row][col] = s.nextDouble();
				}
			}
		}catch (InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure to enter valid input!"); //exit(1)
		}
		s.close();
		
		Location l = Location.localetLargest(a);
		System.out.printf("The location of the largest element is %.02f at (%d, %d)", 
				l.maxValue, l.row, l.column);
	}
	
	/**
	 * Class Location for Exercise 8.13
	 * Finds the location of the largest value in a double array
	 * @author Zach Kaplan
	 * @version 1.0
	 */
	private static class Location {
		public int row, column;
		public double maxValue;
		
		public static Location localetLargest(double[][] a) {
			Location l = new Location();
			l.maxValue = a[l.row = 0][l.column = 0];
			for(int row = 0; row < a.length; row++) {
				for(int column = 0; column < a[row].length; column++) {
					if(a[row][column] > l.maxValue) { //if val is bigger
						l.maxValue = a[l.row = row][l.column = column]; //assign new values
					}
				}
			}
			return l;
		}
	}

}
