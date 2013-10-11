package utils;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public abstract class BasicRect {
	
	protected float x, y, width, height;
	
	public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics g);
	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta);
	
	public boolean isHover(float x, float y) {
		return x > this.x && x < width+this.x && y > this.y && y < height+this.y;
	}
	
	public boolean isCollide(BasicRect r) {
		if(r.getX() > x && r.getX() < x+width || 
				r.getX()+r.getWidth() > x && r.getX()+r.getWidth() < x+width) {
			if(r.getY() > y && r.getY() < y+height ||
					r.getY()+r.getHeight() > y && r.getY()+r.getHeight() < y+height) {
				return true;
			}
		}
		if(x > r.getX() && x < r.getX()+r.getWidth() ||
				x+width > r.getX() && x+width < r.getX()+r.getWidth()) {
			return y > r.getY() && y < r.getY()+r.getHeight() ||
					y+height > r.getY() && y+height < r.getY() + r.getHeight();
		}
		return false;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getHeight() {
		return height;
	}
	
	public float getWidth() {
		return width;
	}
	
}
