
public class QuadraticEquation {
	
	private double a, b, c, discriminant;
	
	public static void main(String[] args) {
		if(args.length != 3) {
			System.err.println("Usage: java QuadraticEquation <a> <b> <c>");
			System.exit(1);
		}
		double[] vals = new double[3];
		for(int i=0; i<3; i++) {
			try {
				vals[i] = Double.parseDouble(args[i]);
			} catch (NumberFormatException nfe) {
				char var = 'a';
				if(i==1) var = 'b';
				else if(i==2) var = 'c';
				System.err.printf("Error: Invalid value '%s' for %s.\n", args[i], var);
				System.exit(1);
			}
		}
		QuadraticEquation q = new QuadraticEquation(1, 1, 1);
		try {
			q = new QuadraticEquation(vals[0], vals[1], vals[2]);
		} catch (IllegalArgumentException iae) {
			System.err.println(iae.getMessage());
			System.exit(1);
		}
		System.out.println(q);
		System.out.printf("Discriminant: %.6f\n", q.getDiscriminant());
		if(q.getDiscriminant() < 0) {
			System.out.println("The equation has no real roots.");
		}else {
			System.out.printf("Root 1: %.6f\nRoot 2: %.6f\n", q.getRoot1(), q.getRoot2());
		}
		System.exit(0);
	}
	
	public QuadraticEquation(double a, double b, double c) throws IllegalArgumentException {
		if(a == 0) throw new IllegalArgumentException("Error: Coefficient 'a' cannot be 0 " +
				"in a quadratic equation.");
		this.a = a;
		this.b = b;
		this.c = c;
		discriminant = b*b - 4*a*c;
	}
	
	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
	
	public double getC() {
		return c;
	}
	
	public double getDiscriminant() {
		return discriminant;
	}
	
	public double getRoot1() {
		if(discriminant < 0) return 0;
		double root = (-b + Math.sqrt(discriminant))/2/a;
		return root == -0.0 ? 0 : root;
	}
	
	public double getRoot2() {
		if(discriminant < 0) return 0;
		double root = (-b - Math.sqrt(discriminant))/2/a;
		return root == -0.0 ? 0 : root;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		if(a<0) {
			str.append(a + "x^2");
		}else {
			str.append((a==1 ? "" : a) + "x^2");
		}
		if(b<0) {
			str.append(" - " + (b==-1 ? "" : -b) + 'x');
		}else if(b>0) {
			str.append(" + " + (b==1 ? "" : b) + 'x');
		}
		if(c<0) {
			str.append(" - " + -c);
		}else if(c>0) {
			str.append(" + " + c);
		}
		str.append(" = 0");
		return str.toString();
	}
	
}
