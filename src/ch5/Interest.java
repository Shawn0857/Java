package ch5;

public class Interest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double principal = 5000;
		double rate = 0.01;
		System.out.printf("%s%25s\n","Year","Amount on deposit");
		for(int year= 0; year<=100; year++) {
			System.out.printf("%4d%,25.2f\n", year,
					principal * Math.pow( 1.0 + rate, year));
		}
	}

}
