
public class TimeConversion {
	
	public static double secondsToDays(int sec) {
		return sec/3600.0/24;
	}
	
	public static int daysToSeconds(double days) {
		return (int)(days*3600*24);
	}

}
