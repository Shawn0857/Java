package ch7;

import java.util.ArrayList;

public class _8_ArrayListClassString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ArrayList�i�H�����s�W/�R��
		/*
		 * <E>�A�x���AE�i�H�����"����"�A�����|�� Primitive type : boolean, char, byte, int, long,
		 * float, double
		 */
		// Integer, Float, Double ����A�bJava�̭�"�j�g�^��}�Y"�C
		ArrayList<String> itemStrings = new ArrayList<>();
		itemStrings.add("���");
		itemStrings.add(0, "�^��");
		itemStrings.add("�ƾ�");
		itemStrings.add("���v");
		itemStrings.add("�a�z");

		for (String s : itemStrings) {
			System.out.printf(" %s ", s);
		}
		System.out.println();

		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}
		System.out.println();

		// �ק�
		itemStrings.set(2, "�z��");
		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}
		System.out.println();

		// �R��
		itemStrings.remove(0);
		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}
		System.out.println();
		int x = itemStrings.indexOf("�z��");
		itemStrings.remove(x); // index 1
		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}

		System.out.println();
		Integer xInteger = 80; //Object "���v"
		itemStrings.remove(xInteger);
		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}
		
		System.out.println();
		String xString = "���v"; //Object "���v"
		itemStrings.remove(xInteger);
		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}
		
		//�P�_���s�b
		System.out.println(itemStrings.contains("Java"));
		// �����M��
		itemStrings.clear();

	}

}
