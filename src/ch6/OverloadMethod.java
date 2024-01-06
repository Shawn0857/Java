package ch6;

import java.security.SecureRandom;

public class OverloadMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecureRandom ranNumbers = new SecureRandom();
		int n1 = ranNumbers.nextInt(101);
		int n2 = ranNumbers.nextInt(101);
		int n3 = ranNumbers.nextInt(101);
		int n4 = ranNumbers.nextInt(101);
		int max = fnAllMax(n1, n2,n3 ,n4);
		System.out.printf("%d, %d, %d, %d的最大值為%d", n1,n2,n3,n4,max);
		double f1 = ranNumbers.nextDouble();
		double f2 = ranNumbers.nextDouble();
		double f3 = ranNumbers.nextDouble();
		double f4 = ranNumbers.nextDouble();
		double fmax = fnAllMax(f1, f2,f3 ,f4);
		System.out.printf("%d, %d, %d, %d的最大值為%f", f1,f2,f3,f4,fmax);
	}
	public static int fnAllMax(int ... d) {   // [] = ...
		// TODO Auto-generated method stub
		int max = d[0];
		for(int i = 1; i< d.length; i++) {
			if(d[i]>max) max=d[i];
		}
		return max;
	}
	public static double fnAllMax(double ... d) {   // [] = ...
		// TODO Auto-generated method stub
		double max = d[0];
		for(int i = 1; i< d.length; i++) {
			if(d[i]>max) max=d[i];
		}
		return max;
	}
}
