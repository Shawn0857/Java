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
		// ���A�@
		String s1 = "Hello";
		String s2 = "Hello";
		if (s1 == s2) {
			System.out.printf("%s == %s", s1, s2);
		} else {
			System.out.printf("%s != %s", s1, s2);
		}
		System.out.println();

		// ���A�G
		String s3 = new String("Hello");  // new ���ܷ|�����s�W�@�ӰO����Ŷ�
		String s4 = new String("Hello");
		if (s3 == s4) {
			System.out.printf("%s == %s", s3, s4);
		} else {
			System.out.printf("%s != %s", s3, s4);
		}
		System.out.println();

		// ���A�T
		String s5 = "Hello";
		String s6 = "Hi";
		if (s5 == s6) {   
			System.out.printf("%s == %s", s5, s6);
		} else {
			System.out.printf("%s != %s", s5, s6);
		}
		System.out.println();

		// ���A�|
		s6 = "Hello"; 
		if (s5 == s6) {   // �P�_ s5,s6���O�����}�ۦP���ۦP
			System.out.printf("%s == %s", s5, s6);
		} else {
			System.out.printf("%s != %s", s5, s6);
		}
		System.out.println();

		// ���A��
		if (s1 == s6) {  // �P�_ s1,s6���O�����}�ۦP���ۦP
			System.out.printf("%s == %s", s1, s6);
		} else {
			System.out.printf("%s != %s", s1, s6);
		}
		System.out.println();

		// ���A��
		if (s3 == s6) {  // �P�_ s3,s6���O�����}�ۦP���ۦP
			System.out.printf("%s == %s", s3, s6);
		} else {
			System.out.printf("%s != %s", s3, s6);
		}
		System.out.println();

		// ���A�C
		String s7 = "Hello";
		String s8 = "Hello";
		if (s7 == s8) {   // �P�_ s7,s8���O�����}�ۦP���ۦP(������s����})
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

		// ���A�K
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

		// ���A�E
		String s10 = "Hello, apple, apple, apple, apple, apple, apple, apple, apple, apple, apple";
		if (s9 == s10) {
			System.out.printf("%s == %s", s9, s10);
		} else {
			System.out.printf("%s != %s", s9, s10);
		}
		System.out.println();

		// ���A�Q
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
		
		//�P�_���e�O�_�ۦP
		if(s9.equals(s10)) {
			System.out.printf("%s == %s", s9, s10);
		}else {
			System.out.printf("%s != %s", s9, s10);
		}
	}

}
