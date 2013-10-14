package chapter2;

import java.util.Scanner;

public class Ex2_11 {

	public static void main(String[] args) {
		System.out.print("Enter the number of years: ");
		Scanner s = new Scanner(System.in);
		int p = 312_032_486, sPerYr = 365*24*3600, numYears = s.nextInt();
		s.close();
		for(int i=1; i<=numYears; i++) {
			p += sPerYr/7 - sPerYr/13 + sPerYr/45;
		}
		System.out.printf("The population in %d years is %d", numYears, p);
	}

}
