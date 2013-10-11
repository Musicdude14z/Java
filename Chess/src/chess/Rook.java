package chess;

import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Rook extends Piece{
	
	protected static int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	
	public Rook(int x, int y, boolean black) {
		this.black = black;
		val = 5;
		rank = 'R';
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
	
	protected boolean isLegalMove(int x, int y) {
		//No mod needed to support rooking, is on same x axis anyway
		return this.x==x || this.y==y;
	}
	
	protected boolean isValidMove(int x, int y, Board b) {
		if(!moved && b.getPiece(x, y) instanceof King) { //if not moved and clikced on King
			if(!b.getPiece(x, y).moved && b.getPiece(x, y).isBlack() == isBlack()) { //if king not moved and is same color
				int sign = this.x-x > 0 ? -1 : 1, //direction of rooking, to check for clear and safe space
						posX = (int)this.x;
				while((posX+=sign) != x) {
					if(!(b.getPiece(posX, y) instanceof Empty)) break; //Space not empty
					if(posX>1 && posX<7 && !b.isSafe(posX, y, isBlack())) break; //Space for king not safe
				}
				if(posX == x) return true; //if broke out of loop instead of finishing don't return true
			}
		}
		return super.isValidMove(x, y, b);
	}
	
	public Integer[] getMoves(Board b) {
		ArrayList<Integer> moves = new ArrayList<Integer>(Arrays.asList(super.getMoves(b)));
		if(isValidMove((int)y*8+3, b)) moves.add((int)y*8+3);
		if(isValidMove((int)y*8+4, b)) moves.add((int)y*8+4);
		return moves.toArray(new Integer[0]);
	}
	
	public int move(int x, int y, Board b) {
		if(!isValidMove(x, y, b)) return -1;
		if(b.getPiece(x, y).isBlack() == isBlack() && b.getPiece(x, y) instanceof King) { //if same color and king must be rooking
			moved = true;
			Piece king = b.getPiece(x, y);
			b.remove(king);
			if(this.x-x < 0) {
				b.setPiece(x-2, y, king);
				king.setX(x-2);
				b.remove(this);
				b.setPiece((int)(this.x=x-1), y, this);
			}else {
				b.setPiece(x+2, y, king);
				king.setX(x+2);
				b.remove(this);
				b.setPiece((int)(this.x=x+1), y, this);
			}
			king.moved = true;
			moveCount++;
			return 0;
		}
		return super.move(x, y, b);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		return;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		return;
	}

}
