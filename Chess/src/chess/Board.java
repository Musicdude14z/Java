package chess;

import java.util.LinkedList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import utils.ClickableRect;

public class Board {

	private Tile[][] board = new Tile[8][];
	private int[][] dirs = {{1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1}},
			dirsHorse = {{1,1}, {1,-1}, {-1,-1}, {-1, 1}};
	private int mouseX = 0, mouseY = 0;
	public LinkedList<Piece> blackPieces = new LinkedList<Piece>(), 
			whitePieces = new LinkedList<Piece>();
	
	public Board(GameContainer gc, StateBasedGame sbg, int squareSide) {
		int hOffset = (gc.getWidth()-squareSide*8)/2, vOffset = (gc.getHeight()-squareSide*8)/2;
		for(int y=0; y<board.length; y++) {
			board[y] = new Tile[8];
			for(int x=0; x<8; x++) {
				if((y+x%2)%2 == 0) board[y][x] = new Tile(x*squareSide+hOffset, 
						y*squareSide+vOffset, squareSide, squareSide, 
						Color.decode("#DEDEAA"), Color.decode("#FFFFFF"));
				else board[y][x] = new Tile(x*squareSide+hOffset, 
						y*squareSide+vOffset, squareSide, squareSide, 
						Color.decode("#000000"), Color.decode("#333333"));
			}
		}
	}

	public boolean isCheckMate(King k) {
		for(int[] dir : dirs) {
			int posX = (int)k.getX()+dir[0], posY = (int)k.getY()+dir[1];
			if(posX > 7 || posX < 0 || posY > 7 || posY < 0) continue;
			if(isSafe(posX, posY, k.isBlack()) && k.isValidMove(posX, posY, this)) return false;
		}
		Piece[] pieces = (k.isBlack() ? blackPieces : whitePieces).toArray(new Piece[0]);
		for(Piece p : pieces) {
			if(p instanceof King) continue;
			System.out.println(p);
			Integer[] moves = p.getMoves(this);
			int from = (int)(p.getX() + p.getY()*8);
			for(int to : moves) {
				Piece oldPiece = getPiece(to); //save old Piece in mem
				boolean oldPieceMoved = oldPiece.moved, moved = p.moved;
				int s = getPiece(from).move(to, this); //test move
				if(to == from || s<0) continue; //if invalid, skip
				boolean worked = isSafe(k); //record if move prevents check
				getPiece(to).moveOverride(from, this); //move piece back
				p.reset(from, moved);
				setPiece(to, oldPiece); //restore oldPiece
				oldPiece.reset(to, oldPieceMoved); //fix oldPiece's coords as to fix render
				if(worked) return false; //if it worked, not checkMate
			}
		}
		return true;
	}

	public boolean isSafe(King k) {
		return isSafe((int)k.getX(), (int)k.getY(), k.isBlack());
	}

	public boolean isSafe(int x, int y, boolean black) { //Use only for testing with KINGS
		for(int[] dir : dirs) {
			int posX = x+dir[0], posY = y+dir[1];
			while(posX<8 && posX>=0 && posY<8 && posY>=0) {
				Piece p = getPiece(posX, posY);
				posX += dir[0];
				posY += dir[1];
				if(p instanceof Empty) continue; //Empty space: Move further in same direction
				else if(p instanceof King) { //Next to opposing King: not allowed; same color, piece moving, skip over
					if(p.isBlack() == black) continue;
					else if(Math.abs(p.getX()-x)<2 && Math.abs(p.getY()-y)<2) return false; 
				}
				else if(p.isBlack() == black) break; //Same color: safe in this direction
				else if(p instanceof Pawn) {
					if(p.getX() == x) break;
					else if(Math.abs(p.getY()-y) == 1) return false;
					else break;
				}
				else { //Found an opposing piece: If it can attack, false; else harmless, safe in this direction
					if(p.isLegalMove(x, y)) return false; 
					else break;
				}
			}
		}
		for(int[] dir : dirsHorse) {
			if(getPiece(x+dir[0]*2, y+dir[1]) instanceof Horse && 
					getPiece(x+dir[0]*2, y+dir[1]).isBlack() != black) return false;
			else if(getPiece(x+dir[0], y+dir[1]*2) instanceof Horse && 
					getPiece(x+dir[0], y+dir[1]*2).isBlack() != black) return false;
		}
		return true;
	}

