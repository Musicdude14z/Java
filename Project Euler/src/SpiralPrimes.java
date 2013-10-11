
public class SpiralPrimes {
	
	private static double numDiagnol = 1, numPrime = 0;
	
	public static void main(String[] args) {
		int val = 3;
		for(int len=3;;len+=2) {
			for(int i=0; i<4; i++) {
				if((numPrime += isPrime(val) ? 1 : 0)/++numDiagnol < 0.1) {
					System.out.println(len);
					System.exit(0);
				}
				val += len-1;
			}
			val += 2;
		}
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
	
}
