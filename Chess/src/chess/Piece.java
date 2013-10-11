package chess;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import chess.Board.Tile;

import utils.BasicRect;

public abstract class Piece extends BasicRect {
	
	public static int moveCount = 0;
	
	protected char rank;
	protected int val;
	protected boolean black, selected = false, moved = false, justMovedTwo = false; //justMovedTwo only applicable to Pawns
	protected Image bg;
	
	protected abstract boolean isLegalMove(int x, int y);
	protected abstract int[][] getDirs();
	
	public Integer[] getMoves(Board b) {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		int[][] dirs = getDirs();
		for(int[] dir : dirs) {
			int posX = (int)x + dir[0], posY = (int)y + dir[1];
			while(posX < 8 && posX >= 0 && posY < 8 && posY >= 0) {
				if(isValidMove(posX, posY, b)) {
					moves.add(posX + posY*8);
				}else {
					break;
				}
				posX += dir[0];
				posY += dir[1];
			}
		}
		return moves.toArray(new Integer[0]);
	}
	
	protected boolean isValidMove(int x, int y, Board b) {
		if(x>7 || x<0 || y>7 || y<0 || this.x==x && this.y==y ) return false;
		if(!isLegalMove(x, y)) return false;
		int posX = (int)this.x, posY = (int)this.y;
		while(posX != x || posY != y) {
			if(x-posX > 0) posX++;
			else if(x-posX < 0) posX--;
			if(y-posY > 0) posY++;
			else if(y-posY < 0) posY--;
			if(!(b.getPiece(posX, posY) instanceof Empty)) {
				if(x==posX && y==posY && b.getPiece(x, y).isBlack() != isBlack()) return true;
				return false;
			}
		}
		return true;
	}
	
	protected boolean isValidMove(int n, Board b) {
		return isValidMove(n%8, n/8, b);
	}
	
	public void select() {
		selected = true;
	}
	
	public void deselect() {
		selected = false;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public char getRank() {
		return rank;
	}
	
	public boolean isBlack() {
		return black;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g, Board b) {
		if(this instanceof Empty) return;
		Tile t = b.getTile((int)x, (int)y);
		g.drawImage(bg, t.getX(), t.getY());
	}
	
	protected int remove(Board b) {
		b.remove(this);
		return val;
	}
	
	public int move(int x, int y, Board b) {
		if(!isValidMove(x, y, b)) return -1;
		int score = 0;
		b.remove(this);
		if(!(b.getPiece((int)(this.x=x), (int)(this.y=y)) instanceof Empty)) { 
			score = b.getPiece(x, y).remove(b);
		}
		b.setPiece(x, y, this);
		moved = true;
		moveCount++;
		return score;
	}
	
	public int move(int n, Board b) {
		return move(n%8, n/8, b);
	}
	
	public boolean moveOverride(int x, int y, Board b) {
		if(x>7 || x<0 || y>7 || y<0 || this.x==x && this.y==y ) return false;
		b.remove(this);
		b.setPiece((int)(this.x=x), (int)(this.y=y), this);
		return true;
	}
	
	public boolean moveOverride(int n, Board b) {
		return moveOverride(n%8, n/8, b);
	}
	
	public void reset(int x, int y, boolean moved) {
		this.x = x;
		this.y = y;
		this.moved = moved;
	}
	
	public void reset(int n, boolean moved) {
		reset(n%8, n/8, moved);
	}
	
	public String toString() {
		return (black ? "B" : "W") + rank + ": (" + (int)this.x + ", " + (int)this.y + ")";
	}
	
	public boolean wasMoved() {
		return moved;
	}
	
	protected void setX(float x) {
		this.x = x;
	}
	
	protected void setY(float y) {
		this.y = y;
	}
	
	public boolean equals(Piece p) {
		return p.toString().equals(toString());
	}
	
}
