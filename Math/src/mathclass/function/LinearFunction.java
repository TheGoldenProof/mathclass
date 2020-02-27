package mathclass.function;

import mathclass.pair.twoD.Point;

public class LinearFunction extends PolynomialFunction {
	
	private double m, b;
	
	//---------------------------------------------------------------------------------//
	//  Static Constructors                                                            //
	//---------------------------------------------------------------------------------//
	
	/**
	 * Creates a line parallel to another line that passes through a given {@link mathclass.geometry.point.Point2D Point}.
	 * 
	 * @param line The line which this line will be parallel to.
	 * @param p The point which this parallel point will pass through.
	 * @return A line which is parallel to a given line that passes through Point p.
	 */
	public static LinearFunction parallelThroughPoint(LinearFunction line, Point p) {
		return new LinearFunction(p, line.getM());
	}
	
	public static LinearFunction perpendicularThroughPoint(LinearFunction line, Point p) {
		return new LinearFunction(p, -1/line.getM());
	}
	
	//---------------------------------------------------------------------------------//
	//  Constructors                                                                   //
	//---------------------------------------------------------------------------------//
	
	/**
	 * Creates a linear function with a given slope m and a y-intercept at (0,b), commonly known as slope-intercept form.
	 * 
	 * @param a	The coefficient of the x component.
	 * @param b	The coefficient of the y component.
	 * @param c	The constant.
	 * @return A linear function (which is internally represented by slope-intercept) from the given standard form.
	 */
	
	public LinearFunction(double m, double b) {
		setM(m);
		setB(b);
	}
	
	/**
	 * Creates a line given two {@link mathclass.geometry.point.Point2D Points}.
	 * 
	 * @param a A point which the line passes through.
	 * @param b A second point which the line passes through.
	 * @return A linear function that passes through point a and b
	 */
	public LinearFunction(Point a, Point b) {
		this(a, (b.v2()-a.v2())/(b.v1()-a.v1()));
	}
	
	/**
	 * Creates a line passing through a {@link mathclass.geometry.point.Point2D Point} with a given slope.
	 * 
	 * @param p The point which the line passes through
	 * @param slope The slope of the line which passes through Point p.
	 * @return A linear function which passes through point p with a given slope.
	 */
	public LinearFunction(Point p, double slope) {
		this(slope, slope*-p.v1()+p.v2());
	}
	
	/**
	 * Creates a linear function from the standard form Ax + By = C, where A, B, and C are integers.
	 * 
	 * @param a	The coefficient of the x component.
	 * @param b	The coefficient of the y component.
	 * @param c	The constant.
	 * @return A linear function (which is internally represented by slope-intercept) from the given standard form.
	 */
	public LinearFunction(int a, int b, int c) {
		this(-a/b, c/b);
	}
	
	//---------------------------------------------------------------------------------//
	//  Conversions                                                                    //
	//---------------------------------------------------------------------------------//
	
	public double[] toStandardForm() {
		double[] ret = new double[3];
		for (ret[1] = 1; ret[1] <= Integer.MAX_VALUE; ret[1]++) {
			if (m*1.0*ret[1] == (int)(m*ret[1]) && b*1.0*ret[1] == (int)(m*ret[1])) {
				ret[0] = (int) (-m*ret[1]);
				ret[2] = (int) (b*ret[1]);
				break;
			} else if (ret[1] == Integer.MAX_VALUE) {
				ret[0] = -m;
				ret[1] = 1;
				ret[2] = b;
				break;
			}
		}
		
		return ret;
	}
	
	//---------------------------------------------------------------------------------//
	//  Math                                                                           //
	//---------------------------------------------------------------------------------//
	
	/**
	 * Calculates y given x
	 * 
	 * @param x
	 * @return y
	 */
	public double f(double x) {
		return m*x+b;
	}
	
	
	/**
	 * Calculates the input (x) from a given output (y)
	 * 
	 * @param y
	 * @return x
	 */
	public double[] solve(double y) {
		if (m!=0) {
			return new double[] {(y-b)/m};
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
		return new LinearFunction(0, m);
	}
	
	//---------------------------------------------------------------------------------//
	//  Getter-Setters                                                                 //
	//---------------------------------------------------------------------------------//
	
	private void setM(double m) {
		this.m = m;
	}
	
	private void setB(double b) {
		this.b = b;
	}

	public double getM() {
		return m;
	}

	public double getB() {
		return b;
	}
	
}
