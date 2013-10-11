import java.util.Scanner;

public class LuckyNumbers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = s.nextLine();
		s.close();
		System.out.print("Hello, " + name + "!\nYour Lucky Numbers are: ");
		System.out.println(luckySeq(name, 10) + '.');
	}
	
	private static String luckySeq(String name, int limit) {
		int n = name.charAt(0);
		for(char c : name.toCharArray()) {
			n *= c/100 + 1;
		}
		String f = n+"";
		//Note: Collatz sequence
		while(n!=1 && --limit>0) {
			n = n%2==0 ? n/2 : 3*n + 1;
			f += ", " + n;
		}
		return f;
	}
	
}
