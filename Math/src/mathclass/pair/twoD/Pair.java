package mathclass.pair.twoD;

public interface Pair<T extends Pair<T>> {
	public double v1();
	public double v2();
	public void v1(double v1);
	public void v2(double v2);
	
	public T add(T other);
	public T subtract(T other);
	public T multiply(T other);
	public T divide(T other);
}