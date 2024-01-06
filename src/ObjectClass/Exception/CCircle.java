package ObjectClass.Exception;

public class CCircle {
	private double radius;

	public void setRadius(double r) throws CircleException {
		if (r < 0) {
			throw new CircleException();
		} else
			radius = r;
	}

	public void show() {
		System.out.println("面積=" + Math.PI * radius * radius);
	}
	
}

