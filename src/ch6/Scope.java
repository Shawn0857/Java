package ch6;

public class Scope {
	private static int x = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5;
		System.out.printf("local x in main is %d\n",x);
		useLocalVariable();
		useField();
		useLocalVariable();
		useField();
		System.out.printf("local x in main is %d\n",x);
		Scope s1 = new Scope();
		System.out.printf("x in s1 is %d\n",s1.x);
		Scope s2 = new Scope();
		s2.x = 999;
		System.out.printf("x in s2 is %d\n",s2.x);
		System.out.printf("x in s1 is %d\n",s1.x);
		
		
	}

	private static void useField() {
		System.out.printf("field x on entering method useField is %d\n", x);
		x *= 10;
		System.out.printf("field x before exiting method useField is %d\n", x);
		}
	
	private static void useLocalVariable() {
		int x = 25;
		System.out.printf("local x on entering method useLocalVariable"+ " is %d\n", x);
		x++;
		System.out.printf("local x before exiting method useLocalVariable"+ " is %d\n", x);
		}
}
