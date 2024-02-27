import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		int[][] sum = new int[n][3];
		int[][] sum2 = new int[n][3];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		sum[0][0]= arr[0][0];
		sum[0][1]= arr[0][1];
		sum[0][2]= arr[0][2];
		
		sum2[0][0]= arr[0][0];
		sum2[0][1]= arr[0][1];
		sum2[0][2]= arr[0][2];
		
		
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<3;j++) {
				if(j==0) {
					sum[i][j] = arr[i][j] + Math.max(sum[i-1][0], sum[i-1][1]);
				}else if(j==1) {
					sum[i][j] = arr[i][j] + Math.max(Math.max(sum[i-1][0], sum[i-1][1]), Math.max(sum[i-1][1], sum[i-1][2]));
				}else {
					sum[i][j] = arr[i][j] + Math.max(sum[i-1][1], sum[i-1][2]);
					
				}
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<3;j++) {
				if(j==0) {
					sum2[i][j] = arr[i][j] + Math.min(sum2[i-1][0], sum2[i-1][1]);
				}else if(j==1) {
					sum2[i][j] = arr[i][j] + Math.min(Math.min(sum2[i-1][0], sum2[i-1][1]), Math.min(sum2[i-1][1], sum2[i-1][2]));
				}else {
					sum2[i][j] = arr[i][j] + Math.min(sum2[i-1][1], sum2[i-1][2]);
					
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<3;i++) {
			if(max < sum[n-1][i]) {
				max =sum[n-1][i];
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			if(min > sum2[n-1][i]) {
				min =sum2[n-1][i];
			}
		}
		
		System.out.print(max+" ");
		System.out.println(min);
		
		
		
	}

}