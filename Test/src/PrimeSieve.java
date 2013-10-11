import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeSieve {
	
	public static void main(String[] args) throws InputMismatchException {
		System.out.print("Enter a limit: ");
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		s.close();
		boolean[] arr = primesUnder(l);
		for(int i=0; i<arr.length; i++) {
			if(!arr[i]) System.out.println(i+2);  //If not COMPOSITE, print
		}
	}
	
	public static boolean[] primesUnder(int n) { //NOTE: false = prime, true = composite
		if(n<2) return new boolean[0];
		boolean[] primes = new boolean[n-1]; //Indexes shifted 2 to the left, includes n
		for(int i=4; i<=n; i+=2) primes[i-2] = true;
		int l = (int) Math.sqrt(n);
		for(int i=3; i<=l; i+=2) {
			if(!primes[i-2]) {
				for(int j=2*i; j<=n; j+=i) primes[j-2] = true;
			}
		}
		return primes;
	}
	
}
