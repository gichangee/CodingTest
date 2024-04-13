import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			
			}

			boolean[][] v = new boolean[N][M];
			int count=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!v[i][j] && arr[i][j] ==1) {
						v[i][j]=true;
						bfs(arr,v,i,j);
						count++;
					}
				}
			}

			System.out.println(count);
		}
	}

	private static void bfs(int[][] arr, boolean[][] v, int y, int x) {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {y,x});
		
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int i=0;i<4;i++) {
				int goY = dy[i]+temp[0];
				int goX = dx[i]+temp[1];
				if(goY >=0 && goX >=0 && goY < arr.length && goX <arr[0].length) {
					if(!v[goY][goX] && arr[goY][goX]==1) {
						v[goY][goX]=true;
						q.add(new int[] {goY,goX});
					}
				}
			}
			
			
		}
	}

}