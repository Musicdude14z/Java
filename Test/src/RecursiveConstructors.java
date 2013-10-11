
public class RecursiveConstructors {
	
	public static void main(String[] args) {
		Test t = new Test(5);
	}
	
	static class Test {
		public Test(int i) {
			if(i<=0) return;
			Test t = new Test(i-1);
		}
	}
	
}
