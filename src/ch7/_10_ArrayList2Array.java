package ch7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _10_ArrayList2Array {

	public static void main(String[] args) {
		
		ArrayList<String> itemStrings = new ArrayList<>();
		itemStrings.add("國文");
		itemStrings.add(0, "英文");
		itemStrings.add("數學");
		itemStrings.add("歷史");
		itemStrings.add("地理");
		
		//String[] aryStrings = (String[]) itemStrings.toArray();
		String[] aryStrings = new String [itemStrings.size()];
		aryStrings = itemStrings.toArray(aryStrings);
		for(int i = 0; i<aryStrings.length; i++) {
			System.out.printf(" %s ", aryStrings[i]);
		}
		System.out.println();
		
		Integer[] arydata = {56,65,552,652,156,15,59,1026,925,824};
		List<Integer> arrayList = Arrays.asList(arydata);
		for(int i = 0; i<arrayList.size(); i++) {
			System.out.printf(" %s ", arrayList.get(i));
		}
		

	}
	
}
