import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] D = new int[n+3];
		
		D[1]=0;
		D[2]=1;
		D[3]=1;
		
		
		
		for(int i=4;i<=n;i++) {
			if(i%3==0 && i%2==0) {
				//총 3가지 비교
				D[i] = Math.min(Math.min(D[i/3],D[i/2]), Math.min(D[i/2],D[i-1]))+1;
			}else if(i%3==0) {
				//총 2가지 비교
				D[i] = Math.min(D[i-1], D[i/3])+1;
			}else if(i%2==0) {
				//총 2가지 비교
				D[i] = Math.min(D[i-1], D[i/2])+1;
			}else {
				D[i] = D[i-1]+1;
			}
		}
		
		
		System.out.println(D[n]);
		
	}

}