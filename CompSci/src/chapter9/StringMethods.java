package chapter9;

import java.util.Scanner;

public class StringMethods {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a list of emails: ");
		String list = s.nextLine();
		s.close();
		
		String[] emails = list.split("[;,\\s]\\s*");
		for(String email : emails) {
			System.out.println(isEmail(email));
		}
	}
	
	//checks for vaid email
	private static boolean isEmail(String email) {
		return email.matches("[\\w\\d.+-]+@[\\w.-]+[.]\\w+");
	}
	//zacharytrent@gmail.com test3r@fun.test.com; Iwon'twork@test.com,	nahh_mann@iamboss.com
	
	//password of len [2, 8] w/ at least 1 uppercase letter and 1 number
	private static boolean isValidPass(String pass) {
		return pass.matches("\\w{2,8}") && pass.matches(".*[A-Z]+.*") 
				&& pass.matches(".*\\d+.*");
	}
	
}
