package asteroids;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
//import org.newdawn.slick.Input;

public class Bullet {
	
	protected float x, y, xV, yV, top, left, bottom, right, height, width;
	protected int size;
	protected Color color;
	
	public Bullet(float top, float left, float right, float bottom, GameContainer gc) {
		//Input input = gc.getInput();
		/*boolean rMove = input.isKeyDown(Input.KEY_RIGHT);
		boolean tMove = input.isKeyDown(Input.KEY_UP);
		boolean lMove = input.isKeyDown(Input.KEY_LEFT);
		boolean bMove = input.isKeyDown(Input.KEY_DOWN);
		if(rMove && tMove) {
			this.xV = (float)0.25;
			this.yV = (float)-0.25;
			this.x = right + 1;
			this.y = top - 1;
		}else if(rMove && bMove) {
			this.xV = (float)0.25;
			this.yV = (float)0.25;
			this.x = right + 1;
			this.y = bottom + 1;
		}else if(lMove && tMove) {
			this.xV = (float)-0.25;
			this.yV = (float)-0.25;
			this.x = left - 1;
			this.y = top - 1;
		}else if(lMove && bMove) {
			this.xV = (float)-0.25;
			this.yV = (float)0.25;
			this.x = left - 1;
			this.y = bottom + 1;
		}else if(tMove) {
			this.yV = (float)-0.5;
			this.x = (right + left)/2 - 1;
			this.y = top + 1;
		}else if(lMove) {
			this.xV = (float)-0.5;
			this.x = left - 1;
			this.y = (top + bottom)/2 - 1;
		}else if(bMove) {
			this.yV = (float)0.5;
			this.x = (right + left)/2 - 1;
			this.y = bottom + 1;
		}else if(rMove) {
			this.xV = (float)0.5;
			this.x = right - 1;
			this.y = (top + bottom)/2 - 1;
		}else {
			this.yV = (float)-0.5;
			this.x = (right + left)/2 - 1;
			this.y = top - 1;
		}*/
		float mouseX = Mouse.getX();
		float mouseY = gc.getHeight() - Mouse.getY() - 1;
		this.x = (right + left)/2;
		this.y = (top + bottom)/2;
		float slope = (this.y - mouseY)/(this.x - mouseX);
		double c = 0.5;
		this.xV =(float) (c/Math.sqrt((1+slope*slope)));
		this.yV =(float) (Math.sqrt(c*c - this.xV*this.xV));
		this.xV = mouseX < this.x ? -this.xV : this.xV;
		this.yV = mouseY < this.y ? -this.yV : this.yV;
		this.top = this.y;
		this.left = this.x;
		this.size = 2;
		this.height = this.size*2;
		this.width = this.size*2;
		this.bottom = this.y + this.height;
		this.right = this.x + this.width;
		this.color = Color.cyan;
	}
	
	public boolean hasPassed() {
		if(this.x > 1000 || this.x < -100 || this.y > 700 || this.y < -100) {
			return true;
		}
		return false;
	}
	
	public void setSize(int newSize) {
		this.size = newSize;
		this.height = this.size*2;
		this.width = this.size*2;
	}
	
	public void setColor(Color newColor) {
		this.color = newColor;
	}
	
	public float getTop() {
		return this.top;
	}
	
	public float getLeft() {
		return this.left;
	}
	
	public float getRight() {
		return this.right;
	}
	
	public float getBottom() {
		return this.bottom;
	}
	
	public void update(int delta) {
		this.x += this.xV*delta;
		this.y += this.yV*delta;
		this.top = this.y;
		this.left = this.x;
		this.bottom = this.y + this.height;
		this.right = this.x + this.width;
	}
	
	public void render(Graphics g) {
		Color previous = g.getColor();
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
		g.setColor(previous);
	}
	
}
