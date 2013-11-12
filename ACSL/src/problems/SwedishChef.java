package problems;

import java.util.Scanner;

/**
 * Placement Take-Home Exam
 * @author Zach Kaplan
 * @version 1.0
 */
public class SwedishChef {

	private static boolean[] edited;
	private static String word;
	
	/**
	 * <code>public static void main({@link String}[] args)</code>
	 * <p>
	 * Main Method
	 * @param args - <code>{@link String}[]</code> of cmd line args
	 * @return {@code void}
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] lines = new String[5];
		for(int i=0; i<5; i++) {
			lines[i] = s.nextLine();
		}
		for(String line : lines) {
			String[] words = line.split(" ");
			for(String word : words) {
				System.out.print(toChef(word) + ' ');
			}
			System.out.println("BORK BORK BORK!");
		}
		s.close();
	}
	
	/**
	 * <code>private static {@link String} toChef({@link String} word)</code>
	 * <p>
	 * Translates from English to Chef
	 * @param word - <code>{@link String}</code> representing a word
	 * @return <code>{@link String}</code> representing word in Chef
	 */
	private static String toChef(String s) {
		String punctuation = "";
		while(s.matches(".*\\p{Punct}$")) { //while s ends in punctuation
			punctuation = s.substring(s.length()-1) + punctuation; //add it before punctuation
			s = s.substring(0, s.length()-1); //strip punctuation from s
		}
		word = s;
		edited = new boolean[word.length()];
		//THE => ZEE
		word = replaceAll("THE", "ZEE", false); //no check
		//AN => UN
		word = replaceAll("AN", "UN", false); //no check
		//AU => OO
		word = replaceAll("AU", "OO", false); //no check
		//A => E - Not at end of word
		word = replaceAll("A", "E", false, 0, word.length()-1); //no check
		//OW => OO
		word = replaceAll("OW", "OO", false); //no check
		//TION => SHUN
		word = replaceAll("TION", "SHUN", false); //no check
		//O => U - check for edit (NOW => NOO and not NUU)
		word = replaceAll("O", "U", true); //CHECK
		//IR => UR
		word = replaceAll("IR", "UR", false); //no check;
		//I => EE - Not at start of word
		word = replaceAll("I", "EE", false, 1); //no check
		//EN => EE - Only at end of word + check (THEN => ZEEN and not ZEEE)
		word = replaceAll("EN", "EE", true, word.length()-2); //CHECK
		//F => FF - check (to avoid infinite loop)
		word = replaceAll("F", "FF", true); //CHECK
		//E => E-A - Only at end of word + check (THE => ZEE and no ZEEN)
		word = replaceAll("E", "E-A", true, word.length()-1); //CHCEK
		//U => OO - Not at start of word + check (TON => TUN and not TOON)
		word = replaceAll("U", "OO", true, 1); //CHECK
		//V => F
		word = replaceAll("V", "F", false); //no check
		//W => V
		word = replaceAll("W", "V", false); //no check
		
		return word + punctuation;
	}
	
	/**
	 * <code>private static {@link String} replaceAt(int index, int size 
	 * {@link String} replacement, {@link String} word)</code>
	 * <p>
	 * Replaces chars at index and after with word up until length of word
	 * @param index - <code>int</code> representing where to start
	 * @param size - <code>int</code> representing size of replacement
	 * @param replacement - {@link String} representing characters to replace with
	 * @param word - {@link String} representing word to replace into
	 * @return {@link String} of word with replacement
	 */
	private static String replaceAt(int index, int size, String replacement, String word) {
		if(size + index >= word.length()) {
			return word.substring(0, index) + replacement; //nothing left in word
		}
		return word.substring(0, index) + replacement + word.substring(index+size);
		//            before            + replacement +           after
	}
	
