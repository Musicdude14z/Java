package chapter2;

import java.util.Scanner;

public class Ex2_14 {

	public static void main(String[] args) {
		System.out.print("Enter weight in pounds: ");
		Scanner s = new Scanner(System.in);
		double weight = s.nextDouble()*0.45359237;
		System.out.print("Enter height in inches: ");
		double height = s.nextDouble()*0.0254;
		s.close();
		System.out.printf("BMI is %f\n", weight/height/height);
	}

}
