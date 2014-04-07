package partIII;

import info.gridworld.actor.ActorWorld;

public class JumperRunner {

	public static void main(String[] args) {
		ActorWorld w = new ActorWorld();
		w.add(new Jumper());
		w.show();
	}

}
