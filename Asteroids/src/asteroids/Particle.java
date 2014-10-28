package asteroids;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Particle {

	protected float x, y, xV, yV, height, width, deltaXV, deltaYV;
	protected int size;
	protected boolean isNegXV, isNegYV;
	protected Color color;
	
	public Particle(float startX, float startY, float velX, float velY,
			float deltaX, float deltaY) {
		this.x = startX;
		this.y = startY;
		this.xV = velX;
		this.yV = velY;
		this.deltaXV = deltaX;
		this.deltaYV = deltaY;
		this.size = 1;
		this.height = this.size*3;
		this.width = this.size*3;
		this.color = Color.blue;
		this.isNegXV = this.xV < 0;
		this.isNegYV = this.yV < 0;
	}
	
	public static Particle[] explosion(float startX, float startY, int num) {
		float v = (float)0.5;
		float inc = (float)-0.002;
		double spacing = 2*Math.PI/num;
		Particle[] temp = new Particle[num];
		for(int i=0; i<num; i++) {
			double xMod = Math.cos(spacing*i);
			double yMod = Math.sin(spacing*i);
			temp[i] = new Particle(startX, startY, (float)(v*xMod), (float)(v*yMod),
					(float)(inc*xMod), (float)(inc*yMod));
		}
		return temp;
	}
	
	public void setColor(Color newColor) {
		this.color = newColor;
	}
	
	public boolean isDone() {
		float testXV, testYV;
		testXV = this.isNegXV ? -(this.xV) : this.xV;
		testYV = this.isNegYV ? -(this.yV) : this.yV;
		return (testXV <= 0 && testYV <= 0);
	}
	
	public void update(int delta) {
		this.x += this.xV*delta;
		this.y += this.yV*delta;
		this.xV += this.deltaXV*delta;
		this.yV += this.deltaYV*delta;
	}
	
	public void render(Graphics g) {
		Color old = g.getColor();
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
		g.setColor(old);
	}
	
}
