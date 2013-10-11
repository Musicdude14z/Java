import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class RomanNumerals {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("roman.txt"));
		int c = 0;
		while(in.ready()) {
			String roman = in.readLine();
			c += roman.length() - toRoman(toNum(roman)).length();
		}
		System.out.println(c);
		in.close();
	}
	
	public static int toNum(String roman) {
		int num = 0, lastChar = 0;
		for(int i=roman.length()-1; i>=0; i--) {
			int val = getVal(roman.charAt(i));
			if(val < lastChar) num -= val;
			else num += val;
			lastChar = val;
		}
		return num;
	}
	
	public static int getVal(char c) {
		switch(c) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default: return 0;
		}
	}
	
	public static char getChar(int val) {
		switch(val) {
		case 1: return 'I';
		case 5: return 'V';
		case 10: return 'X';
		case 50: return 'L';
		case 100: return 'C';
		case 500: return 'D';
		case 1000: return 'M';
		default: return '?';
		}
	}
	
	public static String toRoman(int num) {
		int largest = 1000;
		char c;
		String roman = "";
		while(num > 0) {
			c = getChar(largest);
			while(num >= largest) {
				roman += c+"";
				num -= largest;
			}
			if(num==0) break;
			if(num >= largest-largest/10) {
				roman += getChar(largest/10) + "" + c;
				num -= largest-largest/10;
			}
			if(num==0) break;
			c = getChar(largest/=2);
			while(num >= largest) {
				roman += c+"";
				num -= largest;
			}
			if(num==0) break;
			if(num >= largest-largest/5) {
				roman += getChar(largest/5) + "" + c;
				num -= largest-largest/5;
			}
			largest /= 5;
		}
		return roman;
	}
	
}
