import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ReverseRoots {
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		String result = "";
		while(in.hasNextLong()) {
			result = Math.sqrt(in.nextLong()) + "\n" + result;
		}
		in.close();
		BufferedReader r = new BufferedReader(new StringReader(result));
		while(r.ready()) {
			out.printf("%.4f", Double.parseDouble(r.readLine()));
			out.println();
		}
		out.flush();
		System.exit(0);
	}
	
}
