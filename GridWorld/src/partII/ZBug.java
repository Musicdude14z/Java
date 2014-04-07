package partII;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

/**
 * ZBug - Exercise 3 Part II
 */
public class ZBug extends Bug {

	private int size, steps;
	
	public ZBug(int size) {
		this.size = size;
	}
	
	public void act() {
		if(!canMove()) return; //stops movement
		
		switch(getDirection()) {
		case Location.EAST:
			if(steps%size == 0) {
				if(steps == size*3) return; //done with z
				setDirection(Location.SOUTHWEST); //done with first segment
			}
			move();
			steps++;
			break;
		case Location.SOUTHWEST:
			if(steps%size == 0) { //done with second segment
				setDirection(Location.EAST);
			}
			move();
			steps++;
			break;
		default:
			setDirection(Location.EAST); //start z
			move();
			steps++;
			break;
		}
	}
	
}
