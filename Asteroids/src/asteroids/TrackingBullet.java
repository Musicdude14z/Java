package asteroids;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

public class TrackingBullet extends Bullet{

	protected Asteroid a;
	protected float dist, deltaXV = 0, deltaYV = 0;
	
	public TrackingBullet(float top, float left, float right, float bottom, 
			ArrayList<Asteroid> asteroids, GameContainer gc) {
		super (top, left, right, bottom, gc);
		this.dist = 10000;
		for(Asteroid a : asteroids) {
			float xDist, yDist, dist;
			xDist = Math.abs(a.getX() - this.x);
			yDist = Math.abs(a.getY() - this.y);
			dist = (float)(Math.sqrt(xDist*xDist + yDist*yDist));
			if(dist < this.dist) {
				this.dist = dist;
				this.a = a;
			}
		}
	}
	
	public void update(int delta) {
		this.x += this.xV*delta;
		this.y += this.yV*delta;
		this.top = this.y;
		this.left = this.x;
		this.bottom = this.y + this.height;
		this.right = this.x + this.width;
		this.deltaXV = this.x > a.getX() ? (float).0015 : (float)-.0015;
		this.deltaYV = this.y > a.getY() ? (float).0015 : (float)-.0015;
		this.xV += this.deltaXV*delta;
		this.yV += this.deltaYV*delta;
	}

}
