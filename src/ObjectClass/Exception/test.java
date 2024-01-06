package ObjectClass.Exception;

public class test {

	public static void main(String[] args) {
		CCircle cir = new CCircle();
		try {
			cir.setRadius(-100.0);
		} catch (CircleException e) {
			System.out.println(e + " 被拋出");

		}
		cir.show();
	}

}
