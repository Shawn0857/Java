package ch5;

public class Logic2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean p,q,r;
		System.out.printf("%5s %5s %5s %5s %10s\n ",
				"p","q","r", "~pvq", "(~pvq)->r");
		for(int i = 0; i < 2; i++) {
			p= (i==0);
			for(int j =0; j < 2; j++) {
				q = (j==0);
				for(int k=0; k<2; k++) {
					r = (k==0);
					System.out.printf("%5b %5b %5b %5b %10b\n ",p,q,r, 
							(!p|q) , (!(!p|q)|r));
				}
			}
		}
		
	}

}
