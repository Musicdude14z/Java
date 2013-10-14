package chapter2;

import java.util.Scanner;

public class Ex2_5 {

	public static void main(String[] args) {
		System.out.print("Enter the subtotal and a gratuity rate: ");
		Scanner s = new Scanner(System.in);
		double t = s.nextDouble(), g = s.nextDouble(), gCalc = t*g/100;
		s.close();
		System.out.printf("THe gratuity is $%.02f and the total is $%.02f\n", gCalc, gCalc + t);
	}

}
