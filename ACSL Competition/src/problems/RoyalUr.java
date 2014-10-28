package problems;

public class RoyalUr {

	static Piece[] b = new Piece[20];
	static boolean whiteTurn = false;
	
	public static void main(String[] args) {
		
	}
	
	public void makeMove(int spin) {
		for(Piece p : b) {
			if(whiteTurn == p instanceof White) {
				
			}
		}
	}
	
	private static abstract class Piece {
		protected int pos;
		
		public abstract int getMove(int spin);
		
		public void setPos(int pos) {
			this.pos = pos;
			b[pos] = this;
		}
	}
	
	private static class White extends Piece {
		
		public int getMove(int spin) {
			int temp = pos;
			while(spin-- > 0) {
				if(temp == 12) temp = 5;
				if(temp == 8) temp = 13;
				else if (temp == 16) temp = 19;
				else temp++;
			}
			return temp;
		}
		
	}
	
	private static class Black extends Piece {
		
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
