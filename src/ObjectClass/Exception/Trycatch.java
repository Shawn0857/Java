package ObjectClass.Exception;

public class Trycatch {

	public static void main(String[] args) {
		try {
			int arr[] = new int[5];
			arr[10] = 7;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("索引值超出範圍");
		} finally // 此區塊那敘述一定會被執行
		{
			System.out.println("finally 中敘述");
		}
		System.out.println("try-catch-finally 敘述之外");
	}

}
