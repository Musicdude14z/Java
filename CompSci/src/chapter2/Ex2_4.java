package chapter2;

import java.util.Scanner;

public class Ex2_4 {
	
	public static void main(String[] args) {
		System.out.print("Enter a number for pounds: ");
		Scanner s = new Scanner(System.in);
		double pounds = s.nextDouble();
		s.close();
		System.out.printf("%f pounds is %f kilograms", pounds, pounds*0.454);
	}
	
}
