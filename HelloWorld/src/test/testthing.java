package test;

import javax.swing.JOptionPane;

public class testthing {
	
	public static void main(String[] args) {
		int choice = JOptionPane.showOptionDialog(null, "Choose One", "Choose a Piece", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, new Object[] {"Queen", "Knight", "Bishop", "Castle"}, 
				null);
		System.out.println(choice);
		System.out.println((int)'A');
	}
	
}
