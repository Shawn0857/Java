package ObjectClass.Interface;

public class CCircle2 implements CShape2D,CColor{   //實作 CShape2D子介面 
	double radius;
	String color;

	public CCircle2(double r) {
		radius = r;
	}

	public void setColor(String str) {
		color = str;
		System.out.println("color=" + color);
	}

	public void show() {
		System.out.println("area=" + PI * radius * radius);
	}

	public void diameter() {
		System.out.println("diameter" + 2 * radius);
	}
}
