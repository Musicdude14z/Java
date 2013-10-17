package chapter2;

import java.util.Scanner;

public class Ex2_12 {

	/*
	 * 2.12 Takes a speed and acceleration of an airplane, and calculates the minimum run way
	 * length
	 */
	public static void main(String[] args) {
		System.out.print("Enter speed and acceleration: ");
		Scanner s = new Scanner(System.in);
		double v = s.nextDouble(), a = s.nextDouble();
		s.close();
		System.out.printf("The minimum length for this airplane is %f", v*v/2/a);
	}

}
