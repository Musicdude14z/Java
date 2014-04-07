//Zachary Kaplan, Bergen County Academies, Senior Division
package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*TEST DATA:
1. 3, 12, 17, 22, 3, 4, 14, 10
2. 3, 12, 17, 22, 3, 9, 10, 15
3. 3, 12, 17, 22, 3, 25, 9, 5
4. 3, 3, 16, 22, 3, 15, 19, 25
5. 3, 12, 17, 22, 3, 3, 18, 19
 */

/**
 * Plays one move of a game and returns captured pieces.
 * Board was built with capability to carry out multiple moves
 * @author Zach Kaplan
 * @version 1.0<br />
 *  - Will not be update because I'm really tired<br />
 *  - Also not planning on commenting thoroughly. It works, and I understand it.
 */
public class ZachKaplanFanorona {

	public static void main(String[] args) {
		Board[] boards = new Board[5];
		try(BufferedReader b = new BufferedReader(new InputStreamReader(System.in))) {
			for(int i=0; i<5; i++) {
				boards[i] = Board.parse(b.readLine().substring(3)); //accounts for line number
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
		
		for(int i=0; i<5; i++) {
			System.out.printf("%d. ", i+1);
			if(boards[i].getMoves().isEmpty()) {
				System.out.println("NONE");
				continue;
			}
			int[] move = boards[i].getMoves().get(0); //should only be one move
			boards[i].move(move);
			if(boards[i].getRemovedBlack().isEmpty()) {
				System.out.println("NONE");
			}else {
				ArrayList<Integer> removed = boards[i].getRemovedBlack();
				Collections.sort(removed);
				String listString = removed.toString();
				System.out.println(listString.substring(1, listString.length()-1)); //remove brackets
			}
		}
		
	}
	
	private static class Board {
		
		public final int WHITE = 1, EMPTY = 0, BLACK = -1, 
				dirs[][] = { //every other direction is a diagonal (discounted for even positions)
				{1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1} //all possible directions
			};
		private int size, board[][];
		private ArrayList<Integer> removedBlack = new ArrayList<Integer>(), 
				removedWhite = new ArrayList<Integer>();
		private boolean whiteTurn = true;
		
		public Board(int sideLength) {
			size = sideLength;
			board = new int[size][size];
		}

		public static Board parse(String s) {
			Board b = new Board(5);
			String[] temp = s.split(", ");
			int numWhite = Integer.parseInt(temp[0]), numBlack = Integer.parseInt(temp[numWhite+1]);
			for(int i=1; i<=numWhite; i++) { //place white
				b.setPiece(Integer.parseInt(temp[i]), true);
			}
			for(int i=1; i<=numBlack; i++) { //place black
				b.setPiece(Integer.parseInt(temp[i+numWhite+1]), false);
			}
			return b;
		}
		
		public void setPiece(int pos, boolean white) {
			pos--; //compensate for 0 index vs 1 index
			setPiece(pos%size, pos/size, white);
		}
		
		public void setPiece(int x, int y, boolean white) {
			board[y][x] = white ? WHITE : BLACK;
		}
		
		public boolean move(int[] move) {
			return move(move[0], move[1]);
		}
		
		public boolean move(int from, int to) {
			from--; //compensate for 0 index vs 1 index
			to--;
			return move(from%size, from/size, to%size, to/size);
		}
		
		public boolean move(int fromX, int fromY, int toX, int toY) {
			int color = whiteTurn ? WHITE : BLACK, oColor = whiteTurn ? BLACK : WHITE;
			if(board[fromY][fromX] != color || //moving correct piece
					!isValidMove(fromX, fromY, toX, toY)) { //is Valid Move
				return false;
			}
			int dirX = fromX-toX, dirY = fromY-toY; //will either be -1, 0, or 1
			int a = toY-dirY, b = toX-dirX, c = fromY+dirY, d = fromX+dirX; //temp vars
			while(a >= 0 && a < size && b >= 0 && b < size && board[a][b] == oColor) { //towards
				board[a][b] = EMPTY; //removing piece
				// record removed piece in corresponding ArrayList
				(whiteTurn ? removedBlack : removedWhite).add(getIndex(b, a));
				a -= dirY;
				b -= dirX;
			}
			while (c >= 0 && c < size && d >= 0 && d < size && board[c][d] == oColor) { //away
				board[c][d] = EMPTY; //removing piece
				// record removed piece in corresponding ArrayList
				(whiteTurn ? removedBlack : removedWhite).add(getIndex(d, c));
				c += dirY;
				d += dirX;
			}
			//nothing if neither
			board[fromY][fromX] = EMPTY;
			board[toY][toX] = color;
			return true;
		}
		
		private boolean isValidMove(int fromX, int fromY, int toX, int toY) {
			if(fromX < 0 || fromX >= size || fromY < 0 || fromY >= size ||
					toX < 0 || toX >= size || toY < 0 || toY >= size) return false; //out of bounds
			if(getIndex(fromX, fromY) % 2 == 0 && //diagonal move from an even space
					Math.abs(fromX-toX) == Math.abs(fromY-toY)) return false; 
			if(board[toY][toX] != EMPTY) return false; //not empty
			return true;
		}
		
		private boolean isAggressiveMove(int fromX, int fromY, int toX, int toY) {
			int oColor = whiteTurn ? BLACK : WHITE;
			int dirX = fromX-toX, dirY = fromY-toY;
			int a = fromY+dirY, b = fromX+dirX, c = toY-dirY, d = toX-dirX;
			if(a >= 0 && a < size && b >= 0 && b < size && 
					board[a][b] == oColor) return true; //away
			else if(c >= 0 && c < size && d >= 0 && d < size && //towards 
					board[c][d] == oColor) return true;
			return false;
		}
		
		public ArrayList<Integer> getRemovedBlack() {
			return removedBlack;
		}
		
		public ArrayList<Integer> getRemovedWhite() {
			return removedWhite;
		}
		
		public ArrayList<int[]> getMoves() {
			ArrayList<int[]> aggressive = new ArrayList<int[]>(), passive = new ArrayList<int[]>();
			int color = whiteTurn ? WHITE : BLACK;
			for(int y = 0; y < size; y++) {
				for(int x = 0; x < size; x++) {
					if(board[y][x] == color) { //valid move
						for(int[] dir : dirs) {
							int toX = x + dir[1], toY = y + dir[0];
							if(!isValidMove(x, y, toX, toY)) continue; 
							int[] move = {getIndex(x, y), getIndex(toX, toY)};
							
							if(isAggressiveMove(x, y, toX, toY)) aggressive.add(move);
							else passive.add(move);
						}
					}
				}
			}
			if(!aggressive.isEmpty()) return aggressive;
			else return passive; //only valid if no agressive moves
		}
			
		public int getIndex(int x, int y) {
			return y*size + x + 1;
		}
		
		@Override
		public String toString() { //testing
			StringBuilder sb = new StringBuilder();
			for(int y=0; y<size; y++) {
				for(int x=0; x<size; x++) {
					sb.append(board[y][x] + "\t");
				}
				sb.append('\n');
			}
			return sb.toString();
		}
		
	}

}
