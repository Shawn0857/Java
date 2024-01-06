package ObjectClass.ch3;

public class _1_StringClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 10;
		if (a == b) {
			System.out.printf("%d == %d", a, b);
		} else {
			System.out.printf("%d != %d", a, b);
		}
		System.out.println();
		// 狀態一
		String s1 = "Hello";
		String s2 = "Hello";
		if (s1 == s2) {
			System.out.printf("%s == %s", s1, s2);
		} else {
			System.out.printf("%s != %s", s1, s2);
		}
		System.out.println();

		// 狀態二
		String s3 = new String("Hello");  // new 的話會直接新增一個記憶體空間
		String s4 = new String("Hello");
		if (s3 == s4) {
			System.out.printf("%s == %s", s3, s4);
		} else {
			System.out.printf("%s != %s", s3, s4);
		}
		System.out.println();

		// 狀態三
		String s5 = "Hello";
		String s6 = "Hi";
		if (s5 == s6) {   
			System.out.printf("%s == %s", s5, s6);
		} else {
			System.out.printf("%s != %s", s5, s6);
		}
		System.out.println();

		// 狀態四
		s6 = "Hello"; 
		if (s5 == s6) {   // 判斷 s5,s6的記憶體位址相同不相同
			System.out.printf("%s == %s", s5, s6);
		} else {
			System.out.printf("%s != %s", s5, s6);
		}
		System.out.println();

		// 狀態五
		if (s1 == s6) {  // 判斷 s1,s6的記憶體位址相同不相同
			System.out.printf("%s == %s", s1, s6);
		} else {
			System.out.printf("%s != %s", s1, s6);
		}
		System.out.println();

		// 狀態六
		if (s3 == s6) {  // 判斷 s3,s6的記憶體位址相同不相同
			System.out.printf("%s == %s", s3, s6);
		} else {
			System.out.printf("%s != %s", s3, s6);
		}
		System.out.println();

		// 狀態七
		String s7 = "Hello";
		String s8 = "Hello";
		if (s7 == s8) {   // 判斷 s7,s8的記憶體位址相同不相同(挪移到新的位址)
			System.out.printf("%s == %s", s7, s8);
		} else {
			System.out.printf("%s != %s", s7, s8);
		}
		System.out.println();
		for (int i = 0; i < 10; i++) {
			s7 += ", apple";
			s8 += ", apple";
		}
		if (s7 == s8) {
			System.out.printf("%s == %s", s7, s8);
		} else {
			System.out.printf("%s != %s", s7, s8);
		}
		System.out.println();

		// 狀態八
		String s9 = "Hello, apple, apple, apple, apple, apple, apple, apple, apple, apple, apple";
		if (s7 == s9) {
			System.out.printf("%s == %s", s7, s9);
		} else {
			System.out.printf("%s != %s", s7, s9);
		}
		System.out.println();
		if (s8 == s9) {
			System.out.printf("%s == %s", s8, s9);
		} else {
			System.out.printf("%s != %s", s8, s9);
		}
		System.out.println();

		// 狀態九
		String s10 = "Hello, apple, apple, apple, apple, apple, apple, apple, apple, apple, apple";
		if (s9 == s10) {
			System.out.printf("%s == %s", s9, s10);
		} else {
			System.out.printf("%s != %s", s9, s10);
		}
		System.out.println();

		// 狀態十
		s9 = s7;
		if (s9 == s7) {
			System.out.printf("%s == %s", s9, s7);
		} else {
			System.out.printf("%s != %s", s9, s7);
		}
		System.out.println();
		if (s9 == s10) {
			System.out.printf("%s == %s", s9, s10);
		} else {
			System.out.printf("%s != %s", s9, s10);
		}
		System.out.println();
		
		//判斷內容是否相同
		if(s9.equals(s10)) {
			System.out.printf("%s == %s", s9, s10);
		}else {
			System.out.printf("%s != %s", s9, s10);
		}
	}

}
