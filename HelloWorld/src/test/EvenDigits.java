package test;

public class EvenDigits {

	public static void main(String[] args) {
		System.out.println(evenDigits(81641136));
	}

	public static int evenDigits(int n) {
	    int next = 0;
	    if(n<0) {
	        next = evenDigits(-n);
	        return next==0 ? 0 : -next;
	    }if(n==0) {
	        return 0;
	    }
	    next = evenDigits(n/10);
	    return (next%10==0 ? next : next*10) + n%2==0 ? n%10 : 0;
	}
	
}
