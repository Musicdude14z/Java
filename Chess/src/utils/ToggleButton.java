package utils;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class ToggleButton extends BasicRect{

	protected Color color = Color.transparent, hover = Color.transparent, 
			active = Color.transparent, hoverActive = Color.transparent, 
			textColor = Color.transparent, current;
	protected boolean toggled = false, mouseWasDown = false;
	protected String text;
	
	public ToggleButton(String text, float x, float y, float width, float height, Color color,
			Color hover, Color active, Color hoverActive, Color textColor) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.hover = hover;
		this.active = active;
		this.hoverActive = hoverActive;
		this.textColor = textColor;
	}

	public boolean active() {
		return toggled;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		g.setColor(current);
		g.fillRect(x, y, width, height);
		g.setColor(textColor);
		Font f = g.getFont();
		g.drawString(text, x + (width-f.getWidth(text))/2, y + (height-f.getHeight(text))/2);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		if(isHover(Mouse.getX(), gc.getHeight()-Mouse.getY())) {
			if(Mouse.isButtonDown(0)) {
				if(!mouseWasDown) {
					mouseWasDown = true;
					if(toggled = !toggled) current = hoverActive;
					else current = hover;
				}
			}else {
				current = toggled ? hoverActive : hover;
				mouseWasDown = false;
			}
		}else {
			current = toggled ? active : color;
			mouseWasDown = false;
		}
	}

}
