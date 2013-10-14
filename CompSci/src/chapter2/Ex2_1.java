package chapter2;

import java.util.Scanner;

public class Ex2_1 {
	
	public static void main(String[] args) {
		System.out.print("Enter degrees in Celsius: ");
		Scanner s = new Scanner(System.in);
		double c = s.nextDouble();
		s.close();
		System.out.println(c + " Celsius is " + ((double)9/5*c+32) + " Fahrenheit");
	}
	
}
