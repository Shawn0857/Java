package test;
import java.util.*;
public class bmi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double h = in.nextDouble();
		double b = in.nextDouble();
      	System.out.printf("%.4f",b/(h*h));
	}

}
