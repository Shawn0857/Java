package ch5;

public class Logic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean p,q,r;
		for(int i = 0; i < 2; i++) {
			p= (i==0);
			for(int j =0; j < 2; j++) {
				q = (j==0);
				System.out.println(p+","+q);
			}
		}
		
	}

}