	/**
	 * <code>private static {@link String} replaceAll({@link String} regex, 
	 * {@link String} replacement, boolean check, int start, int end)</code>
	 * <p>
	 * Replaces all occurrences of regex with replacement in word and marks
	 * changes in edited.  If check, then it will check and not edit if
	 * previously edited.  Only runs between start (inclusive) and end (exclusive)
	 * @param regex - {@link String} representing what to search for
	 * @param replacement - {@link String} representing what to replace with
	 * @param word - {@link String} representing the word to replace in
	 * @param edited - <code>boolean[]</code> representing indexes in word and state
	 * @param check - <code>boolean</code> representing whether or not check is req
	 * @param start - <code>int</code> representing starting index
	 * @param end - <code>int</code> representing ending index
	 * @return {@link String} with all edits
	 */
	private static String replaceAll(String regex, String replacement, boolean check,
			int start, int end) {
		if(start < 0 || end > word.length() || end <= start) {
			return word; //replacement doesn't qualify
		}
		String temp = word.substring(start, end); //just portion of word to check
		int index = temp.indexOf(regex); //get first index
		while(index >= 0) { //while index exists
			if(check && edited[index+start]) { //if check, then check
				index = temp.indexOf(regex, index+1); //increment and continue
				continue;
			}
			if(replacement.length() > regex.length()) { //need to change size of edited
				int add = replacement.length()-regex.length(); //difference in size
				boolean[] newEdited = new boolean[edited.length+add]; //temp for new
				for(int i=0; i<edited.length; i++) { //go over edited
					if(i<index+start) { //if before change
						newEdited[i] = edited[i]; //copy over directly
					}else if(i == index+start) { //if at change
						for(int j=i; j<=i+add; j++) newEdited[j] = true; //set added vals to true
					}else { //if after change
						newEdited[i+add] = edited[i]; //copy over with shift 
					}
				}
				edited = newEdited; //set edited to temp
			}else { //otherwise just set changed vals to true b/c no change in size
				for(int i=0; i<replacement.length(); i++) {
					edited[i+start+index] = true; //mark changes true
				}
			}
			temp = replaceAt(index, regex.length(), replacement, temp); //replace
			index = temp.indexOf(regex, index+1); //increment (index+1 if one was skipped)
		}
		//adding parts around temp back
		if(start > 0) temp = word.substring(0, start) + temp;
		if(end < word.length()) temp += word.substring(end);
		return temp; 
	}
	
	/**
	 * <code>private static {@link String} replaceAll({@link String} regex, 
	 * {@link String} replacement, boolean check, int start)</code>
	 * <p>
	 * Replaces all occurrences of regex with replacement in word and marks
	 * changes in edited.  If check, then it will check and not edit if
	 * previously edited.  Only runs after and including start index
	 * @param regex - {@link String} representing what to search for
	 * @param replacement - {@link String} representing what to replace with
	 * @param word - {@link String} representing the word to replace in
	 * @param edited - <code>boolean[]</code> representing indexes in word and state
	 * @param check - <code>boolean</code> representing whether or not check is req.
	 * @param start - <code>int</code> representing starting index
	 * @return {@link String} with all edits
	 */
	private static String replaceAll(String regex, String replacement, boolean check, 
			int start) {
		return replaceAll(regex, replacement, check, start, word.length());
	}
	
	/**
	 * <code>private static {@link String} replaceAll({@link String} regex, 
	 * {@link String} replacement, boolean check)</code>
	 * <p>
	 * Replaces all occurrences of regex with replacement in word and marks
	 * changes in edited.  If check, then it will check and not edit if
	 * previously edited.
	 * @param regex - {@link String} representing what to search for
	 * @param replacement - {@link String} representing what to replace with
	 * @param word - {@link String} representing the word to replace in
	 * @param edited - <code>boolean[]</code> representing indexes in word and state
	 * @param check - <code>boolean</code> representing whether or not check is req
	 * @return {@link String} with all edits
	 */
	private static String replaceAll(String regex, String replacement, boolean check) {
		return replaceAll(regex, replacement, check, 0, word.length());
	}

}
