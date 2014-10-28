package game;

import java.util.ArrayList;
//import java.util.List;

import org.lwjgl.input.Mouse;
//import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
//import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
//import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import asteroids.Asteroid;
//import asteroids.AsteroidAI;
import asteroids.Bullet;
import asteroids.Particle;
import asteroids.Power;
import asteroids.TrackingBullet;
import game.User;

public class Play extends BasicGameState{

	public Play(int play) {
		
	}
	
	public static final int start = 0;
	public static final int mainMenu = 1;
	public static final int play = 2;
	public static final int options = 3;
	public static final int lose = 4;
	public static int score = 0;
	
	float x = 400;
	float y = 250;
	int xCoord, yCoord, stageInc, rarity = 200, rarityAI = 500, change = 1;
	boolean down, gameOver;
	double increment = 0.25;
	int height = 30;
	int width = 30;
	float top, bottom, right, left;
	long time, lastFired = 0;
	String userTitle;
	Font font;
	
	Image bigBullet, trackingBullet, rapidFire;
	
	User player;
	
	ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	ArrayList<Asteroid> removeA = new ArrayList<Asteroid>();
	ArrayList<Asteroid> addA = new ArrayList<Asteroid>();
	
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	ArrayList<Bullet> removeB = new ArrayList<Bullet>();
	
	ArrayList<Particle> particles = new ArrayList<Particle>();
	ArrayList<Particle> removeP = new ArrayList<Particle>();
	
	ArrayList<User> players = new ArrayList<User>();
	
	ArrayList<Power> powers = new ArrayList<Power>();
	ArrayList<Power> removePow = new ArrayList<Power>();
	
