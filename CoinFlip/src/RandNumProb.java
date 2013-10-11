import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RandNumProb {
	
	private static int[] prob = new int[100];
	
	public static void main(String[] args) throws IOException {
		for(int i=0; i<100000; i++) { //100-thousand random numbers from 0-99 
			prob[(int)Math.floor(Math.random()*100)]++;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("RandNumProb.txt")));
		for(int i=0; i<prob.length; i++) {
			out.printf("%d:\t", i);
			while(prob[i]-->0) out.print("*");
			out.println();
		}
		out.close();
	}
	
}
