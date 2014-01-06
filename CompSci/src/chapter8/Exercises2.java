package chapter8;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import utils.Utils;

/**
 * Exercises for Chapter 8
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises2 {

	/**
	 * Main Method
	 * @param args - cmd input
	 */
	public static void main(String[] args) {
		Utils.newLine(8.03);
		x8_03();
		Utils.newLine(8.04);
		x8_04();
		Utils.newLine(8.05);
		x8_05();
	}
	
	/**
	 * Exercise 8.03
	 * Prints date strings at different time offsets
	 */
	private static void x8_03() {
		for(long i = 1_000; i <= 1_000_000_000_000L; i *= 10) {
			Date d = new Date(i);
			System.out.println(d);
		}
	}
	
	/**
	 * Exercise 8.04
	 * Prints the first 50 random numbers on [0, 100) w/ a seed of 1000
	 */
	private static void x8_04() {
		Random r = new Random(1000);
		for(int i=0; i<50; i++) {
			System.out.print(r.nextInt(100) + " ");
		}
	}
	
	/**
	 * Exercise 8.05
	 * Prints Gregorian Calender Year, Month, DayOfMonth for now and a time offset
	 */
	private static void x8_05() {
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.get(GregorianCalendar.YEAR) + ", " + gc.get(GregorianCalendar.MONTH)
				+ ", " + gc.get(GregorianCalendar.DAY_OF_MONTH));
		gc.setTimeInMillis(1234567898765L);
		System.out.println(gc.get(GregorianCalendar.YEAR) + ", " + gc.get(GregorianCalendar.MONTH)
				+ ", " + gc.get(GregorianCalendar.DAY_OF_MONTH));
	}

}
