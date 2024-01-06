package ObjectClass.Exception;

public class ThrowMethod {

	public static void main(String[] args) {
		try {
			abc(100, 0);
		} catch (ArithmeticException e) {
			System.out.println(e + " 被拋出");
		} catch (Exception e) {
			System.out.println(e + " Exception");
		}
	}

	public static void abc(int a,int b) throws ArrayIndexOutOfBoundsException
	{
		try {
			int ans;
			ans=a/b;
			System.out.println(a+"/"+b+"="+ans);
		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
}
