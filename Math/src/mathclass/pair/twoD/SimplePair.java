package mathclass.pair.twoD;

public class SimplePair implements Pair<SimplePair> {
	private double v1, v2;
	
	public SimplePair(double val1, double val2) {
		v1 = val1; v2 = val2;
	}
	
	public double v1() {return v1;}
	public double v2() {return v2;}
	
	public void v1(double val1) {v1 = val1;}
	public void v2(double val2) {v2 = val2;}
	
	@Override
	public String toString() {
		return "("+v1+", "+v2+")";
	}
	
	public SimplePair add(SimplePair other) {
		return new SimplePair(v1()+other.v1(), v2()+other.v2());
	}
	
	public SimplePair subtract(SimplePair other) {
		return new SimplePair(v1()-other.v1(), v2()-other.v2());
	}
	
	public SimplePair multiply(SimplePair other) {
		return new SimplePair(v1()*other.v1(), v2()*other.v2());
	}
	
	public SimplePair divide(SimplePair other) {
		return new SimplePair(v1()/other.v1(), v2()/other.v2());
	}
}