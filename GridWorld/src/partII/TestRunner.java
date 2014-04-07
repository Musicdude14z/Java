package partII;

import info.gridworld.actor.ActorWorld;

public class TestRunner {

	public static void main(String[] args) {
		ActorWorld w = new ActorWorld();
		w.add(new ZBug(4));
		w.show();
	}

}
