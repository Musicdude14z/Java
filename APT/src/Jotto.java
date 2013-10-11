
public class Jotto {

	public int commonCount (String a, String b) {
		int count = 0;
		for(char c : a.toCharArray()) {
			String s = b.replaceFirst(c+"", "\t");
			if(!s.equals(b)) count++;
			b = s;
		}
		return count;
	}
	
}
