package chapter2;

import java.util.Scanner;

public class Ex2_6 {

	public static void main(String[] args) {
		System.out.print("Enter a number between 0 and 1000: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), sum = n%10;
		s.close();
		while((n/=10)>0) sum += n%10;
		System.out.printf("The sum of the digits is %d\n", sum);
	}

}
