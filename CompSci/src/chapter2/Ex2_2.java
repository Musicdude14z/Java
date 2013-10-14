package chapter2;

import java.util.Scanner;

public class Ex2_2 {
	
	public static void main(String[] args) {
		System.out.print("Enter the radius and length of a cylinder: ");
		Scanner s = new Scanner(System.in);
		double radius = s.nextDouble(), length = s.nextDouble(), area = Math.PI*radius*radius;
		s.close();
		System.out.printf("The area is %f\nThe volume is %f\n", area, length*area);
	}
	
}
