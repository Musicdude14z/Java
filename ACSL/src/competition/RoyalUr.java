//Bergen County Academies, NJ; Senior 5 Team 
package competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* Test Case
2 1 2 2 9 10 3 3
2 8 15 2 12 16 3 2
2 3 6 2 7 5 1 1
0 0 4 3
4 1 3 5 7 1 15 4 3
 */

/*Test Case 2
2 15 16 2 13 14 4 4
2 15 16 2 13 14 2 2
2 7 17 2 12 19 1 2
3 1 6 5 2 12 10 1 3
4 1 3 5 7 1 15 4 3
 */


public class RoyalUr {

	static Piece[] b;
	static boolean whiteTurn = false;
	static int numWhite = 0, numBlack = 0;
	
	public static void main(String[] args) {
		String[] lines = new String[5];
		StringTokenizer st;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			for(int i=0; i<5; i++) {
				lines[i] = br.readLine();
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		for(String line : lines) {
			b = new Piece[20];
			whiteTurn = false;
			st = new StringTokenizer(line);
			numBlack = Integer.parseInt(st.nextToken());
			for(int i=0; i<numBlack; i++) {
				Piece p = new Black();
				p.setPos(Integer.parseInt(st.nextToken()));
			}
			numWhite = Integer.parseInt(st.nextToken());
			for(int i=0; i<numWhite; i++) {
				Piece p = new White();
				p.setPos(Integer.parseInt(st.nextToken()));
			}
			Piece[] temp = Arrays.copyOf(b, 20);
			int tempw = numWhite, tempb = numBlack;
			if(makeMove(Integer.parseInt(st.nextToken()))) printBoard();
			else System.out.println("NONE");
			whiteTurn = true;
			b = temp; //reset board
			numWhite = tempw; //reset
			numBlack = tempb; //reset
			if(makeMove(Integer.parseInt(st.nextToken()))) printBoard();
			else System.out.println("NONE");
		}
	}
	
	public static void printBoard() {
		int num = 0, max = (whiteTurn ? numWhite : numBlack);
		if(max == 0) {
			System.out.println("NONE");
			return;
		}
		for(Piece p : b) {
			if(p == null) continue;
			if(whiteTurn == p instanceof White) {
				System.out.print(p);
				if(++num < max) System.out.print(", ");
				else System.out.println();
			}
		}
	}
	
	public static boolean makeMove(int spin) {
		for(int i=0; i<3; i++) {
			Piece p;
			for(int j=0; j<(whiteTurn ? 20 : 18) - spin; j++) {
				if((p = b[j]) == null) continue;
				if(whiteTurn == p instanceof White) { //movable Piece
					int newPos = p.getMove(spin);
					switch(i) {
					case 0: //winning
						if(newPos == 20 || newPos == 18) {
							p.setPos(-1); //remove
							if(whiteTurn) numWhite--;
							else numBlack--;
							return true;
						}
						break;
					case 1: //capturing Piece
						Piece o = b[newPos-1];
						if(o != null && (whiteTurn != o instanceof White)) {
							if(whiteTurn) numBlack--; //capturing
							else numWhite--;
							p.setPos(newPos);
							p.c = true;
							return true;
						}
						break;
					case 2: //normal move
						if(b[newPos-1] == null) { //already not opposing, make sure blank
							p.setPos(newPos);
							return true;
						}
					}
				}
			}
		}
		Piece p; //new Piece
		if(whiteTurn) {
			p = new White();
			int pos = spin + 8;
			if(b[pos-1] == null) {
				p.setPos(pos);
				numWhite++;
				return true;
			}
		} else {
			p = new Black();
			int pos = spin;
			if(b[pos-1] == null) {
				p.setPos(pos);
				numBlack++;
				return true;
			}
		}
		return false;
	}
	
	static abstract class Piece {
		protected int pos;
		public boolean c = false;
		
		public abstract int getMove(int spin);
		
		public void setPos(int pos) {
			if(this.pos != 0) b[this.pos-1] = null;
			if(pos == -1) return; //remove from board
			this.pos = pos;
			b[pos-1] = this;
			c = false;
		}
		
		public String toString() {
			if(c) {
				c = false;
				return pos + "C";
			} else return pos + "";
		}
	}
	
	static class White extends Piece {
		
		public int getMove(int spin) {
			int temp = pos;
			while(spin-- > 0) {
				if(temp == 12) temp = 5;
				else if(temp == 8) temp = 13;
				else if (temp == 16) temp = 19;
				else temp++;
			}
			return temp;
		}
		
	}
	
	static class Black extends Piece {
		
		public int getMove(int spin) {
			int temp = pos;
			while(spin-- > 0) {
				if(temp == 8) temp = 13;
				else temp++;
			}
			return temp;
		}
		
	}
	
}
