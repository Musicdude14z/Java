package partII;

import boxBug.BoxBug;

/**
 * SpiralBug - Exercise 2 Part II
 */
public class SpiralBug extends BoxBug {

	public SpiralBug(int length) {
		super(length);
	}
	
	@Override
	public void act() {
		super.act();
		if(steps == 0) sideLength++;
	}

}
