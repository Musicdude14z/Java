package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import utils.TextButton;

public class MainMenu extends BasicGameState {

	private int id;
	private TextButton b;
	
	public MainMenu(int id) {
		this.id = id;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		b = new TextButton((gc.getWidth()-200)/2, 450, 200, 50, "Start Game", 
				Color.red, Color.blue, Color.cyan, Color.yellow);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setBackground(Color.decode("#662266"));
		g.setColor(Color.cyan);
		g.drawString("CHESS", (gc.getWidth()-g.getFont().getWidth("CHESS"))/2, 150);
		b.render(gc, sbg, g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		b.update(gc, sbg, delta);
		if(b.clicked(0)) sbg.enterState(MainGame.gamePlay);
	}

	public int getID() {
		return id;
	}

}
