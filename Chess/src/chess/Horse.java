package chess;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Horse extends Piece{
	
	protected static int[][] dirs =  {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	
	public Horse(int x, int y, boolean black) {
		this.black = black;
		val = 3;
		rank = 'H';
		this.x = x;
		this.y = y;
		try {
			bg = new Image("res/" + (black ? "B" : "W") + rank + ".png");
		} catch (SlickException se) {
			se.printStackTrace();
		}
	}
	
	protected int[][] getDirs() {
		return dirs;
	}

	protected boolean isValidMove(int x, int y, Board b) {
		if(!isLegalMove(x, y)) return false;
		if(!(b.getPiece(x, y) instanceof Empty)) {
			return b.getPiece(x, y).isBlack() != isBlack();
		}
		return true;
	}
	
	protected boolean isLegalMove(int x, int y) {
		if(x>7 || x<0 || y>7 || y<0) return false;
		return Math.abs(this.x-x) == 1 && Math.abs(this.y-y) == 2 ||
				Math.abs(this.x-x) == 2 && Math.abs(this.y-y) == 1;
	}
	
	public Integer[] getMoves(Board b) {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		for(int[] dir : dirs) {
			int posX = (int)x + dir[0]*2, posY = (int)y + dir[1];
			if(isValidMove(posX, posY, b)) moves.add(posX + posY*8);
			posX = (int)x + dir[0];
			posY = (int)y + dir[1]*2;
			if(isValidMove(posX, posY, b)) moves.add(posX + posY*8);
		}
		return moves.toArray(new Integer[0]);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		return;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		return;
	}

}
