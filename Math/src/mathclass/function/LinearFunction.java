package mathclass.function;

import mathclass.geometry.point.CartesianPoint;
import mathclass.geometry.point.Point2D;

public class LinearFunction extends PolynomialFunction implements Formula {
	
	private double m;
	private double b;
	
	//---------------------------------------------------------------------------------//
	//  Static Constructors                                                            //
	//---------------------------------------------------------------------------------//
	
	/**
	 * Creates a line given two {@link mathclass.geometry.point.Point2D Points}.
	 * <br><br>
	 * Given two <code>Points</code>, a and b, calculates the slope, then returns calculates the rest via {@link #fromPointSlope(Point2D, double)}
	 * 
	 * @param a A point which the line passes through.
	 * @param b A second point which the line passes through.
	 * @return A linear function that passes through point a and b
	 */
	public static LinearFunction fromTwoPoints(Point2D a, Point2D b) {
		double slope = (b.getY()-a.getY())/(b.getX()-a.getX());
		return fromPointSlope(a, slope);
	}
	
	/**
	 * Creates a line passing through a {@link mathclass.geometry.point.Point2D Point} with a given slope.
	 * 
	 * @param p The point which the line passes through
	 * @param slope The slope of the line which passes through Point p.
	 * @return A linear function which passes through point p with a given slope.
	 */
	public static LinearFunction fromPointSlope(Point2D p, double slope) {
		LinearFunction ret = new LinearFunction();
		ret.setM(slope);
		ret.setB(slope*-p.getX()+p.getY());
		return ret;
	}
	
	/**
	 * Creates a linear function from the standard form Ax + By = C, where A, B, and C are integers.
	 * 
	 * @param a	The coefficient of the x component.
	 * @param b	The coefficient of the y component.
	 * @param c	The constant.
	 * @return A linear function (which is internally represented by slope-intercept) from the given standard form.
	 */
	public static LinearFunction fromStandardForm(int a, int b, int c) {
		return new LinearFunction(-a/b, c/b);
	}
	
	/**
	 * Creates a line parallel to another line that passes through a given {@link mathclass.geometry.point.Point2D Point}.
	 * 
	 * @param line The line which this line will be parallel to.
	 * @param p The point which this parallel point will pass through.
	 * @return A line which is parallel to a given line that passes through Point p.
	 */
	public static LinearFunction parallelThroughPoint(LinearFunction line, Point2D p) {
		return fromPointSlope(p, line.getM());
	}
	
	public static LinearFunction perpendicularThroughPoint(LinearFunction line, Point2D p) {
		return fromPointSlope(p, -1/line.getM());
	}
	
	//---------------------------------------------------------------------------------//
	//  Constructors                                                                   //
	//---------------------------------------------------------------------------------//
	
	private LinearFunction() {}
	
	public LinearFunction(double m, double b) {
		setM(m);
		setB(b);
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
	
	public double apply(double x) {
		return m*x+b;
	}
	
	public double[] solve(double y) {
		return new double[] {(y-b)/m};
	}
	
	public Point2D yIntercept() {
		return new CartesianPoint(0, apply(0));
	}
	
	public Point2D xIntercept() {
		return new CartesianPoint(solve(0)[0], 0);
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
