package chess;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Bishop extends Piece{
	
	protected static int[][] dirs = new int[][] {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	
	public Bishop(int x, int y, boolean black) {
		this.black = black;
		val = 3;
		rank = 'B';
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
		return Math.abs(this.x-x) == Math.abs(this.y-y);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		return;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		return;
	}

}
