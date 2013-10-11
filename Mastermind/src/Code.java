import java.util.Arrays;


public class Code {
	
	public static final char[] colors = {'M', 'T', 'P', 'W', 'Y', 'O', 'E'};
	
	public static boolean isColor(char c) {
		for(char x : colors) {
			if(c==x) return true;
		}
		return false;
	}
	
	public static Code parse(String str) {
		char[] temp = str.toUpperCase().trim().toCharArray();
		String f = "";
		for(int i=0; i<temp.length; i++) {
			if(isColor(temp[i])) f += temp[i];
		}
		return new Code(f.toCharArray());
	}
	
	private char[] code;
	
	public Code() {
		code = new char[4];
		for(int i=0; i<code.length; i++) {
			code[i] = colors[(int)(Math.random()*colors.length)];
		}
	}
	
	public Code(int length) {
		code = new char[length];
		for(int i=0; i<code.length; i++) {
			code[i] = colors[(int)(Math.random()*colors.length)];
		}
	}
	
	public Code(char[] code) {
		this.code = code;
	}
	
	public char[] getCode() {
		return code;
	}
	
	public int length() {
		return code.length;
	}
	
	public boolean equals(Code c) {
		return Arrays.equals(code, c.getCode());
	}
	
	public int[] compareTo(Code c) {
		if(c.length() != code.length) return new int[0];
		int[] f = new int[2]; //index 0 is perfect match, index 1 is color match
		char[] one = Arrays.copyOfRange(code, 0, code.length), two = c.getCode();
		for(int i=0; i<one.length; i++) { //perfect match (precedence)
			if(one[i] == two[i]) {
				f[0]++;
				one[i] = '%';
				two[i] = '%';
			}
		}
		for(int i=0; i<one.length; i++) { //color match
			if(one[i] != '%') {
				for(int j=0; j<two.length; j++) {
					if(one[i] == two[j]) {
						f[1]++;
						one[i] = '%';
						two[j] = '%';
						break;
					}
				}
			}
		}
		return f;
	}
	
	public String toString() {
		String f = code[0] + "";
		for(int i=1; i<code.length; i++) {
			f += " " + code[i];
		}
		return f;
	}
	
}
