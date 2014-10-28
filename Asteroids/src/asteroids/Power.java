package asteroids;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Power {

	protected float x, y, top, bottom, left, right;
	protected double timeOut;
	protected int height, width;
	protected long create, current;
	protected String title;
	protected Image display;
	
	public Power(String title, Image display, GameContainer gc) {
		this.x = (float) (Math.floor(Math.random()*(850 - display.getWidth())));
		this.y = (float) (Math.floor(Math.random()*(550 - display.getHeight())));
		this.title = title;
		this.display = display;
		this.timeOut = Math.floor(Math.random()*(10*1000) + (15*1000));
		height = display.getHeight();
		width = display.getWidth();
		top = y;
		bottom = y + height;
		left = x;
		right = x + width;
		create = gc.getTime();
		current = create;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public boolean isTimeOut() {
		return current >= create + timeOut;
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
	
	public void use(GameContainer gc) {
		create = gc.getTime();
		current = create;
	}
	 
	public void render(Graphics g) {
		g.drawImage(display, x, y);
	}
	
	public void update(GameContainer gc) {
		current = gc.getTime();
	}
	
}
