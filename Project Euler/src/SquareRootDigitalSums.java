import java.math.BigInteger;


public class SquareRootDigitalSums {
	
	public static void main(String[] args) {
		System.out.println(Math.sqrt(2));
	}
	/*
	public static long sqDigSum(long base, int numDig) {
		long sum = 0;
		int start = 1;
		for(int odd=3; start<base; odd+=2) start += odd;
		base -= 2*(start=(int)Math.sqrt(start));
		BigInteger b = BigInteger.valueOf(base*100), record = BigInteger.valueOf(start);
		for(int i=0; i<numDig; i++) {
			BigInteger leading = record.multiply(BigInteger.valueOf(20)), next = BigInteger.valueOf(0);
			for(BigInteger j=BigInteger.valueOf(1); j.intValue()<10; j=j.add(BigInteger.valueOf(1))) {
				if(b.compareTo(leading.add(j).multiply(j)) < 0) {
					next = j.subtract(BigInteger.valueOf(1));
					break;
				}
			}
			sum += next.intValue();
			record = record.multiply(BigInteger.valueOf(10).add())
		}
	}
	*/
}
