package mathclass.geometry.shape;

public class Circle extends Shape {
	
	protected double r;
	protected double d;
	
	public static Circle fromPerimeter(double perimeter) {
		return new Circle(perimeter/(2*Math.PI));
	}
	
	public static Circle fromArea(double area) {
		return new Circle(Math.sqrt(area/Math.PI));
	}
	
	public Circle(double radius) {
		r = radius;
		d = 2*r;
		perimeter = 2*Math.PI*r;
		area = Math.PI*r*r;
	}
	
	public double getRadius() {
		return r;
	}
	
	public double getDiameter() {
		return d;
	}
	
	@Override
	public double getPerimeter() {
		return perimeter;
	}

	@Override
	public double getArea() {
		return area;
	}

}
