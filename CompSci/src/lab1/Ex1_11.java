package lab1;

public class Ex1_11 {
	
	public static void main(String[] args) {
		int p = 312_032_486, sPerYr = 365*24*3600;
		for(int i=1; i<=5; i++) {
			System.out.printf("Population after %d years: %d\n", i, 
					(p += sPerYr/7 - sPerYr/13 + sPerYr/45));
		}
	}
	
}
