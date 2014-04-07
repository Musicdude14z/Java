package partIV;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import critters.ChameleonCritter;

public class ChameleonKid extends ChameleonCritter {

	@Override
	public ArrayList<Actor> getActors() {
		Location loc = getLocation(),
				front = loc.getAdjacentLocation(getDirection()),
				back = loc.getAdjacentLocation(getDirection() + Location.HALF_CIRCLE);
		
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Grid<Actor> g = getGrid();
		if(g.isValid(front) && g.get(front) != null) actors.add(g.get(front));
		if(g.isValid(back) && g.get(back) != null) actors.add(g.get(back));
		return actors;
	}

}
