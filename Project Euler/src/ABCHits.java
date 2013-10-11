
public class ABCHits {
	
	public static void main(String[] args) {
		long sum = 0;
		for(int a=2; a<60000; a++) {
			int c;
			for(int b=a+1; (c=a+b)<120000; b++) {
				if(!(gcd(a,b)==1&&gcd(b,c)==1&&gcd(a,c)==1)) continue;
				if(rad(a*b*c) >= c) continue;
				sum += c;
			}
		}
		System.out.println(sum);
	}
	
	public static int gcd(int a, int b) {
		int gcd = 0;
		while (b > 0){
            gcd = b;
            b = a % b;
            a = gcd;
        }
        return gcd;
	}
	
	public static int rad(int a) {
		int prod = 1;
		if(a%2==0) prod = 2;
		while(a%2==0) a/=2;
		for(int i=3; a>1; i+=2) {
			if(a%i==0) prod *= i;
			while(a%i==0) a/=i;
		}
		return prod;
	}
	
}
