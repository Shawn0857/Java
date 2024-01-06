package test;

public class count {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int count = -190; count <= 190; count++) {
			if (count == 5)
				continue;
			System.out.printf("%d", count);
		}
		System.out.print("\nUsed continue to skip printing after 5.\n"); // ���L5
	}

}
