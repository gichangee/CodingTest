import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx,dy;
	static int N,M;
	static boolean[][] v;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dx = new int[]{-1,1,0,0};
		dy = new int[]{0,0,-1,1};
		
		v= new boolean[N][M];
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(s.substring(j,j+1));
			}
		}
		
		bfs(0,0);
		
		System.out.println(arr[N-1][M-1]);
	}

	private static void bfs(int i, int j) {
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i,j});
		v[i][j]=true;
		while(!q.isEmpty()) {
			
			int[] temp = q.poll();

			
			for(int k=0;k<4;k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				
				if(x >= 0 && y >=0 && x<N && y<M) {
					if(arr[x][y] != 0 && !v[x][y]) {
						arr[x][y]=arr[temp[0]][temp[1]]+1;
						v[x][y]=true;
						q.add(new int[] {x,y});
					}
				}
			}
		}
		
	}
}