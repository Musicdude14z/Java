package game;

import javax.swing.JOptionPane;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import utils.HighlightRect;
import utils.ToggleButton;

import chess.*;

public class GamePlay extends BasicGameState {

	//FOR ALL LENGTH 2 ARRAYS: 0 - White, 1 - Black
	
	public static final int WHITE = 0, BLACK = 1;
	public static int winner;
	public static String result = "", pawnChoices[] = {"Rook", "Knight", "Bishop", "Queen"};
	
	/*
	 * TODO: Add support for -done-check, and -done-checkMate
	 * -done-Add booleans, and check isSafe on kings every turn
	 */
	
	private int id;
	private Board board;
	private HighlightRect[] scorebg;
	private ToggleButton moveHelper;
	private King[] kings = new King[2];
	private boolean whiteTurn = true, selectedPiece = false, check[] = {false, false};
	private int lastSelected = -1, score[] = new int[2], scoreX = 925, scoreY = 25;
	
	public GamePlay(int id) {
		this.id = id;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		int width1 = gc.getDefaultFont().getWidth("White: 00  "), 
				width2 = gc.getDefaultFont().getWidth("  Black: 00"),
				height = gc.getDefaultFont().getHeight("W\nB");
		scorebg = new HighlightRect[] {
				new HighlightRect(scoreX-15, scoreY, width1+8, height, Color.lightGray, 
						Color.green), 
				new HighlightRect(scoreX+width1-7, scoreY, width2, height, Color.lightGray, 
						Color.green)};
		
		moveHelper = new ToggleButton("Move Helper", 25, 575, 150, 50, 
				Color.decode("#FF6666"), Color.decode("#FFAAAA"), Color.decode("#66FF66"),
				Color.decode("#AAFFAA"),Color.white);
		
		board = new Board(gc, sbg, 75);
		
		//Setup Board
		for(int i=0; i<8; i+=7) {
			board.setPiece(4, i, kings[(i+1)%2] = new King(4, i, i%2==0));
			board.setPiece(3, i, new Queen(3, i, i%2==0));
			board.setPiece(2, i, new Bishop(2, i, i%2==0));
			board.setPiece(5, i, new Bishop(5, i, i%2==0));
			board.setPiece(6, i, new Horse(6, i, i%2==0));
			board.setPiece(1, i, new Horse(1, i, i%2==0));
			board.setPiece(0, i, new Rook(0, i, i%2==0));
			board.setPiece(7, i, new Rook(7, i, i%2==0));
		}
		for(int i=0; i<8; i++) {
			board.setPiece(i, 1, new Pawn(i, 1, true));
			board.setPiece(i, 6, new Pawn(i, 6, false));
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		for(HighlightRect hr : scorebg) {
			hr.render(gc, sbg, g);
		}
		g.setColor(Color.white);
		//TESTING
		String piecesW = "", piecesB = "";
		for(Piece p : board.whitePieces) {
			piecesW += p.toString() + "\n";
		}
		for(Piece p : board.blackPieces) {
			piecesB += p.toString() + "\n";
		}
		g.drawString(piecesW, 925, 100);
		g.drawString(piecesB, 1025, 100);
		g.drawString("Mouse: (" + board.getMouseX() + ", " + board.getMouseY() + ")", 10, 50);
		g.drawString("Move Count: " + Piece.moveCount, 10, 65);
		//END TESTING
		moveHelper.render(gc, sbg, g);
		
		board.render(gc, sbg, g);
		g.setColor(Color.white);
		g.drawString("White: " + score[WHITE] + "  Black: " + score[BLACK] + '\n' +
				"", scoreX, scoreY);
		if(check[whiteTurn ? WHITE : BLACK]) {
			g.drawString("CHECK", scoreX+(!whiteTurn ? 110 : 10), scoreY+15);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		scorebg[whiteTurn ? WHITE : BLACK].highlight();
		scorebg[!whiteTurn ? WHITE : BLACK].unHighlight();
		for(HighlightRect hr : scorebg) {
			hr.update(gc, sbg, delta);
		}
		
		moveHelper.update(gc, sbg, delta);
		
		if(check[whiteTurn ? WHITE : BLACK]) {
			if(board.isCheckMate(kings[whiteTurn ? WHITE : BLACK])) {
				winner = !whiteTurn ? WHITE : BLACK;
				result = "WIN";
				sbg.enterState(MainGame.win);
			}
		}else {
			boolean hasMoves = false;
			Piece[] pieces = (whiteTurn ? board.whitePieces : board.blackPieces).toArray(new Piece[0]);
			for(Piece p : pieces) {
				if(p.getMoves(board).length > 0) {
					hasMoves = true;
					break;
				}
			}
			if(!hasMoves) {
				result = "STALEMATE";
				winner = -1;
				sbg.enterState(-1); //Will Implement Stalemate later
			}
		}
		
		board.update(gc, sbg, delta); //update
		
		//Just for Testing
		int spot = board.clicked(1); //Right Click
		board.remove(spot);
		//END Just for Testing
		
		int n = board.clicked(0); //Left Click
		if(n == -1) return;
		Piece p = board.getPiece(n);
		
		if(selectedPiece) { //moving selected piece
			board.unHighlightAll();
			selectedPiece = false;
			board.deselect(lastSelected);
			Piece oldPiece = board.getPiece(n);
			boolean oldPieceMoved = oldPiece.wasMoved(), moved = p.wasMoved();
			int s = board.getPiece(lastSelected).move(n, board);
			if(n == lastSelected || s<0) return;
			if(check[whiteTurn ? WHITE : BLACK]) {
				if(!board.isSafe(kings[whiteTurn ? WHITE : BLACK])) {
					board.getPiece(n).moveOverride(lastSelected, board);
					board.setPiece(n, oldPiece);
					p.reset(lastSelected, moved);
					oldPiece.reset(n, oldPieceMoved);
					return;
				}
			}
			score[whiteTurn ? WHITE : BLACK] += s;
			//Pawn Replacement
			int y = whiteTurn ? 0 : 7; //Decides which row to check
			for(int x=0; x<8; x++) { 
				if(board.getPiece(x, y) instanceof Pawn) {
					int choice = JOptionPane.showOptionDialog(null, "Select a piece that you " +
							"would like to replace you pawn at ("+(x+1)+","+(y+1)+") with:", 
							"Pawn Replacement", JOptionPane.DEFAULT_OPTION, 
							JOptionPane.QUESTION_MESSAGE, null, pawnChoices, 3);
					switch(choice) {
					case 0:
						board.setPiece(x, y, new Rook(x, y, !whiteTurn));
						break;
					case 1:
						board.setPiece(x, y, new Horse(x, y, !whiteTurn));
						break;
					case 2:
						board.setPiece(x, y, new Bishop(x, y, !whiteTurn));
						break;
					case 3:
						board.setPiece(x, y, new Queen(x, y, !whiteTurn));
						break;
					}
				}
			}
			
			whiteTurn = !whiteTurn;
			if(!board.isSafe(kings[whiteTurn ? WHITE : BLACK])) {
				check[whiteTurn ? WHITE : BLACK] = true;
			}else {
				check[whiteTurn ? WHITE : BLACK] = false;
			}
		} else { // selecting piece to move
			if(p instanceof Empty || p.isBlack() ^ !whiteTurn) return;
			board.select(n);
			selectedPiece = true;
			lastSelected = n;
			if(moveHelper.active()) {
				Integer[] moves = p.getMoves(board);
				for(int i : moves) {
					board.highlight(i);
				}
			}
		}
	}

	public int getID() {
		return id;
	}

}
