package asteroids;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Asteroid {
	
	protected float x, y, xV, yV, deltaXV, deltaYV;
	protected int height, width, top, bottom, left, right, size;
	protected Color color;
	protected String type;
	
	public Asteroid() {
		double xCoord, yCoord, xVel, yVel;
		double rand8 = Math.floor(Math.random()*8);
		
		//Random generation: defines starting Coords off the visible field
		//				   : defines velocity
		if(rand8 == 7) { // -- --
			xCoord = Math.floor(Math.random()*50 + -75);
			yCoord = Math.floor(Math.random()*5- + -75);
			xVel = Math.random()*0.1;
			yVel = Math.random()*0.1 + 0.1;
		}else if(rand8 == 6) { // ++ --
			xCoord = Math.floor(Math.random()*50 + 875);
			yCoord = Math.floor(Math.random()*50 + -75);
			xVel = Math.random()*-0.1 + -0.1;
			yVel = Math.random()*0.1 + 0.1;
		}else if(rand8 == 5) { // -- ++
			xCoord = Math.floor(Math.random()*50 + -75);
			yCoord = Math.floor(Math.random()*50 + 575);
			xVel = Math.random()*0.1 + 0.1;
			yVel = Math.random()*-0.1 + -0.1;
		}else if(rand8 == 4) { // ++ +
			xCoord = Math.floor(Math.random()*50 + 875);
			yCoord = Math.floor(Math.random()*600 + -25);
			xVel = Math.random()*-0.1 + -0.1;
			yVel = Math.random()*0.4 + -0.2;
		}else if(rand8 == 3) { // -- +
			xCoord = Math.floor(Math.random()*50 + -75);
			yCoord = Math.floor(Math.random()*600 + -25);
			xVel = Math.random()*0.1 + 0.1;
			yVel = Math.random()*0.4 + -0.2;
		}else if(rand8 == 2) { // + ++
			xCoord = Math.floor(Math.random()*900 + -25);
			yCoord = Math.floor(Math.random()*50 + 875);
			xVel = Math.random()*0.4 + -0.2;
			yVel = Math.random()*-0.1 + -0.1;
		}else if(rand8 == 1) { // + --
			xCoord = Math.floor(Math.random()*900 + -25);
			yCoord = Math.floor(Math.random()*50 + -75);
			xVel = Math.random()*0.4 + -0.2;
			yVel = Math.random()*0.1 + 0.1;
		}else {  // ++ ++
			xCoord = Math.floor(Math.random()*50 + 875);
			yCoord = Math.floor(Math.random()*50 + 575);
			xVel = Math.random()*-0.1 + -0.1;
			yVel = Math.random()*-0.1 + -0.1;
		}
		
		double rand5 = Math.floor(Math.random()*5 + 3);
		
		double xInc = Math.floor(Math.random()*0.5);
		double yInc = Math.floor(Math.random()*0.5);
		double signX = Math.floor(Math.random()*2);
		double signY = Math.floor(Math.random()*2);
		
		if(signX == 1) {
			xInc = 0 - xInc;
		}
		if(signY == 1) {
			yInc = 0 - yInc;
		}
		
		this.x = (float)xCoord;
		this.y = (float)yCoord;
		this.xV = (float)xVel;
		this.yV = (float)yVel;
		this.deltaXV = (float)xInc;
		this.deltaYV = (float)yInc;
		this.size = (int)rand5;
		this.height = this.size*5;
		this.width = this.size*5;
		this.top = (int)this.y;
		this.bottom = (int)(this.y + this.height);
		this.left = (int)this.x;
		this.right = (int)(this.x + this.width);
		this.color = Color.gray;
		this.type = "Asteroid";
	}
	
	public Asteroid(float startX, float startY, float velX, float velY, int newSize) {
		this.x = startX;
		this.y = startY;
		this.xV = velX;
		this.yV = velY;
		this.deltaYV = (int)(Math.floor(Math.random()*0.5));
		this.deltaXV = (int)(Math.floor(Math.random()*0.5));
		this.size = newSize;
		this.height = this.size*5;
		this.width = this.size*5;
		this.top = (int)this.y;
		this.bottom = (int)(this.y + this.height);
		this.left = (int)this.x;
		this.right = (int)(this.x + this.width);
		this.color = Color.gray;
		this.type = "Asteroid";
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public boolean isCollide(int t, int b, int r, int l) {
		//check for character in asteroid
		if((t >= this.top && t <= this.bottom) ||
				(b >= this.top && b <= this.bottom)) {
			if((r >= this.left && r <= this.right) ||
					(l >= this.left && l <= this.right)) {
				return true;
			}
		}
		
		//check for asteroid in character
		// ~ Can only happen if the asteroid is smaller than the character, and lag is massive
		if((this.top >= t && this.top <= b) ||
				(this.bottom >= t && this.bottom <= b)) {
			if((this.right >= l && this.right <= r) ||
					(this.left >= l && this.left <= r)) {
				return true;
			}
		}
		
		//no collision
		return false;
	}
	
	public boolean hasPassed() {
		if(this.x > 1000 || this.x < -100 || this.y > 700 || this.y < -100) {
			return true;
		}
		return false;
	}
	
	public void update(int delta) {
		this.x += this.xV*delta;
		this.y += this.yV*delta;
		this.top = (int)this.y;
		this.bottom = (int)(this.y + this.height);
		this.left = (int)this.x;
		this.right = (int)(this.x + this.width);
		this.xV += this.deltaXV*delta;
		this.yV += this.deltaYV*delta;
		this.height = this.size*5;
		this.width = this.size*5;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void render(Graphics g) {
		Color previous = g.getColor();
		g.setColor(color);
		g.fillRect(this.x, this.y, this.width, this.height);
		g.setColor(previous);
	}

	public int getSize() {
		return this.size;
	}
	
	public void setSize(int newSize) {
		this.size = newSize;
	}

	public void setX(float newX) {
		this.x = newX;
	}
	
	public void setY(float newY) {
		this.y = newY;
	}
	
	public void setXV(float newXV) {
		this.xV = newXV;
	}
	
	public void setYV(float newYV) {
		this.yV = newYV;
	}
	
	public float getXV() {
		return this.xV;
	}
	
	public float getYV() {
		return this.yV;
	}
	/*
	public static Asteroid[] split(Asteroid a) {
		int oldSize = a.getSize();
		Asteroid one, two;
		one = new Asteroid();
		two = new Asteroid();
		one.setSize(oldSize - 5);
		two.setSize(oldSize - 5);
		one.setX(a.getX());
		two.setX(a.getX());
		one.setY(a.getY());
		two.setY(a.getY());
		one.setXV(a.getXV());
		two.setXV(a.getXV());
		one.setYV(a.getYV());
		two.setYV(-(a.getYV()));
		Asteroid[] temp  = new Asteroid[] {one, two};
		return temp;
	}
	*/
}
