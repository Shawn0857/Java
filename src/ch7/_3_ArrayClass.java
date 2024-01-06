package ch7;

import java.util.Arrays;

public class _3_ArrayClass {

	public static void main(String[] args) {
		int[] ary1 = {1,22,33,32,6,2,121,315,13256};
		fnPrintArray(ary1);
		int[] ary2= new int[3];
		int[] ary3 = ary2;
		fnPrintArray(ary2);
		fnPrintArray(ary3);
		//fill填入值
		Arrays.fill(ary2, 100);
		fnPrintArray(ary2);
		fnPrintArray(ary3);
		//ArrayCopy
		int[] ary4 = new int[5];
		System.arraycopy(ary1, 4, ary4, 0, ary4.length);
		fnPrintArray(ary4);
		//比較
		int[] ary5 = {100,100,100};
		fnPrintArray(ary5);
		System.out.println(ary2 == ary3); //指標指的位置是否相同
		System.out.println(ary2 == ary5);
		//q042j04
		//判斷2個陣列的值是否相同.
		//System.out.printf("ary2 %s ary5",
		//		(Arrays.equals(ary2 ,ary5))? "==" : "!=");
		//System.out.printf("ary2 %s ary4",
		//		(Arrays.equals(ary2 ,ary4))? "==" : "!=");
		System.out.printf("ary2 %s ary5\n",
				(Arrays.equals(ary2 ,ary5))? "==" : "!=");
		System.out.printf("ary2 %s ary4\n",
				(Arrays.equals(ary2 ,ary4))? "==" : "!=");
		//Sorting(排序)
		Arrays.sort(ary1);
		fnPrintArray(ary1);
		//BinarySearch
		System.out.printf("234在ary1的第%d個位置\n",Arrays.binarySearch(ary1, 234));
		System.out.printf("235在ary1的第%d個位置\n",Arrays.binarySearch(ary1, 235));
	}

	private static void fnPrintArray(int[] ary) {
		for(int i = 0 ; i< ary.length; i++) {
			System.out.printf(" %d ", ary[i]);
		}
		System.out.println();
	}
	
}
