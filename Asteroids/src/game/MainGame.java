package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MainGame extends StateBasedGame{

	public static final String versionNumber = " v0.1";
	public static final String gameTitle = "First Game" + versionNumber;

	public static final int start = 0;
	public static final int mainMenu = 1;
	public static final int play = 2;
	public static final int options = 3;
	public static final int lose = 4;

	public MainGame(String title) {
		super(title);
		this.addState(new Start(start));
		this.addState(new MainMenu(mainMenu));
		this.addState(new Play(play));
		this.addState(new Options(options));
		this.addState(new Lose(lose));
	}

	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new MainGame(gameTitle));
			app.setDisplayMode(850, 550, false);
			app.setAlwaysRender(true);
			app.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		//The code block below is already called by the library, 
		//so this would be redundant, and runs init() twice
		/*
		this.getState(start).init(gc, this);
		this.getState(mainMenu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(options).init(gc, this);
		this.getState(lose).init(gc, this);
		this.getState(5).init(gc, this);
		this.enterState(start);
		*/
	}

}
