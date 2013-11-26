package chapter6;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utils;

/**
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises2 {

	/**
	 * Main Method
	 * @param args - basic input
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Utils.newLine(6.01);
			x6_01(s);
			Utils.newLine(6.03);
			x6_03(s);
			Utils.newLine(6.07);
			x6_07();
			Utils.newLine(6.12);
			x6_12(s);
		}catch(InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure to enter a valid input!");//exit(1)
		}
		
		s.close();
	}
	
	/**
	 * Exercise 6.01
	 * Evaluates letter grades
	 * @param s - scanner
	 */
	private static void x6_01(Scanner s) {
		System.out.print("Enter the number of students: ");
		int num = s.nextInt();
		System.out.print("Enter " + num + " scores: ");
		// declares grades array,    set max to first position to next int
		int grades[] = new int[num], max = grades[0] = s.nextInt();
		
		for(int i=1; i<num; i++) {
			grades[i] = s.nextInt();
			if(grades[i] > max) {
				max = grades[i];
			}
		}
		
		for(int i=0; i<num; i++) {
			System.out.print("Student " + i + " score is " + grades[i] + " and grade is ");
			switch((max-grades[i]-1)/10) { //gets 10's place of one less than the diference
			case -1: case 0: System.out.println('A'); break;
			case 1: System.out.println('B'); break;
			case 2: System.out.println('C'); break;
			case 3: System.out.println('D'); break;
			default: System.out.println('F'); break;
			}
		}
	}
	
	/**
	 * Exercise 6.03
	 * Counts Occurances
	 * @param s - scanner
	 */
	private static void x6_03(Scanner s) {
		System.out.print("Enter the integers: ");
		int num = s.nextInt(), occur[] = new int[100];
		while(num != 0) {
			occur[num-1]++; //store one less than num because 0 is not important
			num = s.nextInt();
		}
		for(int i=1; i<100; i++) {
			if(occur[i-1] == 0) continue; //not necessary to print
			System.out.printf("%d occurs %d %s\n", i, occur[i-1], 
					occur[i-1] > 1 ? "times": "time");
		}
	}
	
	/**
	 * Exercise 6.07
	 * Counts Occurances of Random ints
	 * @param s - scanner
	 */
	private static void x6_07() {
		int[] counts = new int[10];
		for(int i=0; i<100; i++) {
			counts[(int)(Math.random()*10)]++;
		}
		for(int i=0; i<10; i++) {
			System.out.println(counts[i] + " occurances of " + i);
		}
	}
	
	/**
	 * Exercise 6.12 Main
	 * Reads and prints an array
	 * @param s - scanner
	 */
	private static void x6_12(Scanner s) {
		System.out.print("Enter 10 integers: ");
		int[] nums = new int[10];
		for(int i=0; i<10; i++) {
			nums[i] = s.nextInt();
		}
		reverse(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	/**
	 * Exercise 6.12
	 * Reverses an array
	 * @param s - scanner
	 */
	private static void reverse(int[] nums) {
		for(int i=0; i<nums.length/2; i++) { //half the array
			nums[i] ^= nums[nums.length-i-1]; //swaps ints
			nums[nums.length-i-1] ^= nums[i];
			nums[i] ^= nums[nums.length-i-1];
		}
	}

}
