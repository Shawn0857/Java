package ch7;

public class _5_MultiArray {

	public static void main(String[] args) {
		// �@���}�C
		int[] ary1 = {1,2,3};
		int[] ary2 = new int[3];
		ary2[0] = 1;
		ary2[1] = 2;
		ary2[2] = 3;
		fnPrintArray1D(ary1);
		fnPrintArray1D(ary2);
		//�G���}�C�A���פ@�˪�
		int[][] ary3 = {{1,2},{3,4}};
		int[][] ary4 = new int[2][2];
		ary4[0][0] = 1;
		ary4[0][1] = 2;
		ary4[1][0] = 3;
		ary4[1][1] = 4;
		fnPrintArray2D(ary3);
		fnPrintArray2D(ary4);
		//�G���}�C�A���פ��@�˪�
		int[][] ary5 = {{1,2},{3,4},{4,5,6}};
		int[][] ary6 = new int[3][];
		ary6[0]= new int [1];
		ary6[0][0] = 1;
		ary6[1] = new int [2];
		ary6[1][0] = 2;
		ary6[1][1] = 3;
		ary6[2]= new int [3];
		ary6[2][0] = 4;
		ary6[2][1] = 5;
		ary6[2][2] = 6;
		fnPrintArray2D(ary5);
		fnPrintArray2D(ary6);
		//�h���}�C�A���׳����@�˪�
		int[][][] ary7 = {{{1},{2,3},{4,5,6}},{{7},{8,9}},{{10}}};
		fnPrintArray(ary7);
	}
	
	//�}�C�q��
	private static void fnPrintArray(Object o) {
		Class c = o.getClass();
		if(c.isArray()) {
			c=c.getComponentType(); //���o�}�C���U���������A
			if(c.isArray()) {
				for(Object oc: (Object[]) o) {
					fnPrintArray(oc);
				}
			}else {
				for(int oc : (int[])o) {
					System.out.printf(" %d,", oc);
				}
			}
		}
	}
	
	private static void fnPrintArray2D(int[][] ary) {
		for(int i = 0 ; i< ary.length; i++) {
			for(int j = 0 ; j < ary[i].length; j++) {
				System.out.printf(" %d ", ary[i][j]);
			}
		}
		System.out.println();
	}
	private static void fnPrintArray1D(int[] ary) {
		for(int i = 0 ; i< ary.length; i++) {
			System.out.printf(" %d ", ary[i]);
		}
		System.out.println();
	}
}
