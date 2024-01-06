package ch2;

public class FormatNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = -123.4567;
		double b = 24.152;
		System.out.printf("|%10.2f %10.2f|\n", a, b);
		System.out.printf("|%10.2f %10.2f|\n", a+b, a-b);
		System.out.printf("|%-10.2f %-10.2f|\n", a, b);
		System.out.printf("|%-10.2f %-10.2f|\n", a+b, a-b);
		
		double c = 123456789.123456789;
		System.out.printf("%,10.2f\n", c);
		// %s 字串, %d 整數, %f 浮點數. %n 斷行
	}

}
