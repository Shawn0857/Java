package ObjectClass.MultiThread;

public class Multi_Test2 extends Thread {
	private String name;

	public Multi_Test2(String str)
	   {
	      name=str;
	   }

	public void run() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 100000000; j++)
				;
			System.out.println(name);
		}
	}
}
