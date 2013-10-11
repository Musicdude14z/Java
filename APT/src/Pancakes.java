
public class Pancakes {

	public int minutesNeeded (int m, int n) {
		if(m==0) return 0;
		if(m < n) return 10;
		if(n==1) return 10*m;
		return 10 + (int)Math.ceil((double)(m-n)/(n/2)) * 5;
	}
	
}
