package chapter8;

/**
 * Example Class
 * @author Zach Kaplan
 * @version 2.0
 */
public class Vehicle {
	
	private int passengers, fuelCap, mpg;
	
	public Vehicle(int p, int f, int m) {
		setPassengers(p);
		fuelCap = f;
		mpg = m;
	}
	
	int range() {
		return mpg * fuelCap;
	}
	
	double fuelNeeded(int miles) {
		return (double) miles / mpg;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

}
