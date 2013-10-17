package chapter2;

import java.util.Scanner;

public class Ex2_10 {

	/*
	 * 2.10 Takes a weight of water in kilograms and an initial and final
	 * temperature and calculates the amount of energy in Joules needed
	 */
	public static void main(String[] args) {
		System.out.print("Enter the amount of water in kilograms: ");
		
		Scanner s = new Scanner(System.in);
		double kgWater = s.nextDouble();
		
		System.out.print("Enter the initial temperature: ");
		double t0 = s.nextDouble();
		
		System.out.print("Enter the final temperature: ");
		double t1 = s.nextDouble();
		
		s.close();
		
		//This is mCaT, or mass*SpecificHeat*deltaTemperature, so 
		System.out.printf("The energy needed is %f", kgWater * 4184 * (t1 - t0));
	}

}
