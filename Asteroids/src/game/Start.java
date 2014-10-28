package game;

//import java.awt.Font;
import java.util.ArrayList;
//import java.util.List;

import org.lwjgl.input.Mouse;
//import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
//import org.newdawn.slick.TrueTypeFont;
//import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;

import util.Button;

public class Start extends BasicGameState{

	public Start(int start) {
		
	}
	
	public static final int start = 0;
	public static final int mainMenu = 1;
	public static final int play = 2;
	public static final int options = 3;
	public static final int lose = 4;
	
	Transition fadeOut, fadeIn;
	
	Image menuButton, menuButtonHover, menuButtonActive;
	
	ArrayList<Button> buttons = new ArrayList<Button>();
	Button startButton, exitButton;
	
	boolean down;
	int mouseX, mouseY;
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		fadeOut = new FadeOutTransition();
		fadeIn = new FadeInTransition();
		
		menuButton = new Image("res/menuButton.png");
		menuButtonHover = new Image("res/menuButtonHover.png");
		menuButtonActive = new Image("res/menuButtonActive.png");
		
		startButton = new Button(200, 250, "Start", gc, 
				menuButton, menuButtonHover, menuButtonActive);
		buttons.add(startButton);
		exitButton = new Button(500, 250, "Exit", gc, 
				menuButton, menuButtonHover, menuButtonActive);
		buttons.add(exitButton);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("My First Game!", 375, 100);
		for(Button b : buttons) {
			b.render(mouseX, mouseY, down, g);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		mouseX = Mouse.getX();
		mouseY = gc.getHeight() - Mouse.getY() - 1;
		down = Mouse.isButtonDown(0);
		if(startButton.isHover(mouseX, mouseY) && down) {
			sbg.enterState(mainMenu, fadeOut, fadeIn);
		}else if(exitButton.isHover(mouseX, mouseY) && down) {
			gc.exit();
		}
	}

	public int getID() {

		return 0;
	}

}