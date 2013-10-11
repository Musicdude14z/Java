import java.util.ArrayList;
import java.util.Arrays;


public class Test {
	
	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(5);
		test.add(25);
		test.add(15);
		System.out.println(Arrays.toString(test.toArray(new Integer[15])));
	}
	
}
