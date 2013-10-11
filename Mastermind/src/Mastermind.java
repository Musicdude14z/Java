import java.util.InputMismatchException;
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		System.out.print("Are you ready to play?(y/n): ");
		Scanner s = new Scanner(System.in);
		String response = s.nextLine();
		if(response.matches("(n|N)")) {
			System.out.println("Alright, bye!");
			System.exit(0);
		}else if(!response.matches("(y|Y)")) {
			System.out.println("I'm not sure what you meant, but goodbye!");
			System.exit(1);
		}
		System.out.print("Okay, so please enter the length of the code you would like to " +
				"play with \n(Gameplay will last for 2 times the length of the code plus two turns): ");
		int length = 0;
		try {
			length = s.nextInt();
			if(length < 2) throw new InputMismatchException();
		} catch (InputMismatchException ime) {
			s.nextLine();
			System.out.println("Sorry, you must enter an integer greater than 1!");
			s.close();
			System.exit(1);
		}
		Code code = new Code(length);
		System.out.println("Alright I have my code of length " + length + '.');
		System.out.println("Remeber, the colors are M (Magenta), T (Teal), P (Purple), W (White)" +
				", Y (Yellow), O (Orange), or E (Empty). Use the 1 Letter Abrr. Please!");
		//System.out.println(code);
		s.nextLine();
		Code guess;
		for(int i=1; i<=length*2+2; i++) {
			System.out.printf("Attempt #%d: ", i);
			if((guess = Code.parse(s.nextLine())).length() != length) {
				System.out.println("Sorry, your code was the wrong length!");
				i--;
				continue;
			}
			System.out.println("Attempt detected as: " + guess);
			if(code.equals(guess)) {
				s.close();
				System.out.printf("Argh!  You got me, and in only %d guesses!  " +
						"Good Game, play again soon :D", i);
				System.exit(0);
			}
			int[] comp = code.compareTo(guess);
			System.out.printf("Correct Placement and Color: %d\nCorrect Color: %d\n",
					comp[0], comp[1]);
		}
		s.close();
		System.out.printf("Sorry, you lose!  My code was: %s.  Try again next time!", code);
		System.exit(0);
	}

}
