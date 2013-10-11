
public class Birthday {

	public String getNext(String date, String[] birthdays) {
		int minDist = 365;
		String d = new String();
		for(int i=0; i<birthdays.length; i++) {
			int dist = getDist(date, birthdays[i]);
			if(dist < 0) dist+=365;
			if(dist < minDist) {
				minDist = dist;
				d = birthdays[i].substring(0, 5);
			}
		}
		return d;
	}

	private int getDist(String date1, String date2) {
		return toNum(date2) - toNum(date1);
	}

	private int toNum(String date) {
		int n = 0, month = Integer.parseInt(date.substring(0, 2)),
				days = Integer.parseInt(date.substring(3, 5));
		switch(month){
		case 12: n+=31;
		case 11: n+=30;
		case 10: n+=31;
		case 9: n+= 30;
		case 8: n+= 31;
		case 7: n+= 31;
		case 6: n+= 30;
		case 5: n+= 31;
		case 4: n+= 30;
		case 3: n+= 31;
		case 2: n+= 28;
		case 1: n+= 31;
			break;
		default: break;
		}
		return n + days;
	}

}
