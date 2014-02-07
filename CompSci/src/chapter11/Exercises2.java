package chapter11;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import utils.Utils;

/**
 * Exercises for Chapter 11
 * @author Zach Kaplan
 * @version 1.0
 */
public class Exercises2 {

	/**
	 * Main Method
	 * @param args - cmd args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Utils.newLine(11.08);
			x11_08();
			Utils.newLine(11.09);
			x11_09(s);
		} catch(InputMismatchException ime) {
			s.nextLine();
			s.close();
			Utils.err("Please enter a valid input!"); //exit(1)
		}
		
		s.close();
	}
	
	private static void x11_08() {
		Account a = new Account("George", 1122, 1000);
		Account.setAnnualInterestRate(1.5);
		a.deposit(30);
		a.deposit(40);
		a.deposit(50);
		a.withdraw(5);
		a.withdraw(4);
		a.withdraw(2);
		System.out.println(a);
	}
	
	private static class Account {
		private int id = 0;
		private double balance = 0;
		private static double annualInterestRate = 0;
		private Date dateCreated;
		private String name = "";
		private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		public Account() {
			dateCreated = new Date();
		}
		
		public Account(int id, int initBalance) {
			this();
			this.id = id;
			balance = initBalance;
		}
		
		public Account(String name, int id, int initBalance) {
			this(id, initBalance);
			this.name = name;
		}
		
		public int getID() {
			return id;
		}
		
		public void setID(int id) {
			this.id = id;
		}
		
		public double getBalance() {
			return balance;
		}
		
		public void setBalance(double balance) {
			this.balance = balance;
		}
		
		public static double getAnnualInterestRate() {
			return annualInterestRate;
		}
		
		public static void setAnnualInterestRate(double newRate) {
			annualInterestRate = newRate;
		}
		
		public static double getMonthlyInterestRate() {
			return annualInterestRate / 12;
		}
		
		public double getMonthlyInterest() {
			return getMonthlyInterestRate()/100 * balance;
		}
		
		public void withdraw(double amt) {
			balance -= amt;
			transactions.add(new Transaction('W', amt, balance, "Normal Withdrawal"));
		}
		
		public void deposit(double amt) {
			balance += amt;
			transactions.add(new Transaction('D', amt, balance, "Normal Deposit"));
		}
		
		public String toString() {
			String s = name + "\nBalance: $" + String.format("%,.02f", balance) + "\nMonthly Interest: " 
					+ getMonthlyInterest() + "%\nDate Created: " + dateCreated.toString();
			for(Transaction t : transactions) {
				s += "\n" + t.toString();
			}
			return s;
		}
		
		private static class Transaction {
			private Date date;
			private char type;
			private double amount, balance;
			private String description;
			
			public Transaction(char t, double amt, double bal, String desc) {
				date = new Date();
				type = t;
				amount = amt;
				balance = bal;
				description = desc;
			}
			
			public String toString() {
				return String.format("A %s of $%1.2f resulted in a balance of $%1.2f\n\t%s -- %s", 
						type == 'W' ? "WITHDRAWAL" : "DEPOSIT", amount, balance, 
								description, date);
			}
		}
		
	}
	
	private static void x11_09(Scanner s) {
		System.out.print("Enter size of random array: ");
		int n = s.nextInt();
		System.out.println("The random array is:");
		int[] cols = new int[n], rows = new int[n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int rand = (int)(Math.random()*2);
				System.out.printf("%d", rand);
				if(rand == 1) {
					cols[j]++;
					rows[i]++;
				}
			}
			System.out.println();
		}
		ArrayList<Integer> largeRows = new ArrayList<Integer>(), 
				largeCols = new ArrayList<Integer>();
		int largestRow = rows[0], largestCol = cols[0];
		for(int i=0; i<n; i++) {
			if(rows[i] > largestRow) {
				largeRows = new ArrayList<Integer>();
				largeRows.add(i);
				largestRow = rows[i];
			}else if(rows[i] == largestRow) {
				largeRows.add(i);
			}
			
			if(cols[i] > largestCol) {
				largeCols = new ArrayList<Integer>();
				largeCols.add(i);
				largestCol = cols[i];
			}else if(cols[i] == largestCol) {
				largeCols.add(i);
			}
		}
		System.out.print("The largest row index: ");
		Iterator<Integer> i = largeRows.iterator();
		while(i.hasNext()) {
			System.out.print(i.next() + (i.hasNext() ? ", " : "\n"));
		}
		System.out.print("The largest column index: ");
		i = largeCols.iterator();
		while(i.hasNext()) {
			System.out.print(i.next() + (i.hasNext() ? ", " : "\n"));
		}
	}

}
