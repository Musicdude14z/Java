package chapter2;

import java.util.Scanner;

public class Ex2_13 {

	public static void main(String[] args) {
		System.out.print("Enter the monthly saving amount: ");
		Scanner s = new Scanner(System.in);
		double monthlyAmount = s.nextDouble(), total = 0;
		s.close();
		for(int i=0; i<6; i++) {
			total += monthlyAmount;
			total *= 1 + (0.05/12);
		}
		System.out.printf("After the sixth month, the acount value is $%.02f", total);
	}

}
