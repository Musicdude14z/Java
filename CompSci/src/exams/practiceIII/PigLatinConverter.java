//Zach Kaplan
package exams.practiceIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PigLatinConverter {
	
	private String myLine = "What a lovely day";
	
	private boolean isVowel(String ch) { //not shown, but completed for testing purposes
		char c = ch.charAt(0);
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	/**
	 * Part (a) of Question 1
	 * @param word - the word to be converted
	 * @return the Pig Latin form of word
	 */
	public String toPig(String word) {
		if(word.length() == 0) return null;
		if(isVowel(word.substring(0, 1))) {
			return word.substring(1) + word.charAt(0) + "ay";
		} else {
			return word + "yay";
		}
	}
	
	/**
	 * Part (b) of Question 1
	 * @return a list of words in myLine
	 */
	private List<String> getLineWords() {
		//Creates List as a new ArrayList<String> to ensure it is an ArrayList
		return new ArrayList<String>(Arrays.asList(myLine.split(" ")));
	}
	
	/**
	 * Part (c) of Question 1
	 */
	public void pigLatin() {
		List<String> words = getLineWords();
		for(int i=0; i<words.size(); i++) {
			words.set(i, toPig(words.get(i)));
		}
		String listInBrackets = words.toString().replace(",", ""); //remove commas
		myLine = listInBrackets.substring(1, listInBrackets.length()-1); //removes brackets
	}
	
	//Constructors and other methods not shown
	
}
