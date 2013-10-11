import java.util.ArrayList;
import java.util.HashMap;


public class Probation {
	
	public String[] punish(String[] schedule) {
		ArrayList<String> groups = new ArrayList<String>();
		HashMap<String, Integer> numParties = new HashMap<String, Integer>(),
				firstParty = new HashMap<String, Integer>();
		for(int i=0; i<schedule.length; i++) {
			if(numParties.containsKey(schedule[i])) {
				numParties.put(schedule[i], numParties.get(schedule[i])+1);
				if(numParties.get(schedule[i]) == 3) {
					if(i - firstParty.get(schedule[i]) < 5) groups.add(schedule[i]);
					else {
						numParties.put(schedule[i], 2);
						for(int j=i-1; j>0; j--) {
							if(schedule[j].equals(schedule[i])) {
								firstParty.put(schedule[i], j);
								break;
							}
						}
					}
				}
			}else {
				numParties.put(schedule[i], 1);
				firstParty.put(schedule[i], i);
			}
		}
		Object[] temp = groups.toArray();
		String[] punish = new String[temp.length];
		for(int i=0; i<temp.length; i++) {
			punish[i] = temp[i].toString();
		}
		return punish;
	}
	
}
