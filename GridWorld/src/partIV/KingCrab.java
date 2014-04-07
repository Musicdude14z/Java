package partIV;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

import critters.CrabCritter;

public class KingCrab extends CrabCritter {

	@Override
	public void processActors(ArrayList<Actor> actors) {
		for(Actor a : actors) {
			int dir = getLocation().getDirectionToward(a.getLocation());
			Location loc = a.getLocation().getAdjacentLocation(dir);
			if(getGrid().isValid(loc)) 
				a.moveTo(loc);
			else
				a.removeSelfFromGrid();
		}
	}
	
}
