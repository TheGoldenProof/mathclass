package mathclass.function;

import mathclass.pair.twoD.Point;

public class QuadraticFunction extends PolynomialFunction {
	
	private double a, b, c;
	
	public QuadraticFunction(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public QuadraticFunction(double a, Point p) {
		this.a = a;
		this.b = a*-2*p.v1();
		this.c = a*p.v1()*p.v1()+p.v2();
	}
	
	public Point vertex() {
		double x = -b/(2*a);
		return new Point(x, f(x));
	}
	
	public double f(double x) {
		return a*x*x+b*x+c;
	}
	
	public double[] solve(double y) {
		double c2 = c+y;
		double dis = b*b-4*a*c2;
		if (dis > 0) {
			return new double[] {(-b+Math.sqrt(dis)/(2*a)), (-b-Math.sqrt(dis)/(2*a))};
		} else if (dis == 0) {
			return new double[] {-b/(2*a)};
		} else {
			return new double[] {};
		}
	}
	
	/**
	 * @return The y-intercept of the function (0,yIntercept())
	 */
	public Point yIntercept() {
		return new Point(0, f(0));
	}
	
	/**
	 * @return the x-intercepts of the function (xIntercept(),0)
	 */
	public Point[] xIntercepts() {
		double[] roots = solve(0);
		Point[] ret = new Point[roots.length];
		for (int i = 0; i < roots.length; i++) {
			ret[i] = new Point(roots[i], 0);
		}
		return ret;
	}
	
	public LinearFunction derivative() {
		return new LinearFunction(a, b);
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
	
}
