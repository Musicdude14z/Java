package util;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Button {

	private float x, y, height, width, stringX, stringY;
	private Image normal, hover, active;
	private GameContainer gc;
	private String text;
	private Font currentFont, originalFont;
	private Color currentColor, originalColor;
	
	public Button(int xCoord, int yCoord, String str, GameContainer gameC, 
			Image one, Image two, Image three) {
		this.x = xCoord;
		this.y = yCoord;
		this.height = one.getHeight();
		this.width = one.getWidth();
		this.normal = one;
		this.hover = two;
		this.active = three;
		this.gc = gameC;
		this.text = str;
		this.currentFont = this.gc.getDefaultFont();
		this.currentColor = Color.white;
		this.stringX = ((this.width - this.currentFont.getWidth(str)) / 2) + xCoord;
		this.stringY = ((this.height - this.currentFont.getHeight(str)) / 2) + yCoord;
	}
	
	public Button(float xCoord, float yCoord, String str, GameContainer gameC, 
			Image one, Image two, Image three) {
		this.x = xCoord;
		this.y = yCoord;
		this.height = one.getHeight();
		this.width = one.getWidth();
		this.normal = one;
		this.hover = two;
		this.active = three;
		this.gc = gameC;
		this.text = str;
		this.currentFont = gameC.getDefaultFont();
		this.currentColor = Color.white;
		this.stringX = ((this.width - this.currentFont.getWidth(str)) / 2) + xCoord;
		this.stringY = ((this.height - this.currentFont.getHeight(str)) / 2) + yCoord;
	}
	
	public float getHeight() {
		return this.height;
	}
	
	public float getWidht() {
		return this.width;
	}
	
	private void centerText() {
		this.stringX = ((this.width - this.currentFont.getWidth(this.text)) / 2) + this.x;
		this.stringY = ((this.height - this.currentFont.getHeight(this.text)) / 2) + this.y;
	}
	
	public void setText(String newStr) {
		this.text = newStr;
		this.centerText();
	}
	
	public void setFont(Font newFont) {
		this.currentFont = newFont;
		this.centerText();
	}
	
	public void setColor(Color newColor) {
		this.currentColor = newColor;
	}
	
	public boolean isHover(int mouseX, int mouseY) {
		return (mouseX > this.x && mouseX < (this.x + this.width) 
				&& mouseY > this.y && mouseY < (this.y + this.height));
	}
	
	public void render(int mouseX, int mouseY, boolean click, Graphics g) {
		if(this.isHover(mouseX, mouseY) && click) {
			g.drawImage(this.active, this.x, this.y);
		}else if(this.isHover(mouseX, mouseY)) {
			g.drawImage(this.hover, this.x, this.y);
		}else {
			g.drawImage(this.normal, this.x, this.y);
		}
		originalFont = g.getFont();
		originalColor = g.getColor();
		g.setFont(currentFont);
		g.setColor(currentColor);
		this.centerText();
		g.drawString(this.text, this.stringX, this.stringY);
		g.setColor(originalColor);
		g.setFont(originalFont);
	}
	
}
