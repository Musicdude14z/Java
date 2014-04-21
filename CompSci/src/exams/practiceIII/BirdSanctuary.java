//Zach Kaplan
package exams.practiceIII;

public class BirdSanctuary {
	//didn't have time for part (c)
}

/**
 * Part (a) of Question 3
 */
abstract class Owl extends Bird {
	
	public Owl(String name) {
		super(name, "hoot");
	}
	
	
	
}

/**
 * Part (b) of Question 3
 */
class SnowyOwl extends Owl {
	
	public SnowyOwl() {
		super("Snowy owl");
	}
	
	public String getFood() {
		switch((int)(Math.random()*3)) {
		case 0:
			return "hare";
		case 1: 
			return "lemming";
		default: //case 2
			return "small bird";
		}
	}
	
}


//made not public for the sake of fitting all code in one file
abstract class Bird {
	private String myName, myNoise;
	
	public Bird(String name, String noise) {
		myName = name;
		myNoise = noise;
	}
	
	public String getName() {
		return myName;
	}
	
	public String getNoise() {
		return myNoise;
	}
	
	public abstract String getFood();
}
