package test;

import utils.Timer;

public class Test {
	
	public static void main(String[] args) {
		waysToClimb(3);
	}
	
	private static void test1() {
		Timer t = new Timer();
		//cycle through all perfect square from 1 to 1001 2 different methods
		int n = 1, i = 1;
		//method 1
		t.start();
		while(n<=1000) {
			n++;
			i = n*n;
		}
		t.stop();
		System.out.printf("Perfect square %,d of %,d was reached after %,d ns for method 1.\n", 
				i, n, t.getTime());
		t.reset();
		n = 1;
		i = 1;
		//method 2
		t.start();
		while(n<=1000) {
			i += n+n+1;
			n++;
		}
		t.stop();
		System.out.printf("Perfect square %,d of %,d was reached after %,d ns for method 2.\n",
				i, n, t.getTime());
	}
	
	private static void test2() {
		Timer t = new Timer();
		int n = 1, i = 1, numFor2 = 0;
		long time1, time2;
		
		for(int x=0; x < 1_000_000; x++) {
			//method 1
			t.start();
			while(n<=1000) {
				n++;
				i = n*n;
			}
			t.stop();
			time1 = t.getTime();
			t.reset();
			n = 1;
			i = 1;
			//method 2
			t.start();
			while(n<=1000) {
				i += n+n+1;
				n++;
			}
			t.stop();
			time2 = t.getTime();
			t.reset();
			if(time2 > time1) numFor2++;
		}
		
		System.out.println("Method 2 is faster " + (numFor2/1000d) + "% of the time!");
		
	}
	
	public static void waysToClimb(int n) {
		if (n > 0) System.out.print("[");
		else n = -n;
		int next1 = n - 1, next2 = n - 2;

		if (next1 < 0) return;
		else if (next1 == 0) {
			System.out.println("1]");
			System.out.print("[");
		} else {
			System.out.print("1, ");
			waysToClimb(-next1);
		}

		if (next2 < 0) return;
		else if (next2 == 0) {
			System.out.println(" 2]");
			System.out.print("[");
		} else {
			System.out.print("2, ");
			waysToClimb(-next2);
		}
	}

}
