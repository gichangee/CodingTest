import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class Solution {
	
	static int N,M,adj[][],cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			adj = new int[N+1][N+1];
			StringTokenizer st = null;
			for(int i =0; i<M ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1; //a보다 b가 키가 크다
			}
			
			int ans=0;
			for(int i=1;i<=N;i++) {
				cnt = 0;
				gtDFS(i,new boolean[N+1]);
				ltDFS(i,new boolean[N+1]);
				if(cnt == N-1) {
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	
	private static void gtDFS(int cur,boolean[] visited) {
		visited[cur] = true;
		for(int i=1;i<=N;i++) {
			if(adj[cur][i]==1 && !visited[i]) {
				cnt++;
				gtDFS(i,visited);
			}
	
		}
	}
	
	private static void ltDFS(int cur,boolean[] visited) {
		visited[cur] = true;
		for(int i=1;i<=N;i++) {
			if(adj[i][cur]==1 && !visited[i]) {
				cnt++;
				ltDFS(i,visited);
			}
	
		}
	}
}