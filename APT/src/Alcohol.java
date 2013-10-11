import java.util.HashMap;


public class Alcohol {
	
	public String punish(String[] schedule) {
		HashMap<String, Integer> numParties = new HashMap<String, Integer>();
		for(String s : schedule) {
			if(numParties.containsKey(s)) {
				numParties.put(s, numParties.get(s)+1);
				if(numParties.get(s) >= 3) return s;
			}else {
				numParties.put(s, 1);
			}
		}
		return new String();
	}
	
}
