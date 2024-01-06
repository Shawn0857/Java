package ObjectClass.MultiThread;

public class test3 {

	public static void main(String[] args) {
		Multi_Test3 apple = new Multi_Test3("apple");
		Multi_Test3 pen = new Multi_Test3("pen");
		Thread m1 = new Thread(apple);
		Thread m2 = new Thread(pen);
		m1.start();
		m2.start();
	}

}
