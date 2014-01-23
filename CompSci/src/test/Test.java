package test;

import utils.Timer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test {
	
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(int i=0; i<5; i++) l.add(i);
		l.offerLast(5);
		l.offerFirst(-1);
		l.removeFirstOccurrence(3);
		System.out.println(l);
		System.out.println(l.size());
		/*
		ListIterator<Integer> i = l.listIterator();
		while(i.hasNext()) {
			int a = i.next();
			System.out.println(a);
			if(a % 2 == 0) i.remove();
			else {
				i.set(2*a);
				i.add(4*a);
				while(i.hasPrevious()) {
					System.out.println(i.previous());
				}
			}
		}
		System.out.println(l);
		*/
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
	
	private static void test3() {
		Timer t = new Timer();
		int lim = 100_000;
		String add = "n";
		String s = "";
		t.start();
		for(int i=0; i<lim; i++) {
			s += add;
		}
		t.stop();
		System.out.printf("Time for String+=: %,d; %,d\n", t.getTime(), s.length());
		//String Builder
		t.reset();
		StringBuilder sb = new StringBuilder();
		t.start();
		for(int i=0; i<lim; i++) {
			sb.append(add);
		}
		t.stop();
		System.out.printf("Time for StringBuilder.append: %,d; %,d\n", t.getTime(), sb.length());
		t.reset();
		sb = new StringBuilder();
		t.start();
		for(int i=0; i<lim; i++) {
			sb.insert(0, add);
		}
		t.stop();
		System.out.printf("Time for StringBuilder.insert(0): %,d; %,d\n", t.getTime(), sb.length());
		t.reset();
		sb = new StringBuilder();
		t.start();
		for(int i=0; i<lim; i++) {
			sb.insert(i, add);
		}
		t.stop();
		System.out.printf("Time for StringBuilder.insert(i): %,d; %,d\n", t.getTime(), sb.length());
		//capacity ensure
		t.reset();
		sb = new StringBuilder(lim);
		t.start();
		for(int i=0; i<lim; i++) {
			sb.append(add);
		}
		t.stop();
		System.out.printf("Time for StringBuilder.append w/ capacity ensure: %,d; %,d\n", t.getTime(), sb.length());
		t.reset();
		sb = new StringBuilder(lim);
		t.start();
		for(int i=0; i<lim; i++) {
			sb.insert(0, add);
		}
		t.stop();
		System.out.printf("Time for StringBuilder.insert(0) w/ capacity ensure: %,d; %,d\n", t.getTime(), sb.length());
		t.reset();
		sb = new StringBuilder(lim);
		t.start();
		for(int i=0; i<lim; i++) {
			sb.insert(i, add);
		}
		t.stop();
		System.out.printf("Time for StringBuilder.insert(i) w/ capacity ensure: %,d; %,d\n", t.getTime(), sb.length());
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
