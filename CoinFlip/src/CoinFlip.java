import java.util.Scanner;

public class CoinFlip {
	
	public static void main(String[] args) {
		System.out.println("Let's flip a coin...");
		System.out.print("Enter heads or tails: ");
		Scanner s = new Scanner(System.in);
		String choice = s.nextLine();
		s.close();
		String flip = Math.floor(Math.random()*2) == 1 ? "heads" : "tails";
		if(choice.toLowerCase().matches("(heads|tails)")) {
			System.out.println("Coin flipped: " + flip);
			System.out.println(choice.equalsIgnoreCase(flip) ? "You win!" : "Sorry, you lose.");
			System.exit(0);
		}else {
			System.out.println("Error: You must enter heads or tails. Please rerun the program.");
			System.exit(1);
		}
	}
	
}
