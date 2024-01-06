package ch6;
import java.security.SecureRandom;
public class RandomIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecureRandom ranNumbers = new SecureRandom();
		System.out.printf("隨機產生一個數字%d%n", ranNumbers.nextInt());
		System.out.printf("隨機產生一個數字%d%n", ranNumbers.nextInt(101));
		// 0~100之間隨機產生一個數字.
		int sum = 0;
		for(int i=0; i<100; i++) sum += ranNumbers.nextInt(101);
		System.out.printf("隨機100個數字的平均為%.2f\n", (double)sum/100);
		for(int i = 0; i<5; i++) 
			System.out.printf("第%d次骰子的點數為%d\n",i+1, ranNumbers.nextInt(6)+1 );
		int n1 = ranNumbers.nextInt(101);
		int n2 = ranNumbers.nextInt(101);
		int n3 = ranNumbers.nextInt(101);
		int n4 = ranNumbers.nextInt(101);
		int max = RandomIntegers.fnAllMax(n1, n2,n3 ,n4);
		System.out.printf("%d, %d, %d, %d的最大值為%d", n1,n2,n3,n4,max);
	}
	public static int fnAllMax(int ... d) {   // [] = ...
		// TODO Auto-generated method stub
		int max = d[0];
		for(int i = 1; i< d.length; i++) {
			if(d[i]>max) max=d[i];
		}
		return 0;
	}//等一下要改
} 

