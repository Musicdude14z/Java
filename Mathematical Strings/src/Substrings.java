
public class Substrings {
	
	public static void main(String[] args) {
		System.out.println(subLen4());
	}
	
	public static String subLen4() {
		char[] set = {'a', 'b'};
		String s = "aaaabbbb";
		while(true) {
			String temp = s;
			for(char x : set) {
				temp += x;
				String comp = temp.substring(temp.length()-4);
				for(int i=4; i<temp.length()-1; i++) {
					if(temp.substring(i-4, i).equals(comp)) {
						temp = temp.substring(0,temp.length()-1);
						break;
					}
				}
				if(!temp.equals(s)) break; 
			}
			if(temp.equals(s)) return s;
			s = temp;
		}
	}
	
}
