package test;

import utils.Timer;

public class Test {
	
	public static void main(String[] args) {
		test2();
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

}
