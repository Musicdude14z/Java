package lab1;

public class Ex1_7 {
	
	public static void main(String[] args) {
		System.out.println(getPi(5));
		System.out.println(getPi(6));
	}
	
	public static double getPi(int n) {
		double sum = 1;
		for(int i=0, j=3; i<n; i++, j+=2) {
			sum += (i%2==0 ? -1 : 1) * (double)1/j;
		}
		return 4 * sum;
	}
	
}
