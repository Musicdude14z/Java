import java.util.Arrays;


public class TotientMaximum {
	
	public static void main(String[] args) {
		double max = 0;
		for(int i=1; i<=1000000; i++) {
			max = Math.max((double)i/phi(i), max);
		}
		System.out.println(max);
	}
	
	public static int phi(int n) {
		if(n<2) return 0;
		int lim = n/2+1, c = n-1;
		boolean[] key = new boolean[n];
		Arrays.fill(key, true);
		if(n%2==0) for(int i=2; i<n; i+=2) {
			key[i] = false;
			c--;
		}
		for(int i=3; i<lim; i+=2) {
			if(n%i == 0 && key[i]) {
				for(int j=i; j<n; j+=i) {
					key[j] = false;
					c--;
				}
			}
		}
		return c;
	}
	
}
