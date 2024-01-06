package ch2;

public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =10;
		int b =30;
		System.out.println("a ="+a+"; b = "+b);
		//int c = a;
		//a = b;
		//b = c;
		
		a = a ^ b; //2�ƥ洫
		b = a ^ b;
		a = a ^ b;
		
		System.out.println("a ="+a+"; b = "+b);
	}

}
