//Zach Kaplan
package exams.practiceIII;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AllClocks {
	private List<DigitalClock> clocks;
	
	public AllClocks() { //given
		clocks = new ArrayList<DigitalClock>();
	}
	
	public void add() { //given
		clocks.add(new DigitalClock());
	}
	
	/**
	 * Part (a) of Question 2
	 */
	public void advanceTimeOnAll() {
		for(DigitalClock dc : clocks) {
			dc.advanceTime();
		}
	}
	
	/**
	 * Part (b) of Question 2
	 */
	public void removeDefective() {
		Iterator<DigitalClock> i = clocks.iterator();
		while(i.hasNext()) {
			if(i.next().isDefective()) //tests for defective
				i.remove(); //removes if so
		}
	}
	
	/**
	 * Part (c) of Question 2
	 * Clocks added will be set to 12:30
	 */
	public void replaceDefective() {
		ListIterator<DigitalClock> i = clocks.listIterator();
		while(i.hasNext()) {
			if(i.next().isDefective()) { //test for defective
				i.remove(); //removes if so
				i.add(new DigitalClock(12, 30)); //replaces it with a new clock at 12:30
			}
		}
	}
}

//made not public for the sake of fitting all code in one file
class DigitalClock {
	public DigitalClock() {
	//not shown	
	}
	
	public DigitalClock(int hour, int minute) {
	//not shown
	}
	
	public void advanceTime() {
	//not shown
	}
	
	public boolean isDefective() {
	//not shown
		return false; //so the code compiles
	}
	
	//other methods not shown
}