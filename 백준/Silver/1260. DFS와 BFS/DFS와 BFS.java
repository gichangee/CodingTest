import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int arr[][];
	static boolean[] v;
	static boolean[] dfsv;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		v = new boolean[N + 1];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		dfsv = new boolean[N+1];
		
		dfs(start);
		System.out.println();
		bfs(start);
	}

	
	
	private static void dfs(int start) {
		dfsv[start]=true;
		System.out.print(start+" ");
		for(int i=1;i<arr.length;i++) {
			if(arr[start][i] !=0 && !dfsv[i]) {
				
				dfsv[i]=true;
				dfs(i);
			}
		}
		
	}



	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		v[start] =true;
		while (!q.isEmpty()) {
			int x = q.poll();
			
			System.out.print(x+" ");
			for(int i=1;i<arr.length;i++) {
				if(arr[x][i] !=0  && !v[i]) {
					
					q.add(i);
					
					v[i]=true;
				}
			}
		}
	}

}