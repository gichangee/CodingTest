import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] m = new int[N+1];
		int[] c = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		int maxCount=0;
		
		for(int i=1;i<=N;i++) {
			m[i]= Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			c[i]= Integer.parseInt(st.nextToken());
			maxCount+=c[i];
		}
		
		int[][] arr = new int[N+1][maxCount+1];
		
	
		
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=maxCount;j++) {
				if(c[i]>j) {
					arr[i][j]=arr[i-1][j];
				}else {
					arr[i][j]=Math.max(arr[i-1][j], arr[i-1][j-c[i]]+m[i]);
				}
			}
		}
		
		
		for(int i=0;i<=maxCount;i++) {
			
			if(arr[N][i]>=M) {
				System.out.println(i);
				break;
			}
		}
		
//		for(int[] a : arr) {
//			System.out.println(Arrays.toString(a));
//		}
	

		
	}

}