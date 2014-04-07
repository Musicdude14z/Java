package partIII;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class Jumper extends Bug {
	
	public void move() {
		Grid<Actor> g = getGrid();
		if(g == null)
			return;
		Location l = getLocation(), one = l.getAdjacentLocation(getDirection()),
				two = one.getAdjacentLocation(getDirection());
		if(g.isValid(one)) {
			if(g.get(one) == null) //if can move only one, move
				moveTo(one);
			else if(g.isValid(two)) {//if can't move one, move two
				moveTo(two);
				return; //doesn't drop flower when it jumps
			}
		} else
			removeSelfFromGrid();
		Flower f = new Flower(getColor());
		f.putSelfInGrid(g, l);
	}
	
	public boolean canMove() {
		Grid<Actor> g = getGrid();
		if(g == null)
			return false;
		Location l = getLocation(), one = l.getAdjacentLocation(getDirection()),
				two = one.getAdjacentLocation(getDirection());
		if(g.isValid(one) && g.get(one) == null || g.isValid(two))
			return true;
		return false;
	}
	
}
