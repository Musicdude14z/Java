package game;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import asteroids.Power;

public class User {

	protected float x, y, height, width, top, bottom, right, left;
	protected String title;
	protected ArrayList<Power> powers = new ArrayList<Power>();
	protected ArrayList<Power> removePow = new ArrayList<Power>();
	protected Color color;
	protected double increment = 0.25;
	
	public User(float x, float y, float height, float width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.color = Color.white;
		this.title = "";
	}
	
	public void setColor(Color newColor) {
		this.color = newColor;
	}
	
	public void setTitle(String str) {
		this.title = str;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public float getTop() {
		return this.top;
	}
	
	public void addPower(Power add) {
		powers.add(add);
	}
	
	public void remPower(Power rem) {
		powers.remove(rem);
	}
	
	public void clear() {
		powers.clear();
	}
	
	public boolean hasPower(String powTitle) {
		for(Power p : powers) {
			if(p.getTitle() == powTitle) {
				return true;
			}
		}
		return false;
	}
	
	public float getBottom() {
		return this.bottom;
	}
	
	public float getRight() {
		return this.right;
	}
	
	public float getLeft() {
		return this.left;
	}
	
	public void render(Graphics g) {
		g.fillRect(this.x, this.y, this.width, this.height);
	}
	
	public void update(int delta, GameContainer gc) {
		Input input = gc.getInput();
		
		if (input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A)) {
			y -=increment*delta / 2;
			x -= increment*delta / 2;
		}else if(input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_D)) {
			y -=increment*delta / 2;
			x += increment*delta / 2;
		}else if(input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_A)) {
			y +=increment*delta / 2;
			x -= increment*delta / 2;
		}else if(input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_D)) {
			y +=increment*delta / 2;
			x += increment*delta / 2;
		}else if(input.isKeyDown(Input.KEY_S)) {
			y += increment*delta;
		}else if(input.isKeyDown(Input.KEY_W)) {
			y -= increment*delta;
		}else if(input.isKeyDown(Input.KEY_A)) {
			x -= increment*delta;
		}else if(input.isKeyDown(Input.KEY_D)) {
			x += increment*delta;
		}
		
		if(x <= 0) {
			x = 0;
		}else if(x >=850 - 51) {
			x = 850 - 51;
		}
		if(y <=0) {
			y = 0;
		}else if(y >= 550 - 51) {
			y = 550 - 51;
		}
		
		top = y;
		bottom = y + height;
		left = x;
		right = x + width;
		
		for(Power p : this.powers) {
			p.update(gc);
			if(p.isTimeOut()) {
				removePow.add(p);
			}
		}
		
		for(Power p : removePow) {
			powers.remove(p);
		}
		
		removePow.clear();
		
	}
	
}
