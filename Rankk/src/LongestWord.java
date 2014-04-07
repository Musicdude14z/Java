import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestWord {

	public static void main(String[] args) {
		long longest = 0;
		String word = "";
		for(int i=0; i<115; i++) {
			Pattern p = Pattern.compile("\\b\\w+?\\b");
			try(BufferedReader b = new BufferedReader(new FileReader("res/"+i+".txt"))) {
				while(b.ready()) {
					Matcher m = p.matcher(b.readLine());
					while(m.find()) {
						String s = m.group();
						if(s.length() > longest) {
							longest = s.length();
							word = s;
						}
					}
				}
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		System.out.println(word);
	}

}
