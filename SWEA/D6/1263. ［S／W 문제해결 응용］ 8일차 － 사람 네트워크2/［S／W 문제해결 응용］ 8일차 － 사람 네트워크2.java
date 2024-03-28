import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=t;test_case++) {
			

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] arr= new int[N][N];
		
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]==0) {
						if(i != j) {
							arr[i][j]=(1000*1000)+1;
						}
					}
				}
			}
			

			
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
	
			int[] a = new int[N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					a[i]+=arr[i][j];
				}
				
				if(min > a[i]) {
					min = a[i];
				}
			}
			
			
			System.out.println("#"+test_case+" "+min);
			
		}
	}

}