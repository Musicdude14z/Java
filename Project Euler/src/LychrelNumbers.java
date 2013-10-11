import java.text.DecimalFormat;


public class LychrelNumbers {
	
	public static void main(String[] args) {
		int c = 0;
		for(double i=0; i<10000; i++) {
			if(isLychrel(i)) c++;
		}
		System.out.println(c);
	}
	
	private static boolean isPalindrome(double n) {
		String s = format(n);
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
		}
		return true;
	}
	
	private static double reverse(double n) {
		String s = format(n), f = "";
		for(int i=s.length()-1; i>=0; i--) {
			f += s.charAt(i);
		}
		return Double.parseDouble(f);
	}
	
	private static boolean isLychrel(double n) {
		for(int i=0; i<50; i++) {
			n += reverse(n);
			if(isPalindrome(n)) return false;
		}
		return true;
	}
	
	private static String format(double n) {
		return new DecimalFormat("#").format(n);
	}

}
