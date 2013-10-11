import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Stripper {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("in.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("result.out"));
		while(in.ready()) {
			char[] line = in.readLine().toCharArray();
			boolean inTag = false;
			for(char c : line) {
				if(inTag) {
					if(c == '>') {
						inTag = false;
						out.print(' ');
					}
				}else {
					if(c == '<') {
						inTag = true;
					}else out.print(c);
				}
				
			}
			out.println("\n~~BREAK~~\n\n");
		}
		in.close();
		out.close();
	}
	
}
