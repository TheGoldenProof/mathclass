package mathclass.pair.twoD;

public class Vector implements Pair<Vector> {
	double r, theta;

	public Vector(double r, double theta) {
		this.r = r; this.theta = theta;
	}
	
	public Vector(SimplePair offset) {
		r = new Point(offset).distance(new Point(0,0));
		theta = Math.atan2(offset.v2(), offset.v1());
	}

	public double v1() {return r;}
	public double v2() {return theta;}
	public void v1(double v1) {r = v1;}
	public void v2(double v2) {theta = v2;}
	
	public SimplePair toOffset() {
		return new SimplePair(v1()*Math.cos(v2()), v1()*Math.sin(v2()));
	}
	
	public Vector add(Vector other) {
		SimplePair p = toOffset().add(other.toOffset());
		return new Vector(p);
	}
	
	public Vector subtract(Vector other) {
		SimplePair p = toOffset().subtract(other.toOffset());
		return new Vector(p);
	}

	public Vector multiply(Vector other) {
		SimplePair p = toOffset().multiply(other.toOffset());
		return new Vector(p);
	}

	public Vector divide(Vector other) {
		SimplePair p = toOffset().divide(other.toOffset());
		return new Vector(p);
	}
	
	public Vector average(Vector other) {
		SimplePair p = add(other).toOffset();
		p.v1(p.v1()/2); p.v2(p.v2()/2);
		return new Vector(p);
	}
	
	public String toString() {
	    return "("+v1()+","+v2()+")";
	}
}
