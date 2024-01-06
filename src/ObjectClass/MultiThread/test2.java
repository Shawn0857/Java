package ObjectClass.MultiThread;

public class test2 {

	public static void main(String[] args) {
		Multi_Test2 apple = new Multi_Test2("apple");
		Multi_Test2 pen = new Multi_Test2("pen");
		apple.start();
		pen.start();
	}

}
