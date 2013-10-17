package chapter2;

import java.util.Scanner;

public class Ex2_11 {

	/*
	 * 2.11 takes a number of years and calculates the population after that amount of time
	 */
	public static void main(String[] args) {
		System.out.print("Enter the number of years: ");
		Scanner s = new Scanner(System.in);
		int p = 312_032_486, sPerYr = 365*24*3600, numYears = s.nextInt(); //initial vals
		s.close();
		for(int i=1; i<=numYears; i++) {
			p += sPerYr/7 - sPerYr/13 + sPerYr/45; 
			//1Birth/7Seconds - 1Death/13Seconds + 1Immigration/45Seconds
		}
		System.out.printf("The population in %d years is %d", numYears, p);
	}

}
