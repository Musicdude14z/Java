
public class PermutatedMultiples {

	public static void main(String[] args) {
		System.out.println(findSmallest());
	}
	
	private static boolean isPerm(String s1, String s2) {
		for(int i=0; i<s1.length(); i++) {
			int index = s2.indexOf(s1.charAt(i));
			if(index==-1) return false;
			s2 = s2.substring(0, index) + 'x' + s2.substring(index+1);
			s1 = s1.substring(0, i) + 'x' + s1.substring(i+1);
		}
		return s1.equals(s2);
	}
	
	private static int findSmallest() {
		for(int i=2;;i++) {
			boolean perm = true;
			for(int j=i+i; j<=i*6; j+=i) {
				if(!isPerm(""+i, ""+j)) {
					perm = false;
					break;
				}
			}
			if(perm) return i;
		}
	}
	
}
