package chapter2;

import java.util.Scanner;

public class Ex2_7 {

	public static void main(String[] args) {
		System.out.print("Enter number of minutes: ");
		Scanner s = new Scanner(System.in);
		long min = s.nextLong();
		s.close();
		System.out.printf("%d minutes is approximately %d years and %d days", min, min/(365*24*60), min/24/60%365);
	}

}
