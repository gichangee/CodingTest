import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<int[]> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			list.add(new int[] {k,n});
		}
		
		int[][] arr = new int[N+1][K+1];
		
		 for(int i=0;i<=N;i++) {
			 arr[i][0]=0;
		 }
		 
		 for(int i=0;i<=K;i++) {
			 arr[0][i]=0;
		 }
		 
		 
		 for(int i=1;i<=N;i++) {
			 for(int j=1;j<=K;j++) {
				if(list.get(i-1)[1]>j) {
					arr[i][j] = arr[i-1][j];
				}else {
					arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-list.get(i-1)[1]]+list.get(i-1)[0]);
				}
			 }
		 }
		 
//		 for(int[] a : arr) {
//			 System.out.println(Arrays.toString(a));
//		 }
		 
		 System.out.println(arr[N][K]);
		 
		 
		
		
		
	}

}