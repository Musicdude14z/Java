package chapter2;

import java.util.Scanner;

public class Ex2_9 {

	/*
	 * 2.9 Takes an initial and final velocity and the time takes, and caclulates the
	 * average acceleration
	 */
	public static void main(String[] args) {
		System.out.print("Enter v0, v1, and t: ");
		Scanner s = new Scanner(System.in);
		double v0 = s.nextDouble(), v1 = s.nextDouble(), t = s.nextDouble();
		s.close();
		System.out.printf("The average acceleration is %f", (v1-v0)/t);
	}

}
