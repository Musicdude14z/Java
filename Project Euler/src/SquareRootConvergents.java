import java.math.BigInteger;
public class SquareRootConvergents {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		BigInteger one = new BigInteger("1"), two = new BigInteger("2");
		int c = 0;
		Fraction f = new Fraction(one, two);
		for(int i=0; i<1000; i++) {
			if(isNumBigger(f.add(one))) c++;
			f = f.add(two);
			f.invert();
		}
		System.out.println(c);
		System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + " ms");
	}
	
	/*
	public static Fraction getExpansion(int i) {
		BigInteger one = new BigInteger("1"), two = new BigInteger("2");
		if(i==0) {
			return new Fraction(one, two);
		}
		Fraction f = getExpansion(i-1).add(two);
		f.invert();
		return f;
	}
	*/
	
	public static boolean isNumBigger(Fraction f) {
		return (f.getNum()+"").length() > (f.getDen()+"").length(); 
	}
	
	static class Fraction {
		
		private BigInteger num, den;
		
		public Fraction() {
			this.num = new BigInteger("1");
			this.den = new BigInteger("1");
		}
		
		public Fraction(BigInteger num) {
			this.num = num;
			den = new BigInteger("1");
		}
		
		public Fraction(BigInteger num, BigInteger den) {
			this.num = num;
			this.den = den;
			simplify();
		}
		
		public Fraction(Fraction num, Fraction den) {
			this.num = num.getNum().multiply(den.getDen());
			this.den = num.getDen().multiply(den.getNum());
			simplify();
		}
		
		public Fraction(BigInteger num, Fraction den) {
			this.num = num.multiply(den.getDen());
			this.den = den.getNum();
			simplify();
		}
		
		public Fraction(Fraction num, BigInteger den) {
			this.num = num.getNum();
			this.den = num.getDen().multiply(den);
			simplify();
		}
		
		public void invert() {
			BigInteger temp = new BigInteger(this.num.toString());
			this.num = new BigInteger(this.den.toString());
			this.den = new BigInteger(temp.toString());
		}
		
		public BigInteger getNum() {
			return this.num;
		}
		
		public BigInteger getDen() {
			return this.den;
		}
		
		public void setNum(BigInteger n) {
			num = n;
			simplify();
		}
		
		public void setDen(BigInteger d) {
			den = d;
			simplify();
		}
		
		public Fraction add(Fraction f) {
			BigInteger cDen = commonDen(den, f.getDen()), num1 = num.multiply(cDen.divide(den)), 
					num2 = f.getNum().multiply(cDen.divide(f.getDen()));
			return new Fraction(num1.add(num2), cDen);
		}
		
		public Fraction add(BigInteger n) {
			return add(new Fraction(n));
		}
		
		public Fraction sub(Fraction f) {
			f.setNum(f.getNum().negate());
			return add(f);
		}
		
		public Fraction sub(BigInteger n) {
			return sub(new Fraction(n));
		}
		
		public Fraction mult(Fraction f) {
			return new Fraction(num.multiply(f.getNum()), den.multiply(f.getDen()));
		}
		
		public Fraction mult(BigInteger n) {
			return mult(new Fraction(n));
		}
		
		public Fraction div(Fraction f) {
			f.invert();
			return mult(f);
		}
		
		public Fraction div(BigInteger n) {
			return div(new Fraction(n));
		}
		
		public void simplify() {
			BigInteger gcf = gcf(num.abs(), den.abs());
			num = num.divide(gcf);
			den = den.divide(gcf);
			if(den.compareTo(new BigInteger("0"))<0) {
				num = num.negate();
				den = den.negate();
			}
		}
		
		public Fraction pow(int p) {
			return new Fraction(num.pow(p), den.pow(p));
		}
		
		public String toString() {
			return num.toString() + "/" + den.toString();
		}
		
		private BigInteger commonDen(BigInteger a, BigInteger b) {
			return a.multiply(b.divide(a.gcd(b)));
		}
		
		private BigInteger gcf(BigInteger a, BigInteger b) {
			return a.gcd(b);
		}
		
	}

}
