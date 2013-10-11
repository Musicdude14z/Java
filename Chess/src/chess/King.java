package chess;

import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class King extends Piece{
	
	protected static int[][] dirs = {{1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1}};
	
	public King(int x, int y, boolean black) {
		this.black = black;
		val = 0;
		rank = 'K';
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
		if(!moved && this.y-y==0 && (x==0 || x==7)) return true;
		return Math.abs(x-this.x) < 2 && Math.abs(y-this.y) < 2;
	}
	
	protected boolean isValidMove(int x, int y, Board b) {
		/* TODO: Add support for Rooking
		 * Space moved from, to, and in between can't be dangerous
		 * Enable support for all sides
		 * DONE
		 */
		if(!moved && b.getPiece(x, y) instanceof Rook) { //if not moved and clikced on Rook
			if(!b.getPiece(x, y).moved && b.getPiece(x, y).isBlack() == isBlack()) { //if rook not moved and is same color
				int sign = this.x-x > 0 ? -1 : 1, //direction of rooking, to check for clear and safe space
						posX = (int)this.x;
				while((posX+=sign) > 0 && posX < 7) {
					if(!(b.getPiece(posX, y) instanceof Empty)) break; //Space not empty
					if(posX>1 && posX<7 && !b.isSafe(posX, y, isBlack())) break; //Space for king not safe
				}
				if(posX == 0 || posX == 7) return true; //if broke out of loop instead of finishing don't return true
			}
		}
		if(!super.isValidMove(x, y, b)) return false;
		return b.isSafe(x, y, isBlack());
	}

	public Integer[] getMoves(Board b) {
		ArrayList<Integer> moves = new ArrayList<Integer>(Arrays.asList(super.getMoves(b)));
		if(isValidMove((int)y*8, b)) moves.add((int)y*8); //castling spots
		if(isValidMove((int)y*8+7, b)) moves.add((int)y*8+7); //castling spots
		return moves.toArray(new Integer[0]);
	}
	
	public int move(int x, int y, Board b) {
		if(!isValidMove(x, y, b)) return -1;
		if(!moved) {
			moved = true;
			if(x==0){
				b.remove(this);
				b.setPiece((int)(this.x-=2), y, this);
				Piece rook = b.getPiece(x, y);
				b.remove(rook);
				b.setPiece((int)this.x+1, y, rook);
				rook.setX(this.x+1);
				rook.moved = true;
				moveCount++;
				return 0;
			}else if(x==7) {
				b.remove(this);
				b.setPiece((int)(this.x+=2), y, this);
				Piece rook = b.getPiece(x, y);
				b.remove(rook);
				b.setPiece((int)this.x-1, y, rook);
				rook.setX(this.x-1);
				rook.moved = true;
				moveCount++;
				return 0;
			}
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
