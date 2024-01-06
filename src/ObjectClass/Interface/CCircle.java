package ObjectClass.Interface;

public class CCircle implements CShape, CColor {
	double radius;
	String color;
	
	public CCircle(double r) // CCircle建構元
	{
		radius = r;
	}

	public void show() // 改寫介面中抽象函數
	{
		System.out.println("面積＝" + PI * radius * radius);
	}

	public void setColor(String str) {
		color=str;
		System.out.println("color="+color);
	}
}
