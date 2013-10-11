
public class Loops {

	public int[] compress (int[] data) {
		int n = 1, last = data[0];
		for(int i : data) {
			if(i!=last) {
				n++;
				last = i;
			}
		}
		int[] f = new int[n];
		last = data[0];
		n = 0;
		f[n] = data[0];
		for(int i : data) {
			if(i!=last) {
				f[++n] = i;
				last = i;
			}
		}
		return f;
	}
	
}
