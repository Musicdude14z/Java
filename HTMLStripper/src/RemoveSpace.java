import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveSpace {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("in.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("result.out"));
		while(in.ready()) {
			String[] words = in.readLine().split(" ");
			for(String word : words) {
				if(word.equals("")) continue;
				out.print(word + ' ');
			}
			out.println();
		}
		in.close();
		out.close();
	}
	
}
