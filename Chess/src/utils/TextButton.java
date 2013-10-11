package utils;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class TextButton extends ClickableRect {

	protected String text;
	protected Color textColor = Color.white;
	
	public TextButton(float x, float y, float width, float height, String text) {
		super(x, y, width, height);
		this.text = text;
	}
	
	public TextButton(float x, float y, float width, float height, String text,
			Color color) {
		super(x, y, width, height, color);
		this.text = text;
	}
	
	public TextButton(float x, float y, float width, float height, String text,
			Color color, Color hover) {
		super(x, y, width, height, color, hover);
		this.text = text;
	}
	
	public TextButton(float x, float y, float width, float height, String text,
			Color color, Color hover, Color active) {
		super(x, y, width, height, color, hover, active);
		this.text = text;
	}
	
	public TextButton(float x, float y, float width, float height, String text,
			Color color, Color hover, Color active, Color textColor) {
		super(x, y, width, height, color, hover, active);
		this.text = text;
		this.textColor = textColor;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		super.render(gc, sbg, g);
		Font f = g.getFont();
		float x = this.x + (this.width - f.getWidth(text))/2, 
				y = this.y + (this.height - f.getHeight(text))/2;
		g.setColor(textColor);
		g.drawString(text, x, y);
	}

}
