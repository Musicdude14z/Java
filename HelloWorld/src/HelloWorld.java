import java.util.Scanner;

public class HelloWorld {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = s.nextLine();
		s.close();
		System.out.println("Hello, " + name + "!");
	}
	
}
