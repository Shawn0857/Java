package test;
import java.util.*;
public class _for_ {

	public static void main(String[] args) {
		Scanner ii = new Scanner(System.in);
        int a = ii.nextInt();
        if(a<100){
          for(int i=1;i<=a;i++){
            for(int j=1;j<=i;j++){ 
               System.out.printf("%4s",Integer.toString(i*j));
            }
            System.out.print("\n");
          }
        }
	}

}


