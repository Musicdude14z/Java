package chess;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Pawn extends Piece{
	
	private int movedTwoAt = 0;
	
	public Pawn(int x, int y, boolean black) {
		this.black = black;
		val = 1;
		rank = 'P';
		this.x = x;
		this.y = y;
		try {
			bg = new Image("res/" + (black ? "B" : "W") + rank + ".png");
		} catch (SlickException se) {
			se.printStackTrace();
		}
	}
	
	protected boolean isLegalMove(int x, int y) {
		if(Math.abs(this.x-x) > 1) return false;
		if(isBlack()) {
			return this.y-y == -1 || !moved && this.y-y == -2;
		}else {
			return this.y-y == 1 || !moved && this.y-y == 2;
		}
	}
	
	protected boolean isValidMove(int x, int y, Board b) {
		/*
		 * TODO: Add support for en Passant
		 * Add a boolean for justMoved2
		 * DONE
		 */
		if(!super.isValidMove(x, y, b)) return false;
		if(this.x == x && !(b.getPiece(x, y) instanceof Empty)) return false;
		if(this.x != x) {
			if(b.getPiece(x, y) instanceof Empty) {
				if(b.getPiece(x, (int)this.y) instanceof Pawn && 
						b.getPiece(x, (int)this.y).isBlack() != isBlack() &&
						b.getPiece(x, (int)this.y).justMovedTwo) return true;
				return false;
			}
			else if(b.getPiece(x, y).isBlack() == isBlack()) return false;
		}
		return true;
	}

	public Integer[] getMoves(Board b) {
		int mod = black ? 1 : -1;
		ArrayList<Integer> moves = new ArrayList<Integer>();
		int posX = (int)x, posY = (int)y;
		if(isValidMove(posX+1, posY+mod, b)) moves.add(posX+1 + (posY+mod)*8);
		if(isValidMove(posX-1, posY+mod, b)) moves.add(posX-1 + (posY+mod)*8);
		if(isValidMove(posX, posY+mod, b)) moves.add(posX + (posY+mod)*8);
		if(isValidMove(posX, posY+mod*2, b)) moves.add(posX + (posY+2*mod)*8);
		return moves.toArray(new Integer[0]);
	}
	
	public int move(int x, int y, Board b) {
		if(!isValidMove(x, y, b)) return -1;
		if(this.x != x && b.getPiece(x, y) instanceof Empty) {
			moved = true;
			b.remove(x, (int)this.y);
			b.remove(this);
			b.setPiece((int)(this.x=x), (int)(this.y=y), this);
			return 1;
		}
		int oldY = (int)this.y, score = super.move(x, y, b);
		if(Math.abs(oldY-y) == 2) {
			justMovedTwo = true;
			movedTwoAt = moveCount;
		}
		return score;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		return;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		if(moveCount > movedTwoAt) justMovedTwo = false;
		return;
	}
	
	protected int[][] getDirs() {
		return null;
	}
	
}
