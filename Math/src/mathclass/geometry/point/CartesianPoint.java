package mathclass.geometry.point;

import mathclass.general.Mathclass;

public class CartesianPoint extends Point2D {
	
	public CartesianPoint(double x, double y) {
		this.x = x;
		this.y = y;
		
		r = Mathclass.Pythagoras(x, y);
		theta = Math.atan2(y, x);
	}
	
}
