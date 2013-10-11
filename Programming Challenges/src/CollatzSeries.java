import java.util.InputMismatchException;
import java.util.Scanner;


public class CollatzSeries {
	
	public static void main(String[] args) throws InputMismatchException{
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int i = s.nextInt(), j = s.nextInt(), longest = 0;
			for(int x = i; x<=j; x++) {
				longest = Math.max(longest, seriesLength(x));
			}
			System.out.printf("%d %d %d", i, j, longest);
			System.out.println();
		}
		s.close();
		System.exit(0);
	}
	
	public static int seriesLength(int n) {
		int c = 1;
		while(n!=1) {
			n = n%2==0 ? n/2 : n*3+1;
			c++;
		}
		return c;
	}
	
}
