package chess;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Empty extends Piece{

	public Empty() {
		rank = 'E';
		val = 0;
		black = false;
	}
	
	protected int[][] getDirs() {
		return null;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		return;
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		return;
	}

	public boolean isLegalMove(int x, int y) {
		return false;
	}

}
