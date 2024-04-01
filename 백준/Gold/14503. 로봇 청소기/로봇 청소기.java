import java.util.*;
import java.io.*;

public class Main {

	// 상 우 하 좌
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static int[][] arr;

	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		count = 1;
		dfs(r, c, d);

		System.out.println(count);

	}

	private static void dfs(int r, int c, int d) {

		arr[r][c]=-1;
		
		for(int i=0;i<4;i++) {
			d = (d+3)%4;
			int y = dy[d]+r;
			int x = dx[d]+c;
			if(y >=0 && y<arr.length && x>=0 && x<arr[0].length) {
				if(arr[y][x] ==0) {
					count++;
					dfs(y,x,d);
					return;
				}
			}
		}
		
		
		int dir= (d+2)%4;
	
		int y = dy[dir]+r;
		int x = dx[dir]+c;
		
		
			if(y>=0 && x>=0 && y<arr.length && x<arr[0].length) {
				if(arr[y][x] != 1) {
					dfs(y,x,d);
				}
				
			}
		
	
		
		
	}

}