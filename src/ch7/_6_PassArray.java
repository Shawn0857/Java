package ch7;

public class _6_PassArray {

	public static void main(String[] args) {
		int value = 1;
		System.out.printf("value­È¬°%d\n",value);
		fnAddValue(value);
		System.out.printf("value­È¬°%d\n",value);
		int[] ary = {1,2,3};
		fnPrintArray(ary);
		fnAddArrayValue(ary);
		fnPrintArray(ary);
	}


	private static void fnAddArrayValue(int[] ary) {
		for(int i=0; i<ary.length; i++) ary[i]++;
	}
	
	private static void fnAddValue(int value) {
		value++;
	}
	
	private static void fnPrintArray(int[] ary) {
		for(int i = 0 ; i< ary.length; i++) {
			System.out.printf(" %d ", ary[i]);
		}
		System.out.println();
	}
	
}
