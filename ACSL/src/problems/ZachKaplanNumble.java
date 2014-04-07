//Zachary Kaplan, Bergen County Academies, Senior Division
package problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ACSL Numble Coding Challenge<p>
 * Bergen County Academies<p>
 * Senior Division
 * @author Zach Kaplan
 * @version 1.0
 */
public class ZachKaplanNumble {
	
	/* Test Data:
	 * 1. 9768014, 6874514, 9655532
	 * 2. 7, 7, 5, 7, 6
	 * 3. 6, 5, 3, 6, 9
	 * 4. 5, 6, 4, 6, 9
	 * 5. 4, 5, 4, 8, 6
	 * 6. 6, 6, 4, 4, 6
	 */
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] digits = s.nextLine().substring(3).split(", "); //cuts off line number
		for(int i=0; i<3; i++) {
			digits[i] = order(digits[i]);
		}
		String[][] trials = new String[5][5];
		for(int i=0; i<5; i++) {
			trials[i] = s.nextLine().substring(3).split(", "); //cuts off line number
		}
		for(String[] trial : trials) {
			String[] words = {
					getLengthWith(digits[0], Integer.valueOf(trial[0]), //first word
							Integer.valueOf(trial[3]), Integer.valueOf(trial[4])), //ensure both
					getLengthWith(digits[1], Integer.valueOf(trial[1]), //second word
							Integer.valueOf(trial[3]), -1), //ensure only first
					getLengthWith(digits[2], Integer.valueOf(trial[2]), //third word
							Integer.valueOf(trial[4]), -1) //ensure only second
			};
			for(int i=0; i<3; i++) {
				if(words[i].endsWith("00")) { //check for 00 at end
					words[i] = '0' + words[i].substring(0, words[i].length()-1); //change to 0.*0
				}
			}
			printNums(words[0], words[1], words[2], trial[3], trial[4]); //print trial
			System.out.println();
		}
		
		s.close();
	}
	
	/**
	 * Gets highest sum that is a multiple of 5 of a certain length containing the cross characters
	 * <p>
	 * Digits must be in reverse numerical order
	 * @param digits - digits to use
	 * @param length - length of number to build
	 * @param cross1 - first cross character (set to -1 if unused)
	 * @param cross2 - second cross character (set to -1 if unused)
	 * @return character string meeting requirements
	 */
	private static String getLengthWith(String digits, int length, int cross1, int cross2) {
		char[] c = digits.toCharArray();
		if(!crossOff(0, c, length, cross1, cross2, 0))
			return null;
		StringBuilder sb = new StringBuilder();
		for(char ch : c) {
			if(ch != '-') sb.append(ch);
		}
		return sb.toString();
	}
	
	/**
	 * Recursively finds the highest sum of digits containing both cross1 and 2 with that is a 
	 * multiple of 5 and a set length
	 * @param sum - pass 0 at first, is the floating sum
	 * @param digits - set of digits, will be crossed of with '-'s throughout
	 * @param length - length to make, is subtracted from
	 * @param cross1 - cross1 (set to -1 when unused)
	 * @param cross2 - cross2 (set to -1 when unused)
	 * @param pos - current position in digits, start at 0
	 * @return returns if combination worked
	 */
	private static boolean crossOff(int sum, char[] digits, int length, int cross1, 
			int cross2, int pos) {
		if(length == 0) {//break case for having enough digits
			if(sum % 5 == 0) {
				for(int i=pos; i<digits.length; i++) 
					digits[i] = '-'; //cross of remaining digits
				return true;
			} else 
				return false;
		}
		else if(pos > 6) //break case for exceeding size of array
			return false;
		
		int n = getVal(digits[pos]);
		if(n == cross1) { //cases in which cross has not been included and is at current position
			return crossOff(sum+n, digits, length-1, -1, cross2, pos+1);
		} else if(n == cross2) {
			return crossOff(sum+n, digits, length-1, cross1, -1, pos+1);
		}
		
		if(crossOff(sum + n, digits, length-1, cross1, cross2, pos+1)) 
			return true; //if sum can be attained with value include it
		else {
			if(crossOff(sum, digits, length, cross1, cross2, pos+1)) {
				digits[pos] = '-';
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets value of a digit
	 * @param c - digit
	 * @return numerical value
	 */
	private static int getVal(char c) {
		switch(c) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		default:
			return -1;
		}
	}
	
	/**
	 * Puts stirng in reverse numerical order
	 * @param n - input string
	 * @return sorted string
	 */
	private static String order(String n) {
		char[] c = n.toCharArray();
		Arrays.sort(c);
		for(int i=0; i<c.length/2; i++) { //reverse the array
			c[i] ^= c[c.length-i-1];
			c[c.length-i-1] ^= c[i];
			c[i] ^= c[c.length-i-1];
		}
		String s = new String(c);
		return s;
	}
	
	/**
	 * Prints numbers in an acrosstic format (as ACSL specified)
	 * @param n1 - first string (horizontal)
	 * @param n2 - second string (first vertical)
	 * @param n3 - third string (second vertical)
	 * @param c1 - crossing character of n1 and n2
	 * @param c2 - crossing character of n1 and n3
	 */
	private static void printNums(String n1, String n2, String n3, String c1, String c2) {
		boolean big2 = n2.indexOf(c1) > n3.indexOf(c2); //true if n2 is taller than n3
		int h1 = big2 ? n2.indexOf(c1) : n3.indexOf(c2), //height of horizontal
				h2 = big2 ? 0 : n3.indexOf(c2) - n2.indexOf(c1),
				h3 = big2 ? n2.indexOf(c1) - n3.indexOf(c2) : 0,
				hMax = Math.max(h2 + n2.length(), h3 + n3.length()),
				w2 = n1.indexOf(c1), //cross position for n2
				w3 = n1.indexOf(c2); //cross position for n3
		if(w3 == w2) //if cross in same place
			w3 = n1.indexOf(c2, w2+1); //search for second cross after first
		
		for(int h=0; h < hMax; h++) {
			if(h == h1) { //print horizontal string
				for(char c : n1.toCharArray()) {
					System.out.print(c);
					space();
				}
			} else if(w2 < w3) { //second string first
				space(w2); //space to cross
				if(h < h2 + n2.length() && h >= h2) 
					System.out.print(n2.charAt(h-h2)); //print character
				else
					space(); //print space if no character
				space(w3-w2-1); //space to cross
				space(); //add single space
				if(h < h3 + n3.length() && h >= h3) 
					System.out.print(n3.charAt(h-h3)); //print character
			} else { //third string first; same as above
				space(w3); 
				if(h < h3 + n3.length() && h >= h3) 
					System.out.print(n3.charAt(h-h3));
				else
					space();
				space(w2-w3-1);
				space();
				if(h < h2 + n2.length() && h >= h2) 
					System.out.print(n2.charAt(h-h2));
			}
			System.out.println(); //next line
		}
	}
	
	/**
	 * Prints one space character
	 */
	private static void space() {
		System.out.print(" "); //1 space
	}
	
	/**
	 * Prints multiple space characters
	 * @param n - number of spaces
	 */
	private static void space(int n) {
		while(n-- > 0) 
			System.out.print("  "); //2 spaces
	}
	
}
