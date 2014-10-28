package game;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Font;
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

public class Lose extends BasicGameState{

	public Lose(int lose) {
		
	}
	
	public static final int start = 0;
	public static final int mainMenu = 1;
	public static final int play = 2;
	public static final int options = 3;
	public static final int lose = 4;
	
	int finalScore;
	
	Transition fadeOut, fadeIn;
	
	Image menuButton, menuButtonHover, menuButtonActive;
	
	List<Button> buttons = new ArrayList<Button>();
	Button mainMenuButton, exitButton, playAgainButton;
	
	Font font;
	
	boolean down;
	int mouseX, mouseY;
	
	public static void resetScore() {
		Play.score = 0;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		fadeOut = new FadeOutTransition();
		fadeIn = new FadeInTransition();
		
		menuButton = new Image("res/menuButton.png");
		menuButtonHover = new Image("res/menuButtonHover.png");
		menuButtonActive = new Image("res/menuButtonActive.png");
		
		mainMenuButton = new Button(175, 350, "Return to Main Menu", gc, 
				menuButton, menuButtonHover, menuButtonActive);
		buttons.add(mainMenuButton);
		playAgainButton = new Button(475, 350, "Play Again!", gc,
				menuButton, menuButtonHover, menuButtonActive);
		buttons.add(playAgainButton);
		exitButton = new Button(325, 450, "Exit", gc,
				menuButton, menuButtonHover, menuButtonActive);
		buttons.add(exitButton);
		
		finalScore = Play.score;
		font = gc.getDefaultFont();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("You Lose!", 390, 150);
		g.drawString(finalScore + "", (gc.getWidth() - font.getWidth(finalScore + ""))/2, 200);
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
			resetScore();
		}else if(exitButton.isHover(mouseX, mouseY) && down) {
			gc.exit();
			resetScore();
		}else if(playAgainButton.isHover(mouseX, mouseY) && down) {
			sbg.enterState(play, fadeOut, fadeIn);
			resetScore();
		}
		finalScore = Play.score;
	}

	public int getID() {
		
		return 4;
	}

}