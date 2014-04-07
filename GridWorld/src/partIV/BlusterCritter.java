package partIV;

import java.util.ArrayList;
import java.util.HashSet;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter {

	private int c;
	
	public BlusterCritter(int courage) {
		c = courage;
	}
	
	@Override
	public ArrayList<Actor> getActors() {
		HashSet<Actor> actors = new HashSet<Actor>(); //no duplicates
		
		Grid<Actor> g = getGrid();
		ArrayList<Location> locs = new ArrayList<Location>(); //locations to get neighbors of
		locs.add(getLocation()); //adds current location
		locs.addAll(g.getValidAdjacentLocations(getLocation())); //adds surroundings
		
		for(Location l : locs) {
			actors.addAll(g.getNeighbors(l)); //adds in neighbors
		}
		actors.remove(this); //this is a neighbor of the surroundings
		
		return new ArrayList<Actor>(actors);
	}
	
	@Override
	public void processActors(ArrayList<Actor> actors) {
		if(actors.size() < c) {
			setColor(getColor().brighter());
		}else {
			setColor(getColor().darker());
		}
	}
}
