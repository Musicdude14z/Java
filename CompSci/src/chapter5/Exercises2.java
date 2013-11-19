package chapter5;

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
	 * @param args - standard input
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Utils.newLine(5.18);
			x5_18();
			Utils.newLine(5.20);
			x5_20();
			Utils.newLine(5.23);
			x5_23(s);
			Utils.newLine(5.35);
			x5_35(s);
			Utils.newLine(5.37);
			x5_37(s);
		}catch(InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please make sure your input is valid!"); //exit(1)
		}
		
		s.close();
	}
	
	/**
	 * Exercise 5.18
	 * Calculates sqrt of even integers
	 */
	private static void x5_18() {
		System.out.println("Number\t\tSquareRoot"); //header
		System.out.println("__________________________"); //horizontal rule
		for(int i=0; i<=20; i+=2) {
			System.out.printf("%d\t\t%.04f\n", i, Math.sqrt(i)); 
			                   //number \t \t sqrt (round .4)
		}
	}
	
	/**
	 * Exercise 5.20
	 * Calculates Sin and Cos at degree values
	 */
	private static void x5_20() {
		System.out.println("Degree\t\tSin\t\tCos"); //header
		System.out.println("_______________________________________"); //horizontal rule
		for(int deg=0; deg<=360; deg+=10) {
			double rad = Math.PI/180 * deg; //necessary to run function
			System.out.printf("%d\t\t% .04f\t\t% .04f\n", //deg \t \t sin \t \t cos (round .4)
					deg, Math.sin(rad), Math.cos(rad));
		}
	}
	
	/**
	 * Exercise 5.23
	 * Calculates Angels of a triangle
	 * @args s - standard scanner
	 */
	private static void x5_23(Scanner s) {
		final int X = 0, Y = 1, A = 0, B = 1, C = 2;
		System.out.print("Enter three points (x1 y1 x2 y2 x3 y3): ");
		double[][] points = {
				{s.nextDouble(), s.nextDouble()}, //a
				{s.nextDouble(), s.nextDouble()}, //b
				{s.nextDouble(), s.nextDouble()}  //c
		};
		//length calculations sqrt((x1-x2)^2 + (y1-y2)^2)
		double a = Math.sqrt(Math.pow(points[B][X]-points[C][X], 2) + 
				Math.pow(points[B][Y]-points[C][Y], 2)),
				b = Math.sqrt(Math.pow(points[A][X]-points[C][X], 2) + 
				Math.pow(points[A][Y]-points[C][Y], 2)),
				c = Math.sqrt(Math.pow(points[B][X]-points[A][X], 2) + 
				Math.pow(points[B][Y]-points[A][Y], 2));
		System.out.print("The three angles are: ");
		//eq from book + conversion from rad to deg
		System.out.printf("%.2f %.2f %.2f\n", 
				180/Math.PI*Math.acos((a*a - b*b - c*c) / (-2*b*c)), //A
				180/Math.PI*Math.acos((b*b - a*a - c*c) / (-2*a*c)), //B
				180/Math.PI*Math.acos((c*c - b*b - a*a) / (-2*b*a)));//C
	}
	
	/**
	 * Exercise 5.35
	 * Calculates the area of a regular pentagon
	 * @param s - standard scanner
	 */
	private static void x5_35(Scanner s) {
		System.out.print("Enter the side: ");
		double side = s.nextDouble();
		System.out.println("The area of the pentagon is " +
				(5 * side*side) / (4 * Math.sin(Math.PI/5)/Math.cos(Math.PI/5)));
	}
	
	/**
	 * Driver Method for Exercise 5.37
	 * @param s - standard scanner
	 */
	private static void x5_37(Scanner s) {
		System.out.print("Enter and integer and a desired witdth: ");
		int n = s.nextInt(), w = s.nextInt();
		System.out.println(format(n, w));
	}
	
	/**
	 * Helper Method for Exercise 5.37
	 * Formats with minimum n of leading 0's w
	 * @param n - integer
	 * @param w - minimum length
	 * @return equivalent to String.format("%0"+w+"d", n);
	 */
	private static String format(int n, int w) {
		//NOTE: should use built in method
		//return String.format("%0"+w+"d", n);
		StringBuilder sb = new StringBuilder(""+n);
		while(sb.length() < w) sb.insert(0, 0); //at index 0, add 0
		return sb.toString();
	}

}
