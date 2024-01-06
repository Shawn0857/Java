package ch5;

public class ContinueStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int count=1; count<=10; count++) {
			if(count==5) continue;
			System.out.printf("%d", count);
		}
		System.out.print("\nUsed continue to skip printing after 5.\n"); //跳過5
	}

}
