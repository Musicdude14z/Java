package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Print Formatting Problem for ACSL
 * @author Zach Kaplan
 * School - Beren County Academies, 
 * The Academy for the Advancement of Science and Technology [AAST]
 * Senior Devision
 * @version 1.0
 */
public class ZachKaplanPrintFormatting {

	/**
	 * Main Method
	 * @param args - cmd args
	 * @throws IOException
	 * 		doesn't need to be handled, only reading from System.in
	 */
	public static void main(String[] args) throws IOException { 
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String[] lines = new String[5];
		for(int i=0; i<5; i++) {
			lines[i] = b.readLine().substring(3); //strips leading line number, dot, and space
		}
		b.close();
		
		for(int i=0; i<5; i++) {
			String[] vals = lines[i].split(", ");
			System.out.printf("%d. %s\n", i+1, format(vals[0], Double.parseDouble(vals[1])));
		}
	}
	
	/**
	 * (This is very poorly written (rushed here), but it does work)<p>
	 * Formats double values as instructed in prompt
	 * @param f - FORMAT string
	 * @param val - float value to format
	 * @return formatted string
	 */
	private static String format(String f, double val) {
		boolean afterPeriod = false, comma = false, dollar = false, e = false;
		int spaceBefore = 0, spaceAfter = 0;
		for(char c : f.toCharArray()) {
			switch(c) {
			case '&':
				if(afterPeriod) spaceAfter++;
				else spaceBefore++;
				break;
			case '.':
				afterPeriod = true; break;
			case ',':
				comma = true; break;
			case '$':
				dollar = true; break;
			case 'E':
				e = true; break;
			}
		}
		
		String formatted;
		if(dollar && !f.startsWith("*")) spaceBefore = 0;
		
		if(e) {
			formatted = String.format("%." + (spaceBefore - 1) + "E", val)
					.replaceAll("[+-]0*", ""); //remove different exp formatting for E+01 => E1
		} else {
			formatted = String.format("%" + (comma?",.":".") + spaceAfter + "f", val);
			int numDig = numDigits((int)val); //find amount of space already taken
			for(int i=0; i<spaceBefore-numDig; i++) {
				formatted = '*' + formatted;
			}
		}
		
		if(dollar) { //insert dollar sign
			int i = formatted.lastIndexOf('*'); //after last leading '*'
			formatted = formatted.substring(0, i+1) + "$" + formatted.substring(i+1);
		}
		
		return formatted;
	}
	
	/**
	 * Returns number of digits in an int
	 * @param n - int
	 * @return num digits
	 */
	private static int numDigits(int n) {
		int count = 1;
		if(n < 0) n = -n;
		while((n/=10) > 0) count++;
		return count;
	}

}
