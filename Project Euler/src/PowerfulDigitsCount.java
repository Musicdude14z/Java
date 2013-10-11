import java.text.DecimalFormat;


public class PowerfulDigitsCount {
	
	public static void main(String[] args) {
		int count = 0;
		for(int b=1;;b++) {
			double m = 1;
			for(int p=1;; p++) {
				m *= b;
				if(getNumDig(m) < p) {
					if(p==2) {
						//System.out.println
					}
				}
			}
		}
	}
	
	private static int getNumDig(double n) {
		return new DecimalFormat("#").format(n).length();
	}

}
