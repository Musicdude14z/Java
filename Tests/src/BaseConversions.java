import java.util.HashMap;


public class BaseConversions {
	
	public static HashMap<Integer, Character> getDig = new HashMap<Integer, Character>();
	public static HashMap<Character, Integer> getVal = new HashMap<Character, Integer>();
	
	static { //Fill getDig and getVal with values (They are inverses)
		String order = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0; i<order.length(); i++) {
			getDig.put(i, order.charAt(i));
			getVal.put(order.charAt(i), i);
		}
	}
	
	private static long powerUnder(long num, int base) {
		return (long)Math.pow(base, (int)(Math.log(num)/Math.log(base))); //base^floor(log_base(num)) =>largest pow of base below num
	}
	
	private static String fromDecimal(long dec, int base) {
		String out; 
		if(dec < 0) { //setup - sign if neg, make dec pos
			dec = -dec;
			out = "-";
		}else out = "";
		long pOfBase = powerUnder(dec, base); //get largest power of base below dec
		while(pOfBase > 0) { 
			out += getDig.get((int)(dec/pOfBase));	//add digits from left to right (each digit is the floor(dec/pOfBase)
			dec %= pOfBase; //dec set to dec mod pOfBase to remove what was accounted for in previous digit
			pOfBase /= base; //pOfBase goes down one power by dividing by base (will result in 0 after the 0th power - 1)
		}
		return out;
	}
	
	private static long toDecimal(String num, int base) {
		num = num.toUpperCase();  //Maps will only recognize uppercase characters
		long dec = 0;
		boolean negative = false;
		if(num.startsWith("-")) { //handles negatives, makes num 'positive'
			num = num.substring(1);
			negative = true;
		}
		long powOfBase = (long) Math.pow(base, num.length()-1);  //gets power of base associated with left most digit
		char[] numArr = num.toCharArray();
		for(char c : numArr) {
			dec += getVal.get(c) * powOfBase;  //multiplies digit by power at that digit
			powOfBase /= base;  //gets next largest power by dividing by base
		}
		return negative ? -dec : dec; //handles negative
	}
	
	public static String convertBase(String num, int currentBase, int newBase) {
		return fromDecimal(toDecimal(num, currentBase), newBase); //convert to decimal, then to newBase
	}
	
}
