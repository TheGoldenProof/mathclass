package mathclass.function;

public class PolynomialFunction extends AlgebraicFunction {
	
	double[] ce;
	
	public PolynomialFunction(double... coeffecients) {
		ce = coeffecients;
	}
	
	public double degree() {
		return ce.length-1;
	}
	
	public double f(double x) {
		double ret = 0;
		for (int i = 0; i < ce.length; i++) ret+=Math.pow(x, i)*ce[i];
		return ret;
	}
	
	
}
