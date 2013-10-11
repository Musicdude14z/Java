import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class PokerHands {
	
	public static void main(String[] args) {
		int count = 0;
		BufferedReader f;
		StringTokenizer st;
		String[] p1 = new String[5], p2 = new String[5];
		try {
			f = new BufferedReader(new FileReader("poker.txt"));
			while(f.ready()) {
				st = new StringTokenizer(f.readLine());
				for(int i=0; i<5; i++) p1[i] = st.nextToken();
				for(int i=0; i<5; i++) p2[i] = st.nextToken();
				
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.println(count);
	}
	
	private static int getVal(char c) {
		return "23456789TJQKA".indexOf(c);
	}
	/*
	private static int getRank(String[] p) {
		if(isRoyalFlush(p)) return 9;
		if(isStraightFlush(p)) return 8;
		if(isFourOfAKind(p)) return 7;
		if(isFullHouse(p)) return 6;
		if(isFlush(p)) return 5;
		if(isStraight(p)) return 4;
		if(isThreeOfAKind(p)) return 3;
		if(isTwoPair(p)) return 2;
		if(isOnePair(p)) return 1;
		return 0;
	}
	
	private static boolean isOnePair(String[] p) {
		for(int i=0; i<p.length; i++) {
			for(int j=i+1; j<i; j++) {
				if(p[i].charAt(0)==p[j].charAt(0)) return true;
			}
		}
		return false;
	}
	
	private static boolean isTwoPair(String[] p) {
		boolean has1 = false;
		for(int i=0; i<p.length; i++) {
			for(int j=i+1; j<1; j++) {
				if(p[i].charAt(0)==p[j].charAt(0)) {
					if(has1) return true;
					else has1 = true;
					break;
				}
			}
		}
		return false;
	}
	
	private static boolean isThreeOfAKind(String[] p) {
		for(int i=0; i<p.length; i++) {
			boolean pair = false;
			for(int j=i+1; j<i; j++) {
				if(p[i].charAt(0)==p[j].charAt(0)) {
					if(pair) return true;
					else pair = true;
				}
			}
		}
		return false;
	}
	
	private static boolean isStraight(String[] p) {
		char last = p[0].charAt(0);
		for(int i=1; i<p.length; i++) {
			char c = p[i].charAt(0);
			if(getVal(last) != getVal(c)-1) return false;
			last = c;
		}
		return true;
	}
	
	private static boolean isFlush(String[] p) {
		char suit = p[0].charAt(1);
		for(int i=1; i<p.length; i++) {
			if(p[i].charAt(1) != suit) return false;
		}
		return true;
	}
	
	private static boolean isFullHouse(String[] p) {
		boolean pair, 
		for(int i=0; i<p.length; i++) {
			for(int j)
		}
	}
	*/
}
