package asteroids;

import org.newdawn.slick.Color;

public class AsteroidAI extends Asteroid{

	protected float xGoal, yGoal, changeY, changeX;
	protected String which;
	
	public AsteroidAI(float userX, float userY) {
		this.color = Color.green;
		this.deltaXV = (float)0.5;
		this.deltaYV = (float)0.5;
		this.xGoal = userX;
		this.yGoal = userY;
		this.changeY = (float)0.1;
		this.changeX = (float)0.1;
		this.type = "AsteroidAI";
	}
	
	public void update(int delta) {
		this.x += this.xV*delta;
		this.y -= this.yV*delta;
		if(this.y < this.yGoal) {
			this.y += this.changeY*delta;
		}else if (this.y > this.yGoal) {
			this.y -= this.changeY*delta;
		}else {
			this.changeY = 0;
			if(this.yV > 0) {
				this.yV += 0.1;
			}else {
				this.yV -= 0.1;
			}
		}
		if(this.x < this.xGoal) {
			this.x += this.changeX*delta;
		}else if (this.x > this.xGoal) {
			this.x -= this.changeX*delta;
		}else {
			this.changeX = 0;
			if(this.xV > 0) {
				this.xV += 0.1;
			}else {
				this.xV -= 0.1;
			}
		}
		this.top = (int)this.y;
		this.bottom = (int)(this.y + this.height);
		this.left = (int)this.x;
		this.right = (int)(this.x + this.width);
	}
	
}
