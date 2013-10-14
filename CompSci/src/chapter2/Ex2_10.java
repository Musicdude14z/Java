package chapter2;

import java.util.Scanner;

public class Ex2_10 {

	public static void main(String[] args) {
		System.out.print("Enter the amount of water in kilograms: ");
		Scanner s = new Scanner(System.in);
		double kgWater = s.nextDouble();
		System.out.print("Enter the initial temperature: ");
		double t0 = s.nextDouble();
		System.out.print("Enter the final temperature: ");
		double t1 = s.nextDouble();
		s.close();
		System.out.printf("The energy needed is %f", kgWater * (t1-t0) * 4184);
	}

}
