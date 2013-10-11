import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class StatisticalData {
	
	private static Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	private static int a[], max = 0, mode;
	private float mean, median, stdev;
	
	public static void main(String[] args) {
		readData();
		processData();
	}
	
	private static void readData() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number of data points: ");
		int n = s.nextInt();
		for(int i=0; i<n; i++) {
			System.out.print("["+i+"]: ");
			int next = s.nextInt();
			a[i] = next;
			m.put(next, m.containsKey(next) ? m.get(next)+1 : 1);
			max = Math.max(max, m.get(next));
		}
		s.close();
	}
	
	private static void processData() {
		System.out.println("Statistical Information:");
		String eq = "";
		while(eq.length()<30) eq+="=";
		System.out.println(eq);
		
	}

}
