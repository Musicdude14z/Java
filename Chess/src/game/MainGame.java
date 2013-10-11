package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MainGame extends StateBasedGame {

	public static final String versionNumber = "v0.1", gameTitle = "Chess " + versionNumber; 
	public static final int mainMenu = 0, gamePlay = 1, pause = 2, lose = 3, win = 4;
	
	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new MainGame(gameTitle));
			app.setDisplayMode(1200, 650, false);
			app.setAlwaysRender(true);
			app.start();
		} catch (SlickException se) {
			se.printStackTrace();
		}
	}
	
	public MainGame(String name) {
		super(name);
		
		this.addState(new MainMenu(mainMenu));
		this.addState(new GamePlay(gamePlay));
		this.addState(new Pause(pause));
		this.addState(new Lose(lose));
		this.addState(new Win(win));
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.getState(gamePlay).init(gc, this);
		this.getState(pause).init(gc, this);
		this.getState(lose).init(gc, this);
		this.getState(win).init(gc, this);
		
		this.enterState(mainMenu);
	}
	
}
