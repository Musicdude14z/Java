import java.util.Scanner;


public class EstimateEandPi {
	
	public static void main(String[] args) {
		System.out.print("Enter number of iterations: ");
		Scanner s = new Scanner(System.in);
		String in = s.nextLine();
		s.close();
		int n = 0;
		try {
			n = Integer.parseInt(in);
		}catch (NumberFormatException nfe) {
			System.out.println("Error: Invalid input '" + in + "' received.");
			System.exit(1);
		}
		System.out.printf("e : %.5f\npi: %.5f", e(n), pi(n));
		System.exit(0);
	}
	
	public static double e(int n) {
		double e = 1;
		long last = 1, current = 1;
		for(int i=1; i<=n; i++) {
			if(last > (current*=i)) break;
			e += 1.0/(last = current);
		}
		return e;
	}
	
	public static double pi(int n) {
		double pi = 1;
		while(n > 0) {
			pi += (double)(n%2==0 ? 1 : -1) / (2*n-- + 1);
		}
		return pi*4;
	}
	
}
