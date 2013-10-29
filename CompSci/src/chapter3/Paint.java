package chapter3;

import java.util.Scanner;

public class Paint {

	public static void main(String[] args) {
		final int COVERAGE = 350, // paint covers 350 sq. ft. / gal.
				WINDOW_AREA = 15, DOOR_AREA = 20; //constant window and door areas
		int length, width, height, // dimensions of room
				numWindows, numDoors; //number of windows and doors
		double totalSqFt, // total area to be painted
				paintNeeded; // gallons of paint needed
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter the length of the room: ");
		length = s.nextInt(); //length of room
		
		System.out.print("Enter the width of the room: ");
		width = s.nextInt(); //width of room
		
		System.out.print("Enter the height of the room: ");
		height = s.nextInt(); //height of room
		
		System.out.print("Enter the number of windows in the room: ");
		numWindows = s.nextInt(); //number of windows
		
		System.out.print("Enter the number of doors in the room: ");
		numDoors = s.nextInt(); //number of doors
		
		totalSqFt = 2*height*(length + width) //area of walls
				- (numWindows*WINDOW_AREA + numDoors*DOOR_AREA); //minus area of windows/doors
		paintNeeded = totalSqFt / COVERAGE; //area / coverage yields gallons of paint
		
		System.out.printf("For a room with the dimensions %dx%dx%d, with %d windows and" +
				" %d doors, you would need %f gallons of paint!\n",
				length, width, height, numWindows, numDoors, paintNeeded);
		
		System.out.println("Would you like to paint another room?");
		if(s.next().matches("(Yes|yes|Y|y)")) { //check response
			System.out.println(); //spacing
			main(new String[] {}); //call main method recursively
		}
		
		s.close();
	}

}
