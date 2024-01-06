package ch7;

public class _1_InitialArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary1 = new int[10];
		for(int i=0; i<ary1.length; i++) 
		{
			System.out.printf("��%d����Ƭ�%d,",i, ary1[i]);
		}
		System.out.println();
		int[] ary2 = {1,3,4,6,3,10,1};
		for(int i=0; i<ary2.length; i++) 
		{
			System.out.printf("��%d����Ƭ�%d,",i, ary2[i]);
		}
		
	}

}
