import java.util.InputMismatchException;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter degrees in Fahrenheit: ");
		try {
			double f = s.nextDouble(), c = TemperatureConversion.fahrenheitToCelsius(f);
			System.out.printf("%.2f F = %.2f C\n", f, c);
		} catch (InputMismatchException ime) {
			s.nextLine();
			System.out.println("Error: Invalid input received.");
		}
		System.out.print("Enter degrees in Celsius: ");
		try {
			double c = s.nextDouble(), f = TemperatureConversion.celsiusToFahrenheit(c);
			System.out.printf("%.2f C = %.2f F\n", c, f);
		} catch (InputMismatchException ime) {
			s.nextLine();
			System.out.println("Error: Invalid input received.");
		}
		System.out.print("Enter number of days: ");
		try {
			double d = s.nextDouble();
			int sec = TimeConversion.daysToSeconds(d);
			System.out.printf("%.2f days = %01d seconds\n", d, sec);
		} catch (InputMismatchException ime) {
			s.nextLine();
			System.out.println("Error: Invalid input received.");
		}
		System.out.print("Enter number of seconds: ");
		try {
			int sec = s.nextInt();
			double d = TimeConversion.secondsToDays(sec);
			System.out.printf("%01d seconds = %.2f days\n", sec, d);
		} catch (InputMismatchException ime) {
			s.nextLine();
			System.out.println("Error: Invalid input received.");
		}
		s.close();
	}

}
