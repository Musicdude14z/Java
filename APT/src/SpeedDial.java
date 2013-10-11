
public class SpeedDial {
	
	//TODO: FIX
	
	public int assignNumbers(int[] numbers, int[] howMany, int slots) {
		boolean[] setToSpeed = new boolean[numbers.length]; //keeps track of what's been used 
		for(int i=1; i<=slots; i++) { //for each slot
			if(i>numbers.length) break; //too many speed dial slots
			int max = getLength(numbers[0])*howMany[0], maxPos = 0; //max Key presses, start at 0
			for(int j=1; j<numbers.length; j++) { //cycle through all numbers
				if(getLength(numbers[j])*howMany[j] > max && !setToSpeed[j]) {
					max = getLength(numbers[j])*howMany[j]; //get maxNumber of Key presses
					maxPos = j; //track position of max
				}
			}
			numbers[maxPos] = i; //set max keypresses's number to speed dial key;
			setToSpeed[maxPos] = true; //mark as set to speed
		}
		int presses = 0;
		for(int i=0; i<numbers.length; i++) {
			presses += getLength(numbers[i])*howMany[i]; //for all numbers, calc key presses
		}
		return presses;
	}
	
	private int getLength(int n) {
		int l = 1;
		while((n/=10) > 0) l++;
		return l;
	}
	
}
