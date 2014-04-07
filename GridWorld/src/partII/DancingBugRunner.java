package partII;

import info.gridworld.actor.ActorWorld;

/**
 * DancingBugRunner - Exercise 4 Part II
 */
public class DancingBugRunner {

	public static void main(String[] args) {
		ActorWorld w = new ActorWorld();
		w.add(new DancingBug(new int[] {5, 1, 6, 2, 7, 6, 2, 4, 7, 1, 2}));
		w.show();
	}

}