	public int clicked(int button) {
		int n = 0;
		for(Tile[] col : board) {
			for(Tile t : col) {
				if(t.clicked(button)) {
					return n; 
				}
				n++;
			}
		}
		return -1;
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}

	public void select(int x, int y) {
		board[y][x].select();
		board[y][x].getPiece().select();
	}

	public void select(int n) {
		board[n/8][n%8].select();
		board[n/8][n%8].getPiece().select();
	}

	public void deselect(int x, int y) {
		board[y][x].deselect();
		board[y][x].getPiece().deselect();
	}

	public void deselect(int n) {
		board[n/8][n%8].deselect();
		board[n/8][n%8].getPiece().deselect();
	}
	
	public void highlight(int x, int y) {
		board[y][x].highlight();
	}
	
	public void highlight(int n) {
		highlight(n%8, n/8);
	}
	
	public void unHighlight(int x, int y) {
		board[y][x].unHighlight();
	}
	
	public void unHighlight(int n) {
		unHighlight(n%8, n/8);
	}
	
	public void highlightAll() {
		for(Tile[] col : board) {
			for(Tile tile : col) {
				tile.highlight();
			}
		}
	}
	
	public void unHighlightAll() {
		for(Tile[] col : board) {
			for(Tile tile : col) {
				tile.unHighlight();
			}
		}
	}

	public Piece getPiece(int x, int y) {
		if(x>7 || x<0 || y>7 || y<0) return new Empty();
		return board[y][x].getPiece();
	}

	public Piece getPiece(int n) {
		if(n<0 || n >= 64) return new Empty();
		return board[n/8][n%8].getPiece();
	}

	public void setPiece(int x, int y, Piece p) {
		board[y][x].setPiece(p);
		if(p instanceof Empty) return;
		if(p.isBlack()) blackPieces.push(p);
		else whitePieces.push(p);

	}

	public void setPiece(int n, Piece p) {
		setPiece(n%8, n/8, p);
	}

	public void remove(Piece p) {
		if(p instanceof Empty) return;
		board[(int)p.getY()][(int)p.getX()].setPiece(new Empty());
		if(p.isBlack()) blackPieces.remove(p);
		else whitePieces.remove(p);
	}
	
	public void remove(int x, int y) {
		remove(getPiece(x, y));
	}
	
	public void remove(int n) {
		remove(getPiece(n));
	}

	public Tile getTile(int x, int y) {
		return board[y][x];
	}

	public Tile getTile(int n) {
		return board[n/8][n%8];
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		for(Tile[] row : board) {
			for(Tile tile : row) {
				tile.render(gc, sbg, g);
				tile.getPiece().render(gc, sbg, g, this);
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		int n = 0;
		for(Tile[] row : board) {
			for(Tile tile : row) {
				tile.update(gc, sbg, delta);
				tile.getPiece().update(gc, sbg, delta);
				if(tile.isHover(Mouse.getX(), gc.getHeight() - Mouse.getY())) {
					mouseX = n%8;
					mouseY = n/8;
				}
				n++;
			}
		}
	}

	public class Tile extends ClickableRect{

		private Piece p;
		private boolean selected = false, highlighted = false;
		private Color highlight = Color.decode("#33DDDD");

		public Tile(float x, float y, float width, float height, 
				Color color, Color hover) {
			super(x, y, width, height, color, hover);
			this.highlight.a = 0.35f; //Makes highlight 35% opaque (so 65% translucent)
			p = new Empty();
		}

		public void setPiece(Piece p) {
			this.p = p;
		}

		public Piece getPiece() {
			return p;
		}

		public void select() {
			selected = true;
		}

		public void deselect() {
			selected = false;
		}

		public boolean isSelected() {
			return selected;
		}
		
		public void highlight() {
			highlighted = true;
		}
		
		public void unHighlight() {
			highlighted = false;
		}
		
		public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
			super.render(gc, sbg, g);
			if(highlighted) {
				g.setColor(highlight);
				g.fillRect(x, y, width, height);
			}
		}

		public void update(GameContainer gc, StateBasedGame sbg, int delta) {
			super.update(gc, sbg, delta);
			if(selected) current = hover;
		}

	}

}