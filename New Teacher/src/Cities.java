
public class Cities {

	public static void main(String[] args) {
		CityPoint[] cities = {new CityPoint(8, 5), new CityPoint(5, 0), new CityPoint(0, 6)};
		for(int i=0; i<=1000; i++) { //steady by the 16th iteration
			System.out.println(i + ": " + shortestDist(cities, 0, 0, 8, 6, 10, i).toString());
		}
	}
	
	public static CityPoint shortestDist(CityPoint[] cp, double x, double y, 
			double width, double height, int step, int iteration) {
		if(iteration == 0) return new CityPoint(x + width/2, y + height/2);
		double shortest = Double.MAX_VALUE, shortX = 0, shortY = 0, stepX = width/step, stepY = height/step,
				tempX = x + stepX/2, tempY;
		for(int i=0; i<step; i++) { //100 regions
			tempY = y + stepY/2; //reset y coord
			for(int j=0; j<step; j++) {
				double dist = 0;
				for(CityPoint c : cp) dist += c.getDistance(tempX, tempY);
				if(dist < shortest) {
					shortest = dist;
					shortX = tempX;
					shortY = tempY;
				}
				tempY += stepY;
			}
			tempX += stepX;
		}
		return shortestDist(cp, shortX - stepX/2, shortY - stepY/2, stepX, stepY, step, iteration-1);
	}
	
	private static class CityPoint {
		
		private double x, y;
		
		public CityPoint(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double getDistance(double x, double y) {
			double dx = this.x-x, dy = this.y-y;
			return Math.sqrt(dx*dx + dy*dy);
		}
		
		public String toString() {
			return String.format("(%.15f, %.15f)", x, y);
		}
		
	}
	
}
