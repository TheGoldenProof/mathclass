package mathclass.pair.twoD;

public class Point extends SimplePair {

	public Point(double val1, double val2) {
		super(val1, val2);
	}
	
	public Point(SimplePair pair) {
		super(pair.v1(), pair.v2());
	}
	
	public static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.v1()-p2.v1())*(p1.v1()-p2.v1())+(p1.v2()-p2.v2())*(p1.v2()-p2.v2()));
	}
	
	public double distance(Point p) {
		return Math.sqrt((v1()-p.v1())*(v1()-p.v1())+(v2()-p.v2())*(v2()-p.v2()));
	}
	
	public Vector vectorTo(Point p) {
		return new Vector(new SimplePair(p.v1()-v1(), p.v2()-v2()));
	}
	
	public String toString() {
	    return "("+v1()+","+v2()+")";
	}
}