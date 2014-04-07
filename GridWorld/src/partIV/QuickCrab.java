package partIV;

import info.gridworld.grid.Location;

import java.util.ArrayList;

import critters.CrabCritter;

public class QuickCrab extends CrabCritter {

	@Override
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> normLocs = super.getMoveLocations(),
				quickLocs = new ArrayList<Location>();
		
		boolean useQuickLocs = false;
		for(Location l : normLocs) {
			Location newLoc = l.getAdjacentLocation( //get adjacent from selected l
					getLocation().getDirectionToward(l)); //in direction from current loc
			if(getGrid().isValid(newLoc) && getGrid().get(newLoc) == null) {
				useQuickLocs = true; //flag for using the new ArrayList
				quickLocs.add(newLoc);
			}
		}
		
		return useQuickLocs ? quickLocs : normLocs;
	}
	
}

