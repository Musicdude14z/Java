package partIV;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;

public class TestRunner {

	public static void main(String[] args) {
		ActorWorld w = new ActorWorld();
		w.add(new KingCrab());
		w.add(new Rock());
		w.show();
	}

}
