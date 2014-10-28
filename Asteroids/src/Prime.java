
import java.lang.reflect.Array;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Prime extends BasicGameState{

	public Prime(int prime) {
		
	}
	
	String userIn = "", title = "Prime Number Generator", test = "";
	float userX, userY, titleX, titleY, width, height, totalY = 1, totalX = 1;
	
	Font font;
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		font = gc.getDefaultFont();
		width = gc.getWidth();
		height = gc.getHeight();
		titleX = (width - font.getWidth(title)) / 2;
		titleY = 50;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString(title, titleX+totalX, titleY+totalY);
		g.drawString(userIn, userX+totalX, userY+totalY);
		g.drawString(test, 5+totalX, 150+totalY);
	}

	private void calc(String str) {
		test = "";
		//convert input string to int
		int limit = Integer.parseInt(str);
		//boolean array
		boolean[] isPrime = new boolean[limit-1];
		//fill array with true
		for(int i = 0; i < limit - 1; i++) {
			isPrime[i] = true;
		}
		//start checking array
		for(int j = 0; j < isPrime.length; j++) {
			//check if already not prime
			if(j > Math.sqrt(limit)) {
				break;
			}
			//check if over sqrt(n)
			if(!isPrime[j]) {
				continue;
			}
			int number = j+2;
			for(int mult = 2 * number; mult <= limit; mult += number) {
				isPrime[mult - 2] = false;
			}
		}
		int enter = 0;
		int result = 0;
		for(int k = 0; k < isPrime.length; k++) {
			if(isPrime[k]) {/*
				test += (k + 2) + ", ";
				enter++;
				if(enter % 15 == 0 && enter !=0) {
					test += "\n";
				}*/
				result += (k+2);
			}
		}
		test = "" + result;
	}
	
	private void centerUser(String str) {
		userX = (width - font.getWidth(str)) / 2;
		userY = 75;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_0)){
			userIn += "0";
		}else if(input.isKeyPressed(Input.KEY_1)) {
			userIn += "1";
		}else if(input.isKeyPressed(Input.KEY_2)) {
			userIn += "2";
		}else if(input.isKeyPressed(Input.KEY_3)) {
			userIn += "3";
		}else if(input.isKeyPressed(Input.KEY_4)) {
			userIn += "4";
		}else if(input.isKeyPressed(Input.KEY_5)) {
			userIn += "5";
		}else if(input.isKeyPressed(Input.KEY_6)) {
			userIn += "6";
		}else if(input.isKeyPressed(Input.KEY_7)) {
			userIn += "7";
		}else if(input.isKeyPressed(Input.KEY_8)) {
			userIn += "8";
		}else if(input.isKeyPressed(Input.KEY_9)) {
			userIn += "9";
		}else if(input.isKeyPressed(Input.KEY_BACK)) {
			if(userIn.length() > 0) {
				userIn = userIn.substring(0, userIn.length() - 1);
			}
		}else if(input.isKeyPressed(Input.KEY_DELETE)) {
			userIn = "";
		}else if(input.isKeyPressed(Input.KEY_ENTER)) {
			if(userIn != "") {
				calc(userIn);
			}
		}else if(input.isKeyDown(Input.KEY_DOWN)) {
			totalY -= 0.5*delta;
		}else if(input.isKeyDown(Input.KEY_UP)) {
			totalY += 0.5*delta;
		}else if(input.isKeyDown(Input.KEY_LEFT)) {
			totalX -= 0.5*delta;
		}else if(input.isKeyDown(Input.KEY_RIGHT)) {
			totalX += 0.5*delta;
		}
		
		if(totalY > 1) {
			totalY = 1;
		}/*else if(totalY < -(font.getHeight(test) - gc.getHeight())) {
			totalY = -(font.getHeight(test) - gc.getHeight());
		}*/
		
		if(totalX > 1) {
			totalX = 1;
		}/*else if(totalX < -(font.getWidth(test) - gc.getWidth())) {
			totalX = -(font.getWidth(test) - gc.getWidth());
		}*/
		
		centerUser(userIn);
		
	}

	public int getID() {
		
		return 5;
	}

}
