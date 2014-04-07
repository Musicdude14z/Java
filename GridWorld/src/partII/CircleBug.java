package partII;

import boxBug.BoxBug;

/**
 * CircleBug - Exercise 1 Part II
 */
public class CircleBug extends BoxBug {

	public CircleBug(int length) {
		super(length);
	}

	@Override
	public void act() { //sideLength and steps were changed to protected
		if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
	}

}
