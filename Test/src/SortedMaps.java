import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class SortedMaps {

	public static void main(String[] args) {
		SortedMap<String, SortedSet<String>> tags = new TreeMap<String, SortedSet<String>>() {
			//should serialize anonymous subclass
			private static final long serialVersionUID = 5423197010027652853L;
			
			@Override
			public SortedSet<String> get(Object key) { //simulates initial values
				if(!containsKey(key)) {
					put((String) key, new TreeSet<String>());
				}
				return super.get(key);
			}
        };
        
	}

}
