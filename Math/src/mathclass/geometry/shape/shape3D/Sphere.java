package mathclass.geometry.shape.shape3D;

import mathclass.geometry.shape.Circle;

public class Sphere extends Circle implements Shape3D {
	
	protected double s;
	protected double v;
	
	public static Sphere fromSurfaceArea(double area) {
		return new Sphere(Math.sqrt(area/(4*Math.PI)));
	}
	
	public static Sphere fromVolume(double volume) {
		return new Sphere(Math.pow(3*volume/(4*Math.PI), (1.0/3)));
	}
	
	public Sphere(double radius) {
		super(radius);
		s = 4*Math.PI*r*r;
		v = 4*Math.PI*r*r*r/3;
	}
	
	@Override
	public double getSurfaceArea() {
		return s;
	}

	@Override
	public double getVolume() {
		return v;
	}

}
