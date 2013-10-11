
public class TwoHeapNim {
	
	public int makeMove (int numObjectsInFirstHeap, int numObjectsInSecondHeap, 
			int numOpponentTook) {
		if(numObjectsInFirstHeap%3 == 0) {
			if(numObjectsInSecondHeap%3 == 0) {
				return numObjectsInFirstHeap > numObjectsInSecondHeap ? 12 : 22;
			}else {
				return 20 + numObjectsInSecondHeap%3;
			}
		}else {
			if(numObjectsInSecondHeap%3 == 0) {
				return 10 + numObjectsInFirstHeap%3;
			}else {
				if(numObjectsInFirstHeap%3 == 1) {
					if(numObjectsInSecondHeap%3 == 1) {
						if(numObjectsInSecondHeap == numObjectsInFirstHeap 
								&& numObjectsInFirstHeap == 1) return 11;
						else return numObjectsInFirstHeap > numObjectsInSecondHeap ? 12 : 22;
					}else {
						return 21;
					}
				}else {
					if(numObjectsInSecondHeap%3 == 1) {
						return 11;
					}else {
						return numObjectsInFirstHeap < numObjectsInSecondHeap ? 11 : 21;
					}
				}
			}
		}
	}
	
}
