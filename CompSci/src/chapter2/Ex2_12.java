package chapter2;

import java.util.Scanner;

public class Ex2_12 {

	public static void main(String[] args) {
		System.out.print("Enter speed and acceleration: ");
		Scanner s = new Scanner(System.in);
		double v = s.nextDouble(), a = s.nextDouble();
		s.close();
		System.out.printf("The minimum length for this airplane is %f", v*v/2/a);
	}

}
