package ObjectClass.Interface;

public class CRectangle implements CShape {
	int width, height;

	public CRectangle(int w, int h) // CRectangle建構元
	{
		width = w;
		height = h;
	}

	public void show() {
		System.out.println("area=" + width * height);
	}
}
