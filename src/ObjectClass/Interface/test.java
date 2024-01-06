package ObjectClass.Interface;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CRectangle rect = new CRectangle(5, 10);
		rect.show();

		CCircle cir = new CCircle(2.0);
		cir.setColor("yellow");
		cir.show();

		CShape shap01, shap02; // 透過介面宣告變數

		shap01 = new CRectangle(5, 10);
		shap01.show();
		//shap01.setColor("blue");

		shap02 = new CCircle(2.0);
		shap02.show();
		//shap02.setColor("blue");
	}

}
