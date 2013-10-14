package chapter2;

import java.util.Scanner;

public class Ex2_8 {

	public static void main(String[] args) {
		System.out.print("Enter the time offset to GMT: ");
		Scanner s = new Scanner(System.in);
		int offset = s.nextInt();
		s.close();
		long time = System.currentTimeMillis() + offset*3600*1000,
				seconds = time/1000%60, minutes = time/1000/60%60, hours = time/1000/3600%24;
		System.out.printf("The current time is %d:%d:%d", hours, minutes, seconds);
	}

}
