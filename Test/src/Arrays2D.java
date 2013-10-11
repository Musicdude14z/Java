import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays2D {
	
	public static void main(String[] args) {
		System.out.print("Enter a side length for your spiral: ");
		Scanner s = new Scanner(System.in);
		int side = 1;
		try {
			side = s.nextInt();
			if(side <= 0) throw new InputMismatchException();
		}catch (InputMismatchException ime) {
			s.close();
			System.out.println("Sorry, you must enter an integer value greater than 0!");
			System.exit(1);
		}
		System.out.println(genSpiral(side));
		System.exit(0);
	}
	
	public static Grid genSpiral(int side) {
		Grid g = new Grid(side);
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int x = side/2, y = side/2, pos = 0, val = 1;
		if(side%2 == 0) pos = 2;
		g.set(x, y, val);
		while(g.get(0, side-1) == 0) {
			x += dirs[pos][0];
			y += dirs[pos][1];
			g.set(x, y, ++val);
			int nextPos = pos < 3 ? pos+1 : 0;
			if(g.get(x+dirs[nextPos][0], y+dirs[nextPos][1]) == 0) {
				pos = nextPos;
			}
		}
		return g;
	}
	
	static class Grid {
		
		private int width, height, maxAbsVal = 0;
		private int[][] grid; 
		
		public Grid() {
			width = 10;
			height = 10;
			grid = genGrid();
		}
		
		public Grid(int s) {
			width = s;
			height = s;
			grid = genGrid();
		}
		
		public Grid(int w, int h) {
			width = w;
			height = h;
			grid = genGrid();
		}
		
		public int getWidth() {
			return width;
		}
		
		public int getHeight() {
			return height;
		}
		
		public int get(int x, int y) {
			return grid[y][x];
		}
		
		public void set(int x, int y, int val) {
			grid[y][x] = val;
			if(Math.abs(val) > maxAbsVal) {
				maxAbsVal = Math.abs(val);
			}
		}
		
		public int getSum() {
			int s = 0;
			for(int[] a : grid) {
				for(int x : a) {
					s+=x;
				}
			}
			return s;
		}
		
		public static Grid parse(int[][] g) {
			int height = g.length;
			if(height < 1) return new Grid(0, 0);
			int width = g[0].length;
			for(int[] a : g) {
				if(a.length != width) {
					return null;
				}
			}
			Grid a = new Grid(height, width);
			for(int y=height-1; y>=0; y--) {
				for(int x=0; x<width; x++) {
					a.set(x, y, g[height-y-1][x]);
				}
			}
			return a;
		}
		
		public String toString() {
			int spacing = 3, longest = maxAbsVal;
			while((longest/=10) > 0) spacing++;
			String s = "";
			for(int i=height-1; i>=0; i--) {
				for(int j=0; j<width; j++) {
					int fixedSp = spacing-(""+grid[i][j]).length();
					for(int n=0; n<fixedSp/2 + fixedSp%2; n++) s += ' ';
					s += grid[i][j];
					for(int n=0; n<fixedSp/2; n++) s += ' ';
				}
				s += '\n';
			}
			return s;
		}
		
		public boolean equals(Grid g) {
			return Arrays.deepEquals(g.grid, grid);
		}
		
		public int compareTo(Grid g) {
			return getSum() - g.getSum();
		}
		
		private int[][] genGrid() {
			int[][] g = new int[height][];
			for(int i=0; i<height; i++) {
				g[i] = new int[width];
			}
			return g;
		}
		
	}
	
}
