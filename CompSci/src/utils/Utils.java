package utils;

/**
 * Class that stores some basic utilities that help with the completion of my
 * CompSci homework assignments.
 * 
 * @author Zach Kaplan
 * @version 1.0
 */
public class Utils {

	/**
	 * {@code public static void newLine(double section)}
	 * <p>
	 * Prints "Exercise " and the section number rounded to 2 decimal places to
	 * the console, with a new line character before and after.
	 * <p>
	 * 
	 * @param section
	 *            - a {@code double} representing the section number
	 * @return {@code void}
	 */
	public static void newLine(double section) {
		System.out.printf("\nExercise %.2f\n", section);
	}

	/**
	 * {@code public static void err(String message)}
	 * <p>
	 * Prints the {@link String} message to the err console, and exits the code
	 * with and error code of 1.
	 * <p>
	 * 
	 * @param message
	 *            - a {@link String} to be printed to the err console
	 * @return {@code void}
	 */
	public static void err(String message) {
		System.err.println(message);
		System.exit(1);
	}

}
