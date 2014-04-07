package partII;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

/**
 * DancingBug - Exercise 4 Part II
 */
public class DancingBug extends Bug {

	private int moves[], pos = 0;
	
	public DancingBug(int[] moves) throws IllegalArgumentException {
		if(moves.length < 1) throw new IllegalArgumentException();
		this.moves = moves;
	}
	
	public void act() {
		setDirection(getDirection() + Location.HALF_RIGHT*moves[pos++]);
		pos %= moves.length;
		super.act();
	}

}

