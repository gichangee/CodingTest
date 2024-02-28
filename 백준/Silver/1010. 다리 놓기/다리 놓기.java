import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int rtc = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<rtc;tc++) {
			StringTokenizer stz = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stz.nextToken());
			int M = Integer.parseInt(stz.nextToken());
			int[][] dp = new int[N+2][M+2];
			
			//맨아래 1로 채우기
			for(int i=M+1;i>0;i--) {
				dp[N+1][i] = 1;
			}
			
			for(int i=N,k=0;i>=1;i--,k++) {
				//첫 시작값은 무조건 1임
				//dp[i][M-k] = 1;
				for(int j=M-k;j>0;j--) {
					dp[i][j] = dp[i][j+1] + dp[i+1][j+1];
				}
			}
			sb.append(dp[1][1]).append("\n");
		}
		System.out.print(sb);
	}

}
