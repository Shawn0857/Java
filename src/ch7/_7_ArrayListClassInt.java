package ch7;

import java.util.ArrayList;

public class _7_ArrayListClassInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList�i�H�����s�W/�R��
		/*<E>�A�x���AE�i�H�����"����"�A�����|�� Primitive type : boolean,
					  char, byte, int, long, float, double */
		// Integer, Float, Double ����A�bJava�̭�"�j�g�^��}�Y"�C
		ArrayList<Integer> itemInts = new ArrayList<>();
		itemInts.add(60);		
		itemInts.add(0,100);
		itemInts.add(40);
		itemInts.add(80);
		itemInts.add(60);
		
		for(int integer : itemInts) {
			System.out.printf(" %d ", integer);
		}
		System.out.println();
		
		for(int i=0; i< itemInts.size(); i++) {
			System.out.printf(" %d ", itemInts.get(i));
		}
		System.out.println();
		
		//�ק�
		itemInts.set(2,45);
		for(int i=0; i< itemInts.size(); i++) {
			System.out.printf(" %d ", itemInts.get(i));
		}
		System.out.println();
		
		//�R��
		itemInts.remove(0);
		for(int i=0; i< itemInts.size(); i++) {
			System.out.printf(" %d ", itemInts.get(i));
		}
		System.out.println();
		int x = itemInts.indexOf(80);
		//System.out.println(x);
		itemInts.remove(x); //index 2
		for(int i=0; i< itemInts.size(); i++) {
			System.out.printf(" %d ", itemInts.get(i));
		}
		
		System.out.println();
		Integer xInteger = 80;
		itemInts.remove(xInteger); //Object Integer 80
		for(int i=0; i< itemInts.size(); i++) {
			System.out.printf(" %d ", itemInts.get(i));
		}
		
		//�����M��
		itemInts.clear();
		
	}

}
