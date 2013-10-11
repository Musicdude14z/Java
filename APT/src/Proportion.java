
public class Proportion {
	
	public int getPoint (int left, int top, int width, int height, double percent) {
		return left + (int)(percent*width);
	}
	
}
