

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int west;
	static int east;
	static int count;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(st.nextToken());

		// 0은 사용 안하고 1 부터 30까지 사용
		int[][] arr = new int[31][31];
		
		//대각선 값 채우기
		for(int i=1;i<=30;i++) {
			for(int j=1;j<=30;j++) {
				arr[i][j]=1;
			}
		}
		
		//왼쪽 한 줄 채우기
		for(int i=1;i<=30;i++) {
			arr[i][1]=i;
		}
		
		// nCr = n-1Cr + n-1Cr-1
		for(int i=3;i<=30;i++) {
			for(int j=2;j<i;j++) {
				arr[i][j]= arr[i-1][j]+arr[i-1][j-1];
			}
		}
		
		
		
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			west = Integer.parseInt(st.nextToken());
			east = Integer.parseInt(st.nextToken());
		
			sb.append(arr[east][west]+"\n");
		}
		System.out.println(sb.toString());
	

	}


}
