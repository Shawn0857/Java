package ch5;

public class SwitchStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score =100;
		switch(score/10) {
		//case  10:
		case 9,10: //可以用","表示
			System.out.printf("Your score %d is A.\n", score);
			break; //如果沒有加break會繼續執行下一個
		case 8:
			System.out.printf("Your score %d is B.\n", score);
			break;
		case 7:
			System.out.printf("Your score %d is C.\n", score);
			break;
		case 6:
			System.out.printf("Your score %d is D.\n", score);
			break;
		default:
			System.out.printf("Your score %d is F.\n", score);
		}
	}

}
