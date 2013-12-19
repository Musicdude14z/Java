package problems;

import java.util.Scanner;

/**
 * ACSL Scrabble
 * <p>
 * School: Bergen County Academies
 * <p>
 * Division: Senior
 * @author Zach Kaplan
 * @version 1.0
 */
public class ZachKaplanScrabble {
	
	//Double Letter, Triplet Letter, Double Word, Triple Word
	public static final int DL = 1, TL = 2, DW = 3, TW = 4;
	public static int board[][], wordMult;
	
	//init board
	static {
		board = new int[4][10];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				int tile = i*10 + j + 1;
				
				if((tile-3) % 6 == 0) { //every other mult of 3
					board[i][j] = DL;
				}else if(tile % 5 == 0) { //mult of 5
					board[i][j] = TL;
				}else if(tile % 7 == 0) { //mult of 7
					board[i][j] = DW;
				}else if(tile % 8 == 0) { //mult of 8
					board[i][j] = TW;
				}
			}
		}
	}
	
	/**
	 * Main Method
	 * @param args - std input
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String first = s.nextLine().toUpperCase(); //gets first line with word
		char[] word = new char[4];
		for(int i=0; i<word.length; i++) {
			word[i] = first.charAt(i*3); //builds char array of letters
		}
		
		String[][] lines = new String[5][6];
		for(int i=0; i<lines.length; i++) {
			lines[i] = s.nextLine().toUpperCase().split(", ");
		}
		s.close(); //close scanner
		
		System.out.println(); //add space between input and output
		

		for(String[] line : lines) {
			int max = 0;
			for(int i=0; i<line.length; i+=2) {
				int tile = Integer.parseInt(line[i]);
				boolean vertical = line[i+1].equals("V");
				int score = placeWord(word, tile, vertical);
				if(score > max) max = score;
			}
			System.out.println(max);
		}
	}
	
	/**
	 * 'Places' a word on the board, and returns the score
	 * @param word - word to place, as a character array
	 * @param tile - tile to start in
	 * @param vertical - true if vertical, false if horizontal
	 * @return score of word
	 */
	public static int placeWord(char[] word, int tile, boolean vertical) {
		int score = 0, row = (tile-1)/10, col = (tile-1)%10; //getting pos
		wordMult = 1; //reset mult
		
		try {
			for(char c : word) {
				score += placeLetter(c, row, col); //modifies global wordMult
				if(vertical) row++; //increment tile
				else col++;
			}
		} catch (IllegalArgumentException iae) {
			return 0; //implies move goes off board, illegal move
		}
		
		return score * wordMult;
	}
	
	/**
	 * 'Places' a Letter, return score of that letter, modifies global wordMult
	 * respectively
	 * @param c - character to be places
	 * @param row - row to place in
	 * @param col - column to place in
	 * @return score
	 * @throws IllegalArgumentException - if space is not valid
	 */
	public static int placeLetter(char c, int row, int col) throws IllegalArgumentException{
		if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
			throw new IllegalArgumentException();
		}
		int score = 0;
		switch(c) { //score based on character
		case 'A': case 'E':	
			score = 1; break;
		case 'D': case 'R':
			score = 2; break;
		case 'B': case 'M':
			score = 3; break;
		case 'V': case 'Y':
			score = 4; break;
		case 'J': case 'X':
			score = 8; break;
		}
		
		switch(board[row][col]) { //score based on tile
		case DL: 
			score *= 2; break;
		case TL:
			score *= 3; break;
		case DW:
			wordMult *= 2; break;
		case TW:
			wordMult *= 3; break;
		}
		
		return score;
	}

}
