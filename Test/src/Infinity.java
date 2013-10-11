
public class Infinity {

	public static void main(String[] args) {
		double d = Double.POSITIVE_INFINITY, negD = Double.NEGATIVE_INFINITY;
		System.out.println(negD);
		System.out.println(d);
		System.out.println(Double.toString(d));
	}
	
	static double sumOfDig(double d) {
		double sum = d%10;
		while((d/=10) > 0) {
			sum += d%10;
		}
		return sum;
	}
	
}
