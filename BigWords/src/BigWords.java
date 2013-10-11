import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BigWords {
	
	protected static Map<Character, String[]> alpha = new HashMap<Character, String[]>();
	
	public static void main(String[] args) throws IOException{
		String in = "";
		/*
		try {
			BufferedReader f = new BufferedReader(new FileReader("Test.txt"));
			while(f.ready()) in += f.readLine() + '\n';
			f.close();
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter("BigWordsOut.txt")));
			out.print(getBigString(in));
			out.close();
		}catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		*/
		System.out.print("Enter a phrase: ");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(getBigString(str));
	}
	
	public static String getBigString(String s) {
		String[] lines = s.split("\n");
		String f = "";
		for(String line : lines) {
			f += getBigLine(line) + "\n\n";
		}
		return f;
	}
	
	private static String getBigLine(String s) {
		String f = "";
		if(s.length()<1) return f;
		for(int i=0; i<5; i++) {
			int n = 0;
			for(char c : s.toCharArray()) {
				//System.out.println("'" + c + "', line: " + i);
				if(c=='\t') {
					f += alpha.get(' ')[i].replaceAll("[10]{1}", " ") + ' ';
					while(++n%4 != 0) f += alpha.get(' ')[i].replaceAll("[10]{1}", " ") + ' ';
					continue;
				}
				f += alpha.get(c)[i].replace('0', ' ').replace('1', c) + ' ';
				n++;
			}
			f += '\n';
		}
		return f;
	}
	
	static {
		alpha.put('A', new String[] {"01110", "10001", "11111", "10001", "10001"});
		alpha.put('B', new String[] {"11110", "01001", "01110", "01001", "11110"});
		alpha.put('C', new String[] {"01110", "10001", "10000", "10001", "01110"});
		alpha.put('D', new String[] {"11110", "10001", "10001", "10001", "11110"});
		alpha.put('E', new String[] {"11111", "10000", "11110", "10000", "11111"});
		alpha.put('F', new String[] {"11111", "10000", "11110", "10000", "10000"});
		alpha.put('G', new String[] {"01110", "10000", "10011", "10001", "01110"});
		alpha.put('H', new String[] {"10001", "10001", "11111", "10001", "10001"});
		alpha.put('I', new String[] {"11111", "00100", "00100", "00100", "11111"});
		alpha.put('J', new String[] {"00111", "00010", "00010", "10010", "01100"});
		alpha.put('K', new String[] {"11001", "01010", "01100", "01010", "01001"});
		alpha.put('L', new String[] {"10000", "10000", "10000", "10000", "11111"});
		alpha.put('M', new String[] {"10001", "11011", "10101", "10001", "10001"});
		alpha.put('N', new String[] {"10001", "11001", "10101", "10011", "10001"});
		alpha.put('O', new String[] {"01110", "10001", "10001", "10001", "01110"});
		alpha.put('P', new String[] {"11110", "01001", "01110", "01000", "01000"});
		alpha.put('Q', new String[] {"01110", "10001", "10001", "01110", "00011"});
		alpha.put('R', new String[] {"11110", "01001", "01110", "01001", "01001"});
		alpha.put('S', new String[] {"01110", "10000", "01110", "00001", "01110"});
		alpha.put('T', new String[] {"11111", "00100", "00100", "00100", "00100"});
		alpha.put('U', new String[] {"10001", "10001", "10001", "10001", "11111"});
		alpha.put('V', new String[] {"10001", "10001", "10001", "01010", "00100"});
		alpha.put('W', new String[] {"10001", "10001", "10101", "11011", "10001"});
		alpha.put('X', new String[] {"10001", "01010", "00100", "01010", "10001"});
		alpha.put('Y', new String[] {"10001", "01010", "00100", "00100", "00100"});
		alpha.put('Z', new String[] {"11111", "00010", "00100", "01000", "11111"});
		alpha.put('a', new String[] {"00000", "01100", "10010", "10010", "01101"});
		alpha.put('b', new String[] {"11000", "01000", "01110", "01001", "01110"});
		alpha.put('c', new String[] {"00000", "00110", "01000", "01000", "00110"});
		alpha.put('d', new String[] {"00011", "00010", "01110", "10010", "01110"});
		alpha.put('e', new String[] {"00100", "01010", "01110", "01000", "00110"});
		alpha.put('f', new String[] {"00010", "00100", "01110", "00100", "00100"});
		alpha.put('g', new String[] {"00100", "01010", "00110", "00010", "01100"});
		alpha.put('h', new String[] {"01000", "01000", "01110", "01010", "01010"});
		alpha.put('i', new String[] {"00000", "00100", "00000", "00100", "00100"});
		alpha.put('j', new String[] {"00100", "00000", "00100", "00100", "01000"});
		alpha.put('k', new String[] {"01000", "01010", "01100", "01010", "01010"});
		alpha.put('l', new String[] {"01000", "00100", "00100", "00100", "00100"});
		alpha.put('m', new String[] {"00000", "00000", "01010", "10101", "10001"});
		alpha.put('n', new String[] {"00000", "00000", "00100", "01010", "01010"});
		alpha.put('o', new String[] {"00000", "00000", "00100", "01010", "00100"});
		alpha.put('p', new String[] {"00000", "01100", "01010", "01100", "01000"});
		alpha.put('q', new String[] {"00000", "01100", "10100", "01101", "00110"});
		alpha.put('r', new String[] {"00000", "00000", "00110", "01000", "01000"});
		alpha.put('s', new String[] {"00000", "00110", "00100", "00010", "00110"});
		alpha.put('t', new String[] {"00100", "01110", "00100", "00100", "00110"});
		alpha.put('u', new String[] {"00000", "00000", "01010", "01010", "01110"});
		alpha.put('v', new String[] {"00000", "00000", "01010", "01010", "00100"});
		alpha.put('w', new String[] {"00000", "00000", "10001", "10101", "01010"});
		alpha.put('x', new String[] {"00000", "00000", "01010", "00100", "01010"});
		alpha.put('y', new String[] {"00000", "00000", "00101", "00010", "01100"});
		alpha.put('z', new String[] {"00000", "01111", "00010", "00100", "01111"});
		alpha.put('0', new String[] {"01110", "10011", "10101", "11001", "01110"});
		alpha.put('1', new String[] {"00100", "01100", "00100", "00100", "01110"});
		alpha.put('2', new String[] {"00110", "01001", "00010", "00100", "01111"});
		alpha.put('3', new String[] {"01110", "00001", "00110", "00001", "01110"});
		alpha.put('4', new String[] {"00110", "01010", "10010", "11111", "00010"});
		alpha.put('5', new String[] {"01111", "01000", "01110", "00001", "01110"});
		alpha.put('6', new String[] {"00110", "01000", "01110", "01001", "00110"});
		alpha.put('7', new String[] {"01111", "00001", "00010", "00100", "00100"});
		alpha.put('8', new String[] {"01110", "10001", "01110", "10001", "01110"});
		alpha.put('9', new String[] {"00110", "01001", "00111", "00001", "00110"});
		alpha.put('`', new String[] {"01000", "00100", "00000", "00000", "00000"});
		alpha.put('~', new String[] {"00000", "01000", "10101", "00010", "00000"});
		alpha.put('!', new String[] {"01000", "01000", "01000", "00000", "01000"});
		alpha.put('@', new String[] {"01110", "10101", "11011", "10111", "01100"});
		alpha.put('#', new String[] {"01010", "11111", "01010", "11111", "01010"});
		alpha.put('$', new String[] {"01110", "10100", "01110", "00101", "01110"});
		alpha.put('%', new String[] {"10001", "00010", "00100", "01000", "10001"});
		alpha.put('^', new String[] {"00100", "01010", "10001", "00000", "00000"});
		alpha.put('&', new String[] {"01000", "10100", "01000", "10100", "11011"});
		alpha.put('*', new String[] {"01010", "00100", "01010", "00000", "00000"});
		alpha.put('(', new String[] {"00010", "00100", "00100", "00100", "00010"});
		alpha.put(')', new String[] {"01000", "00100", "00100", "00100", "01000"});
		alpha.put('-', new String[] {"00000", "00000", "01110", "00000", "00000"});
		alpha.put('_', new String[] {"00000", "00000", "00000", "00000", "11111"});
		alpha.put('=', new String[] {"00000", "01110", "00000", "01110", "00000"});
		alpha.put('+', new String[] {"00000", "00100", "01110", "00100", "00000"});
		alpha.put('[', new String[] {"00110", "00100", "00100", "00100", "00110"});
		alpha.put(']', new String[] {"01100", "00100", "00100", "00100", "01100"});
		alpha.put('{', new String[] {"00010", "00100", "01100", "00100", "00010"});
		alpha.put('}', new String[] {"01000", "00100", "00110", "00100", "01000"});
		alpha.put('\\', new String[] {"10000", "01000", "00100", "00010", "00001"});
		alpha.put('|', new String[] {"00100", "00100", "00100", "00100", "00100"});
		alpha.put(';', new String[] {"00000", "00100", "00000", "00100", "01000"});
		alpha.put(':', new String[] {"00000", "00100", "00000", "00100", "00000"});
		alpha.put('"', new String[] {"01010", "01010", "00000", "00000", "00000"});
		alpha.put('\'', new String[] {"00100", "00100", "00000", "00000", "00000"});
		alpha.put(',', new String[] {"00000", "00000", "00000", "00100", "01000"});
		alpha.put('<', new String[] {"00010", "00100", "01000", "00100", "00010"});
		alpha.put('.', new String[] {"00000", "00000", "00000", "01100", "01100"});
		alpha.put('>', new String[] {"01000", "00100", "00010", "00100", "01000"});
		alpha.put('/', new String[] {"00001", "00010", "00100", "01000", "10000"});
		alpha.put('?', new String[] {"01110", "10001", "00010", "00000", "00100"});
		alpha.put(' ', new String[] {"00000", "00000", "00000", "00000", "00000"});
	}

}
