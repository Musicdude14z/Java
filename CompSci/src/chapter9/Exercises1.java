package chapter9;

import java.util.Arrays;
import java.util.Scanner;

import utils.Utils;

/**
 * Exercise Set 1 for Chapter 9
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises1 {

	/**
	 * Main Method
	 * @param args - cmd input
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try{
			Utils.newLine(9.04);
			x9_04(s);
		} catch(Exception e) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure to enter a valid input!"); //exit(1);
		}
		
		s.close();
	}
	
	/**
	 * Driver Method for 9.04
	 * @param s - Scanner
	 */
	private static void x9_04(Scanner s) {
		System.out.print("Please enter a String followed by a character: ");
		String[] in = s.nextLine().split("\\s+", 2); //split input at space, only two elements
		//call with string and first character after space
		int count = count(in[0], in[1].charAt(0)); 
		System.out.printf("There are %d occurances of '%c' in \"%s\"\n", 
				count, in[1].charAt(0), in[0]);
	}
	
	/**
	 * Helper Method for 9.04 - Counts Characters
	 * @param s - String
	 * @param c - character
	 * @return numbers of character c's in String s
	 */
	public static int count(String s, char c) {
		int count = 0;
		for(char ch : s.toCharArray()) {
			if(ch == c) count++;
		}
		return count;
	}

}
