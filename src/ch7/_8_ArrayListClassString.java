package ch7;

import java.util.ArrayList;

public class _8_ArrayListClassString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ArrayList可以直接新增/刪除
		/*
		 * <E>，泛型，E可以放任何的"物件"，但不會用 Primitive type : boolean, char, byte, int, long,
		 * float, double
		 */
		// Integer, Float, Double 物件，在Java裡面"大寫英文開頭"。
		ArrayList<String> itemStrings = new ArrayList<>();
		itemStrings.add("國文");
		itemStrings.add(0, "英文");
		itemStrings.add("數學");
		itemStrings.add("歷史");
		itemStrings.add("地理");

		for (String s : itemStrings) {
			System.out.printf(" %s ", s);
		}
		System.out.println();

		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}
		System.out.println();

		// 修改
		itemStrings.set(2, "理化");
		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}
		System.out.println();

		// 刪除
		itemStrings.remove(0);
		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}
		System.out.println();
		int x = itemStrings.indexOf("理化");
		itemStrings.remove(x); // index 1
		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}

		System.out.println();
		Integer xInteger = 80; //Object "歷史"
		itemStrings.remove(xInteger);
		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}
		
		System.out.println();
		String xString = "歷史"; //Object "歷史"
		itemStrings.remove(xInteger);
		for (int i = 0; i < itemStrings.size(); i++) {
			System.out.printf(" %s ", itemStrings.get(i));
		}
		
		//判斷不存在
		System.out.println(itemStrings.contains("Java"));
		// 全部清空
		itemStrings.clear();

	}

}
