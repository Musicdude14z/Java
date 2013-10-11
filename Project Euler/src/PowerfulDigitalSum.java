import java.math.BigInteger;
//import java.text.DecimalFormat;


public class PowerfulDigitalSum {
	
	public static void main(String[] args) {
		int max = 0;
		for(int a=1; a<100; a++) {
			for(int b=1; b<100; b++) {
				BigInteger x = new BigInteger(a+"");
				max = Math.max(digitSum(x.pow(b)), max);
			}
		}
		System.out.println(max);
	}
	
	public static int digitSum(BigInteger n) {
		char[] digits = n.toString().toCharArray();
		int sum = 0;
		for(char c : digits) {
			sum += Integer.parseInt(c+"");
		}
		return sum;
	}

}
