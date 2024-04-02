import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] D = new int[n+1];
		
		D[0]=0;
		D[1]=1;
		
		for(int i=2;i<=n;i++) {
			D[i]=D[i-2]+D[i-1];
		}
		
		System.out.println(D[n]);
	}

}