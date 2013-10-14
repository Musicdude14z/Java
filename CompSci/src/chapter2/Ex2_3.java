package chapter2;

import java.util.Scanner;

public class Ex2_3 {
	
	public static void main(String[] args) {
		System.out.print("Enter a value for feet: ");
		Scanner s = new Scanner(System.in);
		double feet = s.nextDouble();
		s.close();
		System.out.printf("%f feet is %f meters", feet, feet*0.305);
	}
	
}