	void reset() {
		x = 400;
		y = 250;
		rarity = 200;
		xCoord = 0;
		yCoord = 0;
		stageInc = 0;
		down = false;
		gameOver = false;
		increment = 0.25;
		height = 30;
		width = 30;
		top = y;
		bottom = y + height;
		right = x;
		left = x + width;
		asteroids.clear();
		bullets.clear();
		removeA.clear();
		removeB.clear();
		removeP.clear();
		removePow.clear();
		addA.clear();
		particles.clear();
		powers.clear();
		players.clear();
		player = new User(x, y, height, width);
		players.add(player);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		//gc.setShowFPS(false);
		bigBullet = new Image("res/BigBullet.png");
		trackingBullet = new Image("res/TrackingBullet.png");
		rapidFire = new Image("res/RapidFire.png");
		font = gc.getDefaultFont();
		player = new User(x, y, height, width);
		players.add(player);
		System.out.println("YES");
		}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString(score + "", (gc.getWidth() - font.getWidth(score + ""))/2, 50);
		for(Asteroid a : asteroids) {
			a.render(g);
		}
		for(Bullet b : bullets) {
			b.render(g);
		}
		for(Particle p : particles) {
			p.render(g);
		}
		for(User u : players) {
			u.render(g);
		}
		for(Power p : powers) {
			p.render(g);
		}
		g.drawString("Rarity: " + rarity + "\nDelta: " + change + "\nActual: " + rarity/change,
				750, 25);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		
		xCoord = Mouse.getX();
		yCoord = gc.getHeight() - Mouse.getY() - 1;
		down = Mouse.isButtonDown(0);
		time = gc.getTime();
		
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			reset();
			score = 0;
			sbg.enterState(mainMenu);
		}
		if(input.isKeyDown(Input.KEY_SPACE)) {
			int spacing = true || player.hasPower("Rapid Fire") ? 100 : 250;
			if(time >= lastFired + spacing) {
				if(true || player.hasPower("Tracking Bullet")) {
					bullets.add(new TrackingBullet(top, left, right, bottom, asteroids, gc));
				}else {
					bullets.add(new Bullet(top, left, right, bottom, gc));
				}
				lastFired = time;
			}
		}
		
		for(Asteroid a : addA) {
			asteroids.add(a);
		}
		
		addA.clear();
		
		for(Asteroid a : asteroids) {
			a.update(delta);
			if(a.hasPassed()) {
				removeA.add(a);
				score += 100;
			}else if(a.isCollide((int)top, (int)bottom, (int)right, (int)left)) {
				gameOver = true;
				break;
			}
			for(Bullet b : bullets) {
				float to = b.getTop();
				float bo = b.getBottom();
				float ri = b.getRight();
				float le = b.getLeft();
				if(a.isCollide((int)to, (int)bo, (int)ri, (int)le)) {
					float velY = a.getYV();
					float velX = a.getXV();
					int newSize = a.getSize() - 1;
					if(newSize < 3) {
						Particle[] temp = Particle.explosion(b.getLeft(), b.getTop(), 9);
						for(Particle p : temp) {
							particles.add(p);
						}
						removeB.add(b);
						removeA.add(a);
						score += 1000 - (a.getSize()-3)*100;
						continue;
					}
					float velY1, velX1, velY2, velX2, startX, startY;
					double alpha, beta1, beta2, theta, v;
					v = Math.sqrt(velX*velX + velY*velY);
					alpha = Math.acos(velX/v);
					if(velY < 0) alpha = -alpha;
					theta = Math.PI/6;
					beta1 = alpha - theta/2;
					beta2 = alpha + theta/2;
					velX1 = (float)(Math.cos(beta1)*v);
					velY1 = (float)(Math.sin(beta1)*v);
					velX2 = (float)(Math.cos(beta2)*v);
					velY2 = (float)(Math.sin(beta2)*v);
					if(velY < 0) {
						startX = a.getX();
						if(velY < 0) {
							startY = a.getY();
						}else {
							startY = a.getY() + a.getWidth();
						}
					}else {
						startX = a.getX() + a.getWidth();
						if(y < 0) {
							startY = a.getY();
						}else {
							startY = a.getY() + a.getWidth();
						}
					}
					int howMany = a.getSize()*3;
					addA.add(new Asteroid(startX, startY, velX1, velY1, newSize));
					addA.add(new Asteroid(startX, startY, velX2, velY2, newSize));
					Particle[] temp = Particle.explosion(b.getLeft(), b.getTop(), howMany);
					for(Particle p : temp) {
						particles.add(p);
					}
					removeB.add(b);
					removeA.add(a);
					score += 1000 - (a.getSize()-3)*100;
				}
			}
		}
		
		for(Bullet b : bullets) {
			b.update(delta);
			if(b.hasPassed()) {
				removeB.add(b);
			}else if(player.hasPower("Big Bullet")) {
				b.setSize(10);
			}
		}
		
		for(Particle p : particles) {
			p.update(delta);
			if(p.isDone()) {
				removeP.add(p);
			}
		}
		
		for(User u : players) {
			u.update(delta, gc);
		}
		
		for(Power p : powers) {
			p.update(gc);
			if(p.isTimeOut()) {
				removePow.add(p);
			}else if(p.isCollide((int)top, (int)bottom, (int)right, (int)left)) {
				removePow.add(p);
				p.use(gc);
				player.addPower(p);
			}
		}
		
		x = players.get(0).getTop();
		y = players.get(0).getLeft();
		top = players.get(0).getTop();
		bottom = players.get(0).getBottom();
		left = players.get(0).getLeft();
		right = players.get(0).getRight();
		
		for(Asteroid a : removeA) {
			asteroids.remove(a);
			//removeA.remove(a);
		}
		
		for(Bullet b : removeB) {
			bullets.remove(b);
			//removeB.remove(b);
		}
		
		for(Particle p : removeP) {
			particles.remove(p);
		}
		
		for(Power p : removePow) {
			powers.remove(p);
		}
		
		removeA.clear();
		removeB.clear();
		removeP.clear();
		removePow.clear();
		
		stageInc += delta;
		
		if(stageInc == 5000 && rarity != 0 && rarityAI != 0) {
			stageInc = 0;
			rarity--;
			rarityAI--;
		}
		
		if(delta <= 0) {
			change = 1;
		}else {
			change = delta;
		}
		
		if(Math.floor(Math.random()*rarity/change) == 0) {
			asteroids.add(new Asteroid());
		}
		
		if(Math.floor(Math.random()*rarity/change*100) == 0) {
			powers.add(new Power("Big Bullet", bigBullet, gc));
		}
		
		if(Math.floor(Math.random()*rarity/change*100) == 0) {
			powers.add(new Power("Tracking Bullet", trackingBullet, gc));
		}
		
		if(Math.floor(Math.random()*rarity/change*100) == 0) {
			powers.add(new Power("Rapid Fire", rapidFire, gc));
		}
		
		if(Math.floor(Math.random()*rarityAI/change) == 0) {
			//asteroids.add(new AsteroidAI(x, y));
		}
		
		if(gameOver) {
			reset();
			sbg.enterState(lose);
		}
		
	}

	public int getID() {

		return 2;
	}

}
