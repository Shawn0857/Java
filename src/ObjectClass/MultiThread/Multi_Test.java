package ObjectClass.MultiThread;

public class Multi_Test {
	private String name;

	public Multi_Test(String str)
	   {
	      name=str;
	   }

	public void show() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 100_000_000; j++)
				;
			System.out.println(name);
		}
	}
}
