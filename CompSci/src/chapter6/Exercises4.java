package chapter6;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utils;

/**
 * Exercises 4 for Chapter 6 (6.09 6.10, 6.14, and 6.15)
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises4 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Utils.newLine(6.09);
			x6_09(s);
			Utils.newLine(6.10);
			x6_10(s);
			Utils.newLine(6.14);
			x6_14(s);
			Utils.newLine(6.15);
			x6_15(s);
		}catch(InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please enter valid input types!"); //exit(1)
		}
		
		s.close();
	}
	
	/**
	 * Driver Method for 6.09
	 * Prompts the user for 10 numbers, and prints the minimum value
	 * @param s - System.in
	 */
	private static void x6_09(Scanner s) {
		System.out.print("Enter ten numbers: ");
		double[] arr = new double[10];
		for(int i=0; i<10; i++) {
			arr[i] = s.nextDouble();
		}
		System.out.printf("The minimum number is: %.01f\n", min(arr));
	}
	
	/**
	 * Helper Method for 6.09
	 * @param arr - array
	 * @return minimum value of array
	 */
	private static double min(double[] arr) {
		if(arr.length < 1) return 0;
		double min = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	
	/**
	 * Driver Method for 6.10
	 * Prompts the user for 10 numbers, and prints the minimum value's index
	 * @param s - System.in
	 */
	private static void x6_10(Scanner s) {
		System.out.print("Enter ten numbers: ");
		double[] arr = new double[10];
		for(int i=0; i<10; i++) {
			arr[i] = s.nextDouble();
		}
		System.out.printf("The index at the smallest value is: %d\n", 
				indexOfSmallestElement(arr));
	}
	
	/**
	 * Helper Method for 6.10
	 * @param arr - array
	 * @return minimum value's index
	 */
	private static int indexOfSmallestElement(double[] arr) {
		if(arr.length < 1) return -1;
		double min = arr[0];
		int index = 0;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < min) {
				min = arr[index = i];
			}
		}
		return index;
	}
	
	/**
	 * Driver Method for 6.14
	 * Prompts user for 5 numbers, and prints the gcd
	 * @param s - System.in
	 */
	private static void x6_14(Scanner s) {
		System.out.print("Enter five numbers: ");
		int[] nums = new int[5];
		for(int i=0; i<5; i++) {
			nums[i] = s.nextInt();
		}
		
		System.out.println("The GCD is: " + gcd(nums));
	}
	
	/**
	 * Helper Method for 6.14
	 * Easy implementation
	 * Could instead get prime factors and multiply to highest powers
	 * @param numbers - any amount of numbers
	 * @return the gcd of those numbers
	 */
	private static int gcd(int... numbers) {
		int min = numbers[0];
		for(int i=1; i<numbers.length; i++) {
			if(numbers[i] < min) min = numbers[i];
		}
		
		int gcd = min;
		boolean done = true; //checker boolean
		for(int i=0; ; i++) {
			if(i == numbers.length) { //if passed through array
				if(done) break; //if done hasn't been set to false, then break
				else { //else pass through again
					i = 0; //override control flow, resets loop
					done = true; //resets checker boolean
				}
			}
			if(numbers[i] % gcd != 0) { //if the gcd is not right for a value
				gcd--; //subtract one
				done = false; //set done as false because gcd has been modified
			}
		}
		return gcd;
	}
	
	/**
	 * Exercise 6.15
	 * @param s - Scanner
	 */
	private static void x6_15(Scanner s) {
		System.out.print("Enter ten numbers: ");
		int[] a = new int[10];
		for(int i=0; i<10; i++) {
			a[i] = s.nextInt();
		}
		System.out.print("The distinct numbers are: ");
		for(int i : eliminateDuplicates(a)) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	/**
	 * Helper Method for 6.15
	 * @param a - array to eliminate duplicates from
	 * @return array w/o duplicates
	 */
	private static int[] eliminateDuplicates(int[] a) {
		Arrays.sort(a); //sort array for ease
		int unique = 1;
		for(int i=1; i<a.length; i++) //find size of unique array
			if(a[i] != a[i-1]) unique++;
		int[] b = new int[unique]; //create new array
		b[0] = a[0]; //set first val
		for(int i=1, j=1; i<a.length; i++) { //fill with unique vals
			if(a[i] != a[i-1]) {
				b[j++] = a[i];
			}
		}
		return b; //return new array
	}
	
}
