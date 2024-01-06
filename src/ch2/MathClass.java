package ch2;

public class MathClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// java doc math 網站(數學運算)
		double r = 10;
		System.out.printf("Radius : %.2f\n", r);
		System.out.printf("Perimeter : %.2f\n", 2*Math.PI*r);
		System.out.printf("Area : %.2f\n", Math.PI*r*r);
		// Math.E
		
		int a = 5;
		System.out.println(a>>1);
		System.out.println(a<<2); //平移
		// 5 = 101, >>1, 10 = 2
		// 5 = 101, <<2, 10100 = 20
		
		// 5 * 7
		// = 10 * 3 + 5
		// = 20 * 1 + 5 + 10
		// = 20 + 5 + 10 = 35
	}

}
