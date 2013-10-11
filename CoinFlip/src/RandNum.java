import java.util.InputMismatchException;
import java.util.Scanner;

public class RandNum {

	public static void main(String[] args) {
		System.out.println("I'm thinking of a number from 1 to 100.\nCan you guess what it is?");
		int rand = (int)Math.floor(Math.random()*100+1), guess = 0, i = 0;
		Scanner s = new Scanner(System.in);
		while(guess != rand) {
			System.out.printf("Guess #%d: ", ++i);
			try {
				guess = s.nextInt();
			}catch (InputMismatchException ime) {
				s.nextLine();
				error();
				i--;
				continue;
			}
			if(guess <= 0 || guess > 100) {
				error();
				i--;
				continue;
			}
			if(guess > rand) System.out.println("Sorry, your guess was too high!");
			else if(guess < rand) System.out.println("Sorry, your guess was too low!");
		}
		System.out.printf("Congratulations, you got it in only %d guesses!", i);
		s.close();
	}
	
	private static void error() {
		System.out.println("Sorry, your number must be an integer from 1 to 100.");
	}

}
