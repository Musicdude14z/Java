/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.*;
import java.util.*;

class Main implements Runnable {
	static String ReadLn(int maxLength) { // utility function to read from
											// stdin,
											// Provided by
											// Programming-challenges, edit for
											// style only
		byte line[] = new byte[maxLength];
		int length = 0;
		int input = -1;
		try {
			while (length < maxLength) {// Read untill maxlength
				input = System.in.read();
				if ((input < 0) || (input == '\n'))
					break; // or untill end of line ninput
				line[length++] += input;
			}

			if ((input < 0) && (length == 0))
				return null; // eof
			return new String(line, 0, length);
		} catch (IOException e) {
			return null;
		}
	}

	public static void main(String args[]) // entry point from OS
	{
		Main myWork = new Main(); // Construct the bootloader
		myWork.run(); // execute
	}

	public void run() {
		new myStuff().run();
	}
}

class myStuff implements Runnable {
	public void run() {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int i = s.nextInt(), j = s.nextInt(), longest = 0;
			for(int x = i; x<=j; x++) {
				longest = Math.max(longest, seriesLength(x));
			}
			System.out.printf("%d %d %d", i, j, longest);
			System.out.println();
		}
		s.close();
		System.exit(0);
	}
	
	public static int seriesLength(int n) {
		int c = 1;
		while(n!=1) {
			n = n%2==0 ? n/2 : n*3+1;
			c++;
		}
		return c;
	}
	
	// You can insert more classes here if you want.
}