import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum=0;
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			boolean a = false;
			for(int j=2;j<=x/2;j++) {
				if(x%j==0) {
					a=true;
					break;
				}
			}
			if(!a && x != 1) {
				sum++;
			}
		}
		
		System.out.println(sum);
	}

}