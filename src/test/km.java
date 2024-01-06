package test;
import java.util.*;
public class km {

	public static void main(String[] args) {
		Scanner ii = new Scanner(System.in);
        int x = ii.nextInt(); //分
        int y = ii.nextInt(); //秒
        double z = ii.nextDouble(); //公里
		//z/((double)(x*60+y)/3600)(距離/時間)，(x*60+y)/3600=小時，
        System.out.printf("Speed = %.1f", z/((double)(x*60+y)/3600));
	}

}
