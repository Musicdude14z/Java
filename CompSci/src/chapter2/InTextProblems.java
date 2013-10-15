package chapter2;

public class InTextProblems {
	
	public static void main(String[] args) {
		prob2_9();
		System.out.println();
		prob2_10();
		System.out.println();
		prob2_11();
		System.out.println();
		prob2_12();
		System.out.println();
		prob2_13();
	}
	
	private static void prob2_9() {
		System.out.println(56 % 6);
		System.out.println(78 % -4);
		System.out.println(-34 % 5);
		System.out.println(-34 % -5);
		System.out.println(5 % 1);
		System.out.println(1 % 5);
	}
	
	private static void prob2_10() {
		int day = 2; //Tuesday
		day += 100;
		day %= 7;
		switch(day) {
		case 1: System.out.println("Monday"); break;
		case 2: System.out.println("Tuesday"); break;
		case 3: System.out.println("Wednesday"); break;
		case 4: System.out.println("Thursday"); break;
		case 5: System.out.println("Friday"); break;
		case 6: System.out.println("Saturday"); break;
		case 0: System.out.println("Sunday"); break;
		}
	}

	private static void prob2_11() {
		System.out.printf("25/4 = %d\n(float)25/4 or 25f/4 = %f\n", 25/4, 25f/4);
	}
	
	private static void prob2_12() {
		System.out.println("25 / 4 is " + 25 / 4 + " | floor divide");
		System.out.println("25 / 4.0 is " + 25 / 4.0);
		System.out.println("3 * 2 / 4 is " + 3 * 2 / 4 + " | floor divide");
		System.out.println("3.0 * 2 / 4 is " + 3.0 * 2 / 4);
	}
	
	private static void prob2_13() {
		System.out.println(Math.pow(2, 3.5));
	}
	
}
