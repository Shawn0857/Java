package ObjectClass.ch3;

public class _2_StringClass {

	public static void main(String[] args) {
		// ª¬ºA¤@
		String a1 = "Hello2";
		String b1 = "Hello" + 2;
		System.out.println(a1 == b1);
		// ª¬ºA¤G
		String a2 = "Hello2";
		String b2 = "Hello";
		String c2 = b2 + "2";
		System.out.println(a2 == c2);
		// ª¬ºA¤T
		String a3 = "Hello2";
		final String b3 = "Hello";
		String c3 = b3 + "2";
		System.out.println(a2 == c3);
		// ª¬ºA¥|
		String a4 = "Hello2";
		final String b4 = getHello();
		String c4 = b4 + "2";
		System.out.println(a4 == c4);

		// ª¬ºA¤­
		/*String a5 = "Hello2";
		final String b5 = getHello();
		String c5 = b5 + "2";
		System.out.println(a5 == c5); */
		
		
		
	}

	private static String getHello() {
		return "Hello";
	}

}
