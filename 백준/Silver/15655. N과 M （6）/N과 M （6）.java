import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N,R;
	static int[] arr;
	static int[] temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R= sc.nextInt();
		
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		temp = new int[R];
		Arrays.sort(arr);
		
		loop(0,0);
		
	}

	private static void loop(int cnt,int a) {
		if(cnt == R) {
			for(int i=0;i<R;i++) {
				System.out.print(temp[i]+" ");
			}
			System.out.println();
			return;
		}else {
			for(int i=a;i<N;i++) {
				temp[cnt]=arr[i];
				loop(cnt+1,i+1);
			}
			
			
		}
		
	}
}