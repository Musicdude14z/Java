import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws InputMismatchException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		for(int i=0; i<n; i++) {
			int lines = s.nextInt(), tri[][] = new int[lines][];
			s.nextLine();
			for(int j=1; j<=lines; j++) {
				tri[j-1] = new int[j];
				for(int k=0; k<j; k++) {
					tri[j-1][k] = s.nextInt();
					s.nextLine();
				}
			}
			System.out.println(getLargestSum(tri));
		}
		s.close();
	}
	
	public static int getLargestSum(int[][] tri) {
		for(int row = tri.length-2; row>=0; row--) {
			for(int col=0; col<=row; col++) {
				tri[row][col] += Math.max(tri[row+1][col], tri[row+1][col+1]);
			}
		}
		return tri[0][0];
	}
	
}
