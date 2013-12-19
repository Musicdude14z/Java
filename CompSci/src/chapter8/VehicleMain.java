package chapter8;

/**
 * Example Driver Class
 * @author Zach Kaplan
 * @version 2.0
 */
public class VehicleMain {
	
	public static void main(String[] args) {
		Vehicle car = new Vehicle(7, 16, 21);
		int distance = 252;
		
		System.out.println("To go " + distance + " miles, the car needs " + 
					car.fuelNeeded(distance) + " gallons of fuel.");
	}

}
