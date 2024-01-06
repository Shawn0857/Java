package ObjectClass.MultiThread;

//若本身類別已經繼承了其他父類別，但又想繼承 Thread 類別，這時就會遇到 Java 無法多重繼承。
//想到多重繼承就會想到 介面，在［JAVA］多重繼承中提到：透過 介面 就能達到多重繼承。
//Java 提供了 Runnable 介面，有抽象函數 run() ；因此我們只需要定義 run() 即可。

public class Multi_Test3 implements Runnable {
	private String name;

	public Multi_Test3(String str)
	   {
	      name=str;
	   }

	public void run() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 100000000; j++)
				;
			System.out.println(name + " is running..");
		}
	}
}
