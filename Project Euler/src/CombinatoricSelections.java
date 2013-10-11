
public class CombinatoricSelections {

	public static void main(String[] args) {
		int count = 0;
		for(int n=1; n<=100; n++) {
			for(int r=1; r<=n; r++) {
				if(combination(n, r) > 1000000.0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static double combination(int n, int r) {
		return factorial(n) / (factorial(r)*factorial(n-r));
	}
	
	private static double factorial(int n) {
		if(n<2) return 1;
		double sum = n;
		while(n-->2) {
			sum *= n;
		}
		return sum;
	}
	
}
