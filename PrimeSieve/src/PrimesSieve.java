import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PrimesSieve {

	private boolean[] isPrime;
	private int limit, maxPrime = 0, numPrime = 0;

	public static void main(String[] args) {
		String star = "";
		while(star.length() < 28) star += '*';
		System.out.println(star + " Sieve of Eratosthenes " + star);
		System.out.print("Search for primes up to: ");
		Scanner s = new Scanner(System.in);
		int lim = 0;
		PrimesSieve p = null;
		try {
			lim = s.nextInt();
			s.close();
			p = new PrimesSieve(lim);
		} catch(InputMismatchException ime) {
			s.close();
			System.err.println("Error: Input is not an integer.");
			System.exit(1);
		} catch(IllegalArgumentException iae) {
			System.err.println(iae.getMessage());
			System.exit(1);
		}
		System.out.println();
		System.out.printf("Number of primes found: %d\nPrimes up to %d:\n",
				p.countNumberOfPrimes(), lim);
		p.displayPrimes();
		System.exit(0);
	}

	public PrimesSieve(int limit) throws IllegalArgumentException {
		this.limit = limit;
		genIsPrime();
		for(int i=isPrime.length-1; i>=0; i--) {
			if(isPrime[i]) {
				maxPrime = i+2;
				break;
			}
		}
	}

	public void genIsPrime() throws IllegalArgumentException {
		if(limit<2) throw new IllegalArgumentException("Error: Input must be an integer >= 2.");
		isPrime = new boolean[limit-1]; //Indexes shifted 2 to the left, includes n
		Arrays.fill(isPrime, true);
		numPrime = limit-1;
		for(int i=4; i<=limit; i+=2) {
			isPrime[i-2] = false;
			numPrime--;
		}
		int l = (int) Math.sqrt(limit)+1;
		for(int i=3; i<=l; i+=2) {
			if(isPrime[i-2]) {
				for(int j=2*i; j<=limit; j+=i) {
					if(isPrime[j-2]) numPrime--;
					isPrime[j-2] = false;
				}
			}
		}
	}

	public int countNumberOfPrimes() {
		return numPrime;
	}

	public void displayPrimes() {
		int maxPrimeWidth = String.valueOf(maxPrime).length(),
				primesPerRow = 80/(maxPrimeWidth+1);
		if(maxPrime < 2) return;
		for(int i=2, c=primesPerRow; i<=maxPrime; i++) {
			if(!isPrime[i-2]) continue;
			String n = String.valueOf(i);
			while(n.length() < maxPrimeWidth) n = ' ' + n;
			System.out.print(n);
			if(c-- == 1) {
				System.out.println();
				c = primesPerRow;
			}else if(i<maxPrime){
				System.out.print(' ');
			}
		}
	}

}
