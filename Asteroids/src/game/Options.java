package game;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;

import util.Button;

public class Options extends BasicGameState{

	public Options(int options) {
		
	}
	
	public static final int start = 0;
	public static final int mainMenu = 1;
	public static final int play = 2;
	public static final int options = 3;
	public static final int lose = 4;
	
	Transition fadeOut, fadeIn;
	
	Image menuButton, menuButtonHover, menuButtonActive;
	
	List<Button> buttons = new ArrayList<Button>();
	Button mainMenuButton;
	
	boolean down;
	int mouseX, mouseY;
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		fadeOut = new FadeOutTransition();
		fadeIn = new FadeInTransition();
		
		menuButton = new Image("res/menuButton.png");
		menuButtonHover = new Image("res/menuButtonHover.png");
		menuButtonActive = new Image("res/menuButtonActive.png");
		
		mainMenuButton = new Button(325, 450, "Back to Main Menu", gc, 
				menuButton, menuButtonHover, menuButtonActive);
		buttons.add(mainMenuButton);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("Options", 390, 50);
		for(Button b : buttons) {
			b.render(mouseX, mouseY, down, g);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		mouseX = Mouse.getX();
		mouseY = gc.getHeight() - Mouse.getY() - 1;
		down = Mouse.isButtonDown(0);
		if(mainMenuButton.isHover(mouseX, mouseY) && down) {
			sbg.enterState(mainMenu, fadeOut, fadeIn);
		}
	}

	public int getID() {
		
		return 3;
	}

}
