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

public class MainMenu extends BasicGameState{
	
	public MainMenu(int mainmenu) {

	}
	
	public static final int start = 0;
	public static final int mainMenu = 1;
	public static final int play = 2;
	public static final int options = 3;
	public static final int lose = 4;
	
	Transition fadeOut, fadeIn;
	
	Image menuButton, menuButtonHover, menuButtonActive;
	
	Button optionsButton, playButton, exitButton;
	List<Button> buttons = new ArrayList<Button>();
	
	int mouseX, mouseY;
	boolean down;
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		fadeOut = new FadeOutTransition();
		fadeIn = new FadeInTransition();
		
		menuButton = new Image("res/menuButton.png");
		menuButtonHover = new Image("res/menuButtonHover.png");
		menuButtonActive = new Image("res/menuButtonActive.png");
		
		optionsButton = new Button(640, 5, "Options", gc, 
				menuButton, menuButtonHover, menuButtonActive);
		buttons.add(optionsButton);
		playButton = new Button(325, 250, "Play!", gc, 
				menuButton, menuButtonHover, menuButtonActive);
		buttons.add(playButton);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		for(Button b : buttons) {
			b.render(mouseX, mouseY, down, g);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		mouseX = Mouse.getX();
		mouseY = gc.getHeight() - Mouse.getY() - 1;
		down = Mouse.isButtonDown(0);
		if(optionsButton.isHover(mouseX, mouseY) && down) {
			sbg.enterState(options, fadeOut, fadeIn);
		}else if(playButton.isHover(mouseX, mouseY) && down) {
			sbg.enterState(play, fadeOut, fadeIn);
		}
	}

	public int getID() {

		return 1;
	}

}
