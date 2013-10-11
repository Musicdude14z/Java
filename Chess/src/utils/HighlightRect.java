package utils;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class HighlightRect extends BasicRect {
	
	protected Color color = Color.transparent, highlight = Color.transparent, current;
	protected boolean highlighted = false;
	
	public HighlightRect(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		current = color;
	}
	
	public HighlightRect(float x, float y, float width, float height, 
			Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.highlight = color;
		current = color;
	}
	
	public HighlightRect(float x, float y, float width, float height, 
			Color color, Color highlight) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.highlight = highlight;
		current = color;
	}
	
	public void highlight() {
		highlighted = true;
	}
	
	public void unHighlight() {
		highlighted = false;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		g.setColor(current);
		g.fillRect(x, y, width, height);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		if(highlighted) current = highlight;
		else current = color;
	}
	
}
