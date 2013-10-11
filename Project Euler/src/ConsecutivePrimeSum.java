import java.util.Arrays;


public class ConsecutivePrimeSum {

	/*
	private static int[] primes;
	private static boolean[] isPrime;
	*/
	
	public static void main(String[] args) {
		System.out.println(getPrimeSum(1000000));
		/*
		int[] primes = primeArrayUnder(100);
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += primes[i];
		}
		System.out.println(sum);
		boolean[] isPrime = primesUnder(100);
		System.out.println("array:"+isPrime[sum]+"\nmethod:"+isPrime(sum));
		*/
	}
	
	private static String getPrimeSum(int limit) {
		int[] primes = primeArrayUnder(limit);
		for(int len=primes.length; len>0; len--) {
			for(int start=0; start<=primes.length-len; start++) {
				int sum = 0;
				for(int i=start; i<len+start; i++) {
					sum += primes[i];
					if(sum>limit) break;
				}
				if(sum>limit) break;
				if(isPrime(sum)) return "sum:"+sum+"\nstart:"+start+"\nlen:"+len;
			}
		}
		return "";
	}
	
	
	private static boolean isPrime(int n) {
		if(n==2) return true;
		if(n%2==0 || n<2) return false;
		int limit = (int) Math.floor(Math.sqrt(n)) + 1;
		for(int i=3; i<limit; i+=2) {
			if(n%i==0) return false;
		}
		return true;
	}
	
	
	private static boolean[] primesUnder(int limit) {
		boolean[] f = new boolean[limit];
		Arrays.fill(f, 2, limit, true);
		int subLim = (int) Math.floor(Math.sqrt(limit)) + 1;
		for(int i=4; i<limit; i+=2) f[i] = false;
		for(int i=3; i<subLim; i+=2) {
			if(f[i]) {
				for(int j=i+i; j<limit; j+=i) {
					f[j] = false;
				}
			}
		}
		return f;
	}
	
	private static int[] primeArrayUnder(int limit) {
		boolean[] isPrime = primesUnder(limit);
		int f[] = new int[limit], pos = 0;
		for(int i=0; i<isPrime.length; i++) {
			if(isPrime[i]) f[pos++] = i;
		}
		return Arrays.copyOfRange(f, 0, pos);
	}
	
}
