package utils;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.input.Mouse;

public class ClickableRect extends BasicRect {

	protected Color color, hover, active, current;
	protected boolean mouseDown = false, wasMouseDown = false;
	protected int mouseButton = -1;
	
	public ClickableRect(float x, float y, float width, float height) {
		this(x, y, width, height, Color.transparent, Color.transparent, Color.transparent);
	}

	public ClickableRect(float x, float y, float width, float height, 
			Color color) {
		this(x, y, width, height, color, color, color);
	}
	
	public ClickableRect(float x, float y, float width, float height, 
			Color color, Color hover) {
		this(x, y, width, height, color, hover, hover);
	}
	
	public ClickableRect(float x, float y, float width, float height, 
			Color color, Color hover, Color active) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.hover = hover;
		this.active = active;
		current = color;
	}
	
	public boolean clicked(int button) {
		return wasMouseDown && !mouseDown && mouseButton == button;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		g.setColor(current);
		g.fillRect(x, y, width, height);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		if(!mouseDown) wasMouseDown = false;
		mouseDown = false;
		if(isHover(Mouse.getX(), gc.getHeight() - Mouse.getY())) {
			if(Mouse.isButtonDown(0) || Mouse.isButtonDown(1) || Mouse.isButtonDown(2)) {
				current = active;
				wasMouseDown = true;
				mouseDown = true;
				mouseButton = -1;
				while(!Mouse.isButtonDown(++mouseButton));
			}
			else current = hover;
		}else current = color;
	}

}
